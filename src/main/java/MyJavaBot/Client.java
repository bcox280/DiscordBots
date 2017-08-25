package MyJavaBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Blair on 10/07/2017.
 */
public class Client {

    final static String FILENAME = "token.txt";
    public static void main(String[] args){

        String token = "";
        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bR = new BufferedReader(fileReader);
            if((token = bR.readLine()) != null){

                SimpleBot bot = new ModBot(token);

            }else{

                System.out.println("Token not found in token.txt");

            }
        }catch(FileNotFoundException e){

            e.printStackTrace();
            System.out.println("token.txt not found");


        }catch(IOException e){

            e.printStackTrace();
            System.out.println("Error reading token.text");

        }
        System.out.println("Make sure you have a file called token.txt in the base directory(With the readme)");

    }
}
