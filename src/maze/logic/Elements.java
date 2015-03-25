package maze.logic;

import java.util.Random;

public class Elements {
	
	protected int cl;
	protected int lh;
	protected char representation;
	
	
	
	public Elements(int x, int y, char r) {
		// TODO Auto-generated constructor stub
		cl=x;
		lh=y;
		representation=r;
	}
	public Elements(){
		
	}
	
	public void SetPosicaoX(int x){
		cl=x;
	}
	
	public void SetPosicaoY(int y){
		lh=y;
	}
	
	public int GetPosicaoX(){
		return cl;
	}
	
	public int GetPosicaoY(){
		return lh;
	}
	
}