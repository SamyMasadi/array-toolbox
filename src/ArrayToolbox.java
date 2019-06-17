/* Samy Masadi
 * CSCI 211
 * Project 2 */

/* This program is an Array Toolbox containing several methods towards creating and
 * modifying one dimension and two dimension arrays. The program prompts the user with
 * options for first creating an array and then presents options relevant to that array
 * type. The program loops until the user quits.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A class to create, modify, and store 1D and 2D arrays
 * @author Samy Masadi
 */
public class ArrayToolbox {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// Array Lists for storing constructed array objects
		ArrayList<Array_1> arrays1D = new ArrayList<Array_1>();
		ArrayList<Array_2> arrays2D = new ArrayList<Array_2>();
		
		ArrayMenus menus = new ArrayMenus();
		Array_1 user1D = new Array_1(0);
		Array_2 user2D = new Array_2(0, 0);
		String choiceA = ""; // Top menu sentinel
		String choiceB = "";
		String choiceC; // Inner menu sentinel
		int iChoice;
		
		while (!choiceA.equals("5")) {			
			menus.topMenuA();
			choiceA = in.next();
			System.out.println();
			
			// Construct new or load saved 1D arrays
			if (choiceA.equals("1")) {
				menus.createMenuB();
				choiceB = in.next();
				
				if (choiceB.equals("1")) {
					System.out.print("Length? ");
					int inLength = in.nextInt();
					user1D = new Array_1(inLength);
					System.out.println("Array created.");
				}
				if (choiceB.equals("2")) {
					double[] inputs = new double[1];
					int currentSize = 0;
					System.out.print("Enter numbers separated by spaces. Type \".\""
							+ " and \"Enter\" to finish. ");
					while (in.hasNextDouble()) {
						if (currentSize >= inputs.length) {
							inputs = Arrays.copyOf(inputs,  2 * inputs.length);
						}
						inputs[currentSize] = in.nextDouble();
						currentSize++; // Keeps tally of total number of elements
					}
					String catchPeriod = in.next();
					user1D = new Array_1(inputs, currentSize);
					System.out.println("Array created.");
				}
			}
			
			// Construct new or select saved 2D arrays
			if (choiceA.equals("2")) {
				menus.createMenuB();
				choiceB = in.next();
				
				if (choiceB.equals("1")) {
					System.out.print("Number of rows? ");
					int inRows = in.nextInt();
					System.out.print("Number of columns? ");
					int inColumns = in.nextInt();
					user2D = new Array_2(inRows, inColumns);
					System.out.println("Array created.");
				}
				if (choiceB.equals("2")) {
					String moreRows = "Y";
					int numRows = 0;
					int numColumns = 0;
					ArrayList<double[]> inputs2D = new ArrayList<double[]>();
					int currentSize = 0;
					while (moreRows.equals("Y")) {
						numRows++;
						double[] rowInputs = new double[1];
						int rowSize = 0;
						System.out.print("Input row as numbers separated by spaces. "
								+ "Type \".\" and \"Enter\" to finish. ");
						while (in.hasNextDouble()) {
							if (rowSize >= rowInputs.length) {
								rowInputs = Arrays.copyOf(rowInputs,  2 * rowInputs.length);
							}
							rowInputs[rowSize] = in.nextDouble();
							rowSize++;  // Keeps tally of individual row items
							currentSize++;  // Keeps tally of total elements
						}
						String catchPeriod = in.next();
						numColumns = rowSize;
						inputs2D.add(rowInputs);
						System.out.print("Another row? (Y/N) ");
						moreRows = in.next();
						System.out.println();
					}
					user2D = new Array_2(inputs2D, numRows, numColumns, currentSize);
					System.out.println("Array created.");
				}
			}
			
			if (choiceA.equals("3")) {
				if (arrays1D.isEmpty()) {
					System.out.println("Error: no saved 1D arrays");
					choiceA = "";
				}
				else {
					System.out.print("Select from saved arrays 1-"
							+ arrays1D.size() + " ");
					iChoice = in.nextInt();
					user1D = new Array_1(arrays1D.get(iChoice-1).getArray(), 
							arrays1D.get(iChoice-1).getSize());
				}
			}
			
			if (choiceA.equals("4")) {
				if (arrays2D.isEmpty()) {
					System.out.println("Error: no saved 2D arrays");
					choiceA = "";
				}
				else {
					System.out.print("Select from saved arrays 1-"
							+ arrays2D.size() + " ");
					iChoice = in.nextInt();
					user2D = new Array_2(arrays2D.get(iChoice-1).getArray(), 
							arrays2D.get(iChoice-1).getSize());
				}
			}
			
			choiceC = ""; // Sentinel for inner while menus
			// Inner menu for 1D array options
			if (choiceA.equals("1") || choiceA.equals("3")) {
				menus.array1DC();
				while (!choiceC.equals("M")) {
					System.out.print("Select an option: ");
					choiceC = in.next();
					System.out.println();
					
					if (choiceC.equals("7")) {
						if (user1D.checkSpace()) {
							System.out.print("Number: ");
							double inNum = in.nextDouble();
							System.out.print("Index: ");
							int inIndex = in.nextInt();
							user1D.insertElement(inNum, inIndex);
						}
						else {
							System.out.println("Array out of space. Please remove"
									+ " elements or increase its length.");
						}
					}
					
					if (user1D.checkEmpty() && !choiceC.equals("M")) {
						System.out.println("Please add numbers to your array.");
					}
					else {
						if (choiceC.equals("1")) {
							user1D.doubleLength();
						}
						
						if (choiceC.equals("2")) {
							System.out.println("Add current array to which "
									+ "saved array?");
							System.out.println("Select from saved arrays 1-"
									+ arrays1D.size() + " ");
							iChoice = in.nextInt();
							if (user1D.getSize() == arrays1D.get(iChoice-1).getSize()) {
								double[] tempArray = new double[user1D.getSize()];
								tempArray = user1D.addArrays(arrays1D.get(iChoice-1).getArray());
								Array_1 toSave = new Array_1(tempArray, user1D.getSize());
								arrays1D.add(toSave);
								System.out.println("Results saved in Array "
										+ arrays1D.size());
							}
							else {
								System.out.println("Error: the arrays do not contain"
										+ " the same number of elements.");
							}
						}
						
						if (choiceC.equals("3")) {
							System.out.println("Subtract current array from which "
									+ "saved array?");
							System.out.println("Select from saved arrays 1-"
									+ arrays1D.size() + " ");
							iChoice = in.nextInt();
							if (user1D.getSize() == arrays1D.get(iChoice-1).getSize()) {
								double[] tempArray = new double[user1D.getSize()];
								tempArray = user1D.subtractArrays(arrays1D.get(iChoice-1).getArray());
								Array_1 toSave = new Array_1(tempArray, user1D.getSize());
								arrays1D.add(toSave);
								System.out.println("Results saved in Array "
										+ arrays1D.size());
							}
							else {
								System.out.println("Error: the arrays do not contain"
										+ " the same number of elements.");
							}
						}
						
						if (choiceC.equals("4")) {
							System.out.println("The sum of all elements is " 
									+ user1D.sumElements());
						}
						if (choiceC.equals("5")) {
							user1D.maxMinMean();
						}
						if (choiceC.equals("6")) {
							System.out.print("Search for: ");
							user1D.findElement(in.nextDouble());
						}
						if (choiceC.equals("8")) {
							System.out.print("Index: ");
							user1D.removeElement(in.nextInt());
						}
						if (choiceC.equals("9")) {
							user1D.sortArray();
						}
						if (choiceC.equals("10")) {
							user1D.arrayPrinter();
						}
						if (choiceC.equals("11")) {
							arrays1D.add(user1D);
							System.out.println("Array saved as #" + arrays1D.size());
						}
						if (choiceC.equals("N")) {
							menus.array1DC();
						}
					}
					if (!choiceC.equals("M")) {
						System.out.println();
						System.out.println("Type \"N\" to see the current menu.");
						System.out.println();
					}
				}		
			}
			
			// Inner menu for 2D array options
			if(choiceA.equals("2") || choiceA.equals("4")) {
				menus.array2DC();
				while (!choiceC.equals("M")) {
					System.out.print("Select an option: ");
					choiceC = in.next();
					System.out.println();
					
					if (choiceC.equals("1")) {
						System.out.println("Add current array to which "
								+ "saved array?");
						System.out.println("Select from saved arrays 1-"
								+ arrays2D.size() + " ");
						iChoice = in.nextInt();
						if (user2D.getSize() == arrays2D.get(iChoice-1).getSize()) {
							double[][] tempArray = 
									new double[user2D.getRows()][user2D.getColumns()];
							tempArray = user2D.addArrays(arrays2D.get(iChoice-1).getArray());
							Array_2 toSave = new Array_2(tempArray, user2D.getSize());
							arrays2D.add(toSave);
							System.out.println("Results saved in Array "
									+ arrays2D.size());
						}
						else {
							System.out.println("Error: the arrays do not contain"
									+ " the same number of elements.");
						}
					}
					
					if (choiceC.equals("2")) {
						System.out.println("Subtract current array from which "
								+ "saved array?");
						System.out.println("Select from saved arrays 1-"
								+ arrays2D.size() + " ");
						iChoice = in.nextInt();
						if (user2D.getSize() == arrays2D.get(iChoice-1).getSize()) {
							double[][] tempArray = 
									new double[user2D.getRows()][user2D.getColumns()];
							tempArray = user2D.subtractArrays(arrays2D.get(iChoice-1).getArray());
							Array_2 toSave = new Array_2(tempArray, user2D.getSize());
							arrays2D.add(toSave);
							System.out.println("Results saved in Array "
									+ arrays2D.size());
						}
						else {
							System.out.println("Error: the arrays do not contain"
									+ " the same number of elements.");
						}
					}
					
					if (choiceC.equals("3")) {
						System.out.println("The sum of all elements is " 
								+ user2D.sumElements());
					}
					if (choiceC.equals("4")) {
						user2D.maxMinMean();
					}
					if (choiceC.equals("5")) {
						System.out.print("Search for: ");
						user2D.findElement(in.nextDouble());
					}
					if (choiceC.equals("6")) {
						user2D.sortArray();
					}
					if (choiceC.equals("7")) {
						user2D.arrayPrinter();
					}
					if (choiceC.equals("8")) {
						arrays2D.add(user2D);
						System.out.println("Array saved as #" + arrays2D.size());
					}
					if (choiceC.equals("N")) {
						menus.array1DC();
					}
					if (!choiceC.equals("M")) {
						System.out.println();
						System.out.println("Type \"N\" to see the current menu.");
						System.out.println();
					}
				}
			}
			System.out.println();
		}
		
		System.out.print("Goodbye");
		in.close();
	}
}