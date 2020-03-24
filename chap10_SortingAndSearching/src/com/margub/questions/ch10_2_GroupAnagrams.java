package com.margub.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class ch10_2_GroupAnagrams {


    private String sortString(String first) {
        char[] f = first.toCharArray();
        Arrays.sort(f);
        return new String(f);

    }
    private void sort(String[] arr) {
        Arrays.sort(arr, Comparator.comparing(this::sortString));
        System.out.println(arr);
    }

    public static void main(String[] args) {
        String [] arr = {"abc", "efg", "bca", "acb", "fge"};
        new ch10_2_GroupAnagrams().sort(arr);
        new ch10_2_GroupAnagrams().sortUsingHashMap(arr);
    }

    // Why go through all sort, we can avoid that as sorting such that all anagrams should be together
    // we can use hash map
    void sortUsingHashMap(String []arr) {
        Map<String , List<String>> hashMap = new HashMap<>();
        for(String val: arr) {
            String key = sortString(val);
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(val);
        }

        hashMap.keySet().forEach(key -> {
            hashMap.get(key).forEach(System.out::println);
        });
    }

}
