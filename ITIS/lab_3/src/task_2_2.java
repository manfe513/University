/**
 * Программа определяет номер дня недели по введённой строке
 * Версия программы: 2/3
 * Способ проверки: условные операторы
 */
public class task_2_2 {

    public static void main(String[] args) {

        checkDayOfWeek();
    }

    private static void checkDayOfWeek() {
        String dayOfWeekName = Helper.readLine("Введите название дня недели: ");
        int dayNumber;

        if(dayOfWeekName.equalsIgnoreCase("понедельник")) {
            dayNumber = 1;

        } else if(dayOfWeekName.equalsIgnoreCase("вторник")) {
            dayNumber = 2;

        } else if(dayOfWeekName.equalsIgnoreCase("среда")) {
            dayNumber = 3;

        } else if(dayOfWeekName.equalsIgnoreCase("четверг")) {
            dayNumber = 2;

        } else if(dayOfWeekName.equalsIgnoreCase("пятница")) {
            dayNumber = 2;

        } else if(dayOfWeekName.equalsIgnoreCase("суббота")) {
            dayNumber = 2;

        } else if(dayOfWeekName.equalsIgnoreCase("воскресенье")) {
            dayNumber = 7;
        } else {
            System.out.println("Некоррктное имя дня, введите например \"среда\"");
            checkDayOfWeek();
            return;
        }

        System.out.printf("День недели: %d", dayNumber);
    }
}
