package debugging;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Author: MikeRD Class: ICS3U
 *
 * Program: Assignment X Question Y Input: (explain what is being input into the
 * program) Processing: (explain what is being done) Output: (Result of the
 * program)
 *
 */
//Import Statements Listed Alphabetically
import java.io.*;           //used for any type of input or output
import java.util.*;         //useful utilities like Scanner
import hsa.Console;
// CCC 2007
// S5: Bowling for Numbers



import hsa.*;

public class CCC2007S5
{
    static Console c;

    public static void main (String[] args)
    {
	int numberPins, numberBalls, width, s;
	int[] pin;
	int[] sum;
	int[] [] dp;

	c = new Console ();
	TextInputFile f = new TextInputFile ("s5.4.in");

	int tests = f.readInt ();
	for (int t = 0 ; t < tests ; t++)
	{

	    // get input
	    numberPins = f.readInt ();
	    numberBalls = f.readInt ();
	    width = f.readInt ();
	    pin = new int [numberPins];
	    for (int i = 0 ; i < numberPins ; i++){
		int in = f.readInt();
                pin [i] = in;
            }


	    // load sum:
	    // sum[i] = sum of "width" pins, starting at i
	    sum = new int [numberPins];
	    s = 0;
	    for (int i = 0 ; i < width ; i++){
                System.out.println(s);
		s += pin [i];
            }
	    sum [0] = s;
	    for (int i = 1 ; i < numberPins - width + 1 ; i++)
	    {
		s = s - pin [i - 1] + pin [i + width - 1];
		sum [i] = s;
	    }
	    for (int i = numberPins - width + 1 ; i < numberPins ; i++)
	    {
		s = s - pin [i - 1];
		sum [i] = s;
	    }

	    // intialize dp
	    dp = new int [numberBalls + 1] [numberPins];
	    for (int j = 1 ; j < numberPins ; j++)
		dp [0] [j] = 0;
	    for (int i = 1 ; i <= numberBalls ; i++)
		for (int j = 1 ; j < numberPins ; j++)
		    dp [i] [j] = -1;

	    // fill dp, working right to left and down
	    for (int ball = 1 ; ball <= numberBalls ; ball++)
		for (int i = numberPins - 1 ; i >= 0 ; i--)
		{
		    if (i >= numberPins - width)
			dp [ball] [i] = sum [i];
		    else
			dp [ball] [i] = Math.max (dp [ball - 1] [i + width] + sum [i],
				dp [ball] [i + 1]);
		}
	    c.println (dp [numberBalls] [0]);
	}
    }
}
