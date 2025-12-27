import java.io.*;
import java.util.List;

public class SerializeStudents<T extends Serializable> {

    private String fileName;

    public SerializeStudents(String fileName) {
        this.fileName = fileName;
    }

    public void serialize(List<T> list) {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("Unable to serialize");
        }
    }

    public List<T> deserialize() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject(); // unchecked → warning lazımdır
        } catch (Exception e) {
            System.out.println("Unable to deserialize");
            return null;
        }
    }
}
