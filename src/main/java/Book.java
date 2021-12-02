import java.util.Scanner;

public class Book {

    static String id;
    static String title;
    static String authorId;
    static int pagesCount;

    static void getData() {
        id = IdGenerator.getId();
        authorId = IdGenerator.getId();
        System.out.println("Write book's name and then ENTER");
        Scanner sc = new Scanner(System.in);
        title = sc.nextLine();
    }

    static void getPages(){
        System.out.println("Write pages count and then ENTER");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            pagesCount = sc.nextInt();
        } else
            getPages();
    }
}
