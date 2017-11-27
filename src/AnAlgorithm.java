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
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.util.Test;
import hsa.*;
import hsa.Console;
import java.io.*;           //used for any type of input or output
import java.util.*;         //useful utilities like Scanner

/**
 *
 * @author MikeRD
 */
public class AnAlgorithm extends Object{





   private double unitCost;            // unit cost
   private double volumeSold = 0.0; // volume sold
   private int octane;              // octane rating
   private String label;               // marketing label
      
   /** Construct a new Meter object.
   *  @param unitCost The cost for one unit (liter or gallon) of gas 
   *  @param octaneRating An integer related to the "performance" of the fuel;  usually 
   *           between 87 and 93.
   *  @param theLabel A label for the fuel such as "Gold" or "Ultra". */
   public AnAlgorithm (double unitCost, int octaneRating, 
                     String theLabel)
   {  super();
      this.unitCost = unitCost;
      this.octane = octaneRating;
      this.label = theLabel;
   }  
      
   /** Get the cost per unit of fuel.
   *  @return cost per unit of fuel */
   public double getUnitCost()
   {  return this.unitCost;
   }
   
   /** Get the octane rating of the fuel.
   *  @return octane rating (typically between 87 and 93) */
   public int getOctane()
   {  return this.octane;
   }
   
   /** Get the label for this meter's fuel.  For example, "Gold" or "Ultra".
   *  @return this meter's fuel label */
   public String getLabel()
   {  return this.label;
   }
   
   /** Pump some fuel into a tank.  This method is called
   *  repeatedly while the "handle" on the pump is pressed.
   *  @param howMuch How much fuel was pumped since the last time this 
   *           method was called. */
   public void pump(double howMuch)
   {  this.volumeSold = this.volumeSold + howMuch;
   }
   
   /** Get the volume of fuel sold to this customer.
   *  @return volume of fuel sold */
   public double getVolumeSold()
   {  return this.volumeSold;
   }  
   
   /** Calculate the total cost of fuel sold to this customer.
   *  @return price/unit * number of units sold */
   public double calcTotalCost()
   {  double tCost = this.unitCost * this.volumeSold;
      return tCost;
   }
      
   /** Reset the meter for a new customer. */
   public void reset()
   {  this.volumeSold = 0;
   }
      
   // Test the class.
   public static void main(String[] args)
   {  
       Robot r = new Robot(new City(4,3),3,3,Direction.NORTH);
       Test tester = new Test();
      AnAlgorithm m1 = new AnAlgorithm(1.109, 87, "Regular");
      tester.ckEquals("unit cost", 1.109, m1.getUnitCost());
      tester.ckEquals("octane", 87, m1.getOctane());
      tester.ckEquals("label", "Regular", m1.getLabel());

      AnAlgorithm m2 = new AnAlgorithm(1.149, 89, "Ultra");
      tester.ckEquals("unit cost", 1.149, m2.getUnitCost());
      tester.ckEquals("octane", 89, m2.getOctane());
      tester.ckEquals("label", "Ultra", m2.getLabel());
      
      tester.ckEquals("volSold", 0.0, m2.getVolumeSold());
      m2.pump(0.02);
      m2.pump(0.03);
      m2.pump(0.01);
      tester.ckEquals("volSold", 0.06, m2.getVolumeSold());
      tester.ckEquals("totCost", 0.06*1.149, m2.calcTotalCost());
      m2.reset();
      tester.ckEquals("after reset", 0.0, m2.getVolumeSold());
      tester.ckEquals("after reset", 0.0, m2.calcTotalCost());
   }

}
