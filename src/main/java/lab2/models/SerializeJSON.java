package lab2.models;


import java.io.IOException;

public class SerializeJSON implements ISerialize{
    @Override
    public <T> void serialize(T obj) throws IOException{

    }

    @Override
    public <T> T deserialize(Class<T> className) {
        return null;
    }

    @Override
    public <T> void serializeInFile(T obj, String path) {

    }

    @Override
    public <T> T deserializeFromFile(Class<T> className, String path) {
        return null;
    }
}
