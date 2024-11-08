public class P977_SquaresOfASortedArray {

    // https://leetcode.com/problems/squares-of-a-sorted-array
    public static void main(String[] args) {
        sortedSquares(new int[]{-4, -1, 0, 3, 10});  // [0, 1, 9, 16, 100]
        sortedSquares(new int[]{-7, -3, 2, 3, 11});  // [4, 9, 9, 49, 121]
    }

    // 1 ms (100.00%) / 47.67 MB (9.15%)

    // 배열의 양 끝 수의 제곱이 가장 크므로 투 포인터를 사용한다.
    // left, right 중 더 큰 수를 새 배열의 맨 뒤 부터 삽입한다.
    // 삽입한 포인터는 가운데 방향으로 한칸 옮긴다.
    // 위 동작을 두 포인터가 만날 때 까지 반복한다.
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int leftPow = nums[left] * nums[left];
            int rightPow = nums[right] * nums[right];

            if (leftPow > rightPow) {
                ans[idx--] = leftPow;
                left++;
            } else {
                ans[idx--] = rightPow;
                right--;
            }
        }

        return ans;
    }
}
