/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errors;

import java.util.Scanner;

/**
 *
 * @author MikeRD
 */
public class Similies {
  public static void main(String[] args){
      /*This program simulates the game 'deal or no deal'.  You have hidden suitcases with dollar amounts.
      A number 'n' of them have been revealed.  The average of the remaining is the line between deal or no deal.
              
      There are 2 syntax, 1 runtime, and 1 logic error in the code
      */
    int[] a = {100,500,1000,5000,10000,25000,50000,100000,500000,1000000};  //dollar value of suitcases
    
Scanner s = new Scanner(System.in);
// get how many suitcases have been revealed
int n = s.nextLine();

//get the position of revealed suitcases from 1 - n and set value to zero
for (int i =0;i<=n;i++){
    int x = s.nextInt();
    a[i] = 0;
}
//add the value of everything remaining
int sum = 0;
for (int i=0;i<=n;i++){
    sum += a[i];
}
//calculate the average... this is 
int average = sum / n;

System.out.println("Deal is the amount is over",  average);
}
}
