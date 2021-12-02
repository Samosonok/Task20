import java.sql.SQLException;

public class Main {

    static boolean addition = true;
    static boolean search = true;

    public static void main(String[] args) throws SQLException {
        while (addition) {
            Book.getData();
            Book.getPages();
            Author.getData();
            BookService.addBook();
            BookService.addAuthor();
        }
        while (search) {
            BookService.getBooksByAuthor();
        }
    }
}
