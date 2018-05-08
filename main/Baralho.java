package main;
public class Baralho {
	private Carta[] baralho = new Carta[52];
	private final static char[] faces = Utilidade.delegarfaces();
	
	public Baralho() {
			
			inicializarBaralho(0);
		}
		
		public Carta getCarta(int i) {
			return this.baralho[i];
		}
		
		
		
		private void inicializarBaralho(int j) {
		
		int valor = 0;
		for(int i = 0; i < 13; i++){
			if(valor < 10){
				valor++;
			}
			this.baralho[i] = new Carta(valor,"copas",faces[i]);
			
		}
		j = 0;
		valor = 0;
		for(int i = 13; i < 26; i++){
			if(valor < 10){
				valor++;
			}
			
			this.baralho[i] =  new Carta(valor,"espadas",faces[j]);
			j++;
		}
		j = 0;
		valor = 0;
		for(int i = 26; i < 39; i++){
			if(valor < 10){
				valor++;
			}
			this.baralho[i] = new Carta(valor, "ouro",faces[j]);
			j++;
		}
		j = 0;
		valor = 0;
		for(int i = 39; i < 52; i++){
			if(valor < 10){
				valor++;
			}
			this.baralho[i] = new Carta(valor, "paus",faces[j]);
			j++;
		}
			
		}
	

}




































/*public class Baralho {
	private Carta[] baralho = new Carta[52];
		
		Baralho(){
			
			for(int i = 0; i < 52; i++){
				this.baralho[i] = new Carta();
			}
			
			int valor = 0;
			for(int i = 0; i < 13; i++){
				if(valor < 10){
					valor++;
				}
				baralho[i].setValor(valor);
				baralho[i].setNaipe("copas");
				baralho[i].setRetirado(false);
			}
			
			valor = 0;
			
			for(int i = 13; i < 26; i++){
				if(valor < 10){
					valor++;
				}
				baralho[i].setValor(valor);
				baralho[i].setNaipe("espadas");
				baralho[i].setRetirado(false);
			}
			
			valor = 0;
			
			for(int i = 26; i < 39; i++){
				if(valor < 10){
					valor++;
				}
				baralho[i].setValor(valor);
				baralho[i].setNaipe("ouro");
				baralho[i].setRetirado(false);
			}
			
			valor = 0;
			
			for(int i = 39; i < 52; i++){
				if(valor < 10){
					valor++;
				}
				baralho[i].setValor(valor);
				baralho[i].setNaipe("paus");
				baralho[i].setRetirado(false);
			}
		}
		
		public Carta getCarta(int i){
			
			return this.baralho[i];
			
		}

}
*/