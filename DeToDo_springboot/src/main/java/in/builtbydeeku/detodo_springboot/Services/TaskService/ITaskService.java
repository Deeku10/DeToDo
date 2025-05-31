package in.builtbydeeku.detodo_springboot.Services.TaskService;

import in.builtbydeeku.detodo_springboot.Models.Task;

import java.util.List;

public interface ITaskService {
    public Task addTask(Task task);
    public List<Task> getAllTasks();
    public void deleteTaskById(Long id);
    public Task updateTask(Task task, Long id);
}
