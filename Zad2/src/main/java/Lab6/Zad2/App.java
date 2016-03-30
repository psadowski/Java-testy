package Lab6.Zad2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
	public static int Min(List<Integer> intArray){
		Collections.sort(intArray);
		int min = intArray.get(0);
		return min;
	}
	
	public static int Max(List<Integer> intArray){
		Collections.sort(intArray);
		int max = intArray.get(intArray.size() -1);
		return max;
	}

}
