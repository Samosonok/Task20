import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Book> result = new ArrayList<>();
    static String firstNameForSearch;
    static String lastNameForSearch;
    static boolean condition1 = true;
    static boolean condition2 = true;

    public static void main(String[] args) throws SQLException {
        BookService bookService = new BookService();

        while (condition1) {
            Book book = new Book(IdGenerator.getId(), getBookName(), IdGenerator.getId(), getPages());
            Author author = new Author(book.authorId, getFirstName(), getLastName());

            bookService.addBook(book);
            bookService.addAuthor(author);
            getNextInstruction();

            while (condition2) {
                getNamesForSearch();
                bookService.getBooksByAuthor(result, firstNameForSearch, lastNameForSearch);
                condition2 = false;
                condition1 = false;
            }
        }

        System.out.println("BOOKS BY THIS AUTHOR");
        int c = 1;
        for (Book d : result) {
            System.out.println(c + ". " + d.title);
            c++;
        }
    }

    private static String getBookName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write book title and then ENTER");
        return sc.nextLine();
    }

    private static int getPages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write pages count and then ENTER");
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else
            return getPages();
    }

    private static String getFirstName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write author's first name and then ENTER");
        return sc.nextLine();
    }

    private static String getLastName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write author's last name and then ENTER");
        return sc.nextLine();
    }

    private static void getNextInstruction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Will you add more books?
                1 - yes
                2 - no""");
        int answer = sc.nextInt();
        condition2 = answer != 1;
    }

    private static void getNamesForSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which author are you looking for?");
        System.out.println("Write author's first name and then ENTER");
        firstNameForSearch = sc.nextLine();
        System.out.println("Write author's last name and then ENTER");
        lastNameForSearch = sc.nextLine();
    }
}
