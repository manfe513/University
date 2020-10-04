/**
 * Программа определяет номер дня недели по введённой строке
 * Версия программы: 1/3
 * Способ проверки: оператор выбора switch
 */
public class task_2_1 {

    public static void main(String[] args) {

        checkDayOfWeek();
    }

    private static void checkDayOfWeek() {
        String dayOfWeekName = Helper.readLine("Введите название дня недели: ").toLowerCase();
        int dayNumber;

        switch (dayOfWeekName) {
            case "понедельник":
                dayNumber = 1;
                break;
            case "вторник":
                dayNumber = 2;
                break;
            case "среда":
                dayNumber = 3;
                break;
            case "четверг":
                dayNumber = 4;
                break;
            case "пятница":
                dayNumber = 5;
                break;
            case "суббота":
                dayNumber = 6;
                break;
            case "воскресенье":
                dayNumber = 7;
                break;
            default:
                System.out.println("Некоррктное имя дня, введите например \"среда\"");
                checkDayOfWeek();
                return;
        }

        System.out.printf("День недели: %d", dayNumber);
    }
}
