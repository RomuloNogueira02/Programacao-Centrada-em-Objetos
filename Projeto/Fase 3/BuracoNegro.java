/**
 * Esta classe � uma subclasse de CorpoCeleste, cujas inst�ncias representam corpos celestes 
 * com uma massa tal, que faz com que tenham uma grande for�a de atra��o que pode provocar a 
 * destrui��o de outros corpos nas suas proximidades.
 * 
 * @author MadalenaRodrigues_55853, PedroAlmeida_56897, R�muloNogueira_56935
 * @date Dezembro 2021
 */

public class BuracoNegro extends CorpoCeleste{
	
	/*
	 * Construtor que inicializa um novo objeto com uma massa igual a massa e uma posi��o igual a pos
	 * @param massa  massa do corpo celeste	 
	 * @param pos  posi��o do corpo celeste	 
	 */
	
	public BuracoNegro(double massa, Ponto3D pos) {
		
		super(massa, pos);
	}

	
	/*
	 * Retorna o valor da dist�ncia m�nima a que um outro corpo celeste tem que estar
	 * para n�o ser muito afetado pela for�a de atra��o deste buraco negro
	 * 
	 * @param c  corpo celeste sobre o qual se quer calcular a dist�ncia m�nima de seguran�a
	 * @requires c != null	
	 * @return  dist�ncia entre os dois planetas
	 */
	
	public double distanciaMinimaSeguranca(CorpoCeleste c) {
		
		return Math.sqrt(this.massa() * c.massa());
	}
	
}
