public class P643_MaximumAverageSubarrayI {

    // https://leetcode.com/problems/maximum-average-subarray-i
    public static void main(String[] args) {
        findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);  // 12.75000
        findMaxAverage(new int[]{5}, 1);  // 5.00000
        findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 1);  // 50.00000
    }

    // 2 ms (99.93%) / 56.26 MB (43.66%)

    // 1. 0 부터 k 까지의 합을 sum, maxSum 에 저장 한다.
    // 2. k 길이의 양 쪽 포인터를 오른쪽으로 한 칸 씩 동시에 옮겨가며 해당 구간의 sum 을 구한다.
    // 3. 이전 계산의 sum 에서 오른쪽 포인터의 값을 더하고, 이전의 왼쪽 포인터 값을 빼면 현재 sum 이 된다.
    // 4. 현재 sum 이 maxSum 보다 크면 maxSum 을 현재 sum 으로 갱신한다.
    // 5. 배열 nums 의 모든 구간을 순회할 때 까지 2~4 번 과정을 반복한다.
    // 6. maxSum / k 를 double 로 계산하여 반환한다.
    public static double findMaxAverage(int[] nums, int k) {
        int maxSum;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return (double) maxSum / k;
    }
}
