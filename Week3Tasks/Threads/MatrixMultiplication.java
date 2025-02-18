package Threads;

import java.util.Random;

public class MatrixMultiplication {
    static final int MAX = 4; // Size of the matrix
    static int[][] matA = new int[MAX][MAX]; // Matrix A
    static int[][] matB = new int[MAX][MAX]; // Matrix B
    static int[][] matC = new int[MAX][MAX]; // Result Matrix C

    // Worker class to compute one row of the result matrix
    static class Worker implements Runnable {
        int row; // Row index for the result matrix

        Worker(int row) {
            this.row = row;
        }

        @Override
        public void run() {
            // Perform matrix multiplication for the row assigned to this thread
            for (int j = 0; j < MAX; j++) {
                for (int k = 0; k < MAX; k++) {
                    matC[row][j] += matA[row][k] * matB[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // Generating random values in matA and matB
        System.out.println("Matrix A:");
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                matA[i][j] = rand.nextInt(10); // Random integers between 0 and 9
                System.out.print(matA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix B:");
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                matB[i][j] = rand.nextInt(10); // Random integers between 0 and 9
                System.out.print(matB[i][j] + " ");
            }
            System.out.println();
        }

        // Creating an array of threads
        Thread[] threads = new Thread[MAX];

        // Starting a thread for each row in the result matrix
        for (int i = 0; i < MAX; i++) {
            threads[i] = new Thread(new Worker(i)); // Assign each thread a row
            threads[i].start(); // Start the thread
        }

        // Waiting for all threads to finish
        for (int i = 0; i < MAX; i++) {
            try {
                threads[i].join(); // Wait for the thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Displaying the result matrix matC
        System.out.println("Multiplication result (Matrix C):");
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                System.out.print(matC[i][j] + " ");
            }
            System.out.println();
        }
    }
}
