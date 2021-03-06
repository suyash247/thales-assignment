package com.main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearchMain {
	static int count=0;
	int result;
	public static void main(String[] args){
		char[][] wordGrid = createWordGrid("resources/wordSearch.csv");
		
		 Scanner myObj = new Scanner(System.in); 
		 String input="yes"; 
		 String toSearch=""; 
		 while(input.equals("yes")) {
		 System.out.println("Enter word to search"); 
		 toSearch=myObj.nextLine();
		 countWordToSearchInGrid(wordGrid,toSearch.toCharArray());
		 System.out.println(toSearch + " is found " + count + " times in the grid");
		 count=0; 
		 System.out.println("Do you want to Continue?");
		 input=myObj.nextLine();
		 }
		 
	}
	
	private static void countWordToSearchInGrid(char[][] wordGrid, char[] toSearch) {
		for (int i = 0; i < wordGrid.length; i++) {
			for (int j = 0; j < wordGrid[i].length; j++) {
				searchRight(wordGrid,i,j,toSearch);
				searchLeft(wordGrid,i,j,toSearch);
				searchTop(wordGrid,i,j,toSearch);
				searchBottom(wordGrid,i,j,toSearch);
				searchTopRight(wordGrid,i,j,toSearch);
				searchTopLeft(wordGrid,i,j,toSearch);
				searchBottomRight(wordGrid,i,j,toSearch);
				searchBottomLeft(wordGrid,i,j,toSearch);
				}
			}
	}

	private static void searchBottomLeft(char[][] wordGrid, int i, int j, char[] charArray) {
		boolean flag=false;
		for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
				i=i+1;
				j=j-1;
				if(!(k!=charArray.length-1 && i<=(wordGrid.length-1) && j>=0 && j<=(wordGrid[i].length-1))) {
					flag=false;
					break;
				}
			}
		if(flag==true) {
			count++;
			System.out.println("1");
		}
	}

	private static void searchBottomRight(char[][] wordGrid, int i, int j, char[] charArray) {
		boolean flag=false;
		for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
				i=i+1;
				j=j+1;
				if(!(k!=charArray.length-1 && i<=(wordGrid.length-1) && j<=(wordGrid[i].length-1))) {
					flag=false;
					break;
				}
			}
		if(flag==true) {
			count++;
			System.out.println("2");
		}
	}

	private static void searchTopLeft(char[][] wordGrid, int i, int j, char[] charArray) {

		boolean flag=false;
		for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
				i=i-1;
				j=j-1;
				if(!(i>=0 && j>=0 && j<=(wordGrid[i].length-1)) && k!=(charArray.length-1)) {
					flag=false;
					break;
				}
			}
		if(flag==true) {
			count++;
			System.out.println("3");
		}
		
	}

	private static void searchTopRight(char[][] wordGrid, int i, int j, char[] charArray) {
		boolean flag=false;
		for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
				i=i-1;
				j=j+1;
				if(!(i>=0 && j<=(wordGrid[i].length-1)) & k!=(charArray.length-1)) {
					flag=false;
					break;
				}
			}
		if(flag==true) {
			count++;
			System.out.println("4");
		}
	}

	private static void searchBottom(char[][] wordGrid, int i, int j, char[] charArray) {
		boolean flag=false;
		for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
				i=i+1;
				if(!(i<wordGrid.length && j<wordGrid[i].length) && (k!=charArray.length-1)) {
					flag=false;
					break;
				}
			}
		if(flag==true) {
			count++;
			System.out.println("5");
		}
	}

	private static void searchTop(char[][] wordGrid, int i, int j, char[] charArray) {
		boolean flag=false;
		for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
				i=i-1;
				if(!(i>=0 && j<=(wordGrid[i].length-1)) & k!=(charArray.length-1)) {
					flag=false;
					break;
				}
			}
		if(flag==true) {
			count++;
			System.out.println("6");
		}
	}

	private static void searchLeft(char[][] wordGrid, int i, int j, char[] charArray) {
		boolean flag=false;
		if((j+1)<=wordGrid[i].length && (j+1)>=charArray.length) {
			for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j--])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
			}
		}
		if(flag==true) {
			count++;
			System.out.println("7");
		}
	}
	
	private static void searchRight(char[][] wordGrid, int i, int j, char[] charArray) {
		boolean flag=false;
		if(wordGrid[i].length-j>=charArray.length) {
			for (int k = 0; k < charArray.length; k++) {
				if(Character.toLowerCase(charArray[k]) == Character.toLowerCase(wordGrid[i][j++])) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
			}
		}
		if(flag==true) {
			count++;
			System.out.println("8");
		}
	}
	
	private static char[][] createWordGrid(String input){
		ArrayList<char[]> rows=new ArrayList<char[]>();
		String line="";
		try {
			BufferedReader br=new BufferedReader(new FileReader(input));
			try {
				while ((line=br.readLine()) != null) {
					String[] rowStringArray= line.split(",");
					char[] row=new char[rowStringArray.length];
					for (int i = 0; i < row.length; i++) {
						row[i]=rowStringArray[i].charAt(0);
					}
					rows.add(row);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		char[][] wordGrid=new char[rows.size()][];
		for (int i=0;i<rows.size();i++) {
			wordGrid[i]=rows.get(i);
		}
		return wordGrid;
	}

}