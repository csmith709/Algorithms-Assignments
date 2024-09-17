package Assignment3;

import java.util.ArrayList;
import java.util.List;

public class MovieSeatReservation {

    private static final List<Seat> ArrayList = null;
    private final String theaterName;
    private List<Seat> seats = ArrayList;

    public void MovieTheater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        // show seating arrangement
       
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                Seat.add(seat);
            }
            System.out.println("Creating theater " + theaterName + " with " + numRows + " rows and " + seatsPerRow + " seats per row");
        }
    }

    // get theater name
    public String getTheaterName() {
        return theaterName;
    }
    // reserveSeat method
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

    private class Seat {
    private final String seatNumber;
    private boolean reserved = false;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public static void add(Seat seat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    // reserve seat
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

    // cancel reservation
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

    // get seat number
    public String getSeatNumber() {
        return seatNumber;
    }
}
}