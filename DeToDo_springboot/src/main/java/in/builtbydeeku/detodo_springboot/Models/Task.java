package in.builtbydeeku.detodo_springboot.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int periodId;
    private String title;
    private String note;
    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "progressId")
    private Progress progress;
}
