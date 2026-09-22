import java.time.LocalDate;

public class Loan {
  private  int loanId;
    private Member borrowedBy;
    private LocalDate borrowedDate;
    private Book book;


    public Loan(Book book, Member borrowedBy, LocalDate borrowedDate) {
        this.borrowedBy = borrowedBy;
        this.borrowedDate = borrowedDate;
        this.book = book;
    }

    public Book getBook() {
        return this.book;
    }

    public void returnBook() {
        this.borrowedBy = null;
        this.borrowedDate = null;
    }

//    public boolean loanBook(Member member) {
//        if (isAvailable()) {
//            this.borrowedBy = member;
//            this.borrowedDate = LocalDate.now();
//            return true;
//        }
//        return false;
//    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }

    public LocalDate getDueDate() {
        if (borrowedDate == null) {
            return null;
        }
        return borrowedDate.plusDays(14);

    }
//
//    public boolean isOverdue() {
//        LocalDate today = LocalDate.now();
//        if (getDueDate() == null) return false;
//        if (today.isAfter(getDueDate())) {
//            return true;
//        }
//        return false;
//    }

    public int getMemberId() {
        return borrowedBy.memberId;
    }


    public String toString() {
        return String.format(""" 
                        %s %s, afleveringsfrist: %s
                        """
                ,book, borrowedBy, getDueDate());
    }

//    public int getLoanId() {
//        return this.loanId;
//    }

}
