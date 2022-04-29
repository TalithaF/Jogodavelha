import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class jogodavelha {
	
	static ArrayList<Integer> posicaoJogador = new ArrayList<Integer>(); 
	static ArrayList<Integer> posicaoCpu = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char [][] tabuleiroJogo = {{' ', '|', ' ', '|', ' '}, 
				{'—', '+', '—', '+', '—'}, 
				{' ', '|', ' ', '|', ' '}, 
				{'—', '+', '—', '+', '—'},
				{' ', '|', ' ', '|', ' '}};
		
		printTabuleiroJogo(tabuleiroJogo);
		
		
		
		while(true){
		Scanner scan = new Scanner(System.in);
		System.out.println("Coloque a sua posição (1-9)");
		int jogadorPos = scan.nextInt();
		while(posicaoJogador.contains(jogadorPos)|| posicaoCpu.contains(posicaoJogador)) {
		   System.out.println("Posição já preenchida! Escolha outra posição.");
		   jogadorPos = scan.nextInt();
		}
		
		System.out.println(jogadorPos);
	     String result = vencedorConfere();
		if(result.length() >0) {
			System.out.println(result);
			break;
		}
		
		marqueAlternativa(tabuleiroJogo, jogadorPos, "jogador");
		
		Random rand = new Random();
		int cpuPos = rand.nextInt(9) + 1;
		while(posicaoJogador.contains(cpuPos)|| posicaoCpu.contains(cpuPos)) {
			   cpuPos = rand.nextInt(9) + 1;
			}
		marqueAlternativa(tabuleiroJogo,cpuPos, "CPU");
	
		printTabuleiroJogo(tabuleiroJogo);
		
	     result = vencedorConfere();
		if(result.length() >0) {
			System.out.println(result);
			break;
		}
		}}
     
   
public static void printTabuleiroJogo(char [] [] tabuleiroJogo){
	for(char[] row : tabuleiroJogo){
		for(char c : row){
			System.out.print(c);
		}
		System.out.println();
	}
		
		}
	

public static void marqueAlternativa(char[] [] tabuleiroJogo, int pos, String user) {
		
	char simbolo = ' ';
	
	if(user.equals("jogador")) {
		 simbolo = 'X';
		posicaoJogador.add(pos);
	} else if(user.equals("CPU")) {
		 simbolo = 'O';
		}
		
	posicaoCpu.add(pos);
	switch(pos) {
	case 1:
		tabuleiroJogo [0][0] = simbolo;
		break;
	case 2:
		tabuleiroJogo [0][2] = simbolo;
		break;
	case 3:
		tabuleiroJogo [0][4] = simbolo;
		break;
	case 4:
		tabuleiroJogo [2][0] = simbolo;
		break;
	case 5:
		tabuleiroJogo [2][2] = simbolo;
		break;
	case 6:
		tabuleiroJogo [2][4] = simbolo;
		break;
	case 7:
		tabuleiroJogo [4][0] = simbolo;
		break;
	case 8:
		tabuleiroJogo [4][2] = simbolo;
		break;
	case 9:
		tabuleiroJogo [4][4] = simbolo;
		break;
		default:
			break;
	
}
	} 
   
	public static  String vencedorConfere() {
		
		List primeiraFileira = Arrays.asList(1, 2, 3);
		List meioFileira = Arrays.asList(4, 7, 6);
		List ultimaFileira = Arrays.asList(7, 8 ,9);
		List direitaFileira = Arrays.asList(1, 4, 7);
		List meiaFileira = Arrays.asList(2, 5, 8);
		List esquerdaFileira = Arrays.asList(3, 6, 9);
		List diagonal1 = Arrays.asList(1, 5, 9);
		List diagonal2 = Arrays.asList(7, 5, 3);
		
		List<List> vencedor = new ArrayList<List>();
		vencedor.add(primeiraFileira);
		vencedor.add(meioFileira);
		vencedor.add(ultimaFileira);
		vencedor.add(direitaFileira);
		vencedor.add(meiaFileira);
		vencedor.add(esquerdaFileira);
		vencedor.add(diagonal1);
		vencedor.add(diagonal2);
		
		for(List l : vencedor) {
			if(posicaoJogador.containsAll(l)) {
				return "Prabéns você venceu!!!";
			} else if(posicaoCpu.containsAll(l)) {
				return "Você perdeu!";
			}else if(posicaoJogador.size() + posicaoCpu.size() ==9) {
				return "É um empate!";
				
			}
		}
		return "";
    }
}
