package debugging;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MikeRD
 */
public class Nonsense implements Serializable{
    ImportantNonsense[] in = new ImportantNonsense[5000];
    public static void main(String[] args){
       Nonsense n = Nonsense.load();
       System.out.println("Woohoo!!!");
       
    }

    public static String generateString(Random rng, String characters, int length)
{
    char[] text = new char[length];
    for (int i = 0; i < length; i++)
    {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
}
    
    private void createStuff() {
Random r = new Random();
for (int i=0;i<5000;i++){
in[i] = new ImportantNonsense();
in[i].nonsenseName = generateString(r,"asdfghkqwertyizxcvbnmlpo",10);
in[i].nonsenseNumber = r.nextInt(500);
}
    }

    private void save() {
        try{
FileOutputStream fos = new FileOutputStream("myobject.data");
ObjectOutputStream oos = new ObjectOutputStream (fos);
oos.writeObject(this);
        }catch (IOException e){
            System.out.println("oh year" + e);
        }
    }

    private static Nonsense load() {
try{
        FileInputStream fos = new FileInputStream("myobject.data");
ObjectInputStream is = new ObjectInputStream (fos);
       Nonsense o = (Nonsense)(is.readObject());
       return o;
        }catch (IOException e){
            System.out.println("oh year" + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nonsense.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
    }
}
