import java.util.List;
import java.util.ArrayList;

/**
* @author MadalenaRodrigues_55853, PedroAlmeida_56897, R�muloNogueira_56935
* @date Novembro 2021
*/

public class SistemaSolar {
	
	// Vari�veis da inst�ncia
	private String nome;
	private Planeta [][] planetas;
	
    /**
    * Construtor que inicializa um sistema solar cujo nome � o passado no argumento nome e 
	* cont�m uma matriz de planetas passada no argumento planetas
    * 
    * @param nome   Nome do Sistema Solar
    * @param planetas   Matriz que cont�m os planetas e as suas informa��es
    *
    * @requires universoValido(planetas) == true
    */
	public SistemaSolar(String nome, Planeta[][] planetas) { 
		 
		this.nome = nome;
		this.planetas =  planetas;
	}
	 
	 
	/**
    * M�todo que devolve true se o array bi-dimensional arrayBi � uma matriz e n�o cont�m
	* elementos a null
    * 
    * @param arrayBi   Matriz que cont�m os planetas e as suas informa��es
    * @return Retorna true ou false dependendo se h� elementos a null e se a matriz arrayBi 
	* tem a mesma quantidade de elementos em todas as linhas.
	*/
	static boolean universoValido(Planeta[][] arrayBi) {
		
		int nColunasInicial = arrayBi[0].length;
		
		// V� por linha se o n�mero de colunas s�o o mesmo
		for (int i = 0; i < arrayBi.length; i++) {
			int colunas = arrayBi[i].length; 
			
	    	if (colunas != nColunasInicial){
	    		return false;
	    	}
			// V� por coluna se o planeta � nulo 
	    	for (int j = 0; j < arrayBi[i].length; j++) {
	    		if(arrayBi[i][j].nome() == null) {
	    			return false;
	    		}
			}
	    }
		return true;
	}
	

	/**
	* M�todo que devolve o nome do sistema solar
	* 
	* @return nome do sistema solar sobre o qual se chama o m�todo
	*/
	public String nome() {
		
		return this.nome;
	}
	

	/**
    * M�todo que devolve true se o sistema solar sobre o qual � aplicado cont�m um planeta 
	* cujo nome � o passado em nome
    * 
    * @param nome   Nome a verificar se existe
    * @return Retorna true ou false dependendo se existe o nome passado em nome no 
	* sistema solar
	*/
	public boolean temPlaneta(String nome) {
		
		for (int i = 0; i < this.planetas.length; i++) {
			for(int j = 0 ; j < this.planetas[i].length; j++) {
				if(this.planetas[i][j].nome().equals(nome)) {
					return true;
				}	
			}	
		}
		
		return false;
	}
	

	/**
    * M�todo que devolve uma lista contendo os nomes de todos os planetas do sistema solar
	* sobre o qual � aplicado que t�m todas as propriedades referidas na lista props
    * 
    * @param propriedades   lista de propriedades a verificar 
    * @return Retorna quais os planetas que cont�m todas as propriedades 
	*/
    public List<String> comPropriedades(List<Propriedade> propriedades) {

        List<String> nomes = new ArrayList<>();

      	for (int i = 0; i < this.planetas.length; i++) {
        	for(int j = 0; j < this.planetas[i].length; j++) {
        		if(this.planetas[i][j].temTodas(propriedades)) {
        			nomes.add(this.planetas[i][j].nome());
        		}
        	}
      	}
        return nomes;
    }


	/**
    * M�todo que devolve um vetor em que o i-�simo elemento representa o n�mero de 
	* planetas do sistema solar sobre o qual � aplicado que t�m a i-�sima propriedade 
	* do vetor Propriedade.values()
    * 
    * @return N�mero de planetas que t�m a propriedade
 	*/
    public int[] quantosPorPropriedade() {

        Propriedade[] propriedades = Propriedade.values();
        int[] contagem = new int[propriedades.length];

        for (int i = 0; i < propriedades.length; i++) {

            List<Propriedade> p = new ArrayList<>();
            
			p.add(propriedades[i]);

            contagem[i] = this.comPropriedades(p).size();
        }
        return contagem;
    }

	
	/**
    * M�todo auxiliar que calcula a quantidade de planetas de um sistema solar
    * 
    * @return N�mero de planetas do sistema solar
  	*/
	private int numeroDePlanetas() {
		
		int resultado = 0;
		
		for (int i = 0; i < this.planetas.length; i++) {
			for (int j = 0; j < this.planetas[i].length; j++) {
				resultado ++;
			}
		}
		return resultado;
	}
	

	/**
    * M�todo que devolve true se o n-�simo planeta deste sistema solar tem todas as 
	* propriedades referidas na lista props. A ordem pela qual s�o considerados os planetas
	* no sistema solar segue a dire��o de uma lagarta horizontal, que volta ao in�cio
	* quando termina
	* @param n   �ndice do planeta 
	* @param props   Lista de propriedades a verificar 
    * 
    * @return Retorna true ou false dependendo se o planeta tem ou n�o as propriedades
 	*/
	public boolean nEsimoTem(int n, List<Propriedade> props) {
	
		int maximo = numeroDePlanetas();
		
		while (n >= maximo) {
			n -= maximo;
		}
		
		Planeta planetaVerificar = null;
		int contador = -1;
		
		for (int i = 0; i < this.planetas.length; i++) {
			if (i%2 == 0 || i == 0) { // Se for par ou 0
				for (int j = 0; j < this.planetas[i].length; j++) {
					contador++;
					
					if (contador == n) {
						planetaVerificar = this.planetas[i][j];
					}
				}
			}else { // Se for �mpar
				for (int j = this.planetas[i].length - 1; j >= 0; j--) {
					
					contador++;
					
					if (contador == n) {
						planetaVerificar = this.planetas[i][j];
					}
				}
			}	
		}
		return planetaVerificar.temTodas(props);
	}
	

	/**
    * M�todo que devolve a propriedade que aparece mais vezes nos planetas do
	* sistema solar onde � aplicado o m�todo
    * 
    * @return Retorna qual a propriedade mais frequente
 	*/
	public Propriedade maisFrequente(){

		Propriedade[] propriedades = Propriedade.values(); 
		int[] frequencia = this.quantosPorPropriedade();   
        
		Propriedade maisFrequente = propriedades[0];
        int maximo = 0;
		
        for (int i = 0; i < frequencia.length; i++) {
        	if(frequencia[i] > maximo) {
        		maximo = frequencia[i];
        		maisFrequente = propriedades[i];
        	}
        	
        }
        return maisFrequente;
	}	
		
	
	/**
	* M�todo que devolve que devolve a representa��o textual da institui��o sobre a 
	* qual � aplicado o m�todo 
	* 
	* @return Retorna a representa��o textual do planeta em forma de String
	*/
	public String toString() {
	
		StringBuilder resultado = new StringBuilder (this.nome() + "\n");

		for (int i = 0; i < this.planetas.length; i++) {
			for(int j = 0 ; j < this.planetas[i].length; j++) {
				resultado.append(this.planetas[i][j].toString());
			}
			resultado.append("\n");
		}
		return resultado.toString();
	}
}