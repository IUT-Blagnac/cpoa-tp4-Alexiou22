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
	public ActionListAB(AgenceBancaire ag, String code, String mess, String titre) {

		this.listeActions = new ArrayList<Action>();
		this.message = mess;
		this.code = code;
		this.title = titre;

	}

	/**
	 * 
	 */
	public String actionMessage() {
		return this.message;
	}

	/**
	 * 
	 */
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

	public String listTitle() {
		return this.title;
	}

	/**
	 * 
	 */

	public int size() {
		return this.listeActions.size();
	}

	/**
	 * 
	 */

	public boolean addAction(Action ac) {

		listeActions.add(ac);
		return true;
	}

	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caractère.
	 */
	public static void tempo () {
		Scanner lect ;

		lect = new Scanner (System.in );

		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile à stocker mais ... 
	}



}
