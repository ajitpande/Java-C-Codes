//Name:Ajit Pandey
//USC NetID:ajitpand
//CSCI 455 Fall 2019
//Lab 3
/**
   A cash register totals up sales and computes change due.

   Version for CS 455 lab 3.  Modified from version from Big Java, 6th
   ed.

   Changes [made by CMB]:

     * This version of the class is called CashReg (instead of CashRegister)
     * Added getTotal() accessor function.
     *  Made constants private.

   Ex:
   CashReg register = new CashReg();
   register.recordPurchase(0.59);  // ring something up
   register.recordPurchase(1.99);  // ring up another item
   register.recordPurchase(5.0);   // ring up a third item
   double tot = register.getTotal();    // total of purchases so far: 7.58
   register.receivePayment(10,0,0,0,0);  // customer pays with a 10
   int change = register.giveChange();  // compute change owed: 2.42
                                        // and zeroes out register

   register.recordPurchase(1.0);  // now we start ringing up someone else . . .

*/
public class CashReg
{
   private static final double QUARTER_VALUE = 0.25;
   private static final double DIME_VALUE = 0.1;
   private static final double NICKEL_VALUE = 0.05;
   private static final double PENNY_VALUE = 0.01;

   private double purchase ;
   private double payment ;
   private int intPurchase;
   private int intPayment;
  
   /**
      Constructs a cash register with no money in it.
   */
   public CashReg()
   {
      intPurchase = 0;
      intPayment = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
      
   {
      double test =  (amount*100);
      //System.out.println("Test " +test);
      intPurchase = (int)(Math.round(intPurchase + (amount*100)));
      //System.out.println("Test1 " +intPurchase);
   }
   
   /**
      Gets total of all purchases made.
   */
    public double getTotal() {
       double total = intPurchase/100.0;
       return total;
    }; 

   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void receivePayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
      intPayment = (int)((dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
            + nickels * NICKEL_VALUE + pennies * PENNY_VALUE)*100.0);
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      int change = intPayment - intPurchase;
      double dollar_value = (change/100.0);
      intPurchase = 0;
      intPayment = 0;
      return dollar_value;
   }
}
