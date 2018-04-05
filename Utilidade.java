import java.util.ArrayList;
import java.util.Collections;

public class Utilidade {
	
	public static void misturar(ArrayList<Carta> c) {
		Collections.shuffle(c);
		Collections.shuffle(c);
		Collections.shuffle(c);
		Collections.shuffle(c);
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
