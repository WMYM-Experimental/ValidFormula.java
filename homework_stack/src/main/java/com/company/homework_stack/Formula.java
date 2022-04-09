package com.company.homework_stack;

/**
 *
 * @author Washington Yandun @WashingtonYandun
 */
public class Formula {
    
    // A formula must have text and its evaluator
    String txt;
    MyStack eval;

    public Formula(String txt) {
        this.txt = txt;
        this.eval = new MyStack();
    }
    
    // method that count how many openers and closers are
    // 'openers' = '{[('
    // 'closers' = '}])'
    // return an array: 0 index for openers and 1 for closers
    public int[] count(){
        int openers = 0;
        int closers = 0;
        
        int[] numOf = {openers, closers};
        // 'openers' = '{[('
        // 'closers' = '}])'
        
        for (int i = 0; i < txt.length(); i++) {            
            // we have to compare each char
            char currentChar = txt.charAt(i);

            // start with 'openers'
            if ((currentChar == '{') ||
                (currentChar == '(') ||
                (currentChar == '[')) {
                openers++;
            }     
            
            if ((currentChar == '}') ||
                (currentChar == ')') ||
                (currentChar == ']')) {
                closers++;
            }
        }
        
        numOf[0] = openers;
        numOf[1] = closers;
        
        return numOf;
    }
    
    // method that evaluate the formula given using a stack
    // returns the state (if is empty or not) of the evaluator
    // could be refactored in the future 
    public boolean evaluateFormula() {        
        // variable to compare to current
        char match;

        // 'openers' = '{[('
        // 'closers' = '}])'
        for (int i = 0; i < txt.length(); i++) {            
            // we have to compare each char
            char currentChar = txt.charAt(i);

            // start with 'openers'
            if ((currentChar == '{') ||
                (currentChar == '(') ||
                (currentChar == '[')) {
                eval.push(currentChar);
            } else {
                // for not comparing chars that are not the ones we want to compare
                if ((currentChar == '}') ||
                    (currentChar == ')') ||
                    (currentChar == ']')){
                
                    if (eval.isEmpty()) {
                        // prevent error "pop in empty stack"
                        return false;
                    }

                    // compare to last one in the stack with peek()
                    // 'closers' must match 'openers' like this
                    // valid matches = '(' && ')'  -  '[' && ']'  -  '{' && '}'
                    
                    match = eval.peek();

                    // this prevents take something like this '{]' as valid
                    if ((currentChar == '}' && match == '{') ||
                        (currentChar == ')' && match == '(') ||
                        (currentChar == ']' && match == '[')) {
                        eval.pop();
                    }
                }
            }
        }
        return eval.isEmpty();
    }
}
