import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P42747_HIndex {

    public static void main(String[] args) {
        solution(new int[]{3, 0, 6, 1, 5});  // 3
        solution(new int[]{3, 4});  // 2 (tc-9)
        solution(new int[]{0, 0, 0});  // 0
    }

    public static int solution(int[] citations) {
        int n = citations.length;

        // 내림차순으로 정렬
        final List<Integer> citationList = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            if (citationList.get(i) < i + 1) {
                return i;
            }
        }

        return n;
    }
}
