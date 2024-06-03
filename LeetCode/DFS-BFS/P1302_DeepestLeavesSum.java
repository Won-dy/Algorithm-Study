class P1302_DeepestLeavesSum {

    int answer = 0;
    int maxDepth = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return answer;
    }

    public void dfs(TreeNode node, int depth) {
        // 현재 depth 가 max depth 와 같으면 합하기
        if (depth == maxDepth) {
            answer += node.val;
        }
        // 현재 depth 가 max depth 라면 합 덮어씌우기
        if (depth > maxDepth) {
            maxDepth = depth;
            answer = node.val;
        }

        // null 이 아닌 node 는 dfs 수행
        TreeNode[] linkedNode = new TreeNode[]{node.left, node.right};
        for (int i = 0; i < 2; i++) {
            if (linkedNode[i] == null) {
                continue;
            }
            dfs(linkedNode[i], depth + 1);
        }
    }

    // Definition for a binary tree node.
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}