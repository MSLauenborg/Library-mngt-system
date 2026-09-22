import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;

    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("indtast dit ønske for menu "));
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("ugyldigt valg. prøv igen");
            }
        }
    }

    private void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();

    }

    private void borrowBook() {
        int userSelectBook = Integer.parseInt(IO.readln("indtast bogId du vil låne: "));
        int userSelectMemberId = Integer.parseInt(IO.readln("indtast dit medlemsID: "));
        if(library.loanBook(userSelectBook, userSelectMemberId)) {
          IO.println("du har nu lånt bogen " + library.getBooks(userSelectBook));
        } else {
            IO.println("Kunne ikke låne din bog, prøv igen ");
        }
    }

    private void returnBook() {
        int userReturnBookId = Integer.parseInt(IO.readln("indtast bogens bogId du vil aflevere: "));
        if (library.returnBook(userReturnBookId)) {
            IO.println("Du har afleveret bogen: " + library.getBooks(userReturnBookId));
        } else {
            IO.println("Kunne ikke aflevere din bog, prøv igen ");
        }
    }

    private void showLoans() {
        int userTypesMemberId = Integer.parseInt(IO.readln("Indtast dit medlemsId for at se dine lånte bøger: "));
        ArrayList<Loan> loans = library.findLoansByMemberId(userTypesMemberId);
        if (loans.isEmpty()) {
            IO.println("Du har ingen bøger lånt");
        } else {
            IO.println("Du har lånt følgende: ");
            for(Loan loan : loans) {
                IO.println(loan);
            }
        }
    }

}

