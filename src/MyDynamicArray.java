import java.util.Arrays;

class DynamicArray {
    int[] arr = new int[0];


    int count() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }
        return count;
    }

    void add(int data) {
        int n = count();
        if (arr.length == 0) {
            arr = new int[1];
        }
        if (n == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[n] = data;
    }

    void remove() {
        int n = count();

        if (n != arr.length) {
            arr = Arrays.copyOf(arr, arr.length - ((arr.length - n) / 2));
        }
        arr[n - 1] = 0;
    }

    void insertAt(int index, int data) {
        if (index >= 0) {
            int n = count();
            int[] cpyArr = Arrays.copyOf(arr, arr.length);
            if (n == arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }

            if (index <= n) {
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (i == index) {
                        arr[i] = 0;
                    } else {
                        arr[i] = cpyArr[j];
                        j++;
                    }
                }
                arr[index] = data;
            } else {
                System.out.println("ArrayIndexOutOfBoundsException...");
            }
        } else {
            System.out.println("ArrayIndexOutOfBoundsException...");
        }
    }

    void deleteAt(int index) {
        if (index >= 0) {
            int n = count();
            int[] cpyArr = Arrays.copyOf(arr, arr.length);


            if (index < n) {
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (i < index) {
                        arr[i] = arr[j];
                        j++;
                    } else if (i > index) {
                        arr[i - 1] = cpyArr[j+1];
                        j++;
                    }
                }
                n = count();
                if (n < arr.length) {
                    arr = Arrays.copyOf(arr, arr.length - ((arr.length - n) / 2));
                }
            } else {
                System.out.println("ArrayIndexOutOfBoundsException...");
            }
        } else {
            System.out.println("ArrayIndexOutOfBoundsException...");
        }
    }

    void printArray() {
        int n = count();
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}


class ArrayMain {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.printArray();
        dynamicArray.remove();
        dynamicArray.printArray();
        dynamicArray.insertAt(2, 6);
        dynamicArray.printArray();
        dynamicArray.deleteAt(2);
        dynamicArray.printArray();
    }
}
