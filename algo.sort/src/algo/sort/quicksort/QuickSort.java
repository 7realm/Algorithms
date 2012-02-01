/*
 * Copyright (C) 2011 TopCoder Inc., All Rights Reserved.
 */
package algo.sort.quicksort;

import algo.sort.BaseSort;

/**
 *
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class QuickSort extends BaseSort {

    /**
     *
     *
     * @param input
     * @return
     */
    @Override
    public double[] sort(double[] input) {
        doSort(input, 0, input.length - 1);

        return input;
    }

    private void doSort(double[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = (left + right) / 2;
        double pivotValue = input[pivotIndex];

        int l = left;
        int r = right;
        while (true) {
            while(input[l] < pivotValue) {
                l++;
            }
            while(input[r] > pivotValue) {
                r--;
            }

            if (l <= r) {
                swap(input, l, r);
                l++;
                r--;
            }

            if (l > r) {
                break;
            }

        }

        doSort(input, left, r);
        doSort(input, l, right);
    }

    private int partition(double[] input, int left, int right, int pivotIndex) {
        double pivotValue = input[pivotIndex];
        swap(input, right, pivotIndex);

        int newIndex = left;
        for(int i = left; i < right - 1; i++) {
            if (input[i] < pivotValue) {
                swap(input, left, newIndex);
                newIndex++;
            }
        }

        swap(input, newIndex, right);
        return newIndex;
    }


}
