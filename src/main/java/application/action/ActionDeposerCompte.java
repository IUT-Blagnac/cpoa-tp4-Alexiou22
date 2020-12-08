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
import banque.exception.CompteException;

/**
 * @author Alexia
 *
 */
public class ActionDeposerCompte extends GenericActionAB {


	/**
	 * 
	 */
	public ActionDeposerCompte() {
		super("1 - Déposer de l'argent sur un compte","1");
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
				
		//Initialisation
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		
		System.out.print("Num compte -> ");
		numero = lect.next();
		c = ag.getCompte(numero);
		System.out.print("Montant à déposer -> ");
		montant = lect.nextDouble();
		
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant dépôt: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant déposé, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
		
	}

}
