
public class task_1 {

    public static void main(String[] args) {

        checkDayOfWeek();
    }

    private static void checkDayOfWeek() {
        int num = getNum();
        String dayOfWeekName;

        switch (num) {
            case 1:
                dayOfWeekName = "Понедельник";
                break;
            case 2:
                dayOfWeekName = "Вторник";
                break;
            case 3:
                dayOfWeekName = "среда";
                break;
            case 4:
                dayOfWeekName = "четверг";
                break;
            case 5:
                dayOfWeekName = "пятница";
                break;
            case 6:
                dayOfWeekName = "суббота";
                break;
            case 7:
                dayOfWeekName = "воскресенье";
                break;
            default:
                System.out.println("Некоррктный номер, введите число от 1 до 7 включительно");
                checkDayOfWeek();
                return;
        }

        System.out.printf("День недели: %s", dayOfWeekName);
    }

    private static int getNum() {
        int num = Helper.readNum("Введите число от 1 до 7: ");

        if(num < 1 || num > 7) {
            return getNum();
        }

        return num;
    }
}
