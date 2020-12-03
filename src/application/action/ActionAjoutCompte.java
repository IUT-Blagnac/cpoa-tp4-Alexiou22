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
public class ActionAjoutCompte extends GenericActionAB {


	/**
	 * 
	 */
	public ActionAjoutCompte() {
		super("1 - Ajouter un compte","1");
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
		double montant;
		String propri;

		//Initialisation
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);


		System.out.print("Num compte -> ");
		numero = lect.next();
		System.out.print("Proprietaire -> ");
		propri = lect.next();
		c = ag.getCompte(numero);

		if (c!=null) {
			System.out.println("Compte existant ");
		} else {
			ag.addCompte(new Compte(numero,propri));
		}
	}

}
