class Movie {
    String title;
    String Director;
    int yearOfRelease;
    float ratings;
    Movie next;
    Movie(String title, String Director, int yearOfRelease,float ratings) {
        this.title = title;
        this.Director = Director;
        this.yearOfRelease = yearOfRelease;
        this.ratings = ratings;
    }
}
public class linkedList3 {
    Movie head;
    public void addAtBeginning(String title, String Director, int yearOfRelease,float ratings) {
        Movie movie = new Movie(title, Director, yearOfRelease, ratings);
        if (head == null) {
            System.err.println("Not a valid list");
            System.exit(0);
        }
        movie.next = head;
        head = movie;
    }
    public void addDataAtEnd(String title, String Director, int yearOfRelease,float ratings) {
        Movie movie = new Movie(title, Director, yearOfRelease, ratings);
        if (head == null) {
            System.err.println("Not a valid list");
            System.exit(0);
        }
        if (head.next == null) {
            
        }
    }
}
