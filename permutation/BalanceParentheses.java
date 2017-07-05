package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.*;

public class BalanceParentheses {

	public static void main(String[] args) {

		HashSet<String> uniqString = new HashSet<String>();
		HashMap<Integer, ArrayList<String>> toReturnMap = new HashMap<Integer, ArrayList<String>>();
	
		String test = "())((()a(b";
		int strLen = test.length();

		permute(test, 0, strLen, uniqString);
		int max = Integer.MIN_VALUE;
		
		ArrayList<String> strIterArr=new ArrayList <String>();
		strIterArr.add("");
		toReturnMap.put(max,strIterArr);
		
		int len = 0;
		String strIter;
		Iterator<String> itr = uniqString.iterator();

		while (itr.hasNext()) {
			strIter = itr.next();
			if (checkValid(strIter)) {
				len = strIter.length();
				if (toReturnMap.containsKey(len)) {
					strIterArr = toReturnMap.get(len);
					strIterArr.add(strIter);
					toReturnMap.put(len, strIterArr);
				} else {
					strIterArr = new ArrayList<String>();
					strIterArr.add(strIter);
					toReturnMap.put(len, strIterArr);
				}
				if(len>=max){
					max=len;
				}

			}

		}
		
		
			System.out.println(toReturnMap.get(max).toString());
		
		
	}

	/*
	 * ()() 
	 * 			start=0,i=0 )() 										..... 
	 * 		i=0 () 				i=1 )) 		   		i=2 )( 				....
	 *  i=0 ) 	i=1 ( 		i=0 ) 	i=1 )		i=0 ( 	i=1 ) 			....
	 * 
	 * 
	 */

	public static void permute(String s, int start, int stop, HashSet<String> uniqString) {

		if (start >= stop) {
			return;
		}
		char temp;
		for (int i = start; i < stop; i++) {
			uniqString.add(s);
			temp = s.charAt(i);
			s = deleteChar(s, i);
			permute(s, start, s.length(), uniqString);
			s = insertChar(s, i, temp);
		}
	}

	public static String deleteChar(String str, int index) {

		StringBuilder toReturn = new StringBuilder(str);
		toReturn.deleteCharAt(index);
		return toReturn.toString();
	}

	public static String insertChar(String str, int index, char c) {
		StringBuilder toReturn = new StringBuilder(str);
		toReturn.insert(index, c);
		return toReturn.toString();
	}

	public static boolean checkValid(String toCheck) {
		/**
		 * Test cases () (( ()() ((())) ()( ))
		 */

		Stack<Character> stk = new Stack<Character>();
		char temp;
		for (int i = 0; i < toCheck.length(); i++) {
			temp = toCheck.charAt(i);
			if (temp == '(') {
				stk.push(temp);
			} else if (temp == ')') {
				if (!stk.empty()) {
					stk.pop();
				} else {
					return false;
				}
			}
		}

		if (stk.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
