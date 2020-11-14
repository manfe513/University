/**
 * 2. + Напишите программу, в которой есть суперкласс с приватным текстовым полем.
 *
 * 1) + В базовом классе должен быть метод для присваивания значения полю: без параметров и с
 * одним текстовым параметром.
 *
 * 2) + Объект суперкласса создается передачей одного текстового аргумента конструктору.
 *
 * 3) + Доступное только для чтения свойство результатом возвращает длину текстовой строки.
 * На основе суперкласса создается подкласс.
 *
 * 4) + В подклассе появляется дополнительное открытое целочисленное поле.
 *
 * В классе должны быть такие версии метода для присваивания значений полям (используется переопределение
 * и перегрузка метода из суперкласса):
 * + без параметров,
 * + с текстовым параметром,
 * + с целочисленным параметром,
 * + с текстовым и целочисленным параметром.
 *
 * + У конструктора подкласса два параметра (целочисленный и текстовый).
 */

public class ex_2 {

    public static void main(String[] args) {

        Sub_2 subCls = new Sub_2(3, "superClass text");

        //superText = "superClass text"
        //num = 3
        System.out.println(subCls.toString());

        subCls.initFields("two");
        //superText = "twoR"
        //num = -1
        System.out.println(subCls.toString());

        subCls.initFields(1, "one");
        //superText = "one"
        //num = 1
        System.out.println(subCls.toString());
    }
}

class Super_2 {

    private String superText;

    final int textLength = superText != null ? superText.length() : 0;

    Super_2() { initText(); }
    Super_2(String superText) { this.superText = superText; }

    void initText() { superText = "default"; }
    void initText(String text) { superText = text; }

    @Override
    public String toString() {
        return "Class: Super_2, superText: " + superText;
    }
}

class Sub_2 extends Super_2 {

    int num;

    Sub_2(int num, String text) {
        this.num = num;
        super.initText(text);
    }

    private void initNumDefault() { num = -1; }

    void initFields() {
        initNumDefault();
        super.initText();
    }

    void initFields(int num) {
        this.num = num;
        super.initText();
    }

    void initFields(String text) {
        initNumDefault();
        super.initText(text);
    }

    void initFields(int num, String text) {
        this.num = num;
        super.initText(text);
    }

    @Override
    public String toString() {
        return super.toString() + "\nClass: " + this.getClass().getName() + ", num: " + num;
    }
}
