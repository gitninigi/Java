import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.*;

public class czyGraficzny{
	private static int _matrix[][];
	private static int _vertex;
	private static int _edge;
	
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
				map2[i] = new Pair(i,list.get(i));//addning key(first) i value(second)
			}
		List<Pair> mapList = Arrays.asList(map2); //convert array to list
		int matrix[][] = new int[list.size()][list.size()]; //creating matrix
		_matrix=new int[list.size()][list.size()]; //creating global matrix
		_vertex=list.size(); //saving number of vertexes
		for(int i =0;i<mapList.size();i++) //filling matrix with zeros
		{
			for(int j=0;j<mapList.size();j++)
				matrix[i][j] = 0;
		}
		
		for(int i=0;i<mapList.size();i++)
		{
			Collections.sort(mapList,new PairComparator()); 
			int temp = mapList.get(0).getSecond(); //saving value from first cell
			for(int j=0;j<temp;j++)
			{
				matrix[map2[0].getFirst()][map2[j+1].getFirst()] = 1;
				matrix[map2[j+1].getFirst()][map2[0].getFirst()] = 1;
				mapList.get(j+1).setSecond(mapList.get(j+1).getSecond()-1);
				mapList.get(0).setSecond(mapList.get(0).getSecond()-1);
			}
		}
		_matrix=matrix; //copying from local into deep
		//counting edges
		_edge=0;
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(matrix[i][j] == 1) _edge++;
			}
		}
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
				System.out.print(matrix[i][j]);
				System.out.println();
		}
		System.out.println();

		
	}}
	
	public static void randomizuj(int ileIteracji) 
	{
		Random rnd = new Random();//creating generator
		double prob = 1.0/(double)_vertex; //variable for probability
		for(int it=0;it<ileIteracji;it++)
		{
			int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
			List<Pair> listaPar = new ArrayList<Pair>();
			for(int i=0;i<_vertex;i++) //change of all edges in the graph 
			{
				for(int j=i+1;j<_vertex;j++)
				{
					if(_matrix[i][j] == 1)
					{
						listaPar.add(new Pair(i,j));
					}
				}
			}
			int Edges = listaPar.size();
			int il1=0, il2=0; //indexes in list
			while(il1==il2) //until we choose two the same edged it will keep drawing another pair
			{
				il1 = rnd.nextInt(Edges);
				il2 = rnd.nextInt(Edges);
			}
			
			//drawt two different edges
			i1 = listaPar.get(il1).getFirst();
			j1 = listaPar.get(il1).getSecond();
			i2 = listaPar.get(il2).getFirst();
			j2 = listaPar.get(il2).getSecond();
			
			//if which is not changing the edges if they lead to the same vertex lub if there is edge to which we wuld like to change
			if(j1!=i2 && i1!=j2 && _matrix[i2][j1]==0 && _matrix[i1][j2]==0)
			{
				_matrix[i1][j1] = 0;
				_matrix[j1][i1] = 0;
				_matrix[i2][j2] = 0;
				_matrix[j2][i2] = 0;
			
				_matrix[i2][j1] = 1;
				_matrix[j1][i2] = 1;
				_matrix[i1][j2] = 1;
				_matrix[j2][i1] = 1;
			}
			
		}
		
		
		for(int i=0;i<_vertex;i++)
		{
			for(int j=0;j<_vertex;j++)
			{
				System.out.print(_matrix[i][j]);
			}
			
				System.out.println();
		}
		System.out.println();
		
	}
	


}
