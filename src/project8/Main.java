package project8;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int loop = 0;

    void print(int num, Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3){
        System.out.println("Stack 1:\tStack 2:\tStack 3:");
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        Stack<Integer> temp3 = new Stack<>();
        for (int i=0; i<num; i+=1){
            int now1 = 0, now2 = 0, now3 = 0;
            if (!stack1.isEmpty()) {
                temp1.push(stack1.pop());
                now1 = temp1.peek();
            }
            if (!stack2.isEmpty()) {
                temp2.push(stack2.pop());
                now2 = temp2.peek();
            }
            if (!stack3.isEmpty()) {
                temp3.push(stack3.pop());
                now3 = temp3.peek();
            }
            System.out.println(now1 + "\t\t\t" + now2 + "\t\t\t" + now3);
        }
        for (int i=0; i<num; i+=1){
            if (!temp1.isEmpty())
                stack1.push(temp1.pop());
            if (!temp2.isEmpty())
                stack2.push(temp2.pop());
            if (!temp3.isEmpty())
                stack3.push(temp3.pop());
        }
    }

    void hanoi(int num, Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3){
        System.out.println("Step number: " + ++loop);

        if (num%2==0){
            if (!stack1.isEmpty() && (stack2.isEmpty() || stack1.peek()<stack2.peek()))
                stack2.push(stack1.pop());
            else if (stack3.size() < num)
                stack1.push(stack2.pop());

            print(num, stack1, stack2, stack3);
            System.out.println("Step number: " + ++loop);

            if (!stack1.isEmpty() && (stack3.isEmpty() || stack1.peek()<stack3.peek()))
                stack3.push(stack1.pop());
            else if (stack3.size() < num)
                stack1.push(stack3.pop());
        }
        else {
            if (!stack1.isEmpty() && (stack3.isEmpty() || stack1.peek()<stack3.peek()))
                stack3.push(stack1.pop());
            else if (stack3.size() < num)
                stack1.push(stack3.pop());

            print(num, stack1, stack2, stack3);
            System.out.println("Step number: " + ++loop);

            if (!stack1.isEmpty() && (stack2.isEmpty() || stack1.peek()<stack2.peek()))
                stack2.push(stack1.pop());
            else if (stack3.size() < num)
                stack1.push(stack2.pop());
        }

        print(num, stack1, stack2, stack3);
        System.out.println("Step number: " + ++loop);
        if (!stack2.isEmpty() && (stack3.isEmpty() || stack2.peek()<stack3.peek()))
            stack3.push(stack2.pop());
        else if (stack3.size() < num)
            stack2.push(stack3.pop());
        print(num, stack1, stack2, stack3);

        if (stack3.size() < num)
            hanoi(num, stack1, stack2, stack3);
    }

    public static void main(String[] args) {
        int num;
        Stack<Integer> stack1= new Stack<>();
        Stack<Integer> stack2= new Stack<>();
        Stack<Integer> stack3= new Stack<>();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of disks: "); //Maximum number of disk is 12 due to stackoverflow on 13
        num = scan.nextInt();

        for (int i=0; i<num; i++){
            stack1.push(num-i);
        }

        Main towerOf = new Main();
        towerOf.hanoi(num, stack1, stack2, stack3);

    }
}
