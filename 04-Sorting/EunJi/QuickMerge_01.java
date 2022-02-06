package sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickMerge_01 {
	
	public static void quickSort(int[] arr) {
		System.out.println("*** Quick Sort Start ***");
		quickSort(arr, 0, arr.length - 1);
		
		IntStream stream = Arrays.stream(arr);
		stream.forEach(e -> System.out.print(e +" "));
		System.out.println();
	}

	public static void quickSort(int[] arr, int start, int end) {
		int part2 = quick(arr, start, end);

		if (start < part2 - 1) quickSort(arr, start, part2 - 1);
		if (part2 < end) quickSort(arr, part2, end);
	}

	public static int quick(int[] arr, int start, int end) {	// 피벗 지정, start -> 큰 값 찾기, end <- 작은 값 찾기
		int pivot = arr[(start + end) / 2];
		while (start <= end) {			// start end 교차 시 quick 종료
			while (arr[start] < pivot) start++;	// 피벗보다 큰 값이 나올때까지 -> 이동
			while (arr[end] > pivot) end--;	// 피벗보다 작은 값이 나올때까지 <- 이동
			if (start <= end) {			// 위치 이동
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;

				start++;
				end--;
			}
		}
		return start;
	}
	
	public static void mergeSort(int arr[]) {
		System.out.println("*** Merge Sort Start ***");
		mergeSort(arr, 0, arr.length-1);
		
		IntStream stream = Arrays.stream(arr);
		stream.forEach(e -> System.out.print(e +" "));
		System.out.println();
	}
	
	public static void mergeSort(int arr[], int start, int end) {	// 최대한 작게 쪼개서 정렬
		if (start < end) {
			int mid = (start + end) / 2;		// 중간 값 구하기
			mergeSort(arr, start, mid);		// 최대한 작게 쪼개기 위해 재귀
			mergeSort(arr, mid + 1, end);	// 중간 배열도 쪼개기
			merge(arr, start, mid, end);		// 합치면서 정렬
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int tmp[] = new int[(end - start) + 1];
		int i = start;
		int j = mid + 1;
		int index = 0;
		
		while (i <= mid && j <= end) {		// 두 개 비교해서 작은 쪽을 먼저 넣기
			if (arr[i] < arr[j])  tmp[index] = arr[i++];
			else tmp[index] = arr[j++];
			
			index++;
		}

		if (i <= mid) {
			while (i <= mid) {
				tmp[index] = arr[i++];
				index++;
			}
		} else {
			while (j <= end) {
				tmp[index] = arr[j++];
				index++;
			}
		}
		// 임시 배열에 저장한 값 옮겨주기
		for (int m = 0; m < tmp.length; m++) arr[start + m] = tmp[m];
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 10, 1, 8, 3, 6, 4, 0, 7, 2, 9};
		
		quickSort(arr);
		mergeSort(arr);
	}
}