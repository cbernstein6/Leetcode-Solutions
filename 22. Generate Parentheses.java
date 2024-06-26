class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        backtrack(list,str,n,n);
        return list;
        // backtrack with list,openings left which is n, closings in total which should end up being 0

        // define vars and backtrack with list,current stringbuilder, openings,closings
    }
    public void backtrack(List<String> list, StringBuilder str, int open, int close){
        // if open and close are 0, return
        // open--, add ( to str, backtrack
        // open++, remove last char from str

        // if open < close
        // close--, add ) to str, backtrack
        // close++, remove last char from str

        if(open == 0 && close == 0){
            list.add(str.toString());
            return;
        }
        if(open != 0){
            open--;
            str.append('(');
            backtrack(list,str,open,close);
            open++;
            str.deleteCharAt(str.length()-1);
        }
        if(open < close){
            close--;
            str.append(')');
            backtrack(list,str,open,close);
            close++;
            str.deleteCharAt(str.length()-1);
        }
    }
}