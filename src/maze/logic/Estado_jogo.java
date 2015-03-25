package maze.logic;

import java.util.Random;
import java.util.Scanner;

public class Estado_jogo extends Labirinto{
	public static char modo_jogo;


	public static void main(String[] args) {


		System.out.println("==Jogo do Labirinto==");
		System.out.println("Pretende o Labirinto aleatorio(a) ou predefenido(p)?");


		Scanner sc = new Scanner(System.in);
		try {
			modo_jogo = sc.findInLine(".").charAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(modo_jogo=='p'){
			LabirintoPred();
			ma(10);
			return;
		}


		Scanner sc3 = new Scanner(System.in);
		int numero_dragoes;
		System.out.println("Quantos dragões pretende ?");
		numero_dragoes = sc3.nextInt();

		Scanner sc4 = new Scanner(System.in);
		int estrategia_dragoes;
		System.out.println("Que estratégia pretende ?");
		System.out.println("1 - Dragão(ões) parado(s) ");
		System.out.println("2 - Dragão(ões) com movimentação aleatória ");
		System.out.println("3 -  Dragão(ões) com movimentação aleatória intercalada com dormir");
		estrategia_dragoes = sc4.nextInt();

		System.out.println("Insira a dimensao do labirinto (impar): ");
		Scanner sc2 = new Scanner(System.in);
		int dim = sc2.nextInt();
		LabirintoAle(dim);
		ma(dim);
	}

	static void ma (int dim){
		while(!ChegouAoFim()){
			char direcao = direcao();
			if (!clique(direcao,dim))
				break;
			else {
				//d.NovaPosicaoDragao();
				imprimir(dim);
			}
		}
		System.out.println("FIM");
	}		
}
