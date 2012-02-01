/*
 * Copyright (C) 2011 TopCoder Inc., All Rights Reserved.
 */
package algo.sort.bubble;

import algo.sort.BaseSort;

/**
 *
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class BubbleSort extends BaseSort {

    /**
     *
     *
     * @param input
     * @return
     */
    @Override
    public double[] sort(double[] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                   swap(input, j, j+1);
                }
            }
        }
        return input;
    }

}
