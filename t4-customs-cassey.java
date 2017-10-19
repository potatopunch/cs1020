import java.util.*;

public class Customs {
    
    private static Stack<Integer> stackOfPeople = null;
    private static int canSee = 0;
    private static int tallestPerson = 0; //tallest person before the new person comes in
    
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
        setTallestPerson(stackOfPeople.lastIndexOf(height), tallestPerson);
        System.out.println(canSee);
    }
    
    //peopleToLeave leaves queue
    private void leave(int peopleToLeave){
        //reset canSee and tallestPerson values
        canSee = 0;
        tallestPerson = 0;
        //remove people from queue
        while(peopleToLeave != 0){
            peopleToLeave--;
            stackOfPeople.pop();
        }
        //if stackOfPeople is not empty
        if(!stackOfPeople.empty()){
            for(int i = 0, prevPerson = 0; i < stackOfPeople.size(); i++){
                //set tallest and people who can see
                setTallestPerson(i, prevPerson);
                //set previous person's height for checking next round
                prevPerson = stackOfPeople.get(i);
            }
        }
        System.out.println(canSee);
    }
    
    //set tallestPerson and who can see customs officer
    public void setTallestPerson(int currPersonIndex, int personToCheck){
        int currPerson = stackOfPeople.get(currPersonIndex);
        //if first person in queue or current person is taller than previous person
        //and current person is taller than tallest person in the queue
        if((currPersonIndex == 0) || ((currPerson > personToCheck && currPerson > tallestPerson))){
            tallestPerson = currPerson;
            canSee++;
        }
    }
    
    public static void main(String[] args) {
        Customs newCustoms = new Customs();
        newCustoms.run();
    }
    
}
