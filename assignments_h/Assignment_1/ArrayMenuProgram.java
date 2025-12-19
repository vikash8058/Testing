import java.util.Scanner;
import java.util.Arrays;

public class ArrayMenuProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                int position = sc.nextInt();
                int value = sc.nextInt();

                int[] insertArray = new int[size + 1];

                for (int i = 0; i < position; i++) {
                    insertArray[i] = array[i];
                }

                insertArray[position] = value;

                for (int i = position; i < size; i++) {
                    insertArray[i + 1] = array[i];
                }

                System.out.println(Arrays.toString(insertArray));
                break;

            case 2:
                int deleteIndex = sc.nextInt();
                int[] deleteArray = new int[size - 1];

                for (int i = 0, j = 0; i < size; i++) {
                    if (i != deleteIndex) {
                        deleteArray[j++] = array[i];
                    }
                }

                System.out.println(Arrays.toString(deleteArray));
                break;

            case 3:
                int searchValue = sc.nextInt();
                boolean foundLinear = false;

                for (int number : array) {
                    if (number == searchValue) {
                        foundLinear = true;
                        break;
                    }
                }

                System.out.println(foundLinear);
                break;

            case 4:
                Arrays.sort(array);
                int key = sc.nextInt();

                int low = 0;
                int high = size - 1;
                boolean foundBinary = false;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (array[mid] == key) {
                        foundBinary = true;
                        break;
                    }

                    if (array[mid] < key) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                System.out.println(foundBinary);
                break;

            case 5:
                int maximum = array[0];

                for (int number : array) {
                    if (number > maximum) {
                        maximum = number;
                    }
                }

                System.out.println(maximum);
                break;

            case 6:
                int evenCount = 0;
                int oddCount = 0;

                for (int number : array) {
                    if (number % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }

                System.out.println(evenCount);
                System.out.println(oddCount);
                break;

            case 7:
                for (int i = 1; i < size; i++) {
                    int temp = array[i];
                    int j = i - 1;

                    while (j >= 0 && array[j] > temp) {
                        array[j + 1] = array[j];
                        j--;
                    }

                    array[j + 1] = temp;
                }

                System.out.println(Arrays.toString(array));
                break;
        }
    }
}
