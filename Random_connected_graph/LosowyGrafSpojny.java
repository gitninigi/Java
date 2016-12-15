import java.util.*;
import java.util.ArrayList;
import java.util.List;
public class LosowyGrafSpojny{
	private int matrix[][];
	private int vertex;
	private int edge;
	public LosowyGrafSpojny(int _vertex, int _edge)//1. creates empty graph
	{
		vertex=_vertex;
		edge=_edge;
		matrix = new int[vertex][vertex];
	}
	
	public void generujSpojny()
	{
		Random rnd = new Random();//creating generator
		List<Integer> listT = new ArrayList<Integer>();
		List<Integer> listF = new ArrayList<Integer>();
		
		listT.add(new Integer(0));
		
		for(int i=1;i<vertex;i++)
		{
			listF.add(new Integer(i)); //adding initial state
		}
		while(listF.size() > 0)
		{
			//1. finding random index between 0 and listT -1
			//2. connecting vertex of listF[0] with the random verex by edge and matrix
			//3. deleting position of listF[0] and passing to lisT
			int index = rnd.nextInt(listT.size()); //looking for random vertex with true
			matrix[listF.get(0)][listT.get(index)] = 1;
			matrix[listT.get(index)][listF.get(0)] = 1;
			listT.add(new Integer(listF.get(0)));
			listF.remove(0);
		}
		

		double prob = 1.0/(double)vertex; //variable for probability
		int edgesToDo = edge - (vertex-1);
		while(edgesToDo > 0)
		{
			for(int i=0;i<vertex;i++)
			{
				for(int j=i+1;j<vertex;j++)
				{
					if(matrix[i][j] == 0 && rnd.nextDouble() < prob && edgesToDo > 0)
					{
						matrix[i][j] = 1;
						matrix[j][i] = 1;
						edgesToDo--;
					}
				}
			}
		}
		
		for(int i=0;i<vertex;i++)
		{
			for(int j=0;j<vertex;j++)
			{
				System.out.print(matrix[i][j]);
			}
			
				System.out.println();
		}
		System.out.println();
		
	
	}
	
	public void randomizuj(int ileIteracji)
	{
		Random rnd = new Random();//creates generator
		double prob = 1.0/(double)vertex; //variable for probability
		for(int it=0;it<ileIteracji;it++)
		{
			int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
			
			
			loop: while(true){
			
			for(int i=0;i<vertex;i++)
			
			{
				for(int j=i+1;j<vertex;j++)
				{
					if(matrix[i][j] == 1 && rnd.nextDouble() < prob)
					{
						i1 = i;
						j1 = j;
						break loop;
					}
				}
			}
			}
			loop: while(true)
			{
			for(int i=0;i<vertex;i++)
			{
				for(int j=i+1;j<vertex;j++)
				{
					if(i==j1 || j == i1) continue;
					if(matrix[i][j] == 1 && rnd.nextDouble() < prob)
					{
						i2 = i;
						j2 = j;
						break loop;
					}
				}
			}
			}
			matrix[i1][j1] = 0;
			matrix[i2][j2] = 0;
			matrix[j1][i1] = 0;
			matrix[j2][i2] = 0;
			
			
			matrix[i1][j2] = 1;
			matrix[j2][i1] = 1;
			matrix[i2][j1] = 1;
			matrix[j1][i2] = 1;
		}
		
		for(int i=0;i<vertex;i++)
		{
			for(int j=0;j<vertex;j++)
			{
				System.out.print(matrix[i][j]);
			}
			
				System.out.println();
		}
		System.out.println();
		
	}
	
	public void randomizujWagi() //randomise weights
	{
		Random rnd = new Random();//creates generator
		for(int i=0;i<vertex;i++)
		{
			for(int j=i+1;j<vertex;j++)
			{
				if(matrix[i][j] == 1)
				{
					int temp = rnd.nextInt(9) + 1;
					matrix[i][j] = temp;
					matrix[j][i] = temp;
				}
			}
		}
		
		for(int i=0;i<vertex;i++)
		{
			for(int j=0;j<vertex;j++)
			{
				System.out.print(matrix[i][j]);
			}
			
				System.out.println();
		}
		System.out.println();
	}

}
