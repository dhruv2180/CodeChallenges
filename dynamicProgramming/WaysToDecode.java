public class WaysToDecode {

	public static void main(String[] args) {

		//Test Cases
		System.out.println(numWaysToDecodings("112"));
		System.out.println(numWaysToDecodings("1223422445633222"));
		System.out.println(numWaysToDecodings("100"));
		System.out.println(numWaysToDecodings("120"));
		System.out.println(numWaysToDecodings("102"));
		System.out.println(numWaysToDecodings("112234"));
		
	}

	public static int numWaysToDecodings(String s) {
		if (s.equals("")) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];

		dp[0] = 1;
		if ('0' - s.charAt(0) != 0) {
			dp[1] = 1;
		} else {
			dp[0] = 0;
			dp[1] = 0;
		}
		String temp;
		int tempVal;
		for (int i = 1; i < s.length(); i++) {

			temp = s.substring(i - 1, i + 1);
			tempVal = Integer.valueOf(temp);

			if (s.charAt(i) != '0') {
				if (tempVal > 9 && tempVal < 27) {
					dp[i + 1] = dp[i] + dp[i - 1];
				} else {
					dp[i + 1] = dp[i];
				}
			} else if (s.charAt(i) == '0') {
				if (tempVal == 0 || tempVal > 20) {
					dp[i + 1] = 0;
				} else if (tempVal < 27) {
					dp[i + 1] = dp[i - 1];
				}
			}
		}
		return dp[s.length()];
	}
}
