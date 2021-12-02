import java.util.Scanner;

public class Author {

    static String id;
    static String firstName;
    static String lastName;

    static void getData() {
        id = Book.authorId;
        System.out.println("Write author's first name and then ENTER");
        Scanner sc = new Scanner(System.in);
        firstName = sc.nextLine();
        System.out.println("Write author's last name and then ENTER");
        lastName = sc.nextLine();
        System.out.println("""
                Will you add more books?
                1 - yes
                2 - no""");
        int answer = sc.nextInt();
        Main.addition = answer == 1;
    }
}
