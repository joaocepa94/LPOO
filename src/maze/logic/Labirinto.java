package maze.logic;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Labirinto {
	public static char[][] lab;
	static Heroi h;
	static Dragao d;
	static Espada e;

	
	public static void LabirintoPred() {
		// TODO Auto-generated constructor stub
		
		h = new Heroi(1,1,'H');
		//d = new Dragao(3,1,'D',0);
		
		lab = new char[][] {
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', 'D', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'S' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', 'E', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

		for (int i=0; i < 10; i++) {
			for (int j=0; j < 10; j++) {
				if (j == 9)
					System.out.println(lab[i][j]);
				else
					System.out.print(lab[i][j]);
			}
		}
	}

	public static void imprimir(int dim){
		for (int i=0; i < dim; i++) {
			for (int j=0; j < dim; j++) {
				if (j == dim-1)
					System.out.println(lab[i][j]);
				else
					System.out.print(lab[i][j]);
			}
		}
	}
	public static void LabirintoAle(int dim) {
		
		h = new Heroi();
		d = new Dragao();
		e= new Espada();
		
		lab = new char[dim][dim];

		Random aleatorio = new Random();

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if(i%2==0 || j%2==0)
					lab[i][j]='X';
				else
					lab[i][j]=' ';
			}
		}

		int atualX, atualY;

		// Criar Saida
		String horizOuVert;
		if (aleatorio.nextInt(2) == 0) horizOuVert = "horiz";
		else horizOuVert = "vert";

		if (horizOuVert.equals("horiz")) {
			atualX = (dim-1) * aleatorio.nextInt(2);
			atualY = aleatorio.nextInt((dim-3)/2 + 1) * 2 + 1;
		}
		else {
			atualY = (dim-1) * aleatorio.nextInt(2);
			atualX = aleatorio.nextInt((dim-3)/2 + 1) * 2 + 1;
		}

		lab[atualX][atualY] = 'S';
		

		char[][] labAux = new char[dim][dim]; 
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i == 0 || j == 0 || i % 2 == 0 || j % 2 == 0)
					labAux[i][j] = 'V';
				else
					labAux[i][j] = 'N';
			}
		}

		if (atualX == 0)
			atualX += 1;
		else if (atualX == dim-1)
			atualX -= 1;

		if (atualY == 0)
			atualY += 1;
		else if (atualY == dim-1)
			atualY -= 1;

		labAux[atualX][atualY] = 'V';

		Stack<int[]> celulasAVisitar = new Stack<int[]>();

		while (existemNaoVisitadas(labAux, dim)) {
			String vizinhoNaoVisitado = vizinhoNaoVisitado(labAux, atualX, atualY, dim);
			if (!vizinhoNaoVisitado.equals("nao")) { 
				celulasAVisitar.push(new int[]{atualX, atualY}); 

				switch(vizinhoNaoVisitado) { 
				case "cima":
					lab[atualX-1][atualY] = ' ';
					atualX -= 2;
					break;
				case "baixo":
					lab[atualX+1][atualY] = ' ';
					atualX += 2;
					break;
				case "esquerda":
					lab[atualX][atualY-1] = ' ';
					atualY -= 2;
					break;
				case "direita":
					lab[atualX][atualY+1] = ' ';
					atualY += 2;
					break;
				}

				labAux[atualX][atualY] = 'V'; 
			}
			else if (!celulasAVisitar.empty()) { 
				atualX = celulasAVisitar.peek()[0]; 
				atualY = celulasAVisitar.peek()[1];
				celulasAVisitar.pop();
			}
			else {
				int[] novaCelula = celulaNaoVisitadaAleatoria(labAux, dim); 
				atualX = novaCelula[0]; // TornÂ·-la a atual.
				atualY = novaCelula[1];
				labAux[atualX][atualY] = 'V'; 
			}
		}
		InsereElemento(dim,'H');
		InsereElemento(dim,'D');
		InsereElemento(dim,'E');
		imprimir(dim);
		return;
	}



	private static boolean existemNaoVisitadas(char[][] labAux, int dim) { 
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (labAux[i][j] == 'N') return true;
			}
		}

		return false;
	}

	private static  String vizinhoNaoVisitado(char[][] labAux, int x, int y, int dim) {
		boolean[] vizinhos = {false, false, false, false}; 
		Random aleatorio = new Random();
		if (x-2 >= 0 && labAux[x-2][y]=='N')
			vizinhos[0] = true;

		if (x+2 < dim && labAux[x+2][y]=='N')
			vizinhos[1] = true;

		if (y-2 >= 0 && labAux[x][y-2]=='N')
			vizinhos[2] = true;

		if (y+2 < dim && labAux[x][y+2]=='N')
			vizinhos[3] = true;

		boolean temVizinhosNaoVisitados = false;
		for (int i = 0; i < 4; i++)
			if (vizinhos[i]) {
				temVizinhosNaoVisitados = true;
				break;
			}
		if (!temVizinhosNaoVisitados) return "nao";

		int vizinhoNaoVisitadoAleatorio;
		do {
			vizinhoNaoVisitadoAleatorio = aleatorio.nextInt(4);
		} while (!vizinhos[vizinhoNaoVisitadoAleatorio]);

		switch (vizinhoNaoVisitadoAleatorio) {
		case 0:
			return "cima";
		case 1:
			return "baixo";
		case 2:
			return "esquerda";
		case 3:
			return "direita";
		default:
			return "erro";
		}
	}

	private static int[] celulaNaoVisitadaAleatoria(char[][] labAux, int dim) {
		Vector<int[]> celulasNaoVisitadas = new Vector<int[]>();
		Random aleatorio = new Random();
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				if (labAux[i][j]=='N') celulasNaoVisitadas.add(new int[]{i, j});

		int celula = aleatorio.nextInt(celulasNaoVisitadas.size());

		return celulasNaoVisitadas.elementAt(celula);
	}
	
	public static boolean ChegouAoFim(){
		
		if(lab[h.GetPosicaoY()][h.GetPosicaoX()]=='S')
			return true;
		else return false;
		
	}
	
	
	
	
	
	public static boolean moveEsquerda(int dim) {
		//
		return move(h.GetPosicaoY(), h.GetPosicaoX(), h.GetPosicaoY()-1, h.GetPosicaoX(), dim);
	}

	public static boolean moveDireita(int dim) {
		//
		return move(h.GetPosicaoY(), h.GetPosicaoX(), h.GetPosicaoY()+1, h.GetPosicaoX(), dim);
	}

	public static boolean moveCima(int dim) {
		//
		return move(h.GetPosicaoY(), h.GetPosicaoX(), h.GetPosicaoY(), h.GetPosicaoX()-1, dim);
	}

	public static boolean moveBaixo(int dim) {
		//
		return move(h.GetPosicaoY(), h.GetPosicaoX(), h.GetPosicaoY(), h.GetPosicaoX()+1, dim);
	}
	public static int testaProximaPosicao(int col, int lin, int dim) {
		// 1 - Saida ok
		// 2 - nao esta armado
		// 3 - espada ok
		// 4 - dragao sem arma
		// 5 - dragao com arma
		// 6 - parede
		// 7 - movimento
		// 8 - out of bounds

		if (col > dim || lin > dim) {
			System.out.println("Nao pode sair dos limites");
			return 8;

		} else if (lab[lin][col] == 'S') {
			if (h.getestouArmado())
				return 1;
			else {
				System.out.println("Tem de estar armado para terminar");
				return 2;
			}
		} else if (lab[lin][col] == 'E') {
			return 3;
		} else if (lab[lin][col] == 'D') {
			if (h.getestouArmado())
				return 5;
			else {
				System.out.println("Game Over");
				return 4;
			}
		} else if (lab[lin][col] == 'X') {
			System.out.println("Tem Parede");
			return 6;
		} else if (lab[lin][col] == ' ') {
			return 7;
		}
		return 0;
	}

	public static boolean move(int prevcol, int prevlin, int nextcol,
			int nextlin, int dim) {
		// 1 - Saida ok
		// 2 - nao esta armado
		// 3 - espada ok
		// 4 - dragao sem arma
		// 5 - dragao com arma
		// 6 - parede
		// 7 - movimento
		int next;
		next = testaProximaPosicao(nextcol, nextlin, dim);

		switch (next) {
		case 1:
			lab[h.GetPosicaoY()][h.GetPosicaoX()] = 'S';
			break;
		case 2:
			return true; // joga novamente
		case 3:
			h.setestouArmado();
			lab[prevlin][prevcol] = ' ';
			lab[nextlin][nextcol] = 'A';
			h.SetPosicaoX(nextlin);
			h.SetPosicaoY(nextcol);
			break;
		case 4:
			return false;
		case 5:
			lab[prevlin][prevcol] = ' ';
			lab[nextlin][nextcol] = 'A';
			h.SetPosicaoX(nextlin);
			h.SetPosicaoY(nextcol);
			break;
		case 6:
			return true; // joga novamente
		case 7:
			if(h.getestouArmado()){
				lab[prevlin][prevcol] = ' ';
				lab[nextlin][nextcol] = 'A';
				h.SetPosicaoX(nextlin);
				h.SetPosicaoY(nextcol);

			} else{
				lab[prevlin][prevcol] = ' ';
				lab[nextlin][nextcol] = 'H';
				h.SetPosicaoX(nextlin);
				h.SetPosicaoY(nextcol);
				break;}
		case 8:
			return true; // joga novamente
		}
		return true;
	}

	public static char direcao() {
		char ch = 0;
		String st = "";

		Scanner sc = new Scanner(System.in);
		try {
			st = sc.findInLine(".");
			if (st.length() > 0)
				ch = st.charAt(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ch;

	}
	public static boolean clique(char ch, int dim) {

		boolean mov = true;

		switch (ch) {
		case 'e':
			mov = moveEsquerda(dim);
			break;
		case 'd':
			mov = moveDireita(dim);
			break;
		case 'c':
			mov = moveCima(dim);
			break;
		case 'b':
			mov = moveBaixo(dim);
			break;
		default:
			System.out.println("direccao invalida");
		}
		return mov;
	}
	
	public static void InsereElemento(int dim, char representation){
		Random aleatorioX = new Random();
		Random aleatorioY = new Random();
		if(representation=='H'){
			h.SetPosicaoX(aleatorioX.nextInt(dim-1));
			h.SetPosicaoY(aleatorioY.nextInt(dim-1));
			if(lab[h.GetPosicaoX()][h.GetPosicaoY()]==' '){
				lab[h.GetPosicaoX()][h.GetPosicaoY()]=representation;
			}
			else InsereElemento(dim,representation);
		}
		else if(representation=='D'){
			d.SetPosicaoX(aleatorioX.nextInt(dim-1));
			d.SetPosicaoY(aleatorioY.nextInt(dim-1));
			if(lab[d.GetPosicaoX()][d.GetPosicaoY()]==' '){
				lab[d.GetPosicaoX()][d.GetPosicaoY()]=representation;
			}
			else InsereElemento(dim,representation);
		}
		else if(representation=='E'){
			e.SetPosicaoX(aleatorioX.nextInt(dim-1));
			e.SetPosicaoY(aleatorioY.nextInt(dim-1));
			if(lab[e.GetPosicaoX()][e.GetPosicaoY()]==' '){
				lab[e.GetPosicaoX()][e.GetPosicaoY()]=representation;
			}
			else InsereElemento(dim,representation);
		}
	}
	
}
