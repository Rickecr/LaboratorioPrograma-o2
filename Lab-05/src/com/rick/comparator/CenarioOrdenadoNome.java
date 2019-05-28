package com.rick.comparator;

import java.util.Comparator;

import com.rick.models.Cenario;

/**
 * Classe responsavel implementar a interface 'Comparator' para conseguir comparar dois cenarios
 * pelo nome.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>compare</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class CenarioOrdenadoNome implements Comparator<Cenario> {

	/**
	 * Método que guarda a lógica para comparar dois cenarios pelo nome.
	 */
	@Override
	public int compare(Cenario o1, Cenario o2) {
		return o1.getDescricao().compareTo(o2.getDescricao());
	}
}
