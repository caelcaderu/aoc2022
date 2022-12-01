package aoc1_CalorieCounting;
import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		//first();
		second();
	}	
	
	public static void first() {
		System.out.println("Here we go again!");
				
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String line = in.readLine();
			int maxsofar = 0;
			int working = 0;
			while(line != null) {
				if(line.equals("")) {
					if (working>maxsofar) {
						maxsofar = working;
					}
					working = 0;
				} else {
					working += Integer.parseInt(line);
				}
				line = in.readLine();
			}
			in.close();
			System.out.println(maxsofar);
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
