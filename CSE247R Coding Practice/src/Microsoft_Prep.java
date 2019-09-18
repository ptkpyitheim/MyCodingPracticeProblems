
public class Microsoft_Prep {
	
	public static void reverseOnlyAlphabets(String s) {
		char[] c = s.toCharArray();
		
		int pt1 = 0;
		int pt2 = s.length() - 1;
		
		while(pt1 != pt2 && pt1 < pt2) {
			if(c[pt1] == '-') {
				pt1++;
				continue;
			}
			if(c[pt2] == '-') {
				pt2--;
				continue;
			}
		
			char tmp = c[pt1];
			c[pt1] = c[pt2];
			c[pt2] = tmp;
			
			pt1++;
			pt2--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(char a : c) {
			sb.append(a);
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		String test = "abcd-EF-ga";
		reverseOnlyAlphabets(test);

	}

}
