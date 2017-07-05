
public class StringPermutations {

	public static void main(String[] args) {
		
		String test="abc";
		int stringLen=test.length();
		permute(0,stringLen,test);
		
	}
	
	public static void permute(int start,int stop,String result){
		
		/*Code Flow ex.len=3, string=abc 
		 * 
		 * 				(abc)start=0,i=0  								(bac)start=0,i=1    					(cab)start=0,i=2 
		 * 		(abc)start=1,i=1      (acb)start=1,i=2 			(bac)start=1,i=1      (bca)start=1,i=2 				...
		 * (abc)start=2,i=2 		 	(acb)start=2,i=2 	(bac)start=2,i=2 				(bca)start=2,i=2		...
		 * 															
		 * 
		 */
		if(start==stop){
			System.out.println(result);
		}
		for(int i=start;i<stop;i++){
			result=swap(result, start, i);
			permute(start+1, stop, result);
			result=swap(result, i, start);
		}
		
	}
	
	public static String swap(String s,int i,int j){
		//This method swaps the i,j index of a string 
		StringBuilder toReturn=new StringBuilder(s);
		if(i!=j){
			char tempChar=toReturn.charAt(i);
			toReturn.setCharAt(i, toReturn.charAt(j));
			toReturn.setCharAt(j, tempChar);
		}else{
			return s;
		}
		return toReturn.toString();
	}
}
