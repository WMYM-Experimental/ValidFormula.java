package com.company.homework_stack;

import java.util.Stack;

/**
 *
 * @author Washington Yandun @WashingtonYandun
 */

// implementing my stack (from stack.util.Stack) for good programming practice
public class MyStack {
    private Stack stk;

    public MyStack() {
        stk = new Stack();
    }
    
    public boolean isEmpty(){
        return stk.empty();
    }
    
    public void push(char dato){
        stk.push(dato);
    }
    
    public char pop(){
        return (char)stk.pop();
    }
    
    public char peek(){
        return (char)stk.peek();
    }
    
    public int size(){
        return stk.size();
    }
}
