package interview_questions.strings;

public class RomanNumerals {
  public static int romanToInt(String s) {
    s = s.toUpperCase();
    int num = 0;
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == 'I' || c == 'X' || c == 'C') {
        if (i + 1 != chars.length) {

          char next = chars[i + 1];

          if (c == 'I' && next == 'V') {
            num += convert("IV");
            i = i + 1;
          } else if (c == 'I' && next == 'X') {
            num += convert("IX");
            i = i + 1;
          } else if (c == 'I') {
            num += convert("I");
          }

          if (c == 'X' && next == 'L') {
            num += convert("XL");
            i = i + 1;
          } else if (c == 'X' && next == 'C') {
            num += convert("XC");
            i = i + 1;
          } else if (c == 'X') {
            num += convert("X");
          }

          if (c == 'C' && next == 'D') {
            num += convert("CD");
            i = i + 1;
          } else if (c == 'C' && next == 'M') {
            num += convert("CM");
            i = i + 1;
          } else if (c == 'C') {
            num += convert("C");

          }

        } else {
          num += convert(String.valueOf(c));
        }
      } else {
        num += convert(String.valueOf(c));
      }
    }

    System.out.println(num);

    return num;
  }

  private static int convert(String symbol) {
    switch (symbol) {
      case "I":
        return 1;
      case "V":
        return 5;
      case "X":
        return 10;
      case "L":
        return 50;
      case "C":
        return 100;
      case "D":
        return 500;
      case "M":
        return 1000;
      case "IV":
        return 4;
      case "IX":
        return 9;
      case "XL":
        return 40;
      case "XC":
        return 90;
      case "CD":
        return 400;
      case "CM":
        return 900;
      default:
        return 0;
    }
  }
}
