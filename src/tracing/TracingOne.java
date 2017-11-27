package tracing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MikeRD
 */
public class TracingOne {
    public static void main(String[] args){
        String[] array = {"Roy-DiClemente", "Mr. Thompson", "Dalai Lama", "John Cena", "Rick Astley", "Beegees", "Flying Spaghetti Monster", "Eminem", "Michael Jackson", "007", "Dolphins", "Hari Seldon"}; 
        isRDCool(array);
    }
    
    public static int isRDCool(String[] stuff){
        int i=stuff.length-1;
        while(!stuff[i].equals("Roy-DiClemente")){
            System.out.println(stuff[i]);
            i = i / 3;
        }
        return i;
    }
}
