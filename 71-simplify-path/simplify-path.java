class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();

        String[] parts = path.split("/");

        for(String part: parts){
            if(part.isEmpty()){
                //ignore
                continue;
            }
            if(part.equals(".")){
                //ignore
                continue;
            }
            if(part.equals("..")){ 
            if(!st.isEmpty()){
                st.pop();
            }
            }
            else{
                //file name
                st.push(part);
            }
        }
        if(st.isEmpty()){
            //iska mtlb mai root directory par hu
            return "/";
        }
        else{
            //agar stack empty nhi h to answer ko build kro using atring builder
            StringBuilder str =  new StringBuilder();

            while(!st.isEmpty()){
                str.append("/");
                str.append(st.removeLast());
            }
            return str.toString();
        }
    }
}