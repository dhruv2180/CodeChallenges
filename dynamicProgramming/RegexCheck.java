public class RegexCheck {
    public boolean isMatch(String s, String p) {
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];

        //empty string matches empty patter
        dp[0][0]=true;

        //special case, x*...
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*'){
                dp[0][i+1]=dp[0][i-1];
            }
        }

        char sChar;
        char pChar;
        boolean zeroOccur;
        boolean moreOccur;

        for(int i=0;i<s.length();i++){
            sChar=s.charAt(i);
            for(int j=0;j<p.length();j++){
                zeroOccur=false;
                moreOccur=false;
                pChar=p.charAt(j);
                if(sChar==pChar || pChar=='.'){
                    //character match exactly
                    dp[i+1][j+1]=dp[i][j];
                }else if(pChar=='*'){
                    //check for zero occurence
                    zeroOccur=dp[i+1][j-1];
                    //check for more than one occurence
                    if(sChar==p.charAt(j-1) || p.charAt(j-1)=='.'){
                        moreOccur=dp[i][j+1];
                    }
                    dp[i+1][j+1]=zeroOccur|moreOccur;
                }
                else if (sChar!=pChar || pChar!='.'){
                    dp[i+1][j+1]=false;
                }
                 //System.out.println((i+1)+" "+(j+1)+" "+dp[i+1][j+1]);
            }
        }
        return dp[s.length()][p.length()];
    }
}
