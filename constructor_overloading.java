import java.util.Scanner;
import java.util.Arrays;


class MyStack {
    private int[] arr;
    private int top;
    private int capacity;

  
    public MyStack() {
        this.capacity = 5;
        this.arr = new int[capacity];
        this.top = -1;
    }


    public MyStack(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.top = -1;
    }


    public MyStack(MyStack other) {
        this.capacity = other.capacity;
        this.top = other.top;
        this.arr = new int[this.capacity];
        System.arraycopy(other.arr, 0, this.arr, 0, other.top + 1);
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
        } else {
            arr[++top] = x;
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
        } else {
            System.out.println("Popped: " + arr[top--]);
        }
    }

    public void show() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public void search(int x) {
        for (int i = 0; i <= top; i++) {
            if (arr[i] == x) {
                System.out.println("Found at index: " + i);
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void sort() {
        if (top > 0) {
            Arrays.sort(arr, 0, top + 1);
            System.out.println("Stack sorted.");
        } else if (top == 0) {
            System.out.println("Only one element; already sorted.");
        } else {
            System.out.println("Stack empty; nothing to sort.");
        }
    }
}

public class stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size for Parameterized Constructor: ");
        

        MyStack s1 = new MyStack(sc.nextInt());
        int choice;

        do {
            System.out.println("\n1.Push 2.Pop 3.Show 4.Search 5.Sort 6.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: 
                    System.out.print("Enter value to push: "); 
                    s1.push(sc.nextInt()); 
                    break;
                case 2: 
                    s1.pop(); 
                    break;
                case 3: 
                    s1.show(); 
                    break;
                case 4: 
                    System.out.print("Enter value to search: "); 
                    s1.search(sc.nextInt()); 
                    break;
                case 5: 
                    s1.sort(); 
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
        sc.close();
    }
}

