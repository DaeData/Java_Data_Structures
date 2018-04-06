package phoneBook189kk;
/**
 * 
 * @author Kristen Kellerman
 * KK: Class Main used for Binary Tree and Hash Table.
  */


public class Main {
	/**
	 * KK: Used in the Binary Tree.
	 */


	String fullname;

	String email;

	String pnum;
	
	Main entry;
	

	

/**
 * KK: Used in the Binary Tree to Find and Delete entries.	
 * @param fullname concatenated first name and last name.
 * @param entry The entry in the Binary Tree Node.
 */


	public Main(String fullname, Main entry) {
		this.fullname = fullname;
		this.entry = entry;
	}
	
/**
 * KK: The constructor for the Binary Tree.
 * @param fname first name.
 * @param lname last name.
 * @param email email.
 * @param pnum phone number.
 */


	Main(String fname, String lname, String email, String pnum) {

		this.fullname = (fname + " " + lname).toUpperCase();

		this.email = email;

		this.pnum = pnum;

	}



	/**
	 * KK: Begins the execution of the program.
	 * @param args
	 */



	public static void main(String[] args) {
		/**
		 * KK: Begins the Binary Tree test execution.
		 */


		Tree tree = new Tree();

		tree.addEntry("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
		tree.addEntry("Jane", "Williams", "jw@something.com", "555-235-1112");
		tree.addEntry("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
		tree.addEntry("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
		tree.addEntry("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
		tree.addEntry("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
		tree.addEntry("Jack", "Jones" , "jjones@hill.com", "555-235-1117");
		tree.addEntry("Jill", "Jones", "jillj@hill.com", "555-235-1118");
		tree.addEntry("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
		tree.addEntry("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");
		tree.findEntry("Pat", "Jones");
		tree.findEntry("Billy", "Kidd");
		tree.deleteEntry("John", "Doe");
		tree.addEntry("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
		tree.addEntry("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru", "555-235-1122");
		tree.addEntry("Jo", "Wu", "wu@h.com", "555-235-1123");
		tree.addEntry("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
		tree.addEntry("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
		tree.addEntry("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");
		tree.findEntry("Jack", "Jones");
		tree.findEntry("Nadezhda", "Kanachekhovskaya");
		tree.deleteEntry("Jill", "Jones");
		tree.deleteEntry("John", "Doe");
		tree.findEntry("Jill", "Jones");
		tree.findEntry("John", "Doe");
		
		/**
		 * KK: Begins the Hash Table test execution.
		 */
		Table hashtable =  new Table(13);
		
		hashtable.addEntry("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
		hashtable.addEntry("Jane", "Williams", "jw@something.com", "555-235-1112");
		hashtable.addEntry("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
		hashtable.addEntry("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
		hashtable.addEntry("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
		hashtable.addEntry("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
		hashtable.addEntry("Jack", "Jones" , "jjones@hill.com", "555-235-1117");
		hashtable.addEntry("Jill", "Jones", "jillj@hill.com", "555-235-1118");
		hashtable.addEntry("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
		hashtable.addEntry("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");
		hashtable.findEntry("Pat", "Jones");
		
		hashtable.findEntry("Billy", "Kidd");
		hashtable.deleteEntry("John", "Doe");
		hashtable.addEntry("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
		hashtable.addEntry("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru", "555-235-1122");
		hashtable.addEntry("Jo", "Wu", "wu@h.com", "555-235-1123");
		hashtable.addEntry("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
		hashtable.addEntry("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
		hashtable.addEntry("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");
		hashtable.findEntry("Jack", "Jones");
		hashtable.findEntry("Nadezhda", "Kanachekhovskaya");
		
		hashtable.deleteEntry("Jill", "Jones");
		hashtable.deleteEntry("John", "Doe");
		hashtable.findEntry("Jill", "Jones");
		hashtable.findEntry("John", "Doe");
		
		
		

	}
	

}


