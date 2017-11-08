import java.util.*;

public class Customs {

    Stack<Integer> queueStack = new Stack<Integer>();
    Stack<Integer> maxStack = new Stack<Integer>();
    static int counter = 0;
    Scanner sc = new Scanner(System.in);

    private void run() {
        int query = sc.nextInt();
        for(int i=0;i<query;i++){
            handleQuery(sc.next());
        }
    }

    private void handleQuery(String str){
        switch(str){
            case"join":
                join(sc.nextInt());
            break;
            case"leave":
                leave(sc.nextInt());
            break;
            case"p":
                p();
            break;
            default:
            System.out.println("invalid input");
            break;
        }
    }

    private void p(){
        System.out.print("queueStack :");
        for(int i : queueStack){
            System.out.print(" " +i);
        }
        System.out.print("\nmaxStack :");
        for(int i : maxStack){
            System.out.print(" " +i);
        }System.out.println();
    }

    // pre 
    // post
    private void join(int i){
        // w/o line 49 
        Integer height = new Integer(i);
        if(queueStack.empty()){
            queueStack.push(height);
        }else{
            queueStack.push(height);
        }
        if(maxStack.empty()){    
            maxStack.push(height);
            counter++;
        }
        // can see [+1] if joining person is taller than the person in
        // front of him
        //queueStack.push(height);

        // track only the tallest height and push into maxStack
        if(height > maxStack.peek()){
            maxStack.push(height);
            counter++;
        }
        System.out.println(counter);
    }

    // pre
    // post
    private void leave(int people){
        for(int i=0;i<people;i++){
            if(maxStack.peek()==(queueStack.pop())){
                maxStack.pop();
                counter--;
            }
        }
        //  System.out.println(maxStack.peek()+" == "+queueStack.pop());
        System.out.println(counter);

    }


    public static void main(String[] args) {
        Customs newCustoms = new Customs();
        newCustoms.run();
    }

}
