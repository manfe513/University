/**
 * 2. Напишите программу, в которой есть суперкласс с приватным текстовым полем.
 *
 * 1) В базовом классе должен быть метод для присваивания значения полю: без параметров и с
 * одним текстовым параметром.
 *
 * 2) Объект суперкласса создается передачей одного текстового аргумента конструктору.
 *
 * 3) Доступное только для чтения свойство результатом возвращает длину текстовой строки.
 * На основе суперкласса создается подкласс.
 *
 * 4) В подклассе появляется дополнительное открытое целочисленное поле.
 *
 * В классе должны быть такие версии метода для присваивания значений полям (используется переопределение
 * и перегрузка метода из суперкласса):
 * - без параметров,
 * - с текстовым параметром,
 * - с целочисленным параметром,
 * - с текстовым и целочисленным параметром.
 *
 * - У конструктора подкласса два параметра (целочисленный и текстовый).
 */

public class ex_2 {

    public static void main(String[] args) {

        Sub_1 subCls = new Sub_1("subslass text");

        //superText = null
        //sbText = "subslass text"
        System.out.println(subCls.toString());

        //просто отделить вывод
        System.out.println();

        Sub_1 subCls_2 = new Sub_1("super text 1", "subslass text");

        //superText = "super text 1"
        //sbText = "subslass text"
        System.out.println(subCls_2.toString());
    }
}

class Super_2 {

    private String superText;

    Super_2() {
        //значение текста = значение по умолчанию для экземпляров класса,
        // для строки = null
    }

    Super_2(String superText) {
        this.superText = superText;
    }

    @Override
    public String toString() {
        return "Class: Super_1, superText: " + superText;
    }
}

class Sub_2 extends Super_1 {

    private final String subText;

    Sub_2(String subText) {
        super();
        this.subText = subText;
    }

    Sub_2(String superText, String subText) {
        super(superText);
        this.subText = subText;
    }

    @Override
    public String toString() {
        return super.toString() + "\nClass: " + this.getClass().getName() + ", subText: " + subText;
    }
}
