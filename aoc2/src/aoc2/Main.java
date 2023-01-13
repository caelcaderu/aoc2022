package aoc2;
import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		first();
		//second();
	}	
	
	public static void first() {
		System.out.println("Here we go again!");
				
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String line = in.readLine();
			int score = 0;
			while(line != null) {
				String[] components = line.split(" ");
				//convert to numbers
				int myPlay = (int)components[1].charAt(0) - 87; //XYZ --> 1, 2, 3
				int otherPlay = (int)components[0].charAt(0) - 64; //ABC --> 1, 2, 3
				//Score for shape
				score += myPlay;
				System.out.print(myPlay + " + ");
				//Score for victory
				int diff = (3+ myPlay - otherPlay+1)%3;
				score += diff*3;
//				if(diff == 0) { score += 3; }
//				if(diff == 1) { score += 6; }
				System.out.print(diff*3);
				System.out.println(" : " + score);
				
				line = in.readLine();
			}
			in.close();
			System.out.println(score);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void second() {
				
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String line = in.readLine();
			int[] maxsofar = {0,0,0};
			int working = 0;
			while(line != null) {
				if(line.equals("")) {
					if (working>maxsofar[0]) {
						maxsofar[0] = working;
						Arrays.sort(maxsofar);
					}
					working = 0;
				} else {
					working += Integer.parseInt(line);
				}
				line = in.readLine();
			}
			if(working>0) {
				if (working>maxsofar[0]) {
					maxsofar[0] = working;
					Arrays.sort(maxsofar);
				}
				working = 0;
			}
			in.close();
			int sum = 0;
			for(int i:maxsofar) {
				System.out.println(i);
				sum += i;
			}
			System.out.println("Sum:"+sum);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
