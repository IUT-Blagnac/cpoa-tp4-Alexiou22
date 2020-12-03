/**
 * 
 */
package application;

import action.Action;
import banque.AgenceBancaire;

/**
 * @author Alexia
 *
 */
public abstract class GenericActionAB implements Action {
	
	/**
	 * 
	 */
	String lineMessage;
	String code;

	/**
	 * 
	 */
	public GenericActionAB(String messageP, String codeP) {
		this.lineMessage = messageP;
		this.code = codeP;
		
	}
	
	public String actionMessage () {
		
		return this.lineMessage;
	}
	
	public String actionCode () {
		return this.code;
	}

	public abstract void execute(AgenceBancaire ag) throws Exception;

}
