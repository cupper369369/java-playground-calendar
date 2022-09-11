import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month;

        month = scanner.nextInt();
        scanner.close();

        System.out.println(month + "월은 " + getMaxDaysOfMonth(month) + "일까지 있습니다.");
    }
}