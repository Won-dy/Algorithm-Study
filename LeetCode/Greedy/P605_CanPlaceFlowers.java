public class P605_CanPlaceFlowers {

    // https://leetcode.com/problems/can-place-flowers
    public static void main(String[] args) {
        canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);  // true
        canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2);  // false
    }

    // 1 ms (96.97%) / 45.59 MB (48.73%)

    // 1. 입력으로 주어진 화단은 규칙을 만족하므로 n 이 0 이면 true 를 반환한다.
    // 2. 화단 배열을 순회하면서 아래 세 조건을 확인한다.
    // 3-1. 현재 꽃이 0 이고, 첫 번째 꽃이거나 이전 꽃이 0 이고, 마지막 꽃이거나 다음 꽃이 0 이면
    // 3-2. 첫 번째 꽃이거나 이전 꽃이 0 이고 (현재 꽃이 첫 번째 꽃이면, 이전 꽃을 확인할 필요 없다.)
    // 3-3. 마지막 꽃이거나 다음 꽃이 0 이면 (현재 꽃이 마지막 꽃이면, 다음 꽃을 확인할 필요 없다.)
    // 4. 위 세 조건을 만족하면, 꽃을 심고 (1로 변경), 심을 꽃 개수를 -1 한다.
    // 5. 심을 꽃이 0 개가 되면 모두 심은 것이므로 true 를 반환한다.
    // 6. 배열 순회가 끝난 후에도 심을 꽃이 남아 있으면 모두 심지 못한 것이므로 false 를 반환한다.
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                && (i == 0 || flowerbed[i - 1] == 0)
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
