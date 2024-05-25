import java.util.Stack;

public class P12909_올바른괄호 {

    public static void main(String[] args) {
        solution_Queue("()()");  // true
        solution_Queue("(())()");  // true
        solution(")()(");  // false
        solution("(()(");  // false
    }

    public static boolean solution_Queue(String s) {
        // 홀수개면 성립할 수 없음
        if (s.length() % 2 != 0) {
            return false;
        }

        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char bracket : brackets) {
            if (bracket == '(') {
                stack.push(bracket);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }

        return stack.isEmpty();
    }

    public static boolean solution(String s) {
        // 홀수개면 성립할 수 없음
        if (s.length() % 2 != 0) {
            return false;
        }

        char[] brackets = s.toCharArray();
        int cnt = 0;
        for (char bracket : brackets) {
            if (bracket == '(') {
                cnt++;
            }
            if (bracket == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }

        return cnt == 0;
    }
}
