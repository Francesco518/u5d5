package francescobuonocore.u5d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@Entity
@ToString
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private Type type;
    private int  maxOccupantNumbers;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;


}
