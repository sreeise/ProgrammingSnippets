package files.serialize_deserialize;

import java.io.*;

public class SerializedObject {

  public Obj createObj(String objName, String objType) {
    return new Obj(objName, objType);
  }

  public void serializeObj(Obj obj, String fileName) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(fileName);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(obj);
    objectOutputStream.close();
    fileOutputStream.close();
  }

  public Obj deserializeObj(String fileName) throws IOException, ClassNotFoundException {
    FileInputStream fileInputStream = new FileInputStream(fileName);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    Obj obj = (Obj) objectInputStream.readObject();
    objectInputStream.close();
    fileInputStream.close();
    return obj;
  }

}
