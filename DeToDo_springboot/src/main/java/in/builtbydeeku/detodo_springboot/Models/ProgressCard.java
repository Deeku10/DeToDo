package in.builtbydeeku.detodo_springboot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgressCard {

    private String title;
    private String period;
    //need enum for period but how to use with database - check chat gpt
    //need a way to store record for last 7 days
}
