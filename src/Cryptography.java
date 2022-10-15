import java.security.Key;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cryptography implements Encrypt_Decrypt,GetInput {
    String message;
    final String ALGO = "AES";
    byte[] keyval;

    void setSecKey(String key){
        keyval = key.getBytes();
    }

    void setMessage(String mess){
        message = mess;
    }

    public String encrypt() throws Exception{
            Key key = generateKey();
            Cipher cph = Cipher.getInstance(ALGO);
            cph.init(Cipher.ENCRYPT_MODE,key);
            byte [] encMess = cph.doFinal(message.getBytes());
            message =  Base64.getEncoder().encodeToString(encMess);
            return message;
    }

    public String decrypt() throws Exception{
        Key key = generateKey();
        byte mess[] = Base64.getDecoder().decode(message);
        Cipher cph = Cipher.getInstance(ALGO);
        cph.init(Cipher.DECRYPT_MODE,key);
        byte [] decMess = cph.doFinal(mess);
        message = new String(decMess);
        return message;
    }

    public Key generateKey() {
        Key key = new SecretKeySpec(keyval, ALGO);
        return key;
    }


    public void getMessageUser(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your messsage:");
        String mess = scn.nextLine();
        setMessage(mess);
    }

    public void getSeckeyUser(){
        Scanner scn = new Scanner(System.in);
        while(true){
        System.out.println("Enter a 16 letter Secret key:");
        String mess = scn.nextLine();
        if(mess.length() != 16)
            System.out.println("The key does not contain 16 characters");
        else{
            setSecKey(mess);
            break;
        }
        }
    }

}
