package in.builtbydeeku.detodo_springboot.Repository;

import in.builtbydeeku.detodo_springboot.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);
}
