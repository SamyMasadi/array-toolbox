/* Samy Masadi
 * CSCI 211
 * Project 2 */

/**
 * A class to create and modify one-dimension arrays.
 * @author Samy Masadi
 */
public class Array_1 {
	public static final double EPSILON = 1E-14;
	
	private double[] array;
	private int currentSize;
	
	/**
	 * Constructs an array with a given length
	 * @param inLength the given length
	 */
	public Array_1(int inLength) {
		array = new double[inLength];
		currentSize = 0;
	}
	
	/**
	 * Constructs an array with given inputs
	 * @param userInputs an array containing given inputs
	 * @param inputTotal the total number of inputs
	 */
	public Array_1(double[] userInputs, int inputTotal) {
		array = userInputs;
		currentSize = inputTotal;
		//for (int i = 0; i < array.length; i++) { // Not needed?
			//array[i] = userInputs[i];
		//}
	}
	
	/**
	 * Doubles the length of an array
	 */
	public void doubleLength() {
		double[] temp = new double[2 * array.length];
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		array = temp;
		System.out.println("Array length doubled.");
	}
	
	/**
	 * Adds the elements of two arrays of the same size.
	 * @param inArray the second array to add
	 * @return a third array containing the results
	 */
	public double[] addArrays(double[] inArray) {
		double[] array3 = new double[currentSize];
		for (int i = 0; i < currentSize; i++) {
			array3[i] = array[i] + inArray[i];
		}
		return array3;
	}
	
	/**
	 * Subtracts the elements of an array from another of the same size
	 * @param inArray the second array to subtract
	 * @return a third array containing the results
	 */
	public double[] subtractArrays(double[] inArray) {
		double[] array3 = new double[currentSize];
		for (int i = 0; i < currentSize; i++) {
			array3[i] = array[i] - inArray[i];
		}
		return array3;
	}
	
	/**
	 * Calculates the sum of all elements in an array
	 * @return the sum
	 */
	public double sumElements() {
		double sum = 0;
		for (double element : array) {
			sum = sum + element;
		}
		return sum;
	}
	
	/**
	 * Finds the maximum, minimum, and average of values in an array.
	 * Results are printed.
	 */
	public void maxMinMean() {
		double largest = array[0];
		double smallest = array[0];
		double average = this.sumElements() / currentSize;
		
		for (int i = 1; i < currentSize; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
			if (array[i] < smallest) {
				smallest = array[i];
			}
		}
		
		System.out.println("Maximum: " + largest);
		System.out.println("Minimum: " + smallest);
		System.out.println("Average: " + average);
	}
	
	/**
	 * Searches for a specific value in an array
	 * @param inElement the value to search for
	 */
	public void findElement(double inElement) {
		boolean found = false;
		for (int i = 0; i < currentSize; i++) {
			if (Math.abs(inElement - array[i]) <= EPSILON) {
				System.out.println("Number found at index " + i);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Number not found.");
		}
	}
	
	/**
	 * Inserts an element into an array and preserves the order of elements
	 * @param inElement the element to insert
	 * @param inIndex the index position of insertion
	 */
	public void insertElement(double inElement, int inIndex) {
		currentSize++;
		int index;
		if (inIndex >= currentSize) {
			index = currentSize-1;
			System.out.println("Error: Index is beyond the array's current size.");
		}
		else {
			index = inIndex;
		}		
		for (int i = currentSize-1; i > index; i--) {
			array[i] = array[i-1];
		}
		array[index] = inElement;
		System.out.println("Number added at index " + index + ".");
	}
	
	/**
	 * Removes an element from an array and preserves the order of elements
	 * @param index the index position to remove
	 */
	public void removeElement(int index) {
		if (index < currentSize) {
			for (int i = index+1; i < currentSize; i++) {
				array[i-1] = array[i];
			}
			array[currentSize-1] = 0;
			currentSize--;
			System.out.println("Number removed.");
		}
		else {
			System.out.println("Error: Index is beyond the array's current size.");
		}
	}
	
	/**
	 * Sorts an array's elements in ascending order.
	 */
	public void sortArray() {
		double smallest;
		double temp;
		int index;
		for (int i = 0; i < currentSize; i++) {
			temp = array[i];
			smallest = array[i];
			index = i;
			for (int j = i; j < currentSize; j++) {
				if (array[j] < smallest) {
					smallest = array[j];
					index = j;
				}
			}
			if (i != index) {
				array[i] = smallest;
				array[index] = temp;
			}
		}
		System.out.println("Array sorted.");
	}
	
	/**
	 * Prints the elements in an array.
	 */
	public void arrayPrinter() {
		System.out.print("Your array: ");
		for (int i = 0; i < currentSize-1; i++) {
			System.out.print(array[i] + ", ");
			}
		System.out.print(array[currentSize-1]);
		System.out.println();
	}
	
	/**
	 * Checks whether an array contains any elements
	 * @return Empty or not
	 */
	public boolean checkEmpty() {
		return currentSize == 0;
	}
	
	/**
	 * Checks whether an array has room for more elements
	 * @return Has room or not
	 */
	public boolean checkSpace() {
		return currentSize < array.length;
	}
	
	/**
	 * Gets the current number of elements in an array
	 * @return the number of elements
	 */
	public int getSize() {
		return currentSize;
	}
	
	/**
	 * Returns an array to save for later use
	 * @return the array
	 */
	public double[] getArray() {
		return array;
	}

}
