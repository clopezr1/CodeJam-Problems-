package TA;

import java.io.*;
import java.util.*;

public class Test {
	public static void main(String args[]) throws IOException {
		File input = new File("C:\\Users\\Carlos\\Desktop\\A-small-practice.in");
		File outPut = new File("C:\\Users\\Carlos\\Desktop\\laan.txt");

		FileReader in = new FileReader(input);
		FileWriter out = new FileWriter(outPut);
		BufferedReader buf = new BufferedReader(in);

		int numLines = Integer.parseInt(buf.readLine());
		List<String>[] lines = new List[numLines];
		int[] counts = new int[numLines];
		String str = null;

		for (int i = 0; i < numLines; i++) {
			lines[i] = new ArrayList<String>();
			lines[i].add(buf.readLine());
			str = lines[i].get(0);
			StringBuilder sb = new StringBuilder(str);

			while (sb.length() > 0) {

				int j = 0;
				int k = 1;
				while(k < sb.length()){
					if (sb.charAt(j) == sb.charAt(k)) {
						counts[i] += 10;
						sb.deleteCharAt(j);
						sb.deleteCharAt(j);
						j = 0;
						k = 1;
					}
					else{
						k++;
						j++;
					}
				}
				counts[i] += (sb.length() * 5) / 2;
				sb.delete(0, sb.length());
			}
			System.out.println(counts[i]);
		}
		
		for (int c = 1; c <= numLines; c++){
			
			out.write("Case #" + c + ": " + counts[c - 1] + "\n");
			out.flush();
			
		}
		
		in.close();
	}
}
