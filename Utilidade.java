import java.util.Scanner;

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

}
