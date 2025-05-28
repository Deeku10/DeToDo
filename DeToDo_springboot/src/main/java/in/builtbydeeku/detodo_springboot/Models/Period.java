package in.builtbydeeku.detodo_springboot.Models;

import jakarta.persistence.*;

@Entity
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
}
