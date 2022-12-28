package lab2.models;


import java.io.IOException;

public interface ISerialize {
    <T> void serialize(T obj) throws IOException;

    <T> T deserialize(Class<T> className);

    <T> void serializeInFile(T obj, String path);

    <T> T deserializeFromFile(Class<T> className, String path);
}
