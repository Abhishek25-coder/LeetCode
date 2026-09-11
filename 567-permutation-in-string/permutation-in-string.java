class Solution {
    static boolean compareFreq(int[] count1, int[] count2){
        for(int i=0;i<26;i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        //make frequency table for s1
        int count1[] = new int[26];
        for(int i = 0;i<s1.length();i++){
        char ch = s1.charAt(i);
        int index = ch - 'a';
        count1[index]++;
        }
        //s2 ki window ko process kro
        int i = 0;
        int windowlength = s1.length();
        int count2[] = new int[26];
        //first window ka frequency table 
        for(i =0;i<windowlength;i++){
            char ch = s2.charAt(i);
            int index = ch-'a';
            count2[index]++;
        }
        if(compareFreq(count1,count2)==true){
            return true;
        }
        else{
            //both the frequency table are not matching
            //process remaining windows
            while(i<s2.length()){
                //new window par move kro
                char newchar = s2.charAt(i);
                int newindex = newchar-'a';
                count2[newindex]++;
                //old character ki entry ko table se remove kro
                int oldcharindex = i-windowlength;
                char oldchar = s2.charAt(oldcharindex);
                int freqtableindex = oldchar-'a';
                count2[freqtableindex]--;
                
                //isko compare ko s1 ke reference table ke sath
                if(compareFreq(count1,count2)==true)
                    return true;
                    i++;
            }
        }
        return false;
    }
}