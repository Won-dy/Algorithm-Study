import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1679MaxNumberOfKSumPairs {

    // https://leetcode.com/problems/max-number-of-k-sum-pairs
    public static void main(String[] args) {
        maxOperations(new int[]{1, 2, 3, 4}, 5);  // 2
        maxOperations(new int[]{3, 1, 3, 4, 3}, 6);  // 1
        maxOperationsWithMap(new int[]{1, 2, 3, 4}, 5);  // 2
        maxOperationsWithMap(new int[]{3, 1, 3, 4, 3}, 6);  // 1
    }

    // 17 ms (94.68%) / 57.29 MB (47.96%)

    // 1. 0 번 인덱스에 left 포인터를, 배열의 마지막 인덱스에 right 포인터를 초기화한다.
    // 2. 계산 횟수를 (oper) 0 으로 초기화 한다.
    // 3. 배열을 오름차순 정렬한다.
    // 4. 두 포인터의 합을 구하고, k 와 같다면 oper 를 +1 하고 두 포인터를 가운데 방향으로 한 칸 옮긴다.
    // 5. 합이 k 보다 크다면 right 포인터를 감소시키고, 합이 k 보다 작다면 left 포인터를 증가 시킨다.
    // 6. 두 포인터가 만나기 전 까지 4 ~ 5 번 과정을 반복한다.
    // 7. oper 를 반환한다.
    public static int maxOperations(int[] nums, int k) {
        int oper = 0;
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                oper++;
                right--;
                left++;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }

        return oper;
    }

    // 34 ms (36.38%) / 54.75 MB (99.08%)

    // == 주어진 수를 key, 수의 개수를 value 로 갖는 map 에서 필요한 수를 찾는 방법 ==
    // 1. 주어진 nums 배열을 순회한다.
    // 2. k 에서 현재 수를 뺀 값을 other 에 저장한다.
    // 3. other 을 key 로 갖는 map 요소가 있으면  K-Sum Pair 이므로 연산 횟수를 (oper) +1 한다.
    // 4. 그리고 other 이 1개만 남아 있었다면 map 에서 제거하고, 2개 이상이면 value 를 -1 한다.
    // 5. map 에 없다면 현재 수를 key 로 갖는 요소의 value 에 +1 한다. 요소가 없었다면 value 를 1 로 하는 요소를 생성한다.
    // 6. oper 를 반환한다.
    public static int maxOperationsWithMap(int[] nums, int k) {
        int oper = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int other = k - num;
            if (map.containsKey(other)) {
                oper++;
                if (map.get(other) == 1) {
                    map.remove(other);
                } else {
                    map.put(other, map.get(other) - 1);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return oper;
    }
}
