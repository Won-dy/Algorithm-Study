import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P42577_전화번호목록 {

    // phone_book	                        return
    // ["119", "97674223", "1195524421"]	false
    // ["123","456","789"]	                true
    // ["12","123","1235","567","88"]	    false

    public static void main(String[] args) {
        solution_HashMap(new String[]{"119", "97674223", "1195524421"});
        solution_HashSet(new String[]{"123", "456", "789"});
        solution_Arrays(new String[]{"12", "123", "1235", "567", "88"});
    }

    // HashMap 사용
    public static boolean solution_HashMap(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        for (String phoneNum : phone_book) {
            int length = phoneNum.length();
            for (int j = 0; j < length; j++) {
                final String prefix = phoneNum.substring(0, j);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        return answer;
    }

    // HashSet 사용
    public static boolean solution_HashSet(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        for (String phoneNum : phone_book) {
            int length = phoneNum.length();
            for (int j = 0; j < length; j++) {
                final String prefix = phoneNum.substring(0, j);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        return answer;
    }

    // Arrays 사용
    public static boolean solution_Arrays(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }
}
