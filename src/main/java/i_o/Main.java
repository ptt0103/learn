package i_o;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {

            FileWriter file =new FileWriter("doc.txt", true) ;
            file.write("hello");
            file.write("222");
            file.close();
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            FileInputStream fileInputStream = new FileInputStream("data,dat");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
//            printWriter.write("hello");
//            printWriter.write("world");

//            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
