import java.util.ArrayList;
import java.util.Collections;

public class Utilidade {
	
	public static void misturar(ArrayList<Carta> c) {
		Collections.shuffle(c);
		Collections.shuffle(c);
		Collections.shuffle(c);
		Collections.shuffle(c);
	}
	
	public static char[] delegarfaces() {
		char[] c = new char[13];
		
		c[0] = 'A';
		c[1] = '2';
		c[2] = '3';
		c[3] = '4';
		c[4] = '5';
		c[5] = '6';
		c[6] = '7';
		c[7] = '8';
		c[8] = '9';
		c[9] = 'D';
		c[10] = 'J';
		c[11] = 'Q';
		c[12] = 'K';
		
		return c;
		
	}

}
































/*import java.util.Scanner;

public  class Utilidade {
	
	private static Scanner entrada;

	public static int testeNumeroJogadores() {
		entrada = new Scanner(System.in);
		int numero;
		
		System.out.println("O jogo está prestes a começar. Só são permitidas 7 pessoas jogando ao mesmo tmpo. Quantas pessoas irão jogar? ");
		numero = entrada.nextInt();
		if(numero > 7 || numero < 0) {
			return
			testeNumeroJogadores();
		}else {
			return numero;
			
		}
	}
	
	public static int rand(int Str, int End) {
		return (int) Math.ceil(Math.random() * (End - Str + 1)) - 1 + Str;
	}
	
	
	public static void estourado(Participante p) {
		if(p.getPontuacao()> 21) {
			p.setEstourado(true);
		}
	}

}*/
