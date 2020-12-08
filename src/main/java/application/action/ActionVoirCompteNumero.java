/**
 * 
 */
package application.action;

import java.util.Locale;
import java.util.Scanner;

import action.Action;
import application.GenericActionAB;
import banque.AgenceBancaire;
import banque.Compte;

/**
 * @author Alexia
 *
 */
public class ActionVoirCompteNumero extends GenericActionAB{


	/**
	 * 
	 */
	public ActionVoirCompteNumero() {
		super("2 - Voir un compte (par son numéro)","2");
	}

	/**
	 * 
	 */
	@Override
	public void execute(AgenceBancaire ag) throws Exception {

		//creation de variable
		Scanner lect;
		String numero;	
		Compte c;

		//Initialisation
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);

		//nume de compte a afficher
		System.out.print("Num compte -> ");
		numero = lect.next();

		//On regarde si il existe ou pas
		c = ag.getCompte(numero);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
		}


	}

}
