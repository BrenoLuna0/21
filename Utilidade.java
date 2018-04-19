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
		
		for(int i = 0; i < 13; i++) {
			switch(i) {
			case 0:
				c[i] = 'A';
			case 1:
				c[i] = '2';
			case 2:
				c[i] = '3';
			case 3:
				c[i] = '4';
			case 4:
				c[i] = '5';
			case 5:
				c[i] = '6';
			case 6:
				c[i] = '7';
			case 7:
				c[i] = '8';
			case 8:
				c[i] = '9';
			case 9:
				c[i] = 'D';
			case 10:
				c[i] = 'J';
			case 11:
				c[i] = 'Q';
			case 12:
				c[i] = 'K';
			}
		}
		
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
