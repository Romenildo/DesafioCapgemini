
/* @Author Romenildo
 * @Java Version SE-15
 * 
 * Questão 01
 * Algoritmo para mostrar na tela uma escada de tamanho n utilizando
 *  o caractere(*) e espacos
 * 
 * entrada: n = 6
 * Saída:
       *
      **
     ***
    ****
   *****
  ******
 */
package desafioCapgemini;

public class Questao1 {

	public static void main(String[] args) {
		construirEscada(6);

	}
	
	public static void construirEscada(int tamanho) {
		char [] asteriscos = new char[tamanho];
		
		for(int i = tamanho-1; i >=0; i--) {
			asteriscos[i] = '*';
			System.out.println(asteriscos);
			
		}
	}
}
