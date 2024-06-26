class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0 ) return new ArrayList();

        Map<String,String> map = new HashMap<>();
        List<String> list = new ArrayList();

        map.put("2","abc"); map.put("3","def"); map.put("4","ghi"); map.put("5","jkl"); map.put("6","mno"); map.put("7","pqrs"); map.put("8","tuv"); map.put("9","wxyz");

        backtrack(list,map,digits,new StringBuilder(),0);

        return list;
    }

    public void backtrack(List<String> list, Map<String,String> map, String digits, StringBuilder curr, int start){
        // if curr.length() == digits.length() append curr.tostring to list and return
        // loop from 0 to map.get(digits.substring(start,start+1))
        // append current char to curr, 
        // backtrack to start+1
        // remove current char to continue loop

        if(curr.length() == digits.length()){
            list.add(curr.toString());
            return;
        }

        String loopString = map.get(digits.substring(start,start+1));
        // System.out.println(digits.substring(start,start+1));
        for(int i=0;i<loopString.length();i++){
            curr.append(loopString.substring(i,i+1));
            backtrack(list,map,digits,curr,start+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}