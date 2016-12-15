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
	{	
		LosowyGrafSpojny LGS = new LosowyGrafSpojny(Integer.parseInt(args[0]),Integer.parseInt(args[1]));//1.vertex, 2.edges
		LGS.generujSpojny();
		LGS.randomizuj(4);
		LGS.randomizujWagi();
}
}
        
