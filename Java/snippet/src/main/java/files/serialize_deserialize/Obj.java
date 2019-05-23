package files.serialize_deserialize;

import java.io.Serializable;

public class Obj implements Serializable {
  public String name;
  public String type;

  public Obj(String objName, String objType) {
    this.name = objName;
    this.type = objType;
  }
}
