import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int getMaxDaysOfMonth(int year, int month) {
        if (year % 4 != 0)
            return MAX_DAYS[month];
        if (year % 100 != 0)
            return LEAP_MAX_DAYS[month];
        if (year % 400 == 0)
            return LEAP_MAX_DAYS[month];
        return MAX_DAYS[month];
    }

    public static void printCalendar(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int dayOfWeekNumber = date.getDayOfWeek().getValue();

        System.out.printf("    <<%4d년%3d월>>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        for (int i = 0; i < (dayOfWeekNumber % 7); i++)
            System.out.print("   ");

        for (int i = 1; i <= getMaxDaysOfMonth(year, month); i++){
            System.out.printf("%3d", i);

            if ((dayOfWeekNumber + i) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month;

        while (true) {
            System.out.println("년도를 입력하세요.(exit: -1)");
            System.out.print("YEAR> ");
            year = scanner.nextInt();
            if (year == -1)
                break;

            System.out.println("달을 입력하세요.");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            if (month < 1 || 12 < month) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            printCalendar(year, month);
        }

        scanner.close();
        System.out.println("Bye");
    }
}