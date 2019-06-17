/* Samy Masadi
 * CSCI 211
 * Project 2 */

/**
 * A class to print menus for the Array Toolbox.
 * @author Samy Masadi
 */
public class ArrayMenus {
	
	/**
	 * Constructs the ArrayMenus object.
	 */
	public ArrayMenus() {}
	
	/**
	 * Prints the main menu.
	 */
	public void topMenuA() {
		System.out.println("1. Create new 1D array");
		System.out.println("2. Create new 2D array");
		System.out.println("3. Select saved 1D array");
		System.out.println("4. Select saved 2D array");
		System.out.println("5. Exit Program");
		System.out.println();
		System.out.print("Select an option: ");
	}
	
	/**
	 * Prints the menu for creating arrays.
	 */
	public void createMenuB() {
		System.out.println("Initialize array:");
		System.out.println("1. by specified length");
		System.out.println("2. by inputing values");
		System.out.println();
		System.out.print("Select an option: ");
	}
	
	/**
	 * Prints the menu for 1D arrays.
	 */
	public void array1DC() {
		System.out.println("1. Double array's length");
		System.out.println("2. Add two arrays of the same size");
		System.out.println("3. Subtract two arrays of the same size");
		System.out.println("4. Calculate the sum of all elements");
		System.out.println("5. Find maximum, minimum, and average");
		System.out.println("6. Find a specific element");
		System.out.println("7. Insert an element at specific index location");
		System.out.println("8. Remove an element from a specific index location");
		System.out.println("9. Sort the array (ascending order)");
		System.out.println("10. View array elements");
		System.out.println("11. Save array");
		System.out.println("M. Main menu");
		System.out.println();
	}
	
	/**
	 * Prints the menu for 2D arrays.
	 */
	public void array2DC() {
		System.out.println("1. Add two arrays of the same size");
		System.out.println("2. Subtract two arrays of the same size");
		System.out.println("3. Calculate the sum of all elements");
		System.out.println("4. Find the maximum, minimum, and average");
		System.out.println("5. Find specific element");
		System.out.println("6. Sort the array (ascending order)");
		System.out.println("7. View array elements");
		System.out.println("8. Save array");
		System.out.println("M. Main menu");
		System.out.println();
	}

}
