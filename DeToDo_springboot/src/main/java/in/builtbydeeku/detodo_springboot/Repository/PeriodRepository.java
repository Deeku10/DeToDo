package in.builtbydeeku.detodo_springboot.Repository;

import in.builtbydeeku.detodo_springboot.Models.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodRepository extends JpaRepository<Period,Integer> {
}
