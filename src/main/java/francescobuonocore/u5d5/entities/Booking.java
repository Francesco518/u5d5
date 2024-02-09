package francescobuonocore.u5d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Workstation workstation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
