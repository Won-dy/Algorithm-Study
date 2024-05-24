import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P42586_기능개발 {

    public static void main(String[] args) {
        solution_Queue(new int[]{93, 30, 55}, new int[]{1, 30, 5});  // [2, 1]
        solution_Queue(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});  // [1, 3, 2]
        solution_Queue(new int[]{94, 93}, new int[]{2, 2});  // [1, 1] (추가 case)

        solution_Array(new int[]{93, 30, 55}, new int[]{1, 30, 5});  // [2, 1]
        solution_Array(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});  // [1, 3, 2]
        solution_Array(new int[]{94, 93}, new int[]{2, 2});  // [1, 1] (추가 case)
    }

    // Queue
    public static int[] solution_Queue(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> counts = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();

        // 배포까지 남은 일 수 계산
        for (int i = 0; i < progresses.length; i++) {
            days.offer(calculateRemainDay(progresses[i], speeds[i]));
        }

        // 각 배포마다 몇 개의 기능이 배포되는지 구하기
        int cnt = 0;
        int prevDay = days.peek();
        while (!days.isEmpty()) {
            Integer nowDay = days.poll();
            if (nowDay <= prevDay) {
                cnt++;
                continue;
            }
            counts.add(cnt);
            prevDay = nowDay;
            cnt = 1;
        }
        counts.add(cnt);

        // return 형식에 맞게 형변환
        answer = counts.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    // Array
    public static int[] solution_Array(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> counts = new ArrayList<>();
        int[] days = new int[progresses.length];

        // 배포까지 남은 일 수 계산
        for (int i = 0; i < progresses.length; i++) {
            days[i] = calculateRemainDay(progresses[i], speeds[i]);
        }

        // 각 배포마다 몇 개의 기능이 배포되는지 구하기
        int cnt = 0;
        int prevDay = days[0];
        for (int day : days) {
            if (day <= prevDay) {
                cnt++;
                continue;
            }
            counts.add(cnt);
            prevDay = day;
            cnt = 1;
        }
        counts.add(cnt);

        // return 형식에 맞게 형변환
        answer = counts.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    // 배포까지 남은 일 수 계산
    private static int calculateRemainDay(int progresses, int speeds) {
        int remainDay = (100 - progresses) / speeds;
        if ((100 - progresses) % speeds == 0) {
            return remainDay;
        }
        return remainDay + 1;
    }
}
