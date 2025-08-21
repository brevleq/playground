package com.brevleq.playground;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestUnrepeatedSubstringExtractorTest {

    private final SubstringExtractable sut = new LongestUnrepeatedSubstringExtractor();

    @Nested
    class WhenParameterIsNull {

        @Test
        void shouldReturnEmptyString() {
            String expected = "";

            String result = sut.extract(null);

            assertEquals(expected, result);
        }
    }

    @Nested
    class WhenParameterIsEmpty {
        @Test
        void shouldReturnEmptyString() {
            String expected = "";

            String result = sut.extract("");

            assertEquals(expected, result);
        }
    }

    @Nested
    class WhenParameterIsNotEmpty {

        @Nested
        class WhenParameterHasOnlyOneCharacters {
            @Test
            void shouldReturnTheInput() {
                String expected = RandomStringUtils.secure().nextAlphanumeric(1);

                String result = sut.extract(expected);

                assertEquals(expected, result);
            }
        }

        @Nested
        class WhenParameterHasOnlyTheSameCharacter {
            @Test
            void shouldReturnTheCharacter() {
                String expected = RandomStringUtils.secure().nextAlphanumeric(1);
                int quantity = Math.abs(RandomUtils.secure().randomInt() % 20) + 1;
                String parameter = Stream.generate(() -> expected).limit(quantity).collect(Collectors.joining());

                String result = sut.extract(parameter);

                assertEquals(expected, result);
            }
        }

        @Nested
        class WhenParameterHasOnlyTheDifferentCharacter {

            Map<String, String> testCases = new LinkedHashMap<>() {{
                put("GEEKSFORGEEKS", "EKSFORG");
                put("abcabcbb", "abc");
                put("pwwkew", "wke");
                put("aabcddefgh", "defgh");
                put("JavaProgramming", "vaProg");
                put("!!@#$%^&*()", "!@#$%^&*()");
                put("aA1bB2cC3", "aA1bB2cC3");
                put("   ", " ");
                put("abba", "ab");
            }};


            @Test
            void shouldReturnTheLongestUnrepeatedSubstring() {
                for (Map.Entry<String, String> testCase : testCases.entrySet()) {
                    String result = sut.extract(testCase.getKey());

                    assertEquals(testCase.getValue(), result);
                }
            }
        }
    }

}
