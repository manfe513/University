import mooc.EdxIO;

import java.math.BigDecimal;

public class Lab_1_2 {

    public static void main(String[] args) {

        try(EdxIO io = EdxIO.create()) {

            BigDecimal firstOperand = BigDecimal.valueOf(io.nextInt());
            BigDecimal secondOperand = BigDecimal.valueOf(io.nextInt());

            BigDecimal result = firstOperand.add(secondOperand.multiply(secondOperand));

            io.println(result.longValue());
        }
    }
}
