class Solution {
    //3 scenarios, we get (, ), or none of them
    //if we get ({[, append to stack and continue
    //if we get )}], make sure that the val we get is the opposite
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(Character c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') stack.push(c);

            else{
                if(stack.isEmpty()) return false;

                Character pop = stack.pop();
                // System.out.println(pop);
                if(c == ')'){
                    if(pop != '(') return false;
                }
                if(c == ']'){
                    if(pop != '[') return false;
                }
                if(c == '}'){
                    if(pop != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}