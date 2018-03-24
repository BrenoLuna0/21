public class Baralho {
	private Carta[] baralho = new Carta[52];
	
	public Baralho() {
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
			
			switch(i) {
				case 0:
					baralho[i].setValorFace('A');
				case 1:
					baralho[i].setValorFace('2');
				case 2:
					baralho[i].setValorFace('3');
				case 3:
					baralho[i].setValorFace('4');
				case 4:
					baralho[i].setValorFace('5');
				case 5:
					baralho[i].setValorFace('6');
				case 6:
					baralho[i].setValorFace('7');
				case 7:
					baralho[i].setValorFace('8');
				case 8:
					baralho[i].setValorFace('9');
				case 9:
					baralho[i].setValorFace('D');
				case 10:
					baralho[i].setValorFace('J');
				case 11:
					baralho[i].setValorFace('Q');
				case 12:
					baralho[i].setValorFace('K');
			}
			
		}
		
		valor = 0;
		
		for(int i = 13; i < 26; i++){
			if(valor < 10){
				valor++;
			}
			baralho[i].setValor(valor);
			baralho[i].setNaipe("espadas");
			
			switch(i) {
				case 0:
					baralho[i].setValorFace('A');
				case 1:
					baralho[i].setValorFace('2');
				case 2:
					baralho[i].setValorFace('3');
				case 3:
					baralho[i].setValorFace('4');
				case 4:
					baralho[i].setValorFace('5');
				case 5:
					baralho[i].setValorFace('6');
				case 6:
					baralho[i].setValorFace('7');
				case 7:
					baralho[i].setValorFace('8');
				case 8:
					baralho[i].setValorFace('9');
				case 9:
					baralho[i].setValorFace('D');
				case 10:
					baralho[i].setValorFace('J');
				case 11:
					baralho[i].setValorFace('Q');
				case 12:
					baralho[i].setValorFace('K');
			}
		}
		
		valor = 0;
		
		for(int i = 26; i < 39; i++){
			if(valor < 10){
				valor++;
			}
			baralho[i].setValor(valor);
			baralho[i].setNaipe("ouro");
			
			switch(i) {
				case 0:
					baralho[i].setValorFace('A');
				case 1:
					baralho[i].setValorFace('2');
				case 2:
					baralho[i].setValorFace('3');
				case 3:
					baralho[i].setValorFace('4');
				case 4:
					baralho[i].setValorFace('5');
				case 5:
					baralho[i].setValorFace('6');
				case 6:
					baralho[i].setValorFace('7');
				case 7:
					baralho[i].setValorFace('8');
				case 8:
					baralho[i].setValorFace('9');
				case 9:
					baralho[i].setValorFace('D');
				case 10:
					baralho[i].setValorFace('J');
				case 11:
					baralho[i].setValorFace('Q');
				case 12:
					baralho[i].setValorFace('K');
			}
		}
		
		valor = 0;
		
		for(int i = 39; i < 52; i++){
			if(valor < 10){
				valor++;
			}
			baralho[i].setValor(valor);
			baralho[i].setNaipe("paus");
			
			switch(i) {
				case 0:
					baralho[i].setValorFace('A');
				case 1:
					baralho[i].setValorFace('2');
				case 2:
					baralho[i].setValorFace('3');
				case 3:
					baralho[i].setValorFace('4');
				case 4:
					baralho[i].setValorFace('5');
				case 5:
					baralho[i].setValorFace('6');
				case 6:
					baralho[i].setValorFace('7');
				case 7:
					baralho[i].setValorFace('8');
				case 8:
					baralho[i].setValorFace('9');
				case 9:
					baralho[i].setValorFace('D');
				case 10:
					baralho[i].setValorFace('J');
				case 11:
					baralho[i].setValorFace('Q');
				case 12:
					baralho[i].setValorFace('K');
			}
		}
	}
	
	public Carta getCarta(int i) {
		return this.baralho[i];
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