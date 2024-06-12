import java.util.*;

public class P118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        if (numRows == 0) {
            return answer;
        }

        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            answer.add(firstRow);
            return answer;
        }

        // 전 row 까지의 파스칼 삼각형 가져오기
        answer = generate(numRows - 1);

        List<Integer> prevRow = answer.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();

        currentRow.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        currentRow.add(1);
        answer.add(currentRow);

        return answer;
    }
}
