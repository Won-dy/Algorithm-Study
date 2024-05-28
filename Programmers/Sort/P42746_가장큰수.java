import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class P42746_가장큰수 {

    public static void main(String[] args) {
        solution_Stream_sorted(new int[]{6, 10, 2});  // 6210
        solution_Stream_sorted(new int[]{3, 30, 34, 5, 9});  // 9534330
        solution_Stream_sorted(new int[]{0, 0, 0});  // 0

        solution_Array_sort(new int[]{6, 10, 2});  // 6210
        solution_Array_sort(new int[]{3, 30, 34, 5, 9});  // 9534330
        solution_Array_sort(new int[]{0, 0, 0});  // 0
    }

    public static String solution_Stream_sorted(int[] numbers) {
        String sorted = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted(((o1, o2) -> (o2 + o1).compareTo(o1 + o2)))
            .collect(Collectors.joining());

        return sorted.charAt(0) == '0' ? "0" : sorted;
    }

    public static String solution_Array_sort(int[] numbers) {
        String answer = "";

        String[] nums = new String[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            ans.append(nums[i]);
        }
        answer = ans.toString();

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
