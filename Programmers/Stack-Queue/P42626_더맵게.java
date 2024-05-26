import java.util.PriorityQueue;

public class P42626_더맵게 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 9, 10, 12}, 7);  // 2
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovilles = new PriorityQueue<>();
        for (int level : scoville) {
            scovilles.offer(level);
        }

        while (scovilles.size() > 1) {
            Integer firstMinLevel = scovilles.poll();
            // 가장 맵지 않은 음식의 스코빌 지수가 원하는 스코빌 지수 이상이면 중단.
            if (firstMinLevel >= K) {
                return answer;
            }
            Integer secondMinLevel = scovilles.poll();

            int newLevel = firstMinLevel + secondMinLevel * 2;
            scovilles.offer(newLevel);

            answer++;
        }

        // 모두 섞어도 원하는 스코빌 지수를 만들 수 없다.
        if (scovilles.peek() < K) {
            System.out.println(-1);
            return -1;
        }

        System.out.println(answer);
        return answer;
    }
}
