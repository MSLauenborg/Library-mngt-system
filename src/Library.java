import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Book> getBook() {
        return books;
    }

    public Book getBooks(int bookId) {
        for (Book book : books) {
            if (book.getID() == bookId) {
                return book;
            }
        }
        return null;
    }


    public Member getMembers(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }


    public boolean loanBook(int bookId, int memberId) {
        Book book = getBooks(bookId);
        Member member = getMembers(memberId);
        if (book == null || member == null) {
            return false;
        }
        Loan newLoan = new Loan(book, member, LocalDate.now());
        loans.add(newLoan);
        return true;
    }

    public boolean returnBook(int bookId) {
        Book book = getBooks(bookId);
        if (book == null) {
            return false;
        }
        for (Loan loan : loans) {
            if (loan.getBook().getID() == book.getID() && !loan.isAvailable()) {
                loan.returnBook();
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> result = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getMemberId() == memberId) {
                result.add(loan);

            }
        }
        return result;
    }


    public ArrayList<Member> getMember() {
        return members;
    }

    public ArrayList<Loan> getLoan() {
        return loans;
    }

    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }


}
