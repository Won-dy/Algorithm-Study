import java.util.*;

public class P1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public static void main(String[] args) {
        groupThePeopleWithList(new int[]{3, 3, 3, 3, 3, 1, 3});  // [[5],[0,1,2],[3,4,6]]
        groupThePeopleWithList(new int[]{2, 1, 3, 3, 3, 2});  // [[1],[0,5],[2,3,4]]
        groupThePeopleWithList(new int[]{2, 2});  // [[0,1]]

        groupThePeopleWithMap(new int[]{3, 3, 3, 3, 3, 1, 3});  // [[5],[0,1,2],[3,4,6]]
        groupThePeopleWithMap(new int[]{2, 1, 3, 3, 3, 2});  // [[1],[0,5],[2,3,4]]
        groupThePeopleWithMap(new int[]{2, 2});  // [[0,1]]
    }

    // 6 ms / 45.22 MB
    public static List<List<Integer>> groupThePeopleWithMap(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            // 현재 크기의 그룹이 없으면 초기화, 있으면 기존 그룹 불러오기
            List<Integer> group = groups.merge(groupSize, new ArrayList<>(), (old, newVal) -> old);
            group.add(i);  // 그룹에 멤버 추가

            // 그룹이 꽉 찼으면 정답에 추가 후 그룹 초기화
            if (group.size() == groupSize) {
                answer.add(group);
                groups.remove(groupSize);
            }
        }
        return answer;
    }

    // 5 ms / 45.3 MB
    public static List<List<Integer>> groupThePeopleWithList(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> answer = new ArrayList<>();
        List<List<Integer>> cnt = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            cnt.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int groupSize = groupSizes[i];

            // 현재 크기의 그룹에 추가한다.
            List<Integer> members = cnt.get(groupSize);
            members.add(i);

            // 그룹이 꽉 찼으면
            if (groupSize == members.size()) {
                answer.add(members);  // 정답에 추가
                cnt.set(groupSize, new ArrayList<>());  // 그룹 초기화
            } else {  // 그룹 자리가 남았으면 추가
                cnt.set(groupSize, members);
            }
        }
        return answer;
    }
}
