package Assignment3;

public class MovieSeatTest {
    public class Main {
        public static void main(String[] args) {
            System.out.println();
            // Create a movie theater with 5 rows and 10 seats per row
            MovieSeatReservation theater = new MovieSeatReservation("Cineplex", 5, 10);

            System.out.println();
            // Display initial seating chart
            theater.displaySeatingChart(10);

            System.out.println();
            // Reserve a few seats
            theater.reserveSeat("A01");
            theater.reserveSeat("B05");

            System.out.println();
            // Display updated seating chart
            theater.displaySeatingChart(10);

            System.out.println();
            // Cancel a reservation
            theater.cancelSeat("B05");
            
            System.out.println();
            // Display final seating chart
            theater.displaySeatingChart(10);
        }
    }
}
