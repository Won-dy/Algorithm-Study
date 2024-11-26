public class P345_ReverseVowelsOfAString {

    // https://leetcode.com/problems/reverse-vowels-of-a-string
    public static void main(String[] args) {
        reverseVowels("IceCreAm");  // "AceCreIm"
        reverseVowels("leetcode");  // "leotcede"
        reverseVowels(" ");  // " "
    }

    // 3 ms (84.81%) / 44.81 MB (62.53%)

    // 1. 주어진 문자열 s 를 char 배열로 변환하여 word 에 저장한다.
    // 2. lower, upper case 모음 모두를 가지는 문자열을 정의한다. (vowels)
    // 3. 문자열 s 의 양쪽 맨 끝을 포인터로 하는 left, right 를 정의한다.
    // 4. left 와 right 포인터가 만나기 전이고, left 포인터가 모음을 가리킬 때 까지 포인터를 +1 한다.
    // 5. left 와 right 포인터가 만나기 전이고, right 포인터가 모음을 가리킬 때 까지 포인터를 -1 한다.
    // 6. word 배열의 left 포인터와 right 포인터의 모음을 swap 한다.
    // 7. left 포인터를 +1, right 포인터를 -1 한다.
    // 8. left 와 right 포인터가 만나기 전까지 반복한다.
    // 9. word 배열을 String 객체로 생성하여 반환한다.
    public static String reverseVowels(String s) {
        char[] word = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && vowels.indexOf(word[left]) == -1) {
                left++;
            }

            while (left < right && vowels.indexOf(word[right]) == -1) {
                right--;
            }

            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;

            left++;
            right--;
        }

        return new String(word);
    }
}
