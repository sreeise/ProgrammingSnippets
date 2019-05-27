package designpatterns.factory;

public class MiniATX extends Motherboard {
  private String systemId;
  private String vrmVoltage;
  private String clockCycles;

  public MiniATX(String systemId, String vrmVoltage, String clockCycles) {
    this.systemId = systemId;
    this.vrmVoltage = vrmVoltage;
    this.clockCycles = clockCycles;
  }

  @Override
  public String getId() {
    return this.systemId;
  }

  @Override
  public String getVRMVoltage() {
    return this.vrmVoltage;
  }

  @Override
  public String getCPUClockCycles() {
    return this.clockCycles;
  }
}
