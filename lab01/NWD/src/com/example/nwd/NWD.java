package com.example.nwd;

public class NWD {
	public  int NWD_calc(int pierwsza, int druga)
	    {
			if(pierwsza <= 0){
				throw new IllegalArgumentException();
			}
			else if (druga == 0) 
	        {
	            return pierwsza;  
	        }
	        else 
	        {  
	            return NWD_calc(druga, pierwsza%druga);
	        }
	    }
}
