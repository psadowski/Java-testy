package BinaryTree.BinaryTreeJBehave;

public interface BinaryTree {
	public void addNode(int key, String name);
	public boolean remove(int key);
	public Node findNode(int key);
	public Node getReplacementNode(Node replacedNode);
}
