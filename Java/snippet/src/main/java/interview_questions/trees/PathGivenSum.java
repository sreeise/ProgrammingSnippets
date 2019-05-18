package interview_questions.trees;

public class PathGivenSum {
  public static boolean hasPathWithGivenSum(TreeNode<Integer> t, int s) {
    if (t == null) {
      return s == 0;
    } else {
      boolean hasPath = false;
      int total = s - t.value;
      if (total == 0 && t.left == null && t.right == null)
        return true;
      if (t.left != null) {
        hasPath = hasPathWithGivenSum(t.left, total);
      }
      if (t.right != null) {
        hasPath = hasPath || hasPathWithGivenSum(t.right, total);
      }
      return hasPath;
    }
  }
}
