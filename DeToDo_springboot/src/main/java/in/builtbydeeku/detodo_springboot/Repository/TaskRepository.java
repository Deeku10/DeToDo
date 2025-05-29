package in.builtbydeeku.detodo_springboot.Repository;

import in.builtbydeeku.detodo_springboot.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
