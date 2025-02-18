package Threads;

public class PrimeSumMultiThreaded {

    // Shared variable for the sum of primes
    static long sum = 0;

    // Worker class to check primes in a specific range
    static class PrimeWorker implements Runnable {
        long start;   // Start of the range
        long end;     // End of the range

        PrimeWorker(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                if (isPrime(i)) {
                    addToSum(i);  // Add to the sum of primes
                }
            }
        }

        // Helper method to check if a number is prime
        private boolean isPrime(long num) {
            if (num <= 1) return false;
            for (long i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }

        // Method to safely update the sum
        private synchronized void addToSum(long prime) {
            sum += prime;  // Update the global sum of primes
        }
    }

    public static void main(String[] args) {
        // Define the upper limit for the prime number calculation
        long limit = 25;  // Example: 1 million
        int numThreads = 8;     // Number of threads to use

        long rangeSize = limit / numThreads;

        // Create an array of threads
        Thread[] threads = new Thread[numThreads];

        // Divide the work into threads
        for (int i = 0; i < numThreads; i++) {
            long start = i * rangeSize + 1;
            long end = (i == numThreads - 1) ? limit : (i + 1) * rangeSize;
            threads[i] = new Thread(new PrimeWorker(start, end));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Output the sum of prime numbers
        System.out.println("Sum of primes up to " + limit + ": " + sum);
    }
}