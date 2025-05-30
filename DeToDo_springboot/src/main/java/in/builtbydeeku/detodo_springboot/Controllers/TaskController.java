package in.builtbydeeku.detodo_springboot.Controllers;

import in.builtbydeeku.detodo_springboot.Models.Task;
import in.builtbydeeku.detodo_springboot.Response.ApiResponse;
import in.builtbydeeku.detodo_springboot.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllTasks() {
        try {
            return ResponseEntity.ok(new ApiResponse(taskService.getAllTasks(), "All tasks fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), "Task not found"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTask(@RequestBody Task task) {
        try {
            return ResponseEntity.ok(new ApiResponse(taskService.addTask(task), "Task added"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Task addition failure"));
        }
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<ApiResponse> deleteTask(@PathVariable Long taskId) {
        try{
            taskService.deleteTaskById(taskId);
            return ResponseEntity.ok(new ApiResponse(taskId ,"Task deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Task deletion failure"));
        }
    }

    @PostMapping("/update/{taskId}")
    public ResponseEntity<ApiResponse> updateTask(@RequestBody Task task,@PathVariable Long taskId) {
        try {
            return ResponseEntity.ok(new ApiResponse(taskService.updateTask(task, taskId), "Task updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Task update failure"));
        }
    }
}
