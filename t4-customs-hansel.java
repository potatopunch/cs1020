import java.util.*;

public class Customs {

	Stack<Integer> st = new Stack<Integer>();
	static int numCanSee = 0;

	private void run() {

		Scanner sc = new Scanner(System.in);
		int query = sc.nextInt();
		while(query > 0){
			query(sc);
			query--;
		}
	}

	private void query(Scanner sc){

		String command = sc.next();

		switch(command.toLowerCase()){
			case "join":
				join(sc);
				break;
			case "leave":
				leave(sc);
				break;
			default:
				break;
		}
	}

	// parameters: height
	private void join(Scanner sc){
		int height = sc.nextInt();
		int topHeight = 0;
		if(!st.isEmpty())
			topHeight = (int)st.peek();
		if(topHeight >= height)
			st.push(topHeight);
		else {
			st.push(height);
			numCanSee++;
		}
		System.out.println(numCanSee);
	}

	private void leave(Scanner sc){
		int numLeave = sc.nextInt();
		int currentHeight = 0;
		int topHeight = 0;
		while(numLeave > 0){
			currentHeight = (int)st.pop();
			if(!st.isEmpty())
				topHeight = (int)st.peek();
			else
				topHeight = 0;
			if(currentHeight != topHeight)
				numCanSee--;
			numLeave--;
		}
		System.out.println(numCanSee);
	}

	public static void main(String[] args) {
		Customs newCustoms = new Customs();
		newCustoms.run();
	}

}
