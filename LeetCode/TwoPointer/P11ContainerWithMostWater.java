public class P11ContainerWithMostWater {

    // https://leetcode.com/problems/container-with-most-water
    public static void main(String[] args) {
        maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});  // 49
        maxArea(new int[]{1, 1});  // 1
        maxArea(new int[]{1, 2, 3, 4, 5, 3, 1});  // 9
    }

    // 3 ms (96.06%) / 57.26 MB (85.59%)

    // 1. 0 번 인덱스에 left 포인터를, 배열의 마지막 인덱스에 right 포인터를 초기화한다.
    // 2. 물의 최대 양 변수를 (maxArea) 0 으로 초기화 한다.
    // 3. 두 포인터 중 더 작은 포인터의 값을 높이로하고, 두 포인터의 차를 너비로 하여 두 값을 곱한 현재 물 양을 (nowArea) 구한다.
    // 4. maxArea 와 비교하여 nowArea 가 더 크면 maxArea 에 nowArea 값을 넣는다.
    // 5. 더 작은 높이를 가지는 포인터를 가운데 방향으로 한 칸 옮긴다.
    // 6. 두 포인터가 만나기 전 까지 3 ~ 5 번 과정을 반복한다.
    // 7. maxArea 에 저장되어 있는 값이 물의 최대 양이므로 반환한다.
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int nowArea;

            if (height[left] < height[right]) {
                nowArea = height[left++] * width;
            } else {
                nowArea = height[right--] * width;
            }

            if (nowArea > maxArea) {
                maxArea = nowArea;
            }
        }

        return maxArea;
    }
}
