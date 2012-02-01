/*
 * Copyright (C) 2011 TopCoder Inc., All Rights Reserved.
 */
package algo.sort.mergesort;

import algo.sort.BaseSort;

/**
 *
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class MergeSort extends BaseSort {

    /**
     *
     *
     * @param input
     * @return
     */
    @Override
    public double[] sort(double[] input) {
        return doSort(input, 0, input.length - 1);
    }

    private double[] doSort(double[] input, int left, int right) {
        if (left == right) {
            return new double[] {input[left]};
        }

        int middle = (left + right) / 2;

        double[] leftArray = doSort(input, left, middle);
        double[] rightArray = doSort(input, middle + 1, right);

        return doMerge(leftArray, rightArray);
    }

    /**
     *
     *
     * @param leftArray
     * @param rightArray
     * @return
     */
    private double[] doMerge(double[] leftArray, double[] rightArray) {
        double[] result = new double[leftArray.length + rightArray.length];

        int indexLeft = 0;
        int indexRight = 0;

        for (int i = 0; i < result.length; i++) {
            boolean useLeft = true;
            if (indexLeft < leftArray.length) {
                if (indexRight < rightArray.length) {
                    useLeft = leftArray[indexLeft] < rightArray[indexRight];
                }
            } else {
                useLeft = false;
            }
            result[i] = useLeft ? leftArray[indexLeft++] : rightArray[indexRight++];
        }

        return result;
    }

}
