package in.builtbydeeku.detodo_springboot.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
}
