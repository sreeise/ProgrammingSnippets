package designpatterns.abstractfactory;

import java.util.ArrayList;
import java.util.Arrays;

public class VehicleFactory {
  public static AbstractVehicle getVehicle(AbstractVehicleFactory factory) {
    return factory.getVehicle();
  }

  public static void testFactory() {
    AbstractVehicle car = VehicleFactory.getVehicle(new CarFactory(
          "Toyota Camry",
          new ArrayList<>(Arrays.asList(AbstractVehicle.Engine.V4)),
          new ArrayList<>(Arrays.asList(AbstractVehicle.Size.SMALL)),
          new ArrayList<>(Arrays.asList("Black", "Blue", "Red", "Gray"))
    ));

    AbstractVehicle suv = VehicleFactory.getVehicle(new CarFactory(
          "Ford Explorer",
          new ArrayList<>(Arrays.asList(AbstractVehicle.Engine.V6, AbstractVehicle.Engine.V8)),
          new ArrayList<>(Arrays.asList(AbstractVehicle.Size.MID_SIZE, AbstractVehicle.Size.LARGE)),
          new ArrayList<>(Arrays.asList("Black", "Blue", "Red", "Gray"))
    ));

    System.out.println("Car:\n" + car);
    System.out.println("Suv:\n" + suv);
  }
}
