/* @Author Romenildo
 * @Java Version SE-15
 * 
 * Questão 02
 * construa um algoritmo que informe qual é o número mínimo de 
 * caracteres que devem ser adicionados para uma string qualquer ser considerada segura.
 *  
 *  *restricao de tamanho:a senha precisa ter um tamanho mínimo de 6 caracteres.*
 */
package desafioCapgemini;

public class Questao2 {

	public static void main(String[] args) {
		
		System.out.println(verificarTamanhoSenha("Ya3"));

	}
	
	public static int verificarTamanhoSenha(String senha) {
		
			if(senha.length() < 6) {
				return 6 - senha.length();
			}
			return 0;
	}

}
