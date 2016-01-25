package pathFinder;

import java.util.ArrayList;

/** Programming Challenge: Maze Route Finder
 * @author anikaitsingh
 */

public class MazeFinder {
	
	private static ArrayList<Coordinate> path = new ArrayList<Coordinate>(); //has the list of coordinates one must follow
	//finds the beginning and ending point
	public static Coordinate[] findStartAndFinish(char[][] arr, char start, char finish){
		Coordinate Start = null, Finish = null, a[];
		for(int i = 0; i< arr.length; i++){
			for(int j = 0; j< arr[0].length; j++){
				if(arr[i][j] == start){
					Start = new Coordinate(i,j);
				}
				if(arr[i][j] == finish){
					Finish = new Coordinate(i,j);
				}
			}
		}
		a = new Coordinate[2];
		a[0] = Start;
		a[1] = Finish;
		return a;
	}
	
	
	//is called by coordinator
	public static ArrayList<Coordinate> findPath(char[][] arr){
		Coordinate[] beg = findStartAndFinish(arr, 'O', 'X');
		return initFind(arr, beg[0].getX(), beg[0].getY(), beg[1].getX(), beg[1].getY());
	}
	
	
	//initializes the find and finishes it up
	public static ArrayList<Coordinate> initFind(char[][] arr,int x1, int y1, int x2, int y2){
		findASolution(arr, x1,y1,x2,y2);
		return path;
	}
	
	
	//finds a possible path
	public static boolean findASolution(char[][] arr, int x1, int y1, int x2, int y2){
		if(arr[x1][y1] == '|'){
			return false;
		}
		
		if(arr[x1][y1] != 'O'){
			arr[x1][y1] = '1';
		}
		
		path.add(new Coordinate(x1,y1));
		
		if(x1+1 < arr.length){
			if (arr[x1+1][y1] == 'P'){
				if(findASolution(arr, x1 + 1, y1, x2, y2)){
					return true;
				}
			}
			if(arr[x1+1][y1] == 'X'){
				path.add(new Coordinate(y1,x1+1));
				return true;
			}
		}
		if(y1+1 < arr[0].length){
			if (arr[x1][y1+1] == 'P'){
				if(findASolution(arr, x1, y1+1, x2, y2)){
					return true;
			}
			}
			if(arr[x1][y1+1] == 'X'){
				path.add(new Coordinate(y1+1,x1));
				return true;
			}
		}
		if(x1-1 >= 0){
			if (arr[x1-1][y1] == 'P'){
				if(findASolution(arr, x1 - 1, y1, x2, y2)){
					return true;
				}
			}
			if(arr[x1-1][y1] == 'X'){
				path.add(new Coordinate(y1, x1-1));
				return true;
			}
		}
		if(y1-1 >= 0){
			if (arr[x1][y1-1] != 'O'){
				if(findASolution(arr, x1, y1-1, x2, y2)){
					return true;
			}
			}
			if(arr[x1][y1-1] == 'X'){
				path.add(new Coordinate(y1-1,x1));
				return true;
			}
		}
		return false;
	}
}


/*
 * internal class which stores an x and a y value and is used to pass that efficiently
 */
class Coordinate{
	private int x, y;	
	
	public Coordinate(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	
	public void setX(int _x){
		x = _x;
	}
	
	
	public void setY(int _y){
		y = _y;
	}
	
	
	public double getDistance(Coordinate c){
		return (Math.sqrt( Math.pow((x - c.getX()),2) + Math.pow((y - c.getY()),2) ));
	}
	
	
	public int getX(){
		return x;
	}
	
	
	public int getY(){
		return y;
	}
}

