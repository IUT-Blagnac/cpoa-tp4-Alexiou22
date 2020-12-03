import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import application.AccesAgenceBancaire;
import application.ActionListAB;
import application.action.ActionListeDesComptes;
import application.action.ActionVoirCompteNumero;
import banque.AgenceBancaire;

/**
 * @author Alexia
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//creation
		String title;
		String message;
		List<Action> listeActions;
		AgenceBancaire monAg;
		Scanner lect;
		String valeur;
		boolean continu;
		boolean erreur;
		int i;
		int j;
		

		//initialisation
		listeActions = new ArrayList<Action>();
		monAg = AccesAgenceBancaire.getAgenceBancaire();
		listeActions.add(new ActionListeDesComptes());
		listeActions.add(new ActionVoirCompteNumero());
		listeActions.add(new ActionListAB(monAg,"3"));
		listeActions.add(new ActionListAB(monAg,"4"));
		lect = new Scanner ( System.in );

		//savoir si on quite le programe ou pas
		continu = true;

		while (continu == true) {
			
			//erreur
			erreur = true;

			//affichage
			title = "Agence " + monAg.getNomAgence()+ " de " +monAg.getLocAgence();
			message = "Menu G�n�ral";
			System.out.println("--");
			System.out.println(title);
			System.out.println(message);
			System.out.println("--");
			System.out.println("  Choisir :");

			for(j=0; j < listeActions.size(); j++){
				System.out.println(listeActions.get(j).actionMessage());
			}

			System.out.println("\n 0 - Pourquitter ce menu");

			//le choix
			System.out.println("\n Votre choix");
			lect.useLocale(Locale.US);
			valeur = lect.next();
			
			//quel choix choisi
			if (valeur.equals("0")) {
				System.out.println("ByeBye");
				ActionListAB.tempo();
				continu = false;
				erreur = false;
				System.exit(1);
			}else{

				for (i = 0; i< listeActions.size(); i++) {
					if (listeActions.get(i).actionCode().equals(valeur)) {
					try {
							listeActions.get(i).execute(monAg);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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

}
