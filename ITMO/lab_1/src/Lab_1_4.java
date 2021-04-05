import mooc.EdxIO;

public class Lab_1_4 {

    public static void main(String[] args) {


        try (EdxIO io = EdxIO.create()) {

            int count = io.nextInt();
            Item[] nums = new Item[count];

            for (int i = 0; i < count; i++) {
                nums[i] = new Item(io.nextDoubleFast(), i);
            }

            for(int i =0; i<count; i++) {
                for (int k = 1; k < count-i; k++) {

                    if(nums[k-1].val > nums[k].val) {
                        Item temp = nums[k-1];
                        nums[k-1] = nums[k];
                        nums[k] = temp;
                    }
                }
            }

            io.print(nums[0].index+1 + " ");
            io.print(nums[count/2].index+1 + " ");
            io.print(nums[count-1].index+1 + " ");
        }
    }

    static class Item {
        double val;
        int index;

        Item(double val, int index){
            this.val = val;
            this.index = index;
        }
    }
}
