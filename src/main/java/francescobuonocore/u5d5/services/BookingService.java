package francescobuonocore.u5d5.services;


import francescobuonocore.u5d5.entities.Booking;
import francescobuonocore.u5d5.entities.User;
import francescobuonocore.u5d5.entities.Workstation;
import francescobuonocore.u5d5.repositories.BookingDAO;
import francescobuonocore.u5d5.repositories.UserDAO;
import francescobuonocore.u5d5.repositories.WorkstationDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {
    @Autowired
    private BookingDAO bookingDAO;

    public boolean book(Workstation workstation, User user, LocalDate bookingDate) {
        if (isStationFree(workstation, bookingDate)) {
            Booking booking = new Booking();
            booking.setWorkstation(workstation);
            booking.setUser(user);
            booking.setBookingDate(bookingDate);
            bookingDAO.save(booking);
            return true;
        } else {
            return false;
        }
    }
    public boolean isStationFree(Workstation workstation, LocalDate bookingDate) {
        return !bookingDAO.existsByWorkstationAndBookingDate(workstation, bookingDate);
    }
}

