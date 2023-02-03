package org.melody.singleInstance;

import java.io.*;

/**
 * @author lizhaohui
 * @since 2023/2/3
 */
public class SerializeDemo implements Serializable {
    private static final long serialVersionUID = 3436470921329564947L;

    public static void main(String[] args) {

        Singleton3 singleton3 = Singleton3.INSTANCE;

        singleton3.setValue(1);

        String path = System.getProperty("user.dir") + "/src/main/resources/static/out.txt";
        // 序列化
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(singleton3);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        singleton3.setValue(2);

        // 反序列化
        Singleton3 singleton31 = null;
        try (FileInputStream fileIn = new FileInputStream(path)) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            singleton31 = (Singleton3) in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("singletons.SingletonEnum class not found");
            e.printStackTrace();
        }

        if (singleton3 == singleton31) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

        System.out.println(singleton3.getValue());
        System.out.println(singleton31.getValue());
    }
}
