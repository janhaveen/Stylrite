package com.general.number;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Number {
	public static void main(String[] args) {
	  long startTime = System.nanoTime();
	  long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
	  BigDecimal bgInput = new BigDecimal(100000000.55).setScale(2,BigDecimal.ROUND_HALF_UP); 
	  int x = 0;
	  String n=Integer.toString(bgInput.intValue());
	 // String n1=bgInput.toString().replace(n+".","");	
	  String formated = "";
	  for(int i = n.length()-1;i>=0;i--)
	  {
		   if(x%2==0 && i!=0 && x!=0)
		   {
			   formated = "," + n.charAt(i) +formated;
		   }
		   else
		   {
			   formated = n.charAt(i) + formated;
		   }
	   x++;
	  }
	  if(formated.equals(""))
	  {
		  formated = n+"."+bgInput.toString().replace(n+".","");
	  }
	  else
	  {
		  formated += "."+bgInput.toString().replace(n+".","");
	  }
	  System.out.println(formated);
	  long endTime = System.nanoTime();
	  long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
	  long actualMemUsed=afterUsedMem-beforeUsedMem;

	  System.out.println("Took "+(endTime - startTime) + " ns"); 
	  System.out.println("Took "+actualMemUsed + " memory"); 
	}
}
