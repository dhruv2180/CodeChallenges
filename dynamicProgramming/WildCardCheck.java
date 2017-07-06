public class WildCardCheck {
    public boolean isMatch(String s, String p) {

        if(p.length()>1){
             StringBuilder strBldr=new StringBuilder();
             char last=p.charAt(0);
             strBldr.append(last);
             char curr;
            for(int i=1;i<p.length();i++){
                 System.out.println(strBldr.toString());
                curr=p.charAt(i);
                if(curr!='*'){
                    strBldr.append(curr);
                    last=curr;
                }else if(curr=='*'){
                    if(last!=curr){
                        strBldr.append(curr);
                         last=curr;
                    }else if(last==curr){
                         last=curr;
                        continue;
                    }
                }
            }
            p=strBldr.toString();
        }

        System.out.println(p);
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        //empty string matches empty patter
        dp[0][0]=true;

        if (p.length() > 0 && p.charAt(0) == '*') {
            dp[0][1] = true;
        }

        char sChar;
        char pChar;


        for(int i=0;i<s.length();i++){
            sChar=s.charAt(i);
            for(int j=0;j<p.length();j++){
                pChar=p.charAt(j);
                if(sChar==pChar || pChar=='?'){
                    //character match exactly
                    dp[i+1][j+1]=dp[i][j];
                }else if(pChar=='*' ){

                    dp[i+1][j+1]=dp[i][j+1]|dp[i+1][j];
                }else{
                     dp[i+1][j+1]=false;
                }

            }

        }
       return dp[s.length()][p.length()];
    }


}
