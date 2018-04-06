package phoneBook189kk;


/**
 * 
 * @author Kris Kellerman
 *KK: Holds all of the entries in the Hash Table.
 */
public class Table {
	
	private HashNode [] hash;
	


/**
 * KK: Defines the size of the Hash Table.
 * KK: Table hashtable = new Table(13);
 * KK: Used in Main.
 * @param hashSize
 */
	public Table (int hashSize) {
		hash = new HashNode[hashSize];

	}
	/**
	 * KK: Combines first name and last name.
	 * @param fname first name.
	 * @param lname last name.
	 * @return Returns fullname in all Caps.
	 */

	public static String fullname(String fname, String lname) {
		return (fname + " " + lname).toUpperCase();
	}

	/**
	 * KK: Adds entries to the Hash Table.
	 * KK: Takes the hashed value of the fullname to determine what bucket to place the value in the Hash Table.
	 * KK: Checks to see if the entry already is present. 
	 * KK: If there is already and entry and it matches the current entry, it drops the information and sends a message to the console. 
	 * KK: If it does not match it does a check to see if there are more entries in the bucket.  
	 * KK: If there are other entries, it stores that information and checks for more entries until none are found.
	 * KK: Once an empty node is found the new entry is placed in the node.
	 * @param fname first name.
	 * @param lname last name.
	 * @param email email.
	 * @param pnum phone number.
	 * @return Returns based on node information.
	 */
	HashNode addEntry(String fname, String lname, String email, String pnum ) {
		HashNode entry = new HashNode(fname, lname, email, pnum); 
		String fullname = fullname(fname, lname);
		/**
		 * KK: Determines where to put the new entry.
		 */
		int hashValue = hashKey(entry.fullname);
		/**
		 * KK: If the bucket is not empty and the values match.  Send a console message.
		 */
		if ((notEmpty(hashValue)) && (hash[hashValue].fullname.equals(fullname)))  {
			System.out.println("Entry already exists.");
			return null;
		}
		/**
		 * KK: Checks if there are other entries until it finds a spot to add the new entry.
		 * Adds the new entry to the Hash Table bucket.
		 */
		else if((notEmpty(hashValue)) && (hash[hashValue].fullname != null)) {
			HashNode firstEntry = hash[hashValue].entry;
			if(firstEntry.next != null) {
				HashNode nextEntry = hash[hashValue].entry.next;
				nextEntry.entry.next = new HashNode (fullname, entry);
				System.out.println(fullname + " " + email + " " + pnum + " added to the Table.");
				return nextEntry;
			}
			else {
				firstEntry.next = new HashNode(fullname, entry);
			}
			System.out.println(fullname + " " + email + " " + pnum + " added to the Table.");
			return firstEntry;

		}

		else {
			hash[hashValue] = new HashNode(fullname, entry);

			System.out.println(fullname + " " + email + " " + pnum + " added to the Table.");
			return entry;
		}


	}


	/**
	 * KK: Searches entries in the Hash Table to find the entry to be deleted.
	 * KK: Takes the hashed value of the fullname to determine what bucket to look in the Hash Table.
	 * KK: Checks to see if the bucket has information. If not, sends a message to the console.  
	 * KK: Checks to see if the entry to be deleted matches the curent position in the Hash Table.
	 * KK: If it is a match it checks to see if there are more entries in the bucket.
	 * KK: If more entries are present, it temporarily stores those values and continues to search for a match.
	 * KK: If the entry is found, it is deleted, and moves the other entries back to the bucket. A message is sent to the console.
	 * KK: If the entry is not found, a message is sent to the console.
	 * @param fullname This is the concatenated first name and last name.
	 * @return Returns to different points in the search based on the results of the search. Sends a message to the console based on the results.
	 */
	HashNode deleteEntry(String fname, String lname) {
		String fullname = fullname(fname, lname);
		/***
		 * KK: Determines what bucket to start search.
		 */
		int hashValue = hashKey(fullname);
		/**
		 * KK: Checks to see if the bucket is empty.
		 */
		if(hash[hashValue] == null ) {
			System.out.println(fullname + " cannot be removed because " + fullname + " is not in the Table.");
			return null;
		}
		/**
		 * KK: Searches for the entry and temporarily stores other entries if present in the bucket.
		 * Deletes and moves entries back into the bucket.
		 */
		if((hash[hashValue].entry.fullname.equals(fullname) &&  (hash[hashValue].entry.next != null))) {
			HashNode firstEntry = hash[hashValue].entry.next;

			if (firstEntry.next != null) {
				HashNode nextEntry = firstEntry.next;
				if(nextEntry.fullname.equals(fullname)) {
					this.hash[hashValue].entry = null;
					hash[hashValue].entry = nextEntry;
					return nextEntry;
				}

			}
			else {
				this.hash[hashValue] = null;
				this.hash[hashValue] = firstEntry;

				System.out.println(fullname + " removed from the Table.");
				return firstEntry;
			}
		}
		else {
			this.hash[hashValue] = null;

			System.out.println(fullname + " removed from the Table!");
			return null;

		}
		return null;
	}


	/**
	 * KK: Searches for entries in the Hash Table.
	 * KK: Takes the hashed value of the fullname to determine what bucket to look in the Hash Table.
	 * KK: Checks to see if the bucket has information. If not, sends a message to the console.  
	 * KK: Checks to see if the entry matches the search value in the Hash Table.
	 * KK: If it is not a match it checks to see if there are more entries in the bucket.
	 * KK: If more entries are present, it searches those entries for a match.
	 * KK: If the entry is found, a message is sent to the console.
	 * KK: If the entry is not found, a message is sent to the console.
	 */
	HashNode findEntry(String fname, String lname) {
		String fullname = fullname(fname, lname);
		/**
		 * KK: Determines what bucket to search.
		 */
		int hashValue = hashKey(fullname);
		/**
		 * KK: Checks if the bucket is empty.
		 * Sends a message to the console.
		 */
		if(hash[hashValue] == null) {
			System.out.println("Cannot find " + fullname + "!");
			return null;
		}
		/**
		 * KK: Searches the bucket until all entries have been compared.
		 * KK: If a match is found, send a message to the console.
		 * KK: If a match is not found, send a message to the console.
		 */
		if ((hash[hashValue].entry != null) && (!hash[hashValue].fullname.equals(fullname)))  {
			if (hash[hashValue].entry.next != null) {
				if(hash[hashValue].entry.next.fullname.equals(fullname)) {

					System.out.println(fullname + " FOUND in Table!");
				}
				else {
					System.out.println("Cannot find " + fullname + "!");

				}
			}
			else {
				System.out.println("Cannot find " + fullname + "!");

			}
		}


		else {
			System.out.println(fullname + " FOUND in Table!");
		}
		return null;

	}
/**
 * KK: Used to determine what to do if the bucket is not empty.
 * @param index The bucket in the Hash Table.
 * @return Returns the bucket to work with and that it is not empty.
 */

	private boolean notEmpty(int index) {
		return hash[index] != null;
	}
	/**
	 * Creates the hashed reference to the full name.
	 * @param fullname
	 * @return Returns the value of the hashed fullname.
	 */
	private int hashKey(String fullname) {

		int hashValue = fullname.hashCode() % hash.length;

		if(hashValue < 0 ) {
			hashValue += hash.length;

		}
		return hashValue;
	}

}
