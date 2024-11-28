public class P1732_FindTheHighestAltitude {

    // https://leetcode.com/problems/find-the-highest-altitude
    public static void main(String[] args) {
        largestAltitude(new int[]{-5, 1, 5, 0, -7});  // 1
        largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2});  // 0
    }

    // 0 ms (100.00%) / 41.40 MB (35.99%)

    // 1. gain 의 0 번째 요소부터 i 번째 요소까지의 합인 누적 합을 구하여 sumAlti 에 저장한다.
    // 2. sumAlti 가 maxAlti 보다 크면 maxAlti 를 sumAlti 값으로 갱신한다.
    // 3. maxAlti 을 반환한다.
    public static int largestAltitude(int[] gain) {
        int maxAlti = 0;
        int sumAlti = 0;

        for (int i = 0; i < gain.length; i++) {
            sumAlti += gain[i];
            if (sumAlti > maxAlti) {
                maxAlti = sumAlti;
            }
        }

        return maxAlti;
    }
}
