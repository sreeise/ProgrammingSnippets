package interview_questions.strings;

public class RemoveKDigits {
  /*
  Given a non-negative integer num represented as a string, remove k digits from the number
  so that the new number is the smallest possible.

Note:
    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.
   */

  public static String removeKdigits(String num, int k) {
    if(num.length() == k) {
      return "0";
    }

    StringBuilder builder = new StringBuilder(num);
    for(int j = 0; j < k; j++){
      int i = 0;
      while(i < builder.length() - 1 && builder.charAt(i) <= builder.charAt(i + 1)) {
        i++;
      }
      builder.delete(i, i + 1);
    }

    //remove leading 0's
    while (builder.length() > 1 && builder.charAt(0) == '0')
      builder.delete(0, 1);

    if(builder.length() == 0){
      return "0";
    }

    return builder.toString();
  }
}
