package pathFinder;

import java.io.*;
import java.util.ArrayList;

public class Coordinator {
	
	public static void main(String[] args){		
		// instantiation and initialization
		String inputStr;
		ArrayList<String> arrL = new ArrayList<String>();
		char[][] arr = null;
		String file = "maze.txt";

		// input maze.txt as lines of strings
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((inputStr = reader.readLine())!=null){
				arrL.add(inputStr);
			}
			reader.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//arraylist of strings to 2D array of chars
		if(arrL != null){
			arr = new char[arrL.size()][arrL.get(0).length()];
			for(int i = 0; i< arrL.size(); i++){
				inputStr = arrL.get(i); //reuse of string
				for(int j = 0; j< arrL.get(0).length(); j++){
					arr[i][j] = inputStr.charAt(j);
				}
			}
		}
		
		print2DCharArray(arr);
		//maze finding algorithm
		printCoordinateArray(MazeFinder.findPath(arr));
	}
	
	
	//prints a 2 dimensional character array
	public static void print2DCharArray(char[][] arr){
		System.out.print("[");
		for(int i = 0; i < arr.length; i++){
			System.out.print("[ ");
			for(int j = 0; j < arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("]");
		}
		System.out.println("]\n");
	}
	
	
	//prints a single dimensional Coordinate array
	public static void printCoordinateArray(ArrayList<Coordinate> arr){
		Coordinate coord;
		for(int i = 0; i < arr.size(); i++){
			coord = arr.get(i);
			System.out.println("(" + coord.getX() + "," + coord.getY() + ")");
		}
	}
}
