package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Workout {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Exercise> exercises;
    private Long timestamp;

    @Override
    public String toString() {
        return String.format(
                "Workout[id=%d, exercises='%s', timestamp='%s']",
                id, exercises, timestamp);
    }

}