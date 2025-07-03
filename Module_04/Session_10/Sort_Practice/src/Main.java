public class Main {
	public static void main (String[] args) {

	}

	// Thuật toán sắp xếp Exchange Sort
	public static void exchangeSort (int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("Đã sắp xếp xong");
	}

	// Thuật toán sắp xếp Selection Sort
	public static void selectionSort (int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		System.out.println("Đã sắp xếp xong");
	}

	// Thuật toán sắp xếp Insert Sort
	public static void insertSort (int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = key;
		}
	}

	// Thuật toán sắp xếp Bubble Sort
	public static void bubbleSort (int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	// Thuật toán tìm kiếm nhị phân
	public static int binarySearch (int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
