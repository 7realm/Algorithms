/*
 * Copyright (C) 2011 TopCoder Inc., All Rights Reserved.
 */
package algo.sort;

import java.util.Random;

import algo.sort.mergesort.MergeSort;

/**
 *
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class SortTester {

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 10000;
        int repeat = 30;
        Sort sort = new MergeSort();
        double[] input = new double[n];// {4, 4, 1, 3, 2, 3, 1, 4, 5, 7};

        long time = 0;
        for (int i = 0; i < repeat; i++) {
            createRandom(input);

            long start = System.currentTimeMillis();

            double[] result = sort.sort(input);

            time += System.currentTimeMillis() - start;

            // check result
            check(n, result);
        }

        System.out.println("Time: " + time + " ms.");

    }

    private static void check(int n, double[] result) {
        if (result.length != n) {
            System.err.println("Incorrect length of result.");
        }
        for (int i = 0; i < n - 1; i++) {
            if (result[i] > result[i + 1]) {
                System.err.println("Incorrect pair at index " + i + " and " + (i + 1) + " .");
            }
        }
    }

    private static void createRandom(double[] input) {
        Random random = new Random(System.currentTimeMillis());
        int n = input.length;
        for (int i = 0; i < n; i++) {
            input[i] = random.nextDouble() * n;
        }
    }

    private static void print(double[] result) {
        StringBuilder sb = new StringBuilder();
        for (double element : result) {
            sb.append(String.format("%d ", (int) (element * 10)));
        }
        System.out.println(sb.toString());
    }
}
