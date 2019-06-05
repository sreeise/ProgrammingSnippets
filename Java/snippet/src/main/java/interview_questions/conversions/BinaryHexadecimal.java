package interview_questions.conversions;

public class BinaryHexadecimal {
  public static String convertBinary(String hexadecimal) {
    String[] hexArray = hexadecimal.split("");
    StringBuilder builder = new StringBuilder();
    for (String i : hexArray) {
      builder.append(getBinary(i)).append(" ");
    }
    return builder.toString().trim();
  }

  // There is obviously shorter ways of generating the binary
  // mapping of a hexadecimal but this is to show clearly what
  // each hexadecimal would be in binary.
  private static String getBinary(String hexadecimal) {
    switch (hexadecimal) {
      case "0":
        return "0000";
      case "1":
        return "0001";
      case "2":
        return "0010";
      case "3":
        return "0011";
      case "4":
        return "0100";
      case "5":
        return "0101";
      case "6":
        return "0110";
      case "7":
        return "0111";
      case "8":
        return "1000";
      case "9":
        return "1001";
      case "A":
        return "1010";
      case "B":
        return "1011";
      case "C":
        return "1100";
      case "D":
        return "1101";
      case "E":
        return "1110";
      case "F":
        return "1111";
      default:
        return "";
    }
  }
}
