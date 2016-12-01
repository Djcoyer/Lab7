/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author CoyerDevynJoseph
 */
public class Lab7Part1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int max = 50;
        
        double[][] numbers = new double[max][max];
        String[][] names = new String[max][max];
        Scanner inventory;
        int idIndex = 1;
        int aisleIndex = 2;
        int costIndex = 3;
        int quantityIndex = 4;
        int categoryIndex = 1;
        int subCategoryIndex = 2;
        int nameIndex = 3;
        boolean valid;
        
        
        try{
           File firstFile = new File("Inventory.txt");
           inventory = new Scanner(firstFile);
        }catch(FileNotFoundException fnf)
        {
            inventory = new Scanner(System.in);
            
        }
        
        
        int index = 0;
        while(inventory.hasNext())
        {
            valid = true;
            if(inventory.hasNextInt())
        {
            numbers[index][idIndex] = inventory.nextInt();
        }  
          else{
              valid=false;
          }
          if(inventory.hasNextInt() && valid)
          {
              numbers[index][aisleIndex] = inventory.nextInt();
          }
          else
          {
              valid=false;
          }
          if(inventory.hasNext() && valid)
          {
              names[index][categoryIndex] = inventory.next();
          }
          else
          {
              valid=false;
          }
          if(inventory.hasNext() && valid)
          {
              names[index][subCategoryIndex] = inventory.next();
          }
          else
          {
              valid=false;
          }
          if(inventory.hasNextDouble() && valid)
          {
              numbers[index][costIndex] = inventory.nextDouble();
          }
          else
          {
              valid=false;
          }
          
          if(inventory.hasNextDouble() && valid)
          {
              numbers[index][quantityIndex] = inventory.nextDouble();
          }
          else
          {
              valid=false;
          }
          if(inventory.hasNext() && valid)
          {
              names[index][nameIndex] = inventory.nextLine();
          }
          else
          {
              valid=false;
          }
         if(!valid)
          {
              numbers[index][costIndex] = 0;
              inventory.nextLine();
          }                
            index++;
          
        }
        
        System.out.printf("%-16s %-17s %-17s %-17s %-15s %-11s %s", "ID", "Category", "Subcategory", "Aisle", "Quantity", "Cost", "Name");
        System.out.println();
        
       for(int i = 0; i < names.length; i++)
        {
            if(numbers[i][costIndex] > 0)
            {
                System.out.printf("%-16.0f %-17s %-17s %-17.0f %-15.0f %-10.2f %-17s", numbers[i][idIndex], 
                   names[i][categoryIndex], names[i][subCategoryIndex], numbers[i][aisleIndex], numbers[i][quantityIndex], numbers[i][costIndex] ,names[i][nameIndex]);
                System.out.println();
            }
           
            /*for(index = 0; index < names.length; index++)
            if(numbers[i][costIndex] > 0)
            {
                System.out.println(i);
                System.out.println(names[i][nameIndex] + " - " + names[i][categoryIndex] + " - " + names[i][subCategoryIndex]);

                System.out.println(numbers[i][costIndex]);
                System.out.println(numbers[i][quantityIndex]);
                System.out.println(numbers[i][costIndex]);
                System.out.println(numbers[i][aisleIndex]);
                
            }
*/
        }
        
    }
    
   
    
}
