package interview_questions.trees;

public class TreeNode<T> {
  public T value;
  public TreeNode<T> left;
  public TreeNode<T> right;

  public TreeNode(T x) {
    this.value = x;
  }
}
