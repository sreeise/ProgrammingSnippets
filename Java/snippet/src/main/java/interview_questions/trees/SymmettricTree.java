package interview_questions.trees;

public class SymmettricTree {
  int height(TreeNode<Integer> root) {
    if (root == null) {
      return -1;
    } else {
      return 1 + Math.max(height(root.left), height(root.right));
    }
  }

  public boolean isTreeSymmetric(TreeNode<Integer> t) {
    if (t == null) {
      return true;
    }
    int left = height(t.left);
    int right = height(t.right);

    return left == right;
  }
}
