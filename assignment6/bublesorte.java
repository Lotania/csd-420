//Anthony Nguyen, 10/18/2025, Assignment 6
//The puropose of the program is to demonstrate the
//basic capabilities of the comparator and comparable interfaces


import java.util.Comparator;

public class bublesorte {
	
	public static <E extends Comparable<E>> void bubbleSortable(E[] list) {//comparable
			int n = list.length;
			boolean swapped;
			for (int i = 0; i < n - 1; i++) {
			//outer loop: iterate through each element
				swapped = false; 
				//reiterate through the entire array until it's sorted
				for (int j = 0; j < n - 1 - i; j++) {
				//inner loop: compare all remaining elements
				//compare current element with next-indexed element
					if (list[j].compareTo(list[j + 1]) > 0) {
						// Swap if they are in the wrong order
						E temp = list[j];
						list[j] = list[j + 1];
						list[j + 1] = temp;
						swapped = true;
					}
				}
				// If no two elements were swapped by inner loop, then array is sorted
				if (!swapped) {
					break;
				}
			}
		}
		
	public static <E> void bubbleSortator(E[] list, Comparator<? super E> comparator) {//comparator
			int n = list.length;
			boolean swapped;
			for (int i = 0; i < n - 1; i++) {
				swapped = false;
				for (int j = 0; j < n - 1 - i; j++) {
				// Use the comparator to compare adjacent elements
					if (comparator.compare(list[j], list[j + 1]) > 0) {
						// Swap elements if they are in the wrong order
						E temp = list[j];//generic typing for ease of 'casting'
						list[j] = list[j + 1];
						list[j + 1] = temp;
						swapped = true;
					}
				}
				// If no two elements were swapped in inner loop, then array is sorted
				if (!swapped) {
					break;
				}
			}
		}
	
	public static void main(String[] args) {
		//two different arrays for two different interfaces
		Integer[] intArrayBle = {1,4,2,5,3,7,9,6,0,8};
		Integer[] intArrayTor = {51,26,15,14,17,18,29,40,38,37,48,69,70,8,86,65};
		
		//display before and after
	
		System.out.println("First integer array: ");
		for (Integer i : intArrayBle) {
			System.out.print(i + " ");
		}
		
		bubbleSortable(intArrayBle);
		System.out.println("\nFirst array sorted: ");
		for (Integer i : intArrayBle) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nSecond integer array: ");
		for (Integer i : intArrayTor) {
			System.out.print(i + " ");
		}
		
		bubbleSortator(intArrayTor, (num1, num2) -> num1.compareTo(num2));//tell the comparator to ascend the order
		System.out.println("\nSecond array sorted: ");
		for (Integer i : intArrayTor) {
			System.out.print(i + " ");
		}
	}
}