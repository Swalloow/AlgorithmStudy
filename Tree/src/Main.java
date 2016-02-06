
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<String> root = new TreeNode<String>("root");
		{
			TreeNode<String> node1 = root.addChild("node1");
			TreeNode<String> node2 = root.addChild("node2");
			TreeNode<String> node3 = root.addChild("node3");
			{
				TreeNode<String> node4 = node1.addChild("node4");
				TreeNode<String> node5 = node1.addChild("node5");
				{
					TreeNode<String> node6 = node3.addChild("node6");
				}
			}
		}
	}
}
