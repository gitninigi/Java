import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Random;
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
 
public class Testowa{

	public static void main (String[] args)
	{	//checks if sequence is graphic
		System.out.println("Please put number of elements in sequence.");
		Scanner scan = new Scanner(System.in);
		int ileLiczb = scan.nextInt();
		int tab[] = new int[ileLiczb];
		System.out.println("Please input sequence");		
		List<Integer> numbers = new ArrayList<Integer>(); //creating list in which the sequence is saved
		for(int i=0;i<ileLiczb;i++){
		    numbers.add(scan.nextInt());
		}
		
		//deep copy for stworzMacierz function
		List<Integer> numbersCopy = new ArrayList<Integer>();
		numbersCopy.addAll(numbers);
		System.out.println("numberscopy:"+numbersCopy);
		
		List<List<Map<Integer,Integer>>> matrix = new ArrayList<List<Map<Integer,Integer>>>();
		
		czyGraficzny.sprawdz(numbers);
		czyGraficzny.stworzMacierz(numbersCopy,matrix);
		
		System.out.println("Please put number of changes in randomise().");
		int ileIteracji = scan.nextInt();
		czyGraficzny.randomizuj(ileIteracji);
	    
}
}
        
