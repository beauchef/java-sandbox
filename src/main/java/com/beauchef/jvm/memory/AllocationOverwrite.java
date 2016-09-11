package com.beauchef.jvm.memory;

import java.util.Random;

/**
 * @auhor beauchef 9/11/2016.
 */
public class AllocationOverwrite {

    public static void main(String[] args) {

        int arraySize = 1_000_000;
        int lineSize = 120;
        GCMe[] gcMes = new GCMe[arraySize];

        int count = 0 ;
        int lineCount = 0 ;
        Random rnd = new Random();
        while (true) { // infinity
            gcMes[rnd.nextInt(arraySize)] = new GCMe();
            if (count % arraySize == 0) {
                System.out.print(".");
                lineCount++;
                if (lineCount % lineSize == 0) {
                    System.out.println();
                }
            }
            count++;
        }
    }
}
