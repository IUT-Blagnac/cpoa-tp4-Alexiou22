/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionList;
import application.action.ActionAjoutCompte;
import application.action.ActionDeposerCompte;
import application.action.ActionRetirerCompte;
import application.action.ActionSupCompte;
import banque.AgenceBancaire;

/**
 * @author Alexia
 *
 */
public class ActionListAB implements ActionList {

	/**
	 * 
	 */
	private String message;
	private String code;
	private String title;
	private List<Action> listeActions;

	/**
	 * 
	 */
	public ActionListAB(AgenceBancaire ag, String codeMenu) {

		this.listeActions = new ArrayList<Action>();

		if (codeMenu == "3") {
			this.message = "3 - Menu op�rations sur comptes";
			this.code = "3";
			this.title ="Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")";
			this.listeActions.add(new ActionDeposerCompte());
			this.listeActions.add(new ActionRetirerCompte());
		}else {
			this.message = "4 - Menu gestion des comptes";
			this.code = "4";
			this.title ="Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")";
			this.listeActions.add(new ActionAjoutCompte());
			this.listeActions.add(new ActionSupCompte());
		}

	}

	/**
	 * 
	 */
	@Override
	public String actionMessage() {
		return this.message;
	}

	/**
	 * 
	 */
	@Override
	public String actionCode() {
		return this.code;
	}

	/**
	 * 
	 */
	@Override
	public void execute(AgenceBancaire ag) throws Exception {

		//creation de variable
		Scanner lect;
		String valeur;
		boolean continu;
		boolean erreur;
		int i,j;

		//Initialisation
		continu = true;


		//while tant que pas q
		while (continu == true) {
			
			//erreur
			erreur = true;

			//affichage
			System.out.println("--");
			System.out.println(this.title);
			System.out.println(this.message);
			System.out.println("--");
			System.out.println("  Choisir :");

			for(j=0; j < listeActions.size(); j++){
				System.out.println(this.listeActions.get(j).actionMessage());
			}

			System.out.println("\n 0 - Pourquitter ce menu");
			
			//le choix
			System.out.println("\n Votre choix");
			lect = new Scanner ( System.in );
			lect.useLocale(Locale.US);
			valeur = lect.next();
			
			//quel choix choisi
			if (valeur.equals("0")) {
				System.out.println("ByeBye");
				ActionListAB.tempo();
				continu = false;
				erreur = false;
				break;
			}else{

				for (i = 0; i< listeActions.size(); i++) {
					if (listeActions.get(i).actionCode().equals(valeur)) {
						listeActions.get(i).execute(ag);
						erreur = false;
					}
				}
			}
			if (erreur == true) {
				System.out.println("Erreur de saisie ...");
				ActionListAB.tempo();
			}
		}
	}


	/**
	 * 
	 */
	@Override
	public String listTitle() {
		return this.title;
	}

	/**
	 * 
	 */
	@Override
	public int size() {
		return this.listeActions.size();
	}

	/**
	 * 
	 */
	@Override
	public boolean addAction(Action ac) {
		return this.addAction(ac);
	}

	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo () {
		Scanner lect ;

		lect = new Scanner (System.in );

		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile � stocker mais ... 
	}

}
