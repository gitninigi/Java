import java.util.*;

public class Pair{
	    private int first;
	    private int second;

	    public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	    }

	    public void setFirst(int first) {
		this.first = first;
	    }

	    public void setSecond(int second) {
		this.second = second;
	    }

	    public int getFirst() {
		return first;
	    }

	    public int getSecond() {
		return second;
	    }

	    public void set(int first, int second) {
		setFirst(first);
		setSecond(second);
	    }
	    
	    
}
	
class PairComparator implements Comparator<Pair> //-1 1. arg < 2, 0 takie same, 1 2arg<1arg.
{
	public int compare(Pair p1, Pair p2)
	{
		if(p1.getSecond() > p2.getSecond())
		{
			return -1;
		}
		else if(p1.getSecond() < p2.getSecond())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
		
	 
	}
}
