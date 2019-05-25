package interview_questions.strings;

// From Cracking the Coding Interview by Gayle Laakmann McDowell
// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_04_Palindrome_Permutation/QuestionC.java
public class PalindromePermutation {
  /*
  Given a String, write a function to check if it is a permutation of a palindrome.
  A palindrome is a word or phrase that is the same forwards and backwards. A permutation
  is a rearrangement of letters. The palindrome does not need to be limited to just dictionary
  words.
   */

  public static boolean isPermutationOfPalindrome(String phrase) {
    int bitVector = createBitVector(phrase);
    return bitVector == 0 || checkExactlyOneBitSet(bitVector);
  }

  private static int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');

    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  private static int createBitVector(String phrase) {
    int bitVector = 0;
    for (char c : phrase.toCharArray()) {
      int x = getCharNumber(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  private static int toggle(int bitVector, int index) {
    if (index < 0) {
      return bitVector;
    }

    int mask = 1 << index;
    if ((bitVector & mask) == 0) {
      bitVector |= mask;
    } else {
      bitVector &= ~mask;
    }

    return bitVector;
  }

  private static boolean checkExactlyOneBitSet(int bitVector) {
    return (bitVector & (bitVector - 1)) == 0;
  }
}
