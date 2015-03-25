package maze.logic;

import java.util.Random;
import java.util.Scanner;

public class Heroi extends Elements{
	public static boolean estouArmado=false;
	
	public Heroi(int x, int y,char r){
		super(x,y,r);
	}
	

	public Heroi() {
		// TODO Auto-generated constructor stub
	}


	public static boolean getestouArmado(){
		return estouArmado;
	}

	public static boolean setestouArmado(){
		estouArmado = true;
		return estouArmado;
	}
	
}
