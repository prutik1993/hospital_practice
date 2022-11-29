import java.util.Scanner;

public class ScannerHelper {

    public static String getString(String question) {
        System.out.println(question);
        return scan().nextLine();
    }

    public static int getInt(String question) {
        System.out.println(question);
        return scan().nextInt();
    }

    public static double getDouble(String question) {
        System.out.println(question);
        return scan().nextDouble();
    }

    public static Scanner scan() {
        return new Scanner(System.in);
    }
}
