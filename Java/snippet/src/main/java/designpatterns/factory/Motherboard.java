package designpatterns.factory;

// Factory design is considered a creational pattern.
// The factory design allows the subclasses to instantiate a chosen type.
public abstract class Motherboard {
  public abstract String getId();
  public abstract String getVRMVoltage();
  public abstract String getCPUClockCycles();

  @Override
  public String toString() {
    return "Motherboard Id: "
          + this.getId()
          + "\nVRM Voltage : "
          + this.getVRMVoltage()
          + "\nCPU Clock Cycles: " + this.getCPUClockCycles();
  }
}
