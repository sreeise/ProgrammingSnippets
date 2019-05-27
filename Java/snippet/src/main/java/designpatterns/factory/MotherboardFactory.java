package designpatterns.factory;

public class MotherboardFactory {
  public static Motherboard getMotherboard(String type, String systemId, String vrmVoltage, String clockCycles) {
    if (type.equals("ATX")) {
      return new ATX(systemId, vrmVoltage, clockCycles);
    } else if (type.equals("MiniATX")) {
      return new MiniATX(systemId, vrmVoltage, clockCycles);
    }

    return null;
  }

  public static void example() {
    Motherboard atx = MotherboardFactory.getMotherboard("ATX", "ATX", "3.5 V", "2.7 GHZ");
    Motherboard miniATX = MotherboardFactory.getMotherboard("MiniATX", "Mini ATX", "2.8 V", "1.7 GHZ");
    System.out.println(atx);
    System.out.println(miniATX);
  }
}
