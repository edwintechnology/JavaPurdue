public class Distance 
{ // Compliments to WikiPedia
	private static int Minimum(int a, int b, int c)
	{
		int mi;
		
		mi = a;
		if (b < mi)
		{
			mi = b;
		}
		if (c < mi)
		{
			mi = c;
		}
		return mi;
	}
	public static int LD(String s, String t) 
	{
		int ld[][];
		int n = s.length();
		int m = t.length();
		int i;
		int j;
		char s_i;
		char t_j;
		int cost;
		
		if (n == 0) 
		{
			return m;
		}
		if (m == 0) 
		{
			return n;
		}
		ld = new int[n+1][m+1];
		
		for (i = 0; i <= n; i++) 
		{
			ld[i][0] = i;
		}

		for (j = 0; j <= m; j++) 
		{
			ld[0][j] = j;
		}
		for (i = 1; i <= n; i++) 
		{
			s_i = s.charAt(i - 1);
			for (j = 1; j <= m; j++) 
			{
				t_j = t.charAt(j - 1);
				if (s_i == t_j) 
				{
					cost = 0;
				}
				else 
				{
					cost = 1;
				}
				ld[i][j] = Minimum(ld[i-1][j]+1, ld[i][j-1]+1, ld[i-1][j-1] + cost);
			}
		}
		return ld[n][m];
	}

}