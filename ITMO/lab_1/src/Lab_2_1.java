import mooc.EdxIO;

public class Lab_2_1 {

    private static EdxIO io = EdxIO.create();

    public static void main(String[] args) {

        int count = io.nextInt();

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) nums[i] = io.nextInt();

        //--
        int[] sorted = mergeSort(nums, 0, nums.length - 1);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }

    private static int[] mergeSort(int[] arr, int l, int r) {
        if (l == r) return arr;

        int mid = (r - l) / 2+l;

        int[] left = new int[mid-l];
        int[] right = new int[r - mid];

        for (int i = 0; i < left.length; i++) left[i] = arr[l + i];
        for (int i = 0; i < right.length; i++) right[i] = arr[mid + i];

        int[] leftSorted = mergeSort(arr, l, mid);
        int[] rightSorted = mergeSort(arr, mid + 1, r);

        return merge(leftSorted, rightSorted, l, mid, r);
    }

    private static int[] merge(int[] left, int[] right,
                               int srcL, int srcM, int srcR) {

        int l = 0, r = 0, cur = 0;

        int[] result = new int[left.length + right.length];

        while (l < left.length && r < right.length) {

            if (left[l] <= right[r]) {
                result[cur++] = left[l++];
            } else {
                result[cur++] = right[r++];
            }
        }

        if (l < left.length) {
            while (l < left.length) result[cur++] = left[l++];
        } else {
            while (r < right.length) result[cur++] = right[r++];
        }

        return result;
    }
}
