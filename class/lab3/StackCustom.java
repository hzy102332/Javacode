package lab3;

public class StackCustom {
	int size;
    int arr[];
    int top;
 
    //Create a stack
    public StackCustom(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }
 
    public void push(int pushedElement) {
        if (!isFull()) {
            top++;
            arr[top] = pushedElement;
            System.out.println("Push element:" + arr[top]);
        } else {
        	System.out.println("Push element:" + pushedElement+" failure");
            System.out.println("Stack is full");
        }
    }
 
    public int pop() {
        if (!isEmpty()) {
            int returnTop = top;
            top--;
            System.out.println("Popped element: " + arr[returnTop]);
            return arr[returnTop];
        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }
 
    //check the stack is empty or not, if not empty, return the first element
    public int peek() {
        if (!this.isEmpty()) {
            return arr[top];
        }else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }
 
    //Check the stack is empty or not, return boolean
    public boolean isEmpty() {
        return (top == -1);
    }
 
    public boolean isFull() {
        return (size - 1 == top);
    }
 
 
    public static void main(String[] args) {
        
        StackCustom stackCustom = new StackCustom(3);
        stackCustom.pop();
        System.out.println("=====================");
        stackCustom.push(10);
        stackCustom.push(30);
        stackCustom.push(50);
        stackCustom.push(40);	
        System.out.println("=====================");
        stackCustom.pop();
        stackCustom.pop();
        stackCustom.pop();
        System.out.println("=====================");
    }
}
