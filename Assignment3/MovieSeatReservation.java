package Assignment3;

import java.util.ArrayList;
import java.util.List;

// Charity Smith
// SD10
// 17/09/2024

// This program is a movie seat reservation system that allows users to reserve and cancel seats in a movie theater.

// reserve seats
// cancel seats
// retrieve initial seating chart

public class MovieSeatReservation {

    private final String theaterName;
    private final List<Seat> seats;

    // Constructor for the MovieSeatReservation class
    public MovieSeatReservation(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        this.seats = new ArrayList<>();

        // Create a Seating Arrangement
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat); // Add seat to the seats list
            }
        }
        System.out.println("Created theater " + theaterName + " with " + numRows + " rows and " + seatsPerRow + " seats per row");
    }

    // Get theater name
    public String getTheaterName() {
        return theaterName;
    }

    // Reserve a seat
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        if (requestedSeat == null) {
            System.out.println("Seat " + seatNumber + " does not exist");
            return false;
        }
        return requestedSeat.reserve();
    }

    // Cancel a Seat
    public boolean cancelSeat(String seatNumber) {
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        if (requestedSeat == null) {
            System.out.println("Seat " + seatNumber + " does not exist");
            return false;
        }
        return requestedSeat.cancel();
    }

    // Retrieve/Print seating chart
    public void displaySeatingChart(int seatsPerRow) {
        System.out.println("Seating chart for " + theaterName);
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seats.get(i);
            System.out.print(seat.getSeatNumber() + (seat.isReserved() ? " [X] " : " [O] "));
            // Print a newline after every row
            if ((i + 1) % seatsPerRow == 0) {
                System.out.println();
            }
        }
    }

    // Inner Seat class
    private static class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        // Reserve seat
        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is already reserved");
                return false;
            }
        }

        // Cancel reservation
        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation for seat " + seatNumber + " cancelled");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is not reserved");
                return false;
            }
        }

        // Get seat number
        public String getSeatNumber() {
            return seatNumber;
        }

        // Check if seat is reserved
        public boolean isReserved() {
            return reserved;
        }
    }
}

