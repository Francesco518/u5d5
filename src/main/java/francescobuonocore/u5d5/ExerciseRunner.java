package francescobuonocore.u5d5;

import francescobuonocore.u5d5.entities.*;
import francescobuonocore.u5d5.repositories.UserDAO;
import francescobuonocore.u5d5.repositories.WorkstationDAO;
import francescobuonocore.u5d5.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ExerciseRunner implements CommandLineRunner {
    public BookingService bookingService;
    public WorkstationDAO workstationDAO;
    public UserDAO userDAO;

    public ExerciseRunner(BookingService bookingService, WorkstationDAO workstationDAO, UserDAO userDAO) {
        this.bookingService = bookingService;
        this.workstationDAO = workstationDAO;
        this.userDAO = userDAO;
    }
    @Override
    public void run(String... args) throws Exception {
        Workstation workstation = new Workstation();
        workstation.setDescription("Station filled with everything you need");
        workstation.setType(Type.PRIVATE);
        workstation.setMaxOccupantNumbers(1);
        workstationDAO.save(workstation);

        User user = new User();
        user.setUsername("Mr.Nobody");
        user.setCompleteName("John Wayne");
        user.setEmail("mrnobody@gmail.com");
        userDAO.save(user);

        LocalDate bookingDate = LocalDate.now();
        if (bookingService.book(workstation, user, bookingDate)) {
            System.out.println("Bookin successfully completed for the day: " + bookingDate);
        } else {
            System.out.println("The station is not availale for the day: " + bookingDate);
        }
    }
}
