package cat.itacademy.solid.d.service;

import cat.itacademy.solid.d.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends PersistenceInfo {

    Optional<Booking> findById(Long bookingId);
    Booking save(Booking booking);
    List<Booking> findAllOrderedByStart();
}
