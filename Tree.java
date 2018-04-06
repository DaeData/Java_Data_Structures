package phoneBook189kk;



/**
 * @author Kristen Kellerman.
 * 
 * KK: Binary Tree.
 *
 */
class Tree {
	/**
	 * KK: This point to the Top of the Binary Tree.
	 */
	
	private static TreeNode top;

/**
 * KK: The Tree Contructor.
 * KK:  It starts with an empty tree.
 * 
 */


	Tree() {
		top = null;
	}
	
	/**
	 * KK: This will take the parameters and combine them to create the fullname.
	 * @param fname first name.
	 * @param lname last name.
	 * @return Returns the fullname.
	 */

	public static String fullname(String fname, String lname) {
		return (fname + " " + lname).toUpperCase();
	}

	/**
	 * KK: Adds entries to the Binary Table.
	 * @param fname first name.
	 * @param lname last name.
	 * @param email email.
	 * @param pnum phone number.
	 * @return 
	 */

	Main addEntry(String fname, String lname, String email, String pnum) {
		Main entry = new Main(fname, lname, email, pnum);
		/**
		 * KK: Checks to see if there is a tree(top).
		 * KK: If there is not a top node, create the node.
		 *  
		 */

		if (top == null) {

			top = new TreeNode(entry);

			System.out.println(entry.fullname + " is the Top of the Tree!");

			return top.entry;
		} 
		else {

			return top.addEntry(fname, lname, email, pnum);
		}
	}
	/**
	 * KK: Starts a search of the Binary Tree.
	 * KK: This checks to see if the Tree exists.  If it does not exists, it stops the search and returns a console message that the tree is empty.
	* KK: If it does exists, it takes the top entry to be used as a comparison.
	* @param fname first name.
	* @param lname last name.
	* @return Returns the top entry.
	*/

	Main findEntry(String fname, String lname) {
		String fullname  = fullname(fname, lname);

		if (top == null) {
			System.out.println(fullname + " Tree is empty!");

			return null;
		} 
		else {

			return top.findEntry(fullname);
		}
	}

	/**
	 * KK: Starts the delete process for removing entries.
	 * KK: First checks if the top entry exists.
	 * KK: If it does not exist, it returns a console message that the Tree is empty.
	 * @param fname first name.
	 * @param lname last name.
	 * @return Returns results based on whether the Tree exists, or if the top entry is the entry to be deleted.  If it is to be deleted it takes the first left entry of the Tree and moves it to the top.
	 */
	Boolean deleteEntry(String fname, String lname) {
		String fullname = fullname(fname, lname);

		/**
		 * KK: This checks to see if the Tree exists.
		 */

		if (top == null) {
			System.out.println(fullname + " Tree is empty!");

			return false;
		}
		/**
		 * KK: Checks to see if the top enty is the entry to delete.
		 * KK: If it is the entry to be deleted.
		 * KK: If the entries match it will create a copy of the top left node to temporarily hold it.
		 * KK: Once it is temporarily stored, the reference to the top is replaced with the new reference(old left), and the left node is moved to the top.
		 */		
		else {

			if (top.entry.fullname.compareTo(fullname) == 0) {

				TreeNode newRoot = new TreeNode();


				newRoot.left = top;
				top.deleteEntry(fullname, newRoot);
				top = newRoot.left;

				System.out.println(fullname + " removed from Tree.");

				return true;
			} 
			else {
				return top.deleteEntry(fullname, null);
			}
		}
	}





}




