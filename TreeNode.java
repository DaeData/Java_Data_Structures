package phoneBook189kk;
/**
 * @author Kristen Kellerman.
 * 
 * KK: Binary Tree Node.
 * KK: Initial references to right, left and entry.
 */

class TreeNode {
	
	TreeNode right;

	TreeNode left;

	Main entry;



	/**
	 * KK: Constructor for empty nodes.
	 */
	TreeNode() {
		entry = null;
		left = null;
		right = null;
	}

	/**
	 * KK: Constructor for when there is data in a node.
	 * @param entry Node has an entry(not empty).
	 */
	TreeNode(Main entry) {
		this.entry = entry;
		left = null;
		right = null;
	}


	/**
	 * KK: Adds entries to the Binary Tree Nodes after the check to see if the top entry is present.
	 * KK: Checks to see if the entry already is present.  If it is present it is replaced with new information.
	 * KK: If it does not match it does a check to see if the entry is bigger or smaller in value to the top entry.
	 * KK: If it is smaller it will check to see if the left node exists.  If it does not exist, a new left node is created.
	 * KK: If left does exist, it then checks to see if there are any child nodes.  If child nodes are present, another comparison is done and the node is placed in the Binary Tree.
	 * KK: If it is bigger it will check to see if the right node exists.  If it does not exist, a new right node is created.
	 * KK: If right does exist, it then checks to see if there are any child nodes.  If child nodes are present, another comparison is done and the node is placed in the Binary Tree.
	 * @param fname first name.
	 * @param lname last name.
	 * @param email email.
	 * @param pnum phone number.
	 * @return Returns the entry to add based on the conditions of equivalence. Sends a message to the console based on the results.
	 */
	Main addEntry(String fname, String lname, String email, String pnum) {
		Main entry = new Main(fname, lname, email, pnum);

		/**
		 * KK: Checks to see if the entry and the current entry are equal.
		 */
		if (entry.fullname.compareTo(this.entry.fullname) == 0) {
			this.entry = entry;

			System.out.println(entry.fullname + " already exists, overwriting existing entry.");

			return this.entry;
		} 
		/**
		 * KK: Checks to see if the entry is smaller than the top entry.
		 * KK: Checks to see if left node is empty.
		 * KK: Adds a new left entry if an entry already exists.
		 */
		else if (entry.fullname.compareTo(this.entry.fullname) < 0) {

			if (left == null) {
				left = new TreeNode(entry);

				System.out.println(entry.fullname + " was added to the Left.");

				return left.entry;
			} 
			else {
				return left.addEntry(fname, lname, email, pnum);
			}
		} 
		/**
		 * KK: Checks to see if the entry is larger than the top entry.
		 * KK: Checks to see if right node is empty.
		 * KK: Adds a new right entry if an entry already exists.
		 */
		else {

			if (right == null) {
				right = new TreeNode(entry);

				System.out.println(entry.fullname + " was added to the Right.");

				return right.entry;
			} 
			else {

				return right.addEntry(fname, lname, email, pnum);

			}
		}
	}


	/**
	 * KK: Searches entries in the Binary Tree Nodes after the check to see if the top entry is present.
	 * KK: Checks to see if the entry that is being searched matches the curent position after the top search.
	 * KK: If it does not match it does a check to see if the entry is bigger or smaller in value to the current entry.
	 * KK: If it is smaller it will check to see if the left node exists.  If it does not exist it stops searching and sends a message to the console.
	 * KK: If left does exist, it searches through left entries.
	 * KK: If it is bigger it will check to see if the right node exists.  If it does not exist it stops searching and sends a message to the console.
	 * KK: If right does exist, it searches through right entries.
	 * @param fullname This is the concatenated first name and last name.
	 * @return Returns to different points in the search based on the results of the search. Sends a message to the console based on the results.
	 */
	Main findEntry(String fullname) {

		if (fullname.compareTo(entry.fullname) == 0) {
			System.out.println(fullname + " has been found in the Tree!");

			return entry;
		} 
		else if (fullname.compareTo(entry.fullname) < 0) {

			if (left == null) {
				System.out.println(fullname + " does not exist!");

				return null;
			} 
			else {
				return left.findEntry(fullname);
			}
		} 
		else {

			if (right == null) {
				System.out.println(fullname + " does not exist!");

				return null;
			} 
			else {
				return right.findEntry(fullname);
			}
		}
	}

	/**
	 * KK: Searches entries in the Binary Tree Nodes to find the entry to be deleted after the check to see if the top entry is present.
	 * KK: Checks to see if the entry to be deleted matches the curent position.
	 * KK: If it does not match it does a check to see if the entry is bigger or smaller in value to the current entry.
	 * KK: If it is smaller it will check to see if the left node exists.  If it does not exist it stops searching and sends a message to the console.
	 * KK: If left does exist, it searches through left entries.
	 * KK: Once the entry is found another check is done to see if other nodes are present and they are moved.
	 * KK: If it is bigger it will check to see if the right node exists.  If it does not exist it stops searching and sends a message to the console.
	 * KK: If right does exist, it searches through right entries.
	 * @param fullname This is the concatenated first name and last name.
	 * @return Returns to different points in the search based on the results of the search. Sends a message to the console based on the results.
	 */
	Boolean deleteEntry(String fullname, TreeNode topNode) {
		
		/**
		 * KK: Checks to see if the entry and the current entry are the same.
		 * KK: If they are the same, check left and right to see if nodes exist.
		 * KK: If nodes exists below, move them to their new place and delete the entry.
		 */

		if (fullname.compareTo(entry.fullname) == 0) {

			if (left != null && right != null) {
				return right.deleteEntry(fullname, this);
			} 
			else if (topNode.left == this) {

				topNode.left = left != null ? left: right;

				System.out.println(fullname + " has been removed!");

				return true;
			} 
			else if (topNode.right == this) {

				topNode.right = left != null ? left : right;

				System.out.println(fullname + " has been removed!");

				return true;
			}
		}
		/**
		 * KK: Checks to see if the entry to be deleted is smaller than the current entry.
		 * KK: If it is smaller, check to see if there are any nodes below.
		 * KK: If there are no left nodes, delete the entry.
		 * KK: If there are left nodes, move the nodes up and delete the entry.
		 */
		else if (fullname.compareTo(entry.fullname) < 0) {

			if (left != null) {
				return left.deleteEntry(fullname, this);
			} 
			else {
				System.out.println(fullname + " does not exist!");

				return false;
			}
		}
		/**
		 * KK: After the the previous size comparison, search the right nodes for the entry to delete.
		 * KK: Check to see if there are any nodes below.
		 * KK: If there are no nodes below, delete the entry.
		 * KK: If there are nodes below, move the nodes up and delete the entry.
		 */
		else {

			if (right != null) {
				return right.deleteEntry(fullname, this);

			} 
			else {
				System.out.println(fullname + " does not exist!");

				return false;
			}
		}

		System.out.println(fullname + " does not exist!");

		return false;
	}



}





