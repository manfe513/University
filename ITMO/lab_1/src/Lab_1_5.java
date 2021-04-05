import mooc.EdxIO;

public class Lab_1_5 {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            int count = io.nextInt();

            int[] nums = new int[count];
            for (int i = 0; i < count; i++) nums[i] = io.nextInt();

            //--
            for(int i = 0; i < count-1; i++) {
                int minElementIndex = i;

                for(int k = i+1; k < count; k++) {

                    if(nums[k] < nums[minElementIndex]) minElementIndex = k;
                }

                if(i != minElementIndex) {
                    swap(nums, i, minElementIndex);
                    io.println("Swap elements at indices "+getPrintableIndex(Math.min(i, minElementIndex))+" and "+getPrintableIndex(Math.max(i, minElementIndex))+".");
                }
            }

            io.print("No more swaps needed.");
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    private static int getPrintableIndex(int index) {
        return index+1;
    }
}
