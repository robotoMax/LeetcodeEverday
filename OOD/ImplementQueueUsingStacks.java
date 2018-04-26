/**
 * 
 * Date: 04/08/2018
 * Created By: Shuai Liu
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * Notes:
 * 1. You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is 
 * empty operations are valid.
 * 2. Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque 
 * (double-ended queue), as long as you use only standard operations of a stack.
 * 3. You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 */
import java.util.*;
public class ImplementQueueUsingStacks {}

// Using 1 stack
class MyQueue {

    Stack<Integer> stack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.size() == 0) {
            stack.push(x);
            return;
        }
        else {
            int data = stack.peek();
            stack.pop();
            push(x);
            stack.push(data);
            return;
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

// using 2 stacks
class MyQueue2 {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue2() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}