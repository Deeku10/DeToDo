package in.builtbydeeku.detodo_springboot.Services;

import in.builtbydeeku.detodo_springboot.Exceptions.ObjectNotFoundException;
import in.builtbydeeku.detodo_springboot.Models.Progress;
import in.builtbydeeku.detodo_springboot.Models.Task;
import in.builtbydeeku.detodo_springboot.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return Optional.ofNullable(task)
                .map(t -> {
                    t.setProgress(new Progress());
                    return taskRepository.save(t);
                })
                .orElseThrow(() -> new ObjectNotFoundException("Task not found"));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.findById(id)
                .ifPresentOrElse(taskRepository::delete,() -> {
                    throw new ObjectNotFoundException("Task not found");
                });
    }

    @Override
    public Task updateTask(Task task,Long id) {
        return Optional.of(taskRepository.findById(id)
                        .orElseThrow(()-> new ObjectNotFoundException("Task not found")))
                .map(oldTask->{
                    oldTask.setNote(task.getNote());
                    oldTask.setTitle(task.getTitle());
                    oldTask.setPeriodId(task.getPeriodId());
                    oldTask.setProgress(task.getProgress());
                    return taskRepository.save(oldTask);
                })
                .orElseThrow(() -> new ObjectNotFoundException("Task not found"));
    }
}
