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

	public void NovaPosicaoDragao() {

		while (true) {

			Labirinto.lab[GetPosicaoY()][GetPosicaoX()] = ' ';
			Random ale = new Random();
			int vari = ale.nextInt(5) + 1;

			if (vari == 1) {
				if (Labirinto.lab[GetPosicaoY()][GetPosicaoX() + 1] != 'X'
						&& Labirinto.lab[GetPosicaoX()][GetPosicaoY() + 1] != 'S'
						&& Labirinto.lab[GetPosicaoX()][GetPosicaoY() + 1] != Labirinto.lab[Labirinto.h.GetPosicaoX()][Labirinto.h.GetPosicaoY()]) {
					if (Labirinto.lab[GetPosicaoX()][GetPosicaoY() + 1] == 'E') {
						Labirinto.lab[GetPosicaoX()][GetPosicaoY() + 1] = 'F';
						SetPosicaoY(GetPosicaoY()+1);
					} else {
						if (Labirinto.lab[GetPosicaoX()][GetPosicaoY()] == 'F') {
							Labirinto.lab[GetPosicaoX()][GetPosicaoY()] = 'E';
							Labirinto.lab[GetPosicaoX()][GetPosicaoY() + 1] = 'D';
							SetPosicaoY(GetPosicaoY()+1);
						} else {
							Labirinto.lab[GetPosicaoX()][GetPosicaoY() + 1] = 'D';
							SetPosicaoY(GetPosicaoY()+1);
						}
					}
					break;
				}
			} else {

				if (vari == 2) {
					if (Labirinto.lab[GetPosicaoX()+1][GetPosicaoY()] != 'X'
							&& Labirinto.lab[GetPosicaoX()+1][GetPosicaoY()] != 'S'
							&& Labirinto.lab[GetPosicaoX()+1][GetPosicaoY()] != Labirinto.lab[Labirinto.h.GetPosicaoX()][Labirinto.h.GetPosicaoY()]) {
						if (Labirinto.lab[GetPosicaoX()+1][GetPosicaoY()] == 'E') {
							Labirinto.lab[GetPosicaoX()+1][GetPosicaoY()] = 'F';
							SetPosicaoX(GetPosicaoX()+1);
						} else {
							if (Labirinto.lab[GetPosicaoX()][GetPosicaoY()] == 'F') {
								Labirinto.lab[GetPosicaoX()][GetPosicaoY()] = 'E';
								Labirinto.lab[GetPosicaoX()+1][GetPosicaoY()] = 'D';
								SetPosicaoX(GetPosicaoX()+1);
							} else {
								Labirinto.lab[GetPosicaoX()+1][GetPosicaoY()] = 'D';
								SetPosicaoX(GetPosicaoX()+1);
							}
						}
						break;
					}

				} else {
					if (vari == 3) {
						if (Labirinto.lab[GetPosicaoX()][GetPosicaoX() - 1] != 'X'
								&& Labirinto.lab[GetPosicaoX()][GetPosicaoX() - 1] != 'S'
								&& Labirinto.lab[GetPosicaoX()][GetPosicaoX() - 1] != Labirinto.lab[Labirinto.h.GetPosicaoX()][Labirinto.h.GetPosicaoY()]) {
							if (Labirinto.lab[GetPosicaoX()][GetPosicaoX() - 1] == 'E') {
								Labirinto.lab[GetPosicaoX()][GetPosicaoX() - 1] = 'F';
								SetPosicaoY(GetPosicaoY()-1);
							} else {
								if (Labirinto.lab[GetPosicaoX()][GetPosicaoY()] == 'F') {
									Labirinto.lab[GetPosicaoX()][GetPosicaoY()] = 'E';
									Labirinto.lab[GetPosicaoX()][GetPosicaoX() - 1] = 'D';
									SetPosicaoY(GetPosicaoY()-1);
								} else {
									Labirinto.lab[GetPosicaoX()][GetPosicaoX() - 1] = 'D';
									SetPosicaoY(GetPosicaoY()-1);
								}
							}
							break;
						}

					} else {
						if (vari == 4) {
							if (Labirinto.lab[GetPosicaoX()-1][GetPosicaoY()] != 'X'
									&& Labirinto.lab[GetPosicaoX()-1][GetPosicaoY()] != 'S'
									&& Labirinto.lab[GetPosicaoX()-1][GetPosicaoY()] != Labirinto.lab[Labirinto.h.GetPosicaoX()][Labirinto.h.GetPosicaoY()]) {
								if (Labirinto.lab[GetPosicaoX()-1][GetPosicaoY()] == 'E') {
									Labirinto.lab[GetPosicaoX()-1][GetPosicaoY()] = 'F';
									SetPosicaoX(GetPosicaoX()-1);
								} else {
									if (Labirinto.lab[GetPosicaoX()][GetPosicaoY()] == 'F') {
										Labirinto.lab[GetPosicaoX()][GetPosicaoY()] = 'E';
										Labirinto.lab[GetPosicaoX()-1][GetPosicaoY()] = 'D';
										SetPosicaoX(GetPosicaoX()-1);
									} else {
										Labirinto.lab[GetPosicaoX()-1][GetPosicaoY()] = 'D';
										SetPosicaoX(GetPosicaoX()-1);
									}
								}
								break;
							}
						} else {
							Labirinto.lab[GetPosicaoX()][GetPosicaoY()] = 'D';
							break;
						}
					}
				}
			}
		}
	}
	//estado 0 : dragao a dormir


	public void insereDragoes(int estrategia_dragoes, int numero_dragoes) {
		
	}
}
