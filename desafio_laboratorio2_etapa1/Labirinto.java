import java.io.*;
public class Labirinto {

	char[][] labirinto;
	
	public Labirinto() {
	}
	
	//metodo pra criar labirinto
	public void criaLabirinto(String filename) throws FileNotFoundException, IOException {
		
		int quantLinhas = 0;
		int quantColunas = 0;
		int linha = 0;
		
		try{
			
		FileReader fr = new FileReader(filename);
		BufferedReader in = new BufferedReader(fr);
		
		String line;
		
		//loop pra saber o tamanha do array bidimensional
		while((line = in.readLine()) != null) {
			
			++quantLinhas;
			quantColunas = line.length();
			
		}
		
		in.close();
		
		//a array bidimensional labirinto é declarada
		labirinto = new char[quantLinhas][quantColunas];
		
		FileReader rf = new FileReader(filename);
		
		BufferedReader ln = new BufferedReader(rf);
		
		//loop pra encher array
		while((line = ln.readLine()) != null) {
			
			for (int col = 0; col < line.length(); col++){
				
                labirinto[linha][col] = line.charAt(col);
                
            }
			
            linha++;
			
		}
		
		ln.close();
		
		}
		
		catch(FileNotFoundException e){
			
			System.out.println("Arquivo: " + filename + " nao encontrado.");
			
		}
		
		catch(IOException f) {
			
			System.out.println("Erro na leitura do arquivo " + filename + ".");
			
		}
				
	}
	
	//funcao pra começar na posicao inicial
	public boolean percorreLabirinto() {
		
		return percorreLabirinto(0, 0);
	}
	
	//funçao que realmente move o cursor
	private boolean percorreLabirinto(int linha, int coluna) {
		
		//a cada posiçao que o cursor segue é marcado com a letra 'O'
		labirinto[linha][coluna] = 'O';
		
		//antes de checar se a próxima casa está vazia é checado se a próxima casa está dentro do tamanho da array para não houver exceções
		//o cursor só checa se a próxima casa é a chegada depois de checar se há espaços em branco
		
		//lee a casa da direita
		if(((linha >= 0 && linha < 8) && (coluna + 1 >= 0 && coluna + 1 < 20)) && labirinto[linha][coluna + 1]== ' ') {

			return percorreLabirinto(linha, coluna + 1);
			
		}
		
		else if(((linha >= 0 && linha < 8) && (coluna + 1 >= 0 && coluna + 1 < 20)) && labirinto[linha][coluna + 1]== 'D') {
			
			return true;
			
		}
		
		//lee a casa de baixo
		else if(((linha + 1 >= 0 && linha + 1 < 8) && (coluna >= 0 && coluna < 20)) && labirinto[linha + 1][coluna] == ' ') {
			
			return percorreLabirinto(linha + 1, coluna);
			
		}
		
		else if(((linha + 1 >= 0 && linha + 1 < 8) && (coluna >= 0 && coluna < 20)) && labirinto[linha + 1][coluna] == 'D') {
			
			return true;
			
		}
		
		//lee a casa da esquerda
		else if(((linha >= 0 && linha < 8) && (coluna - 1 >= 0 && coluna - 1 < 20)) && labirinto[linha][coluna - 1] == ' ') {

			return percorreLabirinto(linha, coluna - 1);
					
		}
		
		else if(((linha >= 0 && linha < 8) && (coluna - 1 >= 0 && coluna - 1 < 20)) && labirinto[linha][coluna - 1] == 'D') {

			return true;
			
			
		}
		
		//lee a casa de cima
		else if(((linha - 1 >= 0 && linha - 1 < 8) && (coluna >= 0 && coluna < 20)) && labirinto[linha - 1][coluna]== ' ') {

			return percorreLabirinto(linha - 1, coluna);
			
		}
		
		else if(((linha - 1 >= 0 && linha - 1 < 8) && (coluna >= 0 && coluna < 20)) && labirinto[linha - 1][coluna] == 'D') {

			return true;
			
		}

		return false;
				
	}
	
}
