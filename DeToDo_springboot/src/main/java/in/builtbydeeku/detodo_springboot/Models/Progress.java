package in.builtbydeeku.detodo_springboot.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<Integer> progressValue;
    @OneToOne(mappedBy = "progress")
    private Task task;
}
