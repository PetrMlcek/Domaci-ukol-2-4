package com.engeto;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
    }

    public Booking getBooking(int index) {
        if (index >= 0 && index < bookings.size()) {
            return bookings.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public void clearBookings() {
        bookings.clear();
    }

    public void printAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public int getNumberOfBookings() {
        int count = 0;
        for(Booking booking : bookings) {
            if (booking.getTypeOfVacation()) {
                count ++;
            }
        }
        return count;
    }

    public double getAverageGuests() {
        if (bookings.isEmpty()) {
            return 0.0;
        }
        int totalGuests = 0;
        for (Booking booking : bookings) {
            totalGuests += booking.getNumberOfGuests();
        }
        return (double) totalGuests / bookings.size();
    }
}