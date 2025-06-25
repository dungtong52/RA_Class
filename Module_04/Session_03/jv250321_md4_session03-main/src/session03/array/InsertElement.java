package session03.array;

public class InsertElement {
    public static void main(String[] args) {
        int[] oldArray = {1, 3, 5, 7, 9};
        int newElement = 8;
        int insertIndex = 2;
        int[] newArray = new int[oldArray.length + 1];
        //B1: Copy các phần tử mảng cũ sang mảng mới và chèn giá trị mới vào vị trí chỉ định
        for (int i = 0; i < newArray.length; i++) {
            if (i < insertIndex) {
                newArray[i] = oldArray[i];
            } else if (i == insertIndex) {
                newArray[i] = newElement;
            } else {
                newArray[i] = oldArray[i - 1];
            }
        }
        //B2: In ra mảng sau khi chèn
        System.out.printf("Mảng sau khi chèn phần tử:");
        for (int element : newArray) {
            System.out.printf("%d\t", element);
        }
    }
}
