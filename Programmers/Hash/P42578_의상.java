import java.util.HashMap;
import java.util.Map;

public class P42578_의상 {

    public static void main(String[] args) {

        String[][] clothes = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };

        String[][] clothes2 = {
            {"crow_mask", "face"},
            {"blue_sunglasses", "face"},
            {"smoky_makeup", "face"}
        };

        solution(clothes);  // 5
        solution(clothes2);  // 3
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            // 옷을 안입는 경우도 있으므로 초기 값을 2로 설정
            map.merge(clothe[1], 2, (oldValue, newValue) -> oldValue + 1);
        }

        for (Integer num : map.values()) {
            answer *= num;
        }

        // 어떤 종류의 옷도 입지 않는 경우는 제외
        return answer - 1;
    }
}
