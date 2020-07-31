package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption_Decryption {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length==0)
        {
            System.out.print("Nothing passed");
        }
        String mode="enc";
        int key=0;
        String data="";
        String output=null;
        String input=null;
        for(int i=0;i<args.length;i++){
            if(args[i].equals("-mode")){
                if(args[++i].equals("dec"))
                    mode="dec";
                else
                    mode="enc";
                //System.out.print(mode);
            }
            else if(args[i].equals("-key")){
                if((args[++i].length())>0)
                    key=Integer.parseInt(args[i]);
                //System.out.print(key);
            }
            else if(args[i].equals("-out")){
                if((args[++i].length())>0)
                    output=args[i];
            }
            else if(args[i].equals("-in")){
                if((args[++i].length()>0))
                    input=args[i];
            }
            else{
                data=args[i];
                //System.out.print(mode);
            }
        }
        if((input!=null || input==null) && data.length()>0) {
            if(output==null)
                dataEncryptDecrypt(mode, key, data);
            if(output!=null) {
                String str = "";
                if(mode.equals("dec")){
                    for (int i = 0; i < data.length(); i++)
                        str += (char) (str.charAt(i)) - key;
                }
                if(mode.equals("enc")){
                    for (int i = 0; i < data.length(); i++)
                        str += (char) (str.charAt(i)) + key;
                }
                FileWriter fileWriter=new FileWriter(output);
                fileWriter.write(str);
            }
        }
        if(input!=null && data.equals("")) {
            File file=new File(input);
            Scanner in=new Scanner(file);
            while(in.hasNext()){
                String str=in.nextLine();
                if(output==null){
                    dataEncryptDecrypt(mode, key, str);
                }
                if(output!=null){
                    FileWriter fileWriter=new FileWriter(output);
                    fileWriter.write(str);
                }
            }
        }
    }
    public static void dataEncryptDecrypt(String mode, int key, String data) {
        if (mode.equals("dec")) {
            for (int i = 0; i < data.length(); i++) {
                System.out.print((char) (data.charAt(i) - key));
            }
        } else if (mode.equals("enc")) {
            for (int i = 0; i < data.length(); i++) {
                System.out.print((char) (data.charAt(i) + key));
            }
        }
    }
}


//Sample input-- java Main -mode enc -key 5 -data "Welcome to hyperskill!"
//Sample output-- \jqhtrj%yt%m~ujwxpnqq&