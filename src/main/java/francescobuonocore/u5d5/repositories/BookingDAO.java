package francescobuonocore.u5d5.repositories;

import francescobuonocore.u5d5.entities.Booking;
import francescobuonocore.u5d5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long> {
     boolean existsByWorkstationAndBookingDate(Workstation workstation, LocalDate bookingDate);
}
