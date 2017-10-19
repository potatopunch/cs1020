import java.util.*;

public class Customs {

	private static Stack<Integer> stackOfPeople = null;
	private static int canSee = 0;
	private static int tallestPrevPerson = 0; //tallest person before the new person comes in

	private void run() {
		Scanner sc = new Scanner(System.in);
		int numOfQueries = sc.nextInt();
		stackOfPeople = new Stack<Integer>();
		//process queries
		while(sc.hasNext()){
			String queryType = sc.next();
			int queryDetails = sc.nextInt();
			if(queryType.equals("join")){
				//pass height into join method
				join(queryDetails);
			}else if(queryType.equals("leave")){
				//pass in number of people leaving
				leave(queryDetails);
			}
		}
	}

	//person of height joins queue
	private void join(int height){
		//add typecasted height into queue LL
		stackOfPeople.push((Integer) height);
		int newPerson = stackOfPeople.indexOf((Integer) height);
		//if first person or new person is tallest, set person as new tallest person so far
		if((newPerson == 0) || stackOfPeople.get(newPerson) > tallestPrevPerson){
			tallestPrevPerson = (Integer) stackOfPeople.get(newPerson);
			canSee++;
		}
		System.out.println(canSee);
	}

	private void leave(int peopleLeave){

	}

	public static void main(String[] args) {
		Customs newCustoms = new Customs();
		newCustoms.run();
	}

}
