//Name:Ajit Pandey
//USC NetID:ajitpand
//CSCI 455 Fall 2019
//Lab 5

import java.util.ArrayList;
import java.util.Scanner;

public class ReadTester {

    public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           
           System.out.println("Enter size of list of number: ");   
           
           int size = in.nextInt();      
       
           System.out.println("Enter a space separated list of "+size+" numbers: ");
            
           ArrayList<String> numUser = new ArrayList<String>();
       
           for(int i=0; i<size; i++){
            	numUser.add(in.next());
            }
          
           ArrayList<Integer> list = new ArrayList<Integer>();
      
           for (int i=0; i<size; i++){
            	int number = Integer.parseInt(numUser.get(i));
            	list.add(number);
           }
           System.out.println("The numbers were: "+list);
        }
   }
