import java.time.LocalDate;

public class Book {
    private final String author;
    private final String title;
    private final String isbn;
    private final int id;
    LocalDate borrowedDate;

    public Book(String author, String title, String isbn, int id) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.borrowedDate = null;
    }

//    public String getBook() {
//        return author;
//    }

    public int getID() {
        return this.id;
    }

    public String toString() {
        return String.format("""
                %s: %s; ISBN: %s; (%s)""", author, title, isbn, id);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        return this.title.equals(other.title);
    }



}
