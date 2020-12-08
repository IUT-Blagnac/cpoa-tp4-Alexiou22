/**
 * 
 */
package application.action;

import action.Action;
import application.GenericActionAB;
import banque.AgenceBancaire;

/**
 * @author Alexia
 *
 */
public class ActionListeDesComptes extends GenericActionAB {


	/**
	 * 
	 */
	public ActionListeDesComptes() {
		super("1 - Liste des comptes de l'agence","1");

	}


	/**
	 * 
	 */
	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		ag.afficher();
	}

}
