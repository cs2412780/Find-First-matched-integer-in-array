package findTheFirstMatchValue;

import java.util.Scanner;

public class Solution {
	private static int[] temp;

	public static void main(String[] args) {
		System.out.println();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
             arr[i] = sc.nextInt();
        }
        System.out.println("#####################");
        double valueForSearch = value - 0.5;
        Solution.merge(arr);
        for(int i = 0; i < n; i++) {
        	System.out.println(i + ": " + arr[i]);
       }
        System.out.println("#####################");
        int index = findIndex(arr, valueForSearch, value);
        System.out.println("index: " + index);
        sc.close();
	}
	public static int findIndex(int[] arr, double value, int trueValue) {
		int index = findIndex(arr, 0, arr.length - 1, value);
		System.out.println("indexFind: " + index);
		if(arr[index] < value) {
			if(index != arr.length - 1) {
				index++;
				if(arr[index] == trueValue) {
					return index;
				}
				else
					return -1;
			}
			else
				return -1;
		}
		else if(arr[index] == trueValue) 
			return index;
		else {	
			return -1;
		}
	}
	private static int findIndex(int[] arr, int first, int last, double value) {
		System.out.println("first: " + first + " last: " + last);
		if(first == last) {
			return first;
		}
		else {
			int mid = (first + last) / 2;
			System.out.println("mid: " + mid);
			if(value <= arr[mid]) {
				return findIndex(arr, first, mid, value);
			}
			else {
				return findIndex(arr, mid + 1, last, value);
			}
		}
	}
	public static int[] merge(int[] arr) {
		temp = new int[arr.length];
		merge(arr, 0, arr.length - 1);
		return arr;
	}

	private static void merge(int[] arr, int first, int last) {
		if(last - first > 0) {
			int mid = (last + first) / 2;
			merge(arr, first, mid);
			merge(arr, mid + 1, last);
			int left = first;
			int right = mid + 1;
			int index = first;
			while(left <= mid && right <= last) {
				if(arr[left] <= arr[right]) {
					temp[index] = arr[left];
					left++;
				}
				else {
					temp[index] = arr[right];
					right++;
				}
				index++;
			}
			if(left > mid) {
				while(index <= last) {
					temp[index] = arr[right];
					right++;
					index++;
				}
			}
			if(right > last) {
				while(index <= last) {
					temp[index] = arr[left];
					left++;
					index++;
				}
			}
			
			for(int i = first; i <= last; i++) {
				arr[i] = temp[i];
			}
		}
	}
	
	
	
	
}
