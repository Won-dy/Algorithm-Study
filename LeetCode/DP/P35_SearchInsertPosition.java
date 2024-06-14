public class P35_SearchInsertPosition {

    public static void main(String[] args) {
        searchInsert(new int[]{1, 3, 5, 6}, 5);  // 2
        searchInsert(new int[]{1, 3, 5, 6}, 2);  // 1
        searchInsert(new int[]{1, 3, 5, 6}, 7);  // 4
        searchInsert(new int[]{1, 3, 5, 6}, 0);  // 0
        searchInsert(new int[]{3, 5, 7, 9, 10}, 6);  // 2
    }

    public static int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (target > nums[midIndex]) {  // 오른쪽 탐색
                startIndex = midIndex + 1;
            } else if (target < nums[midIndex]) {  // 왼쪽 탐색
                endIndex = midIndex - 1;
            } else {  // target == nums[midIndex]
                return midIndex;
            }
        }
        return startIndex;
    }
}
