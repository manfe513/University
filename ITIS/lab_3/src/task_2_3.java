/**
 * Программа определяет номер дня недели по введённой строке
 * Версия программы: 3/3
 * Способ проверки: карта для сопоставления имени дня недели и его номера
 */

import java.util.HashMap;
import java.util.Map;

public class task_2_3 {

    private static final Map<String, Integer> dayNameToNumberMap = new HashMap<>() {{
        put("понедельник", 1);
        put("вторник", 2);
        put("среда", 3);
        put("четверг", 4);
        put("пятница", 5);
        put("суббота", 6);
        put("воскресенье", 7);
    }};

    public static void main(String[] args) {
        checkDayOfWeek();
    }

    private static void checkDayOfWeek() {
        String dayOfWeekName = Helper.readLine("Введите название дня недели: ");

        Integer dayNumber = dayNameToNumberMap.get(dayOfWeekName);

        if(dayNumber != null) {
            System.out.printf("День недели: %d", dayNumber);

        } else {
            System.out.println("Некоррктное имя дня, введите например \"среда\"");
            checkDayOfWeek();
        }
    }
}
