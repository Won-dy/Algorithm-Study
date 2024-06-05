public class P43165_타겟넘버 {

    static int answer;

    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);  // 5
        solution(new int[]{4, 1, 2, 1}, 4);  // 2
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }

    static void dfs(int[] numbers, int target, int sum, int level) {
        if (level == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        int plusSum = sum + numbers[level];
        int minusSum = sum - numbers[level];
        dfs(numbers, target, plusSum, level + 1);
        dfs(numbers, target, minusSum, level + 1);
    }
}
