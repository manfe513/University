import mooc.EdxIO;

public class Lab_1_3 {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            int numCount = io.nextInt();
            int temp = 0;

            int[] nums = new int[numCount];
            int[] moveIndices = new int[numCount];
            moveIndices[0] = 1;

            for (int j = 0; j < numCount; j++) {
                nums[j] = io.nextInt();

                if (j < 1) continue;

                boolean changed = false;
                for (int i = j - 1; i >= 0; i--) {

                    if (nums[i] > nums[i + 1]) {

                        temp = nums[i + 1];
                        nums[i + 1] = nums[i];
                        nums[i] = temp;

                        changed = true;
                        moveIndices[j] = i + 1;
                    }
                }

                if (!changed) {
                    moveIndices[j] = j + 1;
                }
            }

            printNumsToOutput(io, moveIndices);
            printNumsToOutput(io, nums);
        }
    }

    private static void printNumsToOutput(EdxIO io, int[] nums) {
        StringBuilder sbMoveIndices = new StringBuilder();
        for (int moveIndex : nums) {
            sbMoveIndices.append(moveIndex);
            sbMoveIndices.append(" ");
        }

        io.println(sbMoveIndices.toString());
    }
}
