package cat.itacademy.solid.d.service;

import cat.itacademy.solid.d.model.Booking;

import java.util.Optional;

public interface BookingRepository {

    Optional<Booking> findById(Long bookingId);
    Booking save(Booking booking);
}
