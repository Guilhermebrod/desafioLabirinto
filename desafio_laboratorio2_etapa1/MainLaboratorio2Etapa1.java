import java.io.*;

class MainLaboratorio2Etapa1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Labirinto lab = new Labirinto();
		
		lab.criaLabirinto("desafio_laboratorio2_etapa1/labirinto.txt");

		if(lab.percorreLabirinto()) {
			
			System.out.println("O labirinto possue uma saida!");
			
		}
		else {
			
			System.out.println("O labirinto nao possue uma saida!");
			
			}
	}

}
