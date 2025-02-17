package Threads;

import java.util.Arrays;

public class MultiThreadedSort {

    // Merge sort method that sorts a portion of the array
    public static class MergeSortTask extends Thread {
        private int[] arr;
        private int left, right;

        public MergeSortTask(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            if (left < right) {
                int mid = (left + right) / 2;
                MergeSortTask leftTask = new MergeSortTask(arr, left, mid);
                MergeSortTask rightTask = new MergeSortTask(arr, mid + 1, right);

                // Start sorting in parallel
                leftTask.start();
                rightTask.start();

                try {
                    leftTask.join();
                    rightTask.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                merge(arr, left, mid, right);
            }
        }

        // Merging the sorted halves
        private void merge(int[] arr, int left, int mid, int right) {
            int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
            int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

            int i = 0, j = 0, k = left;
            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k++] = leftArray[i++];
                } else {
                    arr[k++] = rightArray[j++];
                }
            }

            while (i < leftArray.length) {
                arr[k++] = leftArray[i++];
            }

            while (j < rightArray.length) {
                arr[k++] = rightArray[j++];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        // Start sorting the array in multiple threads
        MergeSortTask mainTask = new MergeSortTask(arr, 0, arr.length - 1);
        mainTask.start();
        mainTask.join();

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
