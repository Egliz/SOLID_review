package cat.itacademy.solid.d.service;

import cat.itacademy.solid.d.exception.BookingAccessDeniedException;
import cat.itacademy.solid.d.model.Booking;

import java.time.Clock;
import java.time.LocalDateTime;

public class BookingService {

    private final BookingRepository repository;
    private final Clock clock;

    public BookingService(BookingRepository repository, Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

    public void cancelBooking(String customerId, Long bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(() -> new IllegalStateException("Booking not found"));

        if (!booking.belongsTo(customerId)) {
            throw new BookingAccessDeniedException(customerId, bookingId);
        }

        //TODO se obtiene hora actual
        // recibir la hora por fuera, por constructor, eso es inyectar
        LocalDateTime now = LocalDateTime.now(clock);

        booking.cancel(now);
        repository.save(booking);
    }
}