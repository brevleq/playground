package com.brevleq.playground;

import java.util.HashSet;
import java.util.Set;

public class Playground {

    public static void main(String[] args) {
        System.out.println(findLongest("GEEKSFORGEEKS"));
    }

    static int findLongest(String value) {
        int startIndex = 0;
        String longestSubstring = "";
        while (startIndex < value.length()) {
            Set<Character> set = new HashSet<>();
            int endIndex = startIndex;
            boolean foundRepeated = false;
            String currentSubstring = "";
            while (endIndex < value.length() && !foundRepeated) {
                Character character = value.charAt(endIndex);
                if (set.contains(character)) {
                    foundRepeated = true;
                } else {
                    currentSubstring += character;
                    set.add(character);
                }
                endIndex++;
            }
            if (currentSubstring.length() > longestSubstring.length()) {
                longestSubstring = currentSubstring;
            }
            startIndex++;
        }
        System.out.println(longestSubstring);
        return longestSubstring.length();
    }
}


//Length of the longest substring without repeating characters
//Given a string str, find the length of the longest substring without repeating characters.
//
//Example:
//For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
//
//For “BBBB” the longest substring is “B”, with length 1.
//
//For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7
//AAAAAAAAAA
//AAAAAAAAAA
//        A
//1
//ABCABCABC
//34
//ABC
//        CAB
//BCA
//        ABCDAB
//ABCD
