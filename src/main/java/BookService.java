import java.sql.*;
import java.util.Scanner;

public class BookService {

    static void addBook() throws SQLException {
        String DB_URL = "jdbc:sqlite:C:\\task20\\newDatabase";
        String INSERT_TITLE_AND_PAGES = "INSERT INTO Books VALUES('" + Book.id + "', '" +
                Book.title + "', '" + Book.authorId + "', " + Book.pagesCount + ")";
        try (
                Connection connection = DriverManager.getConnection(DB_URL);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(INSERT_TITLE_AND_PAGES);
        }
    }

    static void addAuthor() throws SQLException {
        String DB_URL = "jdbc:sqlite:C:\\task20\\newDatabase";
        String INSERT_FIRST_NAME_AND_LAST_NAME = "INSERT INTO Authors VALUES('" + Author.id + "', '"
                + Author.firstName + "', '" + Author.lastName + "')";
        try (
                Connection connection = DriverManager.getConnection(DB_URL);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(INSERT_FIRST_NAME_AND_LAST_NAME);
        }
    }

    static void getBooksByAuthor() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which author are you looking for?");
        System.out.println("Write author's first name and then ENTER");
        String firstName = sc.nextLine();
        System.out.println("Write author's last name and then ENTER");
        String lastName = sc.nextLine();
        String DB_URL = "jdbc:sqlite:C:\\task20\\newDatabase";
        String JOIN_TABLES = "SELECT Books.id, firstName, lastName, title, pagesCount FROM Books " +
                "JOIN Authors ON Books.authorId = Authors.id " +
                "WHERE firstName='" + firstName +
                "' AND lastName='" + lastName + "'";
        try (
                Connection connection = DriverManager.getConnection(DB_URL);
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(JOIN_TABLES);
            System.out.println("Books by this author:");
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name1 = resultSet.getString(2);
                String name2 = resultSet.getString(3);
                String title = resultSet.getString(4);
                int pages = resultSet.getInt(5);
                System.out.println(id + "\t" + name1 + "\t" + name2 + "\t" + title + "\t"  + pages);
            }
        }
        System.out.println("""
                Do you want to continue your search?
                1 - yes
                2 - no""");
        int answer = sc.nextInt();
        Main.search = answer == 1;
    }
}
