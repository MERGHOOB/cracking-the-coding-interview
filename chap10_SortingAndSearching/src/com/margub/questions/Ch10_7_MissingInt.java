package com.margub.questions;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.LongStream;

public class Ch10_7_MissingInt {
    //10MB = 2 ^23 Bytes = 2^21 intergers = 2 millions around
    // Bucket : 0,10000m Bucket2: 10-20k and so one.
    // Total buuckets: 400

    private static final int SINGLE_BUCKET_SIZE = 10_000;
    private static final int TOTAL_BUCKETS = 400;
    private int[] buckets = new int[TOTAL_BUCKETS];
    private Set<Integer> bucketsWithLesserItems = new HashSet<>();

    private void countItemsInEachBucket(long input) {
        int bucketId = (int) input / SINGLE_BUCKET_SIZE;
        buckets[bucketId]++;
    }

    private void findBucketsWithLesserItems() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] < SINGLE_BUCKET_SIZE) {
                bucketsWithLesserItems.add(i);
                System.out.println("Bucket has a problem: " + i + ", " +
                        "total items =" + buckets[i] + ", missing items = " + (SINGLE_BUCKET_SIZE - buckets[i]));
            }
        }
    }

    Map<Integer, BitSet> bucketData = new HashMap<>();

    private void locateMissingNumbers(long input) {
        int bucketId = (int) (input / SINGLE_BUCKET_SIZE);
        if (bucketsWithLesserItems.contains(bucketId)) {
            bucketData.computeIfAbsent(bucketId, BitSet::new).set((int) (input % SINGLE_BUCKET_SIZE));
        }
    }

    private void printMissingNumbers() {
        bucketData.forEach((integer, bitSet) -> {
            int nextClearBit = 0, lastClearBit = 0;
            do {
                nextClearBit = bitSet.nextClearBit(lastClearBit);
                if (nextClearBit < SINGLE_BUCKET_SIZE) {
                    int missingNumber = integer * SINGLE_BUCKET_SIZE + nextClearBit;
                    System.out.println("missing number = " + missingNumber);
                } else break;
                lastClearBit = nextClearBit + 1;
            } while (lastClearBit < SINGLE_BUCKET_SIZE);
        });
    }

    public static void main(String[] args) {
        Set<Long> missingNumbers = new HashSet<>();

        missingNumbers.add(10L);
        missingNumbers.add(100L);
        missingNumbers.add(900L);
        missingNumbers.add(15L);
        missingNumbers.add(3999L);


        Ch10_7_MissingInt ch10_7_missingInt = new Ch10_7_MissingInt();
        LongStream.range(0, 4_000_000L) // run through all buckets.
                .filter(value -> !missingNumbers.contains(value))
                .forEach(ch10_7_missingInt::countItemsInEachBucket);
        System.out.println("First Pass done");
        ch10_7_missingInt.findBucketsWithLesserItems();

        System.out.println("Second pass done");
        LongStream.range(0, 4000000L)
                .filter(value -> !missingNumbers.contains(value))
                .forEach(ch10_7_missingInt::locateMissingNumbers);
        System.out.println("Third pass done");
        ch10_7_missingInt.printMissingNumbers();
        System.out.println("Fourth pass done");
    }


}
