
/*************************************
 * Brendan Shine 
 * Mr. Kiedes Period 2               *
 * 11-2-15             
 * Rational Class Program  II        *
 *                                   *
 ************************************/
import java.util.Scanner;

public class Runner {
	private static int num1, den1;   // numerator and denominator of the 1st rational number
	   private static int num2, den2;   // numerator and denominator of the 2nd rational number

	   public static void main (String[] args)
	   {
	      enterData();

	      Rational r1 = new Rational(num1,den1);
	      Rational r2 = new Rational(num2,den2);
	      Rational r3 = new Rational();

	      r3.multiply(r1,r2);
	      System.out.println("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getReduced());
	      r3.divide(r1,r2);
	      System.out.println("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getReduced());

	  //100 Point Version Only
	    r3.add(r1,r2);
	    System.out.println("\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getReduced());
	    r3.subtract(r1,r2);
	    System.out.println("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getReduced());
	      System.out.println();
	   }

	   
	   public static void enterData()
	   {
	      Scanner input = new Scanner(System.in);
	      System.out.print("\nEnter the 1st numerator ----> ");
	      num1 = input.nextInt();
	      System.out.print("\nEnter the 1st denominator --> ");
	      den1 = input.nextInt();
	      System.out.print("\nEnter the 2nd numerator ----> ");
	      num2 = input.nextInt();
	      System.out.print("\nEnter the 2nd denominator --> ");
	      den2 = input.nextInt();
	   }

}


class Rational
{
	
	//Class Attributes
	   private int firstNum;
	   private int firstDen;
	   private int reducedNum;
	   private int reducedDen;
	   private int gcf;
	   

	  //Default Constructor
	  public Rational(){
		  
	  }
   
	  
   //Overloaded Constructor
   public Rational(int n, int d)
   {
	   firstNum = n;
	   firstDen = d;
   }
   
   //Returns numerator
   private int getNum()
   {
	   return firstNum;
   }
   
   //Returns denominator
   private int getDen()
   {
	   return firstDen;
   }
   
   //Converts numerator and denominator to double and divides them
   private double getDecimal()
   {
	   return (double)getNum() / (double)getDen();
	   
   }
   
   //Multiplies two fractions
   public void multiply(Rational r1, Rational r2 ){
	   int largeNum = r1.getNum() * r2.getNum();
	   int largeDen = r1.getDen() * r2.getDen();
	   reduce(largeNum, largeDen);
	   getReduced();
	   
   }
   
   //Divides two fractions
   public void divide(Rational r1, Rational r2){
	   int largeNum = r1.getNum() * r2.getDen();
	   int largeDen = r1.getDen() * r2.getNum();
	   reduce(largeNum, largeDen);
	   getReduced();
   }
   
   //Adds two fractions
   public void add(Rational r1, Rational r2){
	   int combinedDen = r1.getDen()*r2.getDen();
	   int combinedNum = r1.getNum() * r2.getDen() + r2.getNum() * r1.getDen();
	   reduce(combinedNum,combinedDen);
	   getReduced();
   }
   
   //Subtracts two fractions
   public void subtract(Rational r1, Rational r2){
	   int combinedDen = r1.getDen()*r2.getDen();
	   int combinedNum = r1.getNum() * r2.getDen() - r2.getNum() * r1.getDen();
	   reduce(combinedNum,combinedDen);
	   getReduced();
   }
   
   
   //Gets Original String Representation of fraction
   public String getOriginal(){
	   return String.valueOf(firstNum) + "/" + String.valueOf(firstDen);
   }
   
   
   //First finds the gcf and then reduces num and den by gcf
   public String getReduced(){
	  return String.valueOf(reducedNum) + "/" + String.valueOf(reducedDen);
   }
   
   private void reduce(int Num, int Den){
	   getGCF(Num,Den);
	   reducedNum = Num / gcf;
	   reducedDen = Den / gcf;
	   
   }
   

   
   //Method to find gcf
  private void getGCF(int n1,int n2)
   {
      int rem = 0;
      do
      {
         rem = n1 % n2;
         if (rem == 0)
            gcf = n2;
         else
         {
            n1 = n2;
            n2 = rem;
        }
      }
      while (rem != 0);
   }
}

