/*
 * Copyright (C) 2011 TopCoder Inc., All Rights Reserved.
 */
package algo.sort;

/**
 *
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public abstract class BaseSort implements Sort {

   protected void swap(double[] input, int i, int j) {
       double temp = input[i];
       input[i] = input[j];
       input[j] = temp;
   }

}
