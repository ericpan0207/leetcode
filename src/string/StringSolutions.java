import java.util.*;

class StringSolutions {
    /* Longest Substring Without Repeating Characters
     *
     * Idea: Sliding window, move end forward until invalid,
     *     then move start forward until valid and repeat
     * Optmizations: int[128] over hash map since only chars
     *               storing variables inside for loop
     * Example: "pwwkew", output is 3: "wke"
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] characters = new int[128];
        int longest = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {
            characters[s.charAt(end)] += 1;
            while (characters[s.charAt(end)] > 1) {
                characters[s.charAt(start)]--;
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }

    /* Longest Repeating Character Replacement
     *
     * Idea: sliding window with 2 insights:
     *     1) Keep track of max char in window and not just the first char
     *     2) No need to shrink window, since we're interesed in longest anyway
     *        (can't do this for above because of the condition for maxChar)
     *
     * Example: s = "AABABBA", k = 1, output is 4
     */
    public static int characterReplacement(String s, int k) {
        int start = 0;
        int[] charCount = new int[26];

        for (int end = 0, maxChar = 0; end < s.length(); end++) {
            maxChar = Math.max(maxChar, ++charCount[s.charAt(end) - 'A']);

            // Doesn't work for "ABBB", k = 2; always skips first part:
            // while (charCount[s.charAt[start] + k < end - start + 1])
            if (maxChar + k < end - start + 1) {
                charCount[s.charAt(start++) - 'A']--;
            }
        }
        return s.length() - start;
    }

    public static void main(String[] args) {
        // String test = "pwwkew";
        // System.out.println(lengthOfLongestSubstring(test));

        String test = "ABBB";
        System.out.println(characterReplacement(test, 2));
    }
}
