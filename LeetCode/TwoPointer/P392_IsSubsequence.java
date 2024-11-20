public class P392_IsSubsequence {

    // https://leetcode.com/problems/is-subsequence
    public static void main(String[] args) {
        isSubsequence("abc", "ahbgdc");  // true
        isSubsequence("axc", "ahbgdc");  // false
    }

    // 2 ms (63.19%) / 41.2 MB (74.47%)

    // 두 문자열의 0번 인덱스에서 포인터를 초기화 한다.
    // 순회 하며 t 포인터가 가리키는 문자와 s 포인터가 가리키는 문자가 같으면 두 포인터 모두 증가 시킨다.
    // 다르다면, t 포인터만 증가 시킨다.
    // 두 문자열 중 한 쪽이라도 순회가 끝날 때 까지 위 두 과정을 반복한다.
    // 순회 후 s 문자열의 pointer 가 끝까지 갔다면, subsequence 인것이고, 못갔다면 아닌것이다.
    public static boolean isSubsequence(String s, String t) {
        int tPoint = 0;
        int sPoint = 0;

        while (tPoint < t.length() && sPoint < s.length()) {
            if (t.charAt(tPoint) == s.charAt(sPoint)) {
                sPoint++;
            }
            tPoint++;
        }

        return sPoint == s.length();
    }
}
