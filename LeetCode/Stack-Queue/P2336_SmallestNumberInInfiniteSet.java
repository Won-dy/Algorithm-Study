import java.util.PriorityQueue;

public class P2336_SmallestNumberInInfiniteSet {

    // Runtime: 67ms, Memory: 45.35mb
    public static void main(String[] args) {
        SmallestInfiniteSet obj = new SmallestInfiniteSet();
        obj.addBack(2);
        obj.popSmallest();
        obj.popSmallest();
        obj.popSmallest();
        obj.addBack(1);
        obj.popSmallest();
        obj.popSmallest();
        obj.popSmallest();
    }

    public static class SmallestInfiniteSet {

        private PriorityQueue<Integer> queue;

        // 초기화
        public SmallestInfiniteSet() {
            queue = new PriorityQueue<>();
            for (int i = 1; i <= 1000; i++) {
                queue.add(i);
            }
        }

        // 제일 작은 정수 제거 및 반환
        public int popSmallest() {
            return queue.poll();
        }

        // 없으면 맨 뒤에 추가
        public void addBack(int num) {
            if (!queue.contains(num)) {
                queue.offer(num);
            }
        }
    }
}
