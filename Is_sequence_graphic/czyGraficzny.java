import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

public class czyGraficzny{

	public static boolean czyJest;
	//checks if sequence is graphic using Halv-Hakimi algorithm
	public static void sprawdz(List<Integer> list)
	{
		
		Collections.sort(list); 
		Collections.reverse(list); 
		
		for(int i=0;i<list.size();i++)
		{
			//if lists has negative value elements, sequence is not graphic
			if(list.get(i)<0) 
			{
				czyJest = false;
				System.out.println("Sequence is not graphic"); 
				return;
			}
		}
		
		//if sum of all elements is 0 - Sequence is graphic
		int sum = 0;
		for(int i=0;i<list.size();i++)
			sum += list.get(i);
		if(sum == 0) 
		{
			czyJest = true;
			System.out.println("Sequence is graphic"); 
			return;
		}
		
		
		int ile = list.get(0); //variable for stating from how may following elements of sequence operation '-1' is to be done
		if(ile>=list.size()) 
		{
			czyJest = false;
			System.out.println("Sequence is not graphic"); 
			return;
		}
		list.remove(0);
		for(int i=0;i<ile;i++)
		{
			list.set(i,list.get(i)-1);
		}
		
		System.out.println(list); 
		sprawdz(list);			
	}
	
	public static void stworzMacierz(List<Integer> list, List<List<Map<Integer,Integer>>> m)
	{if(czyJest==true){
		int size = list.size();
		Pair[] map2 = new Pair[list.size()]; //array of objects of class pair
		for(int i=0;i<list.size();i++)
			{
				map2[i] = new Pair(i,list.get(i));//adding key(first) i value(second)
			}
		List<Pair> mapList = Arrays.asList(map2); //convert array to list
		int matrix[][] = new int[list.size()][list.size()]; //creating matrix
		for(int i =0;i<mapList.size();i++) //filling matrix with zeros
		{
			for(int j=0;j<mapList.size();j++)
				matrix[i][j] = 0;
		}
		
		for(int i=0;i<mapList.size();i++)
		{
			Collections.sort(mapList,new PairComparator()); //list sorting
			int temp = mapList.get(0).getSecond(); //saves value from firs cell
			for(int j=0;j<temp;j++)
			{
				matrix[map2[0].getFirst()][map2[j+1].getFirst()] = 1;
				matrix[map2[j+1].getFirst()][map2[0].getFirst()] = 1;
				mapList.get(j+1).setSecond(mapList.get(j+1).getSecond()-1);
				mapList.get(0).setSecond(mapList.get(0).getSecond()-1);
			}
			
			
			
		}
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
				System.out.print(matrix[i][j]);
				System.out.println();
		}
	}}
	


}
