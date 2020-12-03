package application.action;

import java.util.Locale;
import java.util.Scanner;

import action.Action;
import application.GenericActionAB;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class ActionSupCompte extends GenericActionAB {


	/**
	 * 
	 */
	public ActionSupCompte() {
		super("2 - Supprimer un compte","2");
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

		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			ag.removeCompte(numero);
		}

	}
}
