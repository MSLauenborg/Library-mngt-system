public static void main(String[] args) {

    Library library = new Library();


    Book book1 = new Book("Klaus Rifbjerg",
            "Den kroniske uskyld",
            "9788700184466",
            1);

    Book book2 = new Book("J.K. Rowling",
            "Harry Potter 1",
            "9788702272451",
            2);

    Book book3 = new Book("D. Alighieri",
            "The Divine Comedy",
            "2288701172451",
            2);
    Member member1 = new Member("Morten", 1234);
    Member member2 = new Member("Louise", 4321);
    Member member3 = new Member("Morten", 1111);
    final Loan loan1 = new Loan(book1, member1, LocalDate.of(2026, 9, 16));
    final Loan loan2 = new Loan(book3,member2, LocalDate.of(2026,9,16));

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

    library.addBook(book1);
    library.addBook(book2);
    Book foundBook = library.getBooks(1);
//    IO.println(foundBook);
    Book unknownBook = library.getBooks(100);
//    IO.println(unknownBook);

    Member foundMember = library.getMembers(1234);
    //IO.println(foundMember);

    library.loanBook(1,1234);
    library.loanBook(2,1234);

    ArrayList<Loan> loans = library.findLoansByMemberId(1234);

    IO.println(loans);
   // IO.println(loans);
    //IO.println(loans);
   // IO.println(library.returnBook(1));
   // loans = library.getLoan();
  //  IO.println(loans);

//    boolean loaned = loan1.loanBook(member1);
//    boolean loanedd = loan2.loanBook(member2);


//    IO.println(loan1);
//    library.printBooks();
//    library.printMembers();

//    IO.println(library.getBook().contains(book1));
//    IO.println(library.getMember().contains(member1));
//    IO.println(member1.equals(member3));
}


