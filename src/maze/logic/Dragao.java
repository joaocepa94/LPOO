package maze.logic;
import java.util.Random;


public class Dragao extends Elements{
	protected int DragonState;
	public Dragao(int X, int Y, char R, int Ds){
		super(X,Y,R);
		DragonState=Ds;
	}
	
	public Dragao() {
		// TODO Auto-generated constructor stub
	}

	public void alteraEstadoDragao(){
		if(DragonState==0)
			DragonState=1;
		else DragonState=1;
	}

	public void insereDragoes(int estrategia_dragoes, int numero_dragoes) {
		
	}
	
}
