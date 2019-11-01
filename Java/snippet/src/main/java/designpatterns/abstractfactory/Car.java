package designpatterns.abstractfactory;

import java.util.List;

public class Car extends AbstractVehicle {
  private String name;
  private List<Engine> engines;
  private List<Size> sizes;
  private List<String> colors;

  public Car(String name, List<Engine> engines, List<Size> sizes, List<String> colors) {
    this.name = name;
    this.engines = engines;
    this.sizes = sizes;
    this.colors = colors;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public List<Engine> getEngines() {
    return this.engines;
  }

  @Override
  public List<Size> getSizes() {
    return this.sizes;
  }

  @Override
  public List<String> getColors() {
    return this.colors;
  }
}
