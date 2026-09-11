class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            //find part inside string s
            int index = s.indexOf(part);
            
            //ek nayi substring bnao by adding left and right part of found substring inside string s
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }
}