import java.util.Scanner;
// Abstract class Media
abstract class Media {
    String title;
    String publication;
    // Pass the scanner instance to avoid creating multiple streams
    abstract void read(Scanner sc);
    abstract void show();
}
// Book class inherited from Media
class Book extends Media {
    int pages;
    static int countBooks = 0;
    void read(Scanner sc) {
        System.out.print("Enter book title: ");
        title = sc.nextLine();
        System.out.print("Enter publication: ");
        publication = sc.nextLine();
        System.out.print("Enter number of pages: ");
        pages = sc.nextInt();
        sc.nextLine(); // Clear the buffer after nextInt()
        if (pages > 400) {
            countBooks++;
        }
    }
    void show() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication: " + publication);
        System.out.println("Pages: " + pages);
    }
    static int count() {
        return countBooks;
    }
}
// Tape class inherited from Media
class Tape extends Media {
    int playingTime;
    void read(Scanner sc) {
        System.out.print("Enter tape title: ");
        title = sc.nextLine();
        System.out.print("Enter publication: ");
        publication = sc.nextLine();
        System.out.print("Enter playing time (minutes): ");
        playingTime = sc.nextInt();
        sc.nextLine(); // Clear the buffer after nextInt()
    }
    void show() {
        System.out.println("Tape Title: " + title);
        System.out.println("Publication: " + publication);
        System.out.println("Playing Time: " + playingTime + " minutes");
    }
}
public class book1 { // Rename class to 'Main' to match standard conventions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // Clear buffer
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Book " + (i + 1));
            books[i] = new Book();
            books[i].read(sc); // Use the shared scanner
        }
        System.out.print("\nEnter number of tapes: ");
        int m = sc.nextInt();
        sc.nextLine(); // Clear buffer
        Tape[] tapes = new Tape[m];
        for (int i = 0; i < m; i++) {
            System.out.println("\nEnter details of Tape " + (i + 1));
            tapes[i] = new Tape();
            tapes[i].read(sc);
        }
        System.out.println("\n--- Book Details ---");
        for (Book b : books) {
            b.show();
            System.out.println();
        }
        System.out.println("\n--- Tape Details ---");
        for (Tape t : tapes) {
            t.show();
            System.out.println();
        }
        System.out.println("Number of books having more than 400 pages: " + Book.count());
        System.out.println("\nTapes with playing time more than 60 minutes:");
        for (Tape t : tapes) {
            if (t.playingTime > 60) {
                System.out.println("- " + t.title);
            }
        }
        sc.close(); // Close only at the very end
    }
}


