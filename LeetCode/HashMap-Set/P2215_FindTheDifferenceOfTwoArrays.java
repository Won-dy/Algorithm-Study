import java.util.*;

public class P2215_FindTheDifferenceOfTwoArrays {

    // https://leetcode.com/problems/find-the-difference-of-two-arrays
    public static void main(String[] args) {
        findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});  // [[1,3],[4,6]]
        findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});  // [[3],[]]

        findDifference2(new int[]{1, 2, 3}, new int[]{2, 4, 6});  // [[1,3],[4,6]]
        findDifference2(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});  // [[3],[]]
    }

    // 10 ms (79.05%) / 45.26 MB (76.58%)

    // 1. nums1 과 nums2 를 각각 set1, set2 HashSet 에 추가하여 중복 값을 제거한다.
    // 2. set1 의 값이 set2 에 없다면 ans1 에 추가한다.
    // 3. set2 의 값이 set1 에 없다면 ans2 에 추가한다.
    // 4. ans1 과 ans2 를 ans 에 추가하여 ans 를 반환한다.
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }

        for (int n : set1) {
            if (!set2.contains(n)) {
                ans1.add(n);
            }
        }
        for (int n : set2) {
            if (!set1.contains(n)) {
                ans2.add(n);
            }
        }

        ans.add(ans1);
        ans.add(ans2);

        return ans;
    }

    // 11 ms (46.07%) / 45.06 MB (94.15%)

    // 1. nums1 과 nums2 를 각각 set1, set2 HashSet 에 추가하여 중복 값을 제거한다.
    // 2. set1 의 값이 set2 에 있다면 keys HashSet 에 추가한다.
    // 3. keys 의 값을 set1 과 set2 에서 제거한다.
    // 4. set1 과 sets2 를 갖는 list 를 반환한다.
    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }

        Set<Integer> keys = new HashSet<>();
        for (int n : set1) {
            if (set2.contains(n)) {
                keys.add(n);
            }
        }

        for (int key : keys) {
            set1.remove(key);
            set2.remove(key);
        }

        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));
    }
}
