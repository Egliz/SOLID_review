package cat.itacademy.solid.d.service;

import cat.itacademy.solid.d.model.Booking;

public interface BookingRepository {

    Booking findById(String bookingId);
    Booking save(Booking booking);
}
