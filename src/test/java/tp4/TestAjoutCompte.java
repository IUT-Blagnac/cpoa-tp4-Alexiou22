/**
 * 
 */
package tp4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.ABCompteDejaExistantException;
import banque.exception.ABCompteNullException;

/**
 * @author Alexia
 *
 */
class TestAjoutCompte {

	@Test
	void testAjout() {
		AgenceBancaire ag = new AgenceBancaire("Leguevin","Leguevin" );
		Compte vraieCompte;
		Compte testCompte = null;
		
		vraieCompte = new Compte("01020304", "Alexia");
		
		try {
			ag.addCompte(new Compte("01020304","Alexia"));
			testCompte = ag.getCompte("01020304");
		} catch (ABCompteNullException e) {
			e.printStackTrace();
		} catch (ABCompteDejaExistantException e) {
			e.printStackTrace();
		}
				
		assertEquals(vraieCompte.toString(), testCompte.toString());
		
	}

}
