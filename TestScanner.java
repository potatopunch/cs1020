import java.util.*;

class TestScanner {

	private static Scanner gsc = new Scanner(System.in);
	private static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main (String args[]) {
		// process query
		while(gsc.hasNext()){
			processQuery(gsc.nextLine());
		}
	}
	
	public static void printOutput(String o){
		Scanner sc = new Scanner(o);
		while(sc.hasNext()){
			System.out.print(sc.next() + " ");
		}
	}

	public static void processQuery(String q){
		Scanner sc = new Scanner(q);
		switch(sc.next().toLowerCase()){
			case "add":
				printOutput("[A]\n");
				add(sc.nextLine(), queue);	
				System.out.println(queue);
				break;
			case "remove":
				printOutput("[R]\n");
				break;
			default:
				printOutput("Def\n");
		}
	}

	public static void add(String q, Queue<Integer> queue){
		Scanner sc = new Scanner(q);
		while(sc.hasNext()){
			queue.offer(sc.nextInt());
			// printOutput(sc.nextInt() + "");
		}
	}

	public static Queue<Integer> remove(int min, int max, Queue<Integer> queue){
		//do while queue is not empty
			//if queue peek is min, do not pop and add until
			//if queue is max
	}
}
