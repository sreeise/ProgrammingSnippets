package designpatterns.abstractfactory;

import java.util.List;

public class CarFactory implements AbstractVehicleFactory {
  private String name;
  private List<AbstractVehicle.Engine> engines;
  private List<AbstractVehicle.Size> sizes;
  private List<String> colors;

  public CarFactory(String name, List<AbstractVehicle.Engine> engines, List<AbstractVehicle.Size> sizes, List<String> colors) {
    this.name = name;
    this.engines = engines;
    this.sizes = sizes;
    this.colors = colors;
  }

  @Override
  public AbstractVehicle getVehicle() {
    return new Car(this.name, this.engines, this.sizes, this.colors);
  }
}
