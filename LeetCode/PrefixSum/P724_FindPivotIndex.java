public class P724_FindPivotIndex {

    // https://leetcode.com/problems/find-pivot-index
    public static void main(String[] args) {
        pivotIndex(new int[]{1, 7, 3, 6, 5, 6});  // 3
        pivotIndex(new int[]{1, 2, 3});  // -1
        pivotIndex(new int[]{2, 1, -1});  // 0
    }

    // 1 ms (94.73%) / 45.58 MB (36.77%)

    // 1. nums 의 0 번째 요소부터 i 번째 요소까지의 합인 누적 합을 구하여 sum 배열에 저장한다.
    // 2. pivot 인덱스를 0 부터 nums.length 까지 설정하는 반복문을 순회한다.
    // 3. pivot 인덱스 p 를 기준으로 왼쪽 요소들의 합은 sum[p] 이다.
    // 4. pivot 인덱스 p 를 기준으로 오른쪽 요소들의 합은 sum[nums.length] - sum[p + 1] 이다. ( s(i, j) = sum[j] - sum[i - 1] )
    // 5. 왼쪽 구간 합과 오른쪽 구간 합이 같으면 pivot 인덱스를 반환한다.
    // 6. 반복문이 끝나도 pivot 인덱스가 없다면, -1을 반환한다.
    public static int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int p = 0; p < nums.length; p++) {
            int leftSum = sum[p];
            int rightSum = sum[nums.length] - sum[p + 1];
            if (leftSum == rightSum) {
                return p;
            }
        }

        return -1;
    }
}
