package persistance.client;

import entity.Client;
import entity.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class ClientPersistance {
	public static void main(String[] args) {


		// 'pu' nom de l'unité de persistance
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			// Instance clientOne
			Client clientOne = new Client("Duboit", "Bob", "10 rue alexandre", "35000", "Rennes", 061107653);
			Compte compteOne = new Compte(1000.0);
			Compte comptetwo = new Compte(9000.0);

			// Association clientOne and his Accounts
			clientOne.addCompte(compteOne);
			clientOne.addCompte(comptetwo);

			// Instance clientTwo and his Accounts
			Client clientTwo = new Client("Max", "Maxi", "12 rue blop", "75000", "paris", 061107653);
			Compte compteThree = new Compte(10000.0);
			Compte compteFour = new Compte(120000.0);

			// Association clientTwo and his Accounts
			clientTwo.addCompte(compteThree);
			clientTwo.addCompte(compteFour);

			// Save my instances in DB
			em.persist(clientOne);
			em.persist(clientTwo);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}

