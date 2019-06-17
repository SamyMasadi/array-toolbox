/* Samy Masadi
 * CSCI 211
 * Project 2 */

import java.util.ArrayList;

/**
 * A class to create and modify two-dimension arrays.
 * @author Samy Masadi
 */
public class Array_2 {
	public static final double EPSILON = 1E-14;
	
	private double[][] array2;
	private int currentSize;
	
	/**
	 * Constructs a 2D array with a given number of rows and columns.
	 * @param inRows the given number of rows
	 * @param inColumns the given number of columns
	 */
	public Array_2(int inRows, int inColumns) {
		array2 = new double[inRows][inColumns];
		currentSize = 0;
	}
	
	/**
	 * Constructs a 2D array from user input
	 * @param inRowList a list of arrays representing rows
	 * @param inRows the number of rows
	 * @param inColumns the number of columns
	 * @param inputTotal the total number of inputs
	 */
	public Array_2(ArrayList<double[]> inRowList, int inRows, 
			int inColumns, int inputTotal) {
		array2 = new double[inRows][inColumns];
		currentSize = inputTotal;
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				array2[i][j] = inRowList.get(i)[j];
			}
		}
	}
	
	/**
	 * Constructs an array for use with loading/saving an array
	 * @param inArray
	 * @param inSize
	 */
	public Array_2(double[][] inArray, int inSize) {
		array2 = inArray;
		currentSize = inSize;
	}
	
	/**
	 * Adds an array's elements to the elements of a second saved array of the same size
	 * @param inArray the saved array
	 * @return a third array containing the results of sums
	 */
	public double[][] addArrays(double[][] inArray){
		int numRows = array2.length;
		int numColumns = array2[0].length;
		double[][] array3 = new double[numRows][numColumns];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				array3[i][j] = array2[i][j] + inArray[i][j];
			}
		}
		return array3;
	}
	
	/**
	 * Subtracts an array's elements from a second saved array of the same size
	 * @param inArray the saved array
	 * @return a third array containing the results
	 */
	public double[][] subtractArrays(double[][] inArray){
		int numRows = array2.length;
		int numColumns = array2[0].length;
		double[][] array3 = new double[numRows][numColumns];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				array3[i][j] = array2[i][j] - inArray[i][j];
			}
		}
		return array3;
	}
	
	/**
	 * Returns the sum of all elements in an array
	 * @return the sum of all elements
	 */
	public double sumElements() {
		double sum = 0;
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				sum = sum + array2[i][j];
			}
		}
		return sum;
	}
	
	/**
	 * Finds the maximum, minimum, and average of values in an array.
	 * Results are printed.
	 */
	public void maxMinMean() {
		double largest = array2[0][0];
		double smallest = array2[0][0];
		double average = this.sumElements() / currentSize;
		
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				if (array2[i][j] > largest) {
					largest = array2[i][j];
				}
				if (array2[i][j] < smallest) {
					smallest = array2[i][j];
				}
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
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				if (Math.abs(inElement - array2[i][j]) <= EPSILON) {
					System.out.println("Number found in row " + i + ", column " + j);
					found = true;
				}
			}
		}
		if (!found) {
			System.out.println("Number not found.");
		}
	}
	
	/**
	 * Sorts an array's elements in ascending order.
	 */
	public void sortArray() {
		double smallest;
		double temp;
		int sRow;  // Row index for smallest value
		int sColumn;  // Column index for smallest value
		/* This needs to iterate two different things simultaneously: iterate through 
		 * a "current index" (tracked by i and j) to compare the rest of the array 
		 * against, and  iterate (using k and l) from "current index" to the end of 
		 * the array to find the smallest value. */
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				temp = array2[i][j]; // "Current Index"
				smallest = array2[i][j]; // Compare from this position to end
				sRow = i;
				sColumn = j;
				/* Iterate through later rows again using k after earlier i rows have
				 * already been sorted. */
				for (int k = i; k < array2.length; k++) {
					if (k > i) {
						for (int l = 0; l < array2[0].length; l++) {
							if (array2[k][l] < smallest) {
								smallest = array2[k][l];
								sRow = k;
								sColumn = l;
							}
						}
					}
					/* When k = i, indices less than j will already have been sorted.
					 * Skip over these. Make l start at j then iterate to the end of 
					 * the row */
					else {
						for (int l = j; l < array2[0].length; l++) {
							if (array2[k][l] < smallest) {
								smallest = array2[k][l];
								sRow = k;
								sColumn = l;
							}
						}
					}
				}
				/* Swap found smaller value (if any) with "current index"
				 * sRow or sColumn or both with change if smaller value is found */
				if (sRow != i || sColumn != j) {
					array2[i][j] = smallest;
					array2[sRow][sColumn] = temp;
				}
			}
		}
		System.out.println("Array sorted.");
	}
	
	/**
	 * Prints the elements of an array.
	 */
	public void arrayPrinter() {
		System.out.println("Your array: ");
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				System.out.print(array2[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Reports the array's rows
	 * @return the number of rows
	 */
	public int getRows() {
		return array2.length;
	}
	
	/**
	 * Reports the number of columns
	 * @return the number of columns
	 */
	public int getColumns() {
		return array2[0].length;
	}
	
	/**
	 * Reports the number of elements in the array
	 * @return the number of elements
	 */
	public int getSize() {
		return currentSize;
	}
	
	/**
	 * Gets the current array for saving
	 * @return the current array
	 */
	public double[][] getArray(){
		return array2;
	}
}
