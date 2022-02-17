/* @Author Romenildo
 * @Java Version SE-15
 * 
 * Questão 03
 *  Dada uma string qualquer, desenvolva um algoritmo que encontre
 * o número de pares de substrings que são anagramas.
 *  
 */

package desafioCapgemini;

import java.util.Arrays;

public class Questao3 {
	
	public static void main(String[] args) {
		
		encontrarAnagramasDuplos("ifailuhkqq");
	}

	public static void encontrarAnagramasDuplos(String palavra) {
		int ponteiro = 0;
		int i;
		String [] subStrings = new String[gerarQuantidade(palavra.length())];
		
		//gerar subStrings
		for(int passo = 1; passo < subStrings.length; passo++) {
			i = 0;
			for(; i <= palavra.length() - passo; i++) {
				subStrings[ponteiro++] = palavra.substring(i, i+passo);
			}
		}

		//somar peso da palavra
		int [] subStringsPeso= transformarPesoDaString(subStrings);

		
		//verificar se alguma palavra possui o mesmo peso
		
		System.out.println(contarRepetidos(subStringsPeso));
		
		
		
		
	}
	
	
	public static int gerarQuantidade(int tamanhoPalavra) {
		//faz o somatorio de 1 até o tamanho da palavra
		int total = 0;
		
		for(int i = tamanhoPalavra; i>0; i--) {
			total += i;
		}
		return total;
	}
	
	public static int[] transformarPesoDaString(String[] subStrings) {
		//transforma a palavra em um Peso pela tabela ASCII
		int [] subStringsPeso= new int[subStrings.length];
		
		for(int i=0;i<subStrings.length;i++) {
			String[] auxString = subStrings[i].split("");
			
			for(int j = 0; j< subStrings[i].length();j++) {
				char myChar = auxString[j].charAt(0);
				subStringsPeso[i] += (int)myChar;
			}
		}
		return subStringsPeso;
	}
	
	public static int contarRepetidos(int[] subStringsPeso) {
		//verifica se alguma substring possui o valor repetido
		int encontrou;
		String repetidos = "";
		
		for(int i = 0; i< subStringsPeso.length; i++) {
			encontrou = 0;
			for(int j = i+1; j<subStringsPeso.length; j++) {
				if(subStringsPeso[i]==subStringsPeso[j]) {
					
					if(encontrou==0 ) {
						repetidos+= Integer.toString(subStringsPeso[i])+",";
					}
					subStringsPeso[j]=0;
					encontrou++;
				}
			}
		}
		return contar(repetidos);
	
		
	}
	public static int contar(String repetidos) {
		//caso tenha 2 ou mais repeticoes do mesmo peso ela foi zerada e aqui nao entra na conta
		String [] arrayAux = repetidos.split(",");
		int total=0;
		
		for(int i = 0; i < arrayAux.length;i++) {
			if(Integer.parseInt(arrayAux[i])!=0) {
				total++;
			}
		}
		return total;
	}
}
