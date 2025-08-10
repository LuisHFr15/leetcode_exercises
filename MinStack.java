// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

//     MinStack() initializes the stack object.
//     void push(int val) pushes the element val onto the stack.
//     void pop() removes the element on the top of the stack.
//     int top() gets the top element of the stack.
//     int getMin() retrieves the minimum element in the stack.

// You must implement a solution with O(1) time complexity for each function.

import java.util.*;
public class MinStack {
    private Stack<Integer> stack; // normal stack to manipulate data
    private Stack<Integer> minimumValues; // storing the minimum values until now
    // if you insert only highest values, it won't change and won't need any manipulation

    public MinStack() {
        this.stack = new Stack<>();
        this.minimumValues = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(this.minimumValues.isEmpty() || this.minimumValues.peek() >= val) {
            this.minimumValues.push(val); // insert on the minimum stack only if its equal or
            // less than the actual minimum, so you can save repeated occurrences and store
            // previous minimum values
        }
    }
    
    public void pop() {
        int valueToRemove = this.stack.pop();
        
        if(!this.minimumValues.isEmpty() && valueToRemove == this.minimumValues.peek()) {
            this.minimumValues.pop();
            // actually if you remove the minimum value, it will change the minimum stack
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minimumValues.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */