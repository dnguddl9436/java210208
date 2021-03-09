package com.java;

public class ArrayJumsu {

	public static void main(String[] args) {
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		int[][] score = {{50,60,75}
						,{60,70,90}
						,{80,60,70}
						,{90,90,90}
						,{80,80,80}};
		System.out.println("no\tkor\teng\tmath\ttotal\tavg");
		System.out.println("=========================================================");
		for(int i=0;i<score.length;i++) {
			int sum = 0;
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
			System.out.print(" "+(i+1));
			for(int j=0;j<score[i].length;j++) {
				System.out.print("\t"+score[i][j]);
				sum += score[i][j];
			}
			System.out.println("\t"+sum+"\t"+sum/(float)score[i].length);
		}
		System.out.println("=========================================================");
		System.out.println("총점:\t"+korTotal+"\t"+engTotal+"\t"+mathTotal);
	}
}
