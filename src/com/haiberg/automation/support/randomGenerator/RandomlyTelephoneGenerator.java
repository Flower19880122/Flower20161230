package com.haiberg.automation.support.randomGenerator;

import java.util.Random;

public class RandomlyTelephoneGenerator {
	
	public String GeneratorTelephoneRandomly(int length){
		String str="0123456789";
	    Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<length;++i){
	        int number=random.nextInt(10);
	        sb.append(str.charAt(number));
	      }
	      return sb.toString();
	  }
	    	

}
