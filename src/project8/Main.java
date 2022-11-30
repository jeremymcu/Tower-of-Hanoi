package project8;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    void hanoi(int num, Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3){
        if (num%2==0){
            if (stack1.peek()<stack2.peek())
                stack2.push(stack1.pop());
            else
                stack1.push(stack2.pop());

            if (stack1.peek()<stack3.peek())
                stack3.push(stack1.pop());
            else
                stack1.push(stack3.pop());

            if (stack2.peek()<stack3.peek())
                stack3.push(stack2.pop());
            else
                stack2.push(stack3.pop());
        }
        else {
            if (stack1.peek()<stack3.peek())
                stack3.push(stack1.pop());
            else
                stack1.push(stack3.pop());

            if (stack1.peek()<stack2.peek())
                stack2.push(stack1.pop());
            else
                stack1.push(stack2.pop());

            if (stack2.peek()<stack3.peek())
                stack3.push(stack2.pop());
            else
                stack2.push(stack3.pop());
        }

        System.out.println("Stack 1:\t\tStack 2:\t\tStack 3:");
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        Stack<Integer> temp3 = new Stack<>();
        for (int i=0; i<num; i+=1){
            temp1.push(stack1.pop());
            temp2.push(stack2.pop());
            temp3.push(stack3.pop());
            System.out.println(temp1.peek() + "\t" + temp2.peek() + "\t" + temp3.peek());
        }
        for (int i=0; i<num; i+=1){

            stack1.push(temp1.pop());
            stack2.push(temp2.pop());
            stack3.push(temp3.pop());


        }

        if (stack3.size() != num)
            hanoi(num, stack1, stack2, stack3);
    }

    public static void main(String[] args) {
        int num;
        Stack<Integer> stack1= new Stack<>();
        Stack<Integer> stack2= new Stack<>();
        Stack<Integer> stack3= new Stack<>();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        num = scan.nextInt();

        for (int i=0; i<num; i++){
            stack1.push(num-i);
        }

        Main towerOf = new Main();
        towerOf.hanoi(num, stack1, stack2, stack3);

    }
}
