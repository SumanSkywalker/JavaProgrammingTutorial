
public class ElementarySortingAlgorithms {
    public static void main(String[] args) {

        int[] array = new int[]{5, 7, 3, 2, 6, 4, 1, 9, 8, 0};

        //bubbleSort(array);
        //selectionSort(array);
        //insertionSort(array);

        //Print Array
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }

    static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int swap = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = swap;
                }
            }
        }
        return array;
    }

    static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int swap = array[index];
            array[index] = array[i];
            array[i] = swap;
        }
        return array;
    }

    static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int smallest = array[i];
            if (array[0] > array[i]) {
                //Un-shift from index 0
                for (int j = i; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = smallest;

            } else {
                int index = -1;

                for (int k = 1; k < i; k++) {
                    if (array[k] > array[i] && array[k - 1] <= array[i]) {
                        index = k;
                    }
                }

                //Un-shift from index K
                if (index != -1) {
                    for (int l = i; l > index; l--) {
                        array[l] = array[l - 1];
                    }
                    array[index] = smallest;
                }

            }
        }
        return array;
    }
}
