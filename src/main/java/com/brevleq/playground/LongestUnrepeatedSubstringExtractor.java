package com.brevleq.playground;

import java.util.HashSet;
import java.util.Set;

public class LongestUnrepeatedSubstringExtractor implements SubstringExtractable {


    @Override
    public String extract(String original) {
        if (original == null)
            return "";
        if (original.length() <= 1)
            return original;
        int startIndex = 0;
        String longestSubstring = "";
        while (startIndex < original.length()) {
            Set<Character> set = new HashSet<>();
            int endIndex = startIndex;
            boolean foundRepeated = false;
            String currentSubstring = "";
            while (endIndex < original.length() && !foundRepeated) {
                Character character = original.charAt(endIndex);
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
        return longestSubstring;
    }
}
