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
        StringBuilder longestSubstring = new StringBuilder();
        while (startIndex < original.length()) {
            StringBuilder currentSubstring = extractCurrentSubstring(original, startIndex);
            if (currentSubstring.length() > longestSubstring.length())
                longestSubstring = currentSubstring;
            startIndex++;
        }
        return longestSubstring.toString();
    }

    private StringBuilder extractCurrentSubstring(String original, int startIndex) {
        Set<Character> set = new HashSet<>();
        int endIndex = startIndex;
        StringBuilder currentSubstring = new StringBuilder();
        while (endIndex < original.length()) {
            Character character = original.charAt(endIndex);
            if (set.contains(character))
                return currentSubstring;
            currentSubstring.append(character);
            set.add(character);
            endIndex++;
        }
        return currentSubstring;
    }
}
