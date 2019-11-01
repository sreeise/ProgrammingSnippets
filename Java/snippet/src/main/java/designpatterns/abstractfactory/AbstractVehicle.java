package designpatterns.abstractfactory;

import java.util.List;

public abstract class AbstractVehicle {
  public abstract String getName();

  public abstract List<Engine> getEngines();

  public abstract List<Size> getSizes();

  public abstract List<String> getColors();

  @Override
  public String toString() {
    return "Name: " + this.getName()
          + "\nEngines: " + this.getEngines()
          + "\nSizes: " + this.getSizes()
          + "\nColors: " + this.getColors();
  }

  public enum Size {
    SMALL,
    MID_SIZE,
    LARGE,
  }

  public enum Engine {
    V4,
    V6,
    V8
  }
}
