import mooc.*;

public class Lab_1 {

    public static void main(String[] args) {

        try(EdxIO io = EdxIO.create()) {
            io.println(io.nextInt() + io.nextInt());
        }
    }
}
