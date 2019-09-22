import java.util.*;

class ArraySolutions {
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

    public static void main(String[] args) {
        String test = "pwwkew";
        System.out.println(lengthOfLongestSubstring(test));
    }
}
