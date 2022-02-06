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

	public static int quick(int[] arr, int start, int end) {	// �ǹ� ����, start -> ū �� ã��, end <- ���� �� ã��
		int pivot = arr[(start + end) / 2];
		while (start <= end) {			// start end ���� �� quick ����
			while (arr[start] < pivot) start++;	// �ǹ����� ū ���� ���ö����� -> �̵�
			while (arr[end] > pivot) end--;	// �ǹ����� ���� ���� ���ö����� <- �̵�
			if (start <= end) {			// ��ġ �̵�
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
	
	public static void mergeSort(int arr[], int start, int end) {	// �ִ��� �۰� �ɰ��� ����
		if (start < end) {
			int mid = (start + end) / 2;		// �߰� �� ���ϱ�
			mergeSort(arr, start, mid);		// �ִ��� �۰� �ɰ��� ���� ���
			mergeSort(arr, mid + 1, end);	// �߰� �迭�� �ɰ���
			merge(arr, start, mid, end);		// ��ġ�鼭 ����
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int tmp[] = new int[(end - start) + 1];
		int i = start;
		int j = mid + 1;
		int index = 0;
		
		while (i <= mid && j <= end) {		// �� �� ���ؼ� ���� ���� ���� �ֱ�
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
		// �ӽ� �迭�� ������ �� �Ű��ֱ�
		for (int m = 0; m < tmp.length; m++) arr[start + m] = tmp[m];
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 10, 1, 8, 3, 6, 4, 0, 7, 2, 9};
		
		quickSort(arr);
		mergeSort(arr);
	}
}