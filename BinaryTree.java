
public class BinaryTree<T> extends BinaryTreeBasis<T> {

  public BinaryTree() {
  }  // end default constructor

  public BinaryTree(T rootItem) {
    super(rootItem);
  }  // end constructor

  public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
    root = new TreeNode<T>(rootItem, null, null);
    attachLeftSubtree(leftTree);
    attachRightSubtree(rightTree);
  }  // end constructor

  public void setRootItem(T newItem) {
    if (root != null) {
      root.setItem(newItem);
    }
    else {
      root = new TreeNode<T>(newItem, null, null);
    }  // end if
  }  // end setRootItem

  public void attachLeft(T newItem) {
    if (!isEmpty() && root.getLeft() == null) {
      // assertion: nonempty tree; no left child
      root.setLeft(new TreeNode<T>(newItem, null, null));
    }  // end if
  }  // end attachLeft

  public void attachRight(T newItem) {
    if (!isEmpty() && root.getRight() == null) {
      // assertion: nonempty tree; no right child
      root.setRight(new TreeNode<T>(newItem, null, null));
    }  // end if
  }  // end attachRight

  public void attachLeftSubtree(BinaryTree<T> leftTree) 
                                throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else if (root.getLeft() != null) {
      // a left subtree already exists; it should have been 
      // deleted first
      throw new TreeException("TreeException: " + 
                           "Cannot overwrite left subtree");
    }
    else {
      // assertion: nonempty tree; no left child
      root.setLeft(leftTree.root);
      // don't want to leave multiple entry points into 
      // our tree
      leftTree.makeEmpty(); 
    }  // end if
  }  // end attachLeftSubtree

  public void attachRightSubtree(BinaryTree<T> rightTree)  
                                 throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else if (root.getRight() != null) {
      // a right subtree already exists; it should have been 
      // deleted first
      throw new TreeException("TreeException: " + 
                          "Cannot overwrite right subtree");
    }
    else {
      // assertion: nonempty tree; no right child
      root.setRight(rightTree.root);
      // don't want to leave multiple entry points into 
      // our tree
      rightTree.makeEmpty(); 
    }  // end if
  }  // end attachRightSubtree
  
  protected BinaryTree(TreeNode<T> rootNode) {
    root = rootNode;
  }  // end protected constructor

  public BinaryTree<T> detachLeftSubtree()  
                         throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else {
      // create a new binary tree that has root's left 
      // node as its root
      BinaryTree<T> leftTree;
      leftTree = new BinaryTree<T>(root.getLeft());
      root.setLeft(null);
      return leftTree;
    }  // end if
  }  // end detachLeftSubtree

  public BinaryTree<T> detachRightSubtree() 
                         throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else {
      BinaryTree <T> rightTree;
      rightTree = new BinaryTree<T>(root.getRight());
      root.setRight(null);
      return rightTree;
    }  // end if
  }  // end detachRightSubtree
  public static void printsAll(BinaryTree<String> tree){				//uses inorder transversal to go through all the businesses greatest to least in profit
		TreeIterator<String> iter = new TreeIterator<String>(tree);
		iter.setInorder();
		while (iter.hasNext()){
			System.out.print (iter.next() +"\n");
		}
 	}
	
	public static void findsProfit(BinaryTree<String> tree, String name) {		//uses inorder to find profit of company name given
		TreeIterator<String> iter = new TreeIterator<String>(tree);
		iter.setInorder();
		
		boolean cont = true;
		while (cont || iter.hasNext()){
			String copy = iter.next();	//using a copy because I want to reuse it. whenever iter.next is called it goes onto the next one
			for(int i = 0; i < copy.length(); i++) {	//going though string copy up to : since that is the way I formatted my string values for the binary trees 
				if(copy.charAt(i) == ':') {				//this is in order to make a substring of it to compare to my String parameter name.			
					String compareTo = copy.substring(0, (i));	//creates a substring to compare to name
					if(name.equals(compareTo)) {
						String profit = copy.substring(i+2); //if they are equal, create a substring that goes from 2 indexes ahead of where the last substring ended. This is also due to the way I formatted the strings in the binary search trees, with 2 spaces
						System.out.println("The profit for this business is: " + profit);		//finally prints
						cont = false;		//in order to exit the while loop
					}
				}
			}
		}
	}
} // end BinaryTree
