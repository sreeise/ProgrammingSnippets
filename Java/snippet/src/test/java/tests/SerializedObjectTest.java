package tests;

import files.serialize_deserialize.Obj;
import files.serialize_deserialize.SerializedObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SerializedObjectTest {
  private static final String TEST_CASE_FILE = "./test_files/obj.ser";

  private static void tryDeleteFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      file.delete();
    }
  }

  private static boolean canRunTest(String filePath) {
    File file = new File(filePath);
    if (!file.exists()) {
      return true;
    } else {
      boolean deleted = file.delete();
      if (deleted) {
        return true;
      }
    }

    return !file.exists();
  }

  @Test
  public void testSerializedObject() throws IOException, ClassNotFoundException {
    if (canRunTest(TEST_CASE_FILE)) {
      SerializedObject serializedObject = new SerializedObject();
      Obj obj = serializedObject.createObj("objName", "objType");
      serializedObject.serializeObj(obj, TEST_CASE_FILE);
      Obj obj1 = serializedObject.deserializeObj(TEST_CASE_FILE);
      assertEquals(obj1.name, obj.name);
      assertEquals(obj1.type, obj.type);
    }

    tryDeleteFile(TEST_CASE_FILE);
  }
}
