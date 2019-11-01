package designpatterns.abstractfactory;

import java.util.List;

public class SuvFactory implements AbstractVehicleFactory {
  private String name;
  private List<AbstractVehicle.Engine> engines;
  private List<AbstractVehicle.Size> sizes;
  private List<String> colors;

  public SuvFactory(String name, List<AbstractVehicle.Engine> engines, List<AbstractVehicle.Size> sizes, List<String> colors) {
    this.name = name;
    this.engines = engines;
    this.sizes = sizes;
    this.colors = colors;
  }

  @Override
  public AbstractVehicle getVehicle() {
    return new Suv(this.name, this.engines, this.sizes, this.colors);
  }
}
