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
		for(int j = 0; j<subStrings.length; j++) {
			
			System.out.print(" "+subStrings[j]);
		
	}
		System.out.println("\n");
		//somar peso da palavra
		int [] subStringsPeso= transformarPesoDaString(subStrings);
		
		for(int j = 0; j<subStringsPeso.length; j++) {
			
				System.out.print(" "+subStringsPeso[j]);
			
		}
		System.out.println("\n");
		
		//verificar se alguma palavra possui o mesmo peso
		int contador;
		int repeticoes=0;
		String repetidos = "";
		for(i = 0; i< subStringsPeso.length; i++) {
			contador = 0;
			for(int j = i+1; j<subStringsPeso.length; j++) {
				if(subStringsPeso[i]==subStringsPeso[j]) {
					
					if(contador==0 ) {
						repetidos+= Integer.toString(subStringsPeso[i])+",";
					}
					subStringsPeso[j]=0;
					contador++;
					
				}
			}
		}
		System.out.println(repetidos);
		
		String [] arrayAux = repetidos.split(",");
		for(i = 0; i < arrayAux.length;i++) {
			if(Integer.parseInt(arrayAux[i])!=0) {
				repeticoes++;
				System.out.print(arrayAux[i]+ " ");
			}
		}
		
		
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
}
