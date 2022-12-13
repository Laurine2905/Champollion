package champollion;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	@Test
	public void testHeuresPrevues() {
		untel.ajouteEnseignement(uml, 0, 10, 0);
		untel.ajouteEnseignement(uml, 5, 0, 2);
		untel.ajouteEnseignement(java, 1, 1, 1);
		assertEquals((int) (6 * 1.5 + 11 + 3 * 0.75), untel.heuresPrevues());
	}

	@Test
	public void testHeuresPrevuesUE() {
		try {
			untel.heuresPrevuesPourUE(null);
		} catch (IllegalArgumentException e) {

		}

		untel.ajouteEnseignement(uml, 0, 10, 0);
		untel.ajouteEnseignement(uml, 5, 0, 2);
		untel.ajouteEnseignement(java, 1, 1, 1);
		assertEquals((int) (5 * 1.5 + 10 + 2 * 0.75), untel.heuresPrevuesPourUE(uml));
	}

	@Test
	public void testSousService() {
		assertTrue(untel.enSousService());
		untel.ajouteEnseignement(uml, 0, 100, 0);
		untel.ajouteEnseignement(uml, 50, 0, 20);
		untel.ajouteEnseignement(java, 10, 10, 10);
		assertFalse(untel.enSousService());
	}

	@Test
	public void testAjoutIntervention() throws IllegalArgumentException {
		try {
			untel.ajouteIntervention(null);
		} catch (IllegalArgumentException e) {

		}
		Intervention i = new Intervention(new Date(), 0, 0, java, new Salle("test", 10), TypeIntervention.TP, untel);
		untel.ajouteIntervention(i);
	}

	@Test
	public void testAjoutEnseignement() {
		try {
			untel.ajouteEnseignement(null, 0, 10, 0);
		} catch (IllegalArgumentException e) {

		}
		untel.ajouteEnseignement(uml, 0, 100, 0);
	}

	@Test
	public void testResteAPlanifier() {
		untel.ajouteEnseignement(uml, 0, 10, 0);
		untel.ajouteEnseignement(uml, 5, 0, 2);
		untel.ajouteEnseignement(java, 1, 1, 1);

		Intervention i = new Intervention(new Date(), 9, 0, uml, new Salle("test", 10), TypeIntervention.TD, untel);
		untel.ajouteIntervention(i);

		Intervention i2 = new Intervention(new Date(), 2, 0, uml, new Salle("test2", 10), TypeIntervention.TP, untel);
		untel.ajouteIntervention(i2);

		Intervention i3 = new Intervention(new Date(), 6, 0, uml, new Salle("test3", 10), TypeIntervention.CM, untel);
		untel.ajouteIntervention(i3);

		try {
			untel.resteAPlanifier(null, null);
		} catch (IllegalArgumentException e) {

		}

		assertEquals(1, untel.resteAPlanifier(uml, TypeIntervention.TD));
		assertEquals(-1, untel.resteAPlanifier(uml, TypeIntervention.CM));
		assertEquals(0, untel.resteAPlanifier(uml, TypeIntervention.TP));
	}
}
