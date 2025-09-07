import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private LinkedHashMap<String, String> borrowedBooks = new LinkedHashMap<>();

    public void borrowBook(String studentName, String bookTitle) {
        borrowedBooks.put(studentName,bookTitle);
        System.out.println(studentName + " Has Borrowed " + bookTitle );
    }

    public void returnBook(String studentName) {
        if (borrowedBooks.containsKey(studentName)){
            String removedBook = borrowedBooks.remove(studentName);
            System.out.println(studentName + " Has returned their book");
        }else{
            System.out.println("Student hasn't borrowed any books");
        }
    }

    public void checkBorrowedBook(String studentName) {
        if (borrowedBooks.containsKey(studentName)){
            String stName = borrowedBooks.get(studentName);
            System.out.println(stName + " Has borrowed a book");
        }else{
            System.out.println(studentName + " hasn't borrowed any books");
        }
    }

    public void displayAllBorrowedBooks() {
        if (borrowedBooks.isEmpty()){
            System.out.println("The list is empty no one has borrowed any books");
        }else{
            System.out.println("List of borrowed books : ");
            for (Map.Entry<String,String> students : borrowedBooks.entrySet()){
                System.out.println(students.getKey() + ": " + students.getValue() );
            }
        }
    }

    public void borrowBookIfNotBorrowed(String bookTitle, String studentName) {
        if (borrowedBooks.containsValue(bookTitle)||borrowedBooks.containsKey(studentName)){
            System.out.println(bookTitle + " Is already borrowed by another student ");
        }else{
            System.out.println(studentName + " borrwed the book " + bookTitle + " Successfully" );
            borrowBook(studentName, bookTitle);
        }

    }

    public static void main(String[] args) {
        Main library = new Main();
        // testing the functionality 
        library.borrowBook("Ahmed", "Pragmatic Programmer");
        
        library.borrowBook("Adham", "Data Intensive Applications");

        library.displayAllBorrowedBooks();

        library.checkBorrowedBook("Charlie");

        library.borrowBookIfNotBorrowed("Pragmatic Programmer", "Charlie");

        library.borrowBookIfNotBorrowed("Operating Systems", "Charlie");

        library.returnBook("Alice");

        library.displayAllBorrowedBooks();

    }
}
