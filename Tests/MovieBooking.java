import java.util.*;
class Movie {
    private Map<String, List<String>> moviedatas = new HashMap<>();
    public void addMovieData() {
        List<String> datas = new ArrayList<>();
        datas.add("Theatre 1");
        datas.add("Seat 10, Seat 20, Seat 30");
        datas.add("10.30, 1.00");
        moviedatas.put("Movie 1", new ArrayList<>(datas));

        datas.clear();
        datas.add("Theatre 2");
        datas.add("Seat 111, Seat 223, Seat 323");
        datas.add("3.40, 1.00");
        moviedatas.put("Movie 2", new ArrayList<>(datas));

        datas.clear();
        datas.add("Theatre 3");
        datas.add("Seat 8, Seat 5, Seat 4");
        datas.add("4.30, 17.00");
        moviedatas.put("Movie 3", new ArrayList<>(datas));

        datas.clear();
        datas.add("Theatre 4");
        datas.add("Seat 1, Seat 2, Seat 3");
        datas.add("15.30, 16.00");
        moviedatas.put("Movie 4", new ArrayList<>(datas));

        System.out.println("Available Movies: ");
        for (Map.Entry<String, List<String>> e : moviedatas.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    public Map<String, List<String>> getMoviedatas() {
        return moviedatas;
    }
}

public class MovieBooking {
    private static Movie movie = new Movie();
    private static Scanner scanner = new Scanner(System.in);

    public static void listAllTheMovies() {
        movie.addMovieData();
    }

    public static void bookTickets() {
        if (movie.getMoviedatas().isEmpty()) {
            movie.addMovieData();
        }
        System.out.print("Enter the movie> ");
        scanner.nextLine();
        String movieName = scanner.nextLine();
        Map<String, List<String>> movies = movie.getMoviedatas();
        if (movies.containsKey(movieName)) {
            List<String> data = movies.get(movieName);
            System.out.println("Theatre: " + data.get(0));
            System.out.println("Available Seats: " + data.get(1));
            System.out.println("Show Timings: " + data.get(2));
            System.out.print("Enter seat to book> ");
            String seat = scanner.nextLine();
            String seats = data.get(1);
            if (seats.contains(seat)) {
                String updatedSeats = seats.replace(seat, "BOOKED");
                data.set(1, updatedSeats);
                System.out.println("Seat " + seat + " booked for " + movieName);
            } else {
                System.out.println("Seat not available.");
            }
        } else {
            System.out.println("Movie not found.");
        }
    }

    public static void checkSeatsAvailability() {
        if (movie.getMoviedatas().isEmpty()) {
            movie.addMovieData();
        }
        System.out.print("Enter the movie> ");
        scanner.nextLine();
        String movieName = scanner.nextLine();
        Map<String, List<String>> movies = movie.getMoviedatas();
        if (movies.containsKey(movieName)) {
            List<String> data = movies.get(movieName);
            System.out.println("Available Seats: " + data.get(1));
        } else {
            System.out.println("Movie not found.");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nWelcome to Movie Booking App.");
            System.out.println("1. List All the Movies.");
            System.out.println("2. Book a Ticket for a Movie.");
            System.out.println("3. Check Seats Availability.");
            System.out.println("5. Exit");
            System.out.print("\nChoose the option > ");
            choice = scanner.nextInt();
            if (choice == 1) {
                listAllTheMovies();
            } else if (choice == 2) {
                bookTickets();
            } else if (choice == 3) {
                checkSeatsAvailability();
            }
        } while (choice != 5);
        System.out.println("Thank you, Exiting ...\n");
    }
}