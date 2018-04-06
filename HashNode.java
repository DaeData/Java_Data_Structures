package phoneBook189kk;


/**
 * 
 * @author Kristen Kellerman.
 *KK: Constructor.
 */
public class HashNode {

	HashNode entry;
	HashNode next;
	String fullname;
	String email;
	String pnum;


/**
 * KK: Constructor for Find and Delete.
 * @param fullname
 * @param entry
 */
	HashNode(String fullname, HashNode entry) {

		this.fullname = fullname.toUpperCase();
		this.entry = entry;

	}
/**
 * KK: Constsructor for data.
 * @param fname
 * @param lname
 * @param email
 * @param pnum
 */

	HashNode(String fname, String lname, String email, String pnum) {
		fullname = (fname + " " + lname).toUpperCase();
		this.email = email;
		this.pnum = pnum;


	}




}
