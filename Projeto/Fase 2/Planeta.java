import java.util.List;
import java.util.ArrayList;

/**
* @author MadalenaRodrigues_55853, PedroAlmeida_56897, R�muloNogueira_56935
* @date Novembro 2021
*/

public class Planeta {

	// Vari�veis da inst�ncia
	private String nome;
	private List<Propriedade> props;
	
	/**
	* Construtor que inicializa um novo Planeta cujo nome � o passado no argumento nome, 
	* e cujas propriedades s�o as contidas na lista props
	* 
	* @param nome   nome do novo Planeta
	* @param props   lista de propriedades do novo Planeta
	*/
	public Planeta(String nome, List<Propriedade> props){
		
		this.nome = nome;
		this.props = new ArrayList<Propriedade>(props);
	}
	

	/**
	* M�todo que devolve o nome de um Planeta
	* 
	* @return Retorna o nome do Planeta sobre o qual se chama o m�todo
	*/
	public String nome () {
	
		return this.nome;
	}
	
	
	/**
	* M�todo que devolve true se o planeta sobre o qual � aplicado tem a propriedade passada 
	* como argumento
	* 
	* @param propriedade   propriedade a verificar se existe no Planeta 
	* @return Retorna true ou false dependendo da exist�ncia da propriedade na lista de 
	* propriedades do Planeta
	*/
    public boolean temPropriedade(Propriedade propriedade) {
        
		return this.props.contains(propriedade);
    }

	
	/**
	* M�todo que devolve true se o planeta sobre o qual � aplicado tem todas as propriedades 
	* contidas na lista de propriedades passada como argumento
	* 
	* @param propriedades   lista de propriedades a verificar no Planeta 
	* @return Retorna true ou false dependendo se o Planeta tem ou n�o todas as propriedades
	* indicadas
	*/
    public boolean temTodas(List<Propriedade> propriedades) {

        for (Propriedade p : propriedades ) {
            if (!this.props.contains(p)) {
                return false;
            }
        }
        return true;
    }

	
	/**
	* M�todo que devolve a representa��o textual do planeta sobre o qual � aplicado
	* 
	* @return Retorna a representa��o textual do planeta em forma de String
	*/
	public String toString() {
		
		String nome = this.nome();
		StringBuilder resultado = new StringBuilder(nome + ": ");
		
		for (Propriedade prop : this.props) {
			resultado.append(prop.name() + " ");
		}
		
		return resultado.toString();
	}
}
