package hello;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer repetitions;

    @Override
    public String toString() {
        return String.format(
                "Exercise[id=%d, name=%s,reps='%s']",
                id, name, repetitions);
    }

}