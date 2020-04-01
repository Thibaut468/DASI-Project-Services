package fr.insalyon.dasi.ihm.console;

import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DASI Team
 */
public class MainMedium {

    public static void main(String[] args) {

        // TODO : Pensez à créer une unité de persistance "DASI-PU" et à vérifier son nom dans la classe JpaUtil
        // Contrôlez l'affichage du log de JpaUtil grâce à la méthode log de la classe JpaUtil
        JpaUtil.init();

        initialiserMediums();            // Question 3
        //testerInscriptionClient();       // Question 4 & 5
        //testerRechercheClient();         // Question 6
        //testerListeClients();            // Question 7
        //testerAuthentificationClient();  // Question 8
        //saisirInscriptionClient();       // Question 9
        //saisirRechercheClient();

        JpaUtil.destroy();
    }

    public static void afficherMedium(Medium medium) {
        System.out.println("-> " + medium);
    }

    public static void initialiserMediums() {
        
        System.out.println();
        System.out.println("**** initialiserMediums() ****");
        System.out.println();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DASI-PU");
        EntityManager em = emf.createEntityManager();

        Medium gwenaëlle = new Spirite("Gwenaëlle", false, "Spécialiste des grandes conversations au-delà de TOUTES les frontières", "Boule de cristal");
        Medium tran = new Spirite("Professeur Tran", true, "Votre avenir est devant vous : regardons-le ensemble !", "Marc de café, boule de cristal, oreilles de lapin");
        
        Medium irma = new Cartomancien("Mme Irma", false, "Comprenez votre entourage grâce à mes cartes ! Résultats rapides.");
        Medium endora = new Cartomancien("Endora", false, "Mes cartes répondront à toutes vos questions personnelles.");
        
        Medium serena = new Astrologue("Serena", false, "Basée à Champigny-sur-Marne, Serena vous révèlera votre avenir pour éclairer votre passé", "Ecole Nationale Supérieure d'Astrologie (ENS-Astro)",2006);
        Medium m = new Astrologue("Mr M", true, "Avenir, avenir, que nous réserves-tu ? N'attendez plus, demandez à me consulter!", "Institut des Nouveaux Savoirs Astrologiques", 2010);
        
        System.out.println();
        System.out.println("** Médium avant persistance: ");
        
        afficherMedium(gwenaëlle);
        afficherMedium(tran);
        afficherMedium(irma);
        afficherMedium(endora);
        afficherMedium(serena);
        afficherMedium(m);
        
        System.out.println();

        try {
            em.getTransaction().begin();
            em.persist(gwenaëlle);
            em.persist(tran);
            em.persist(irma);
            em.persist(endora);
            em.persist(serena);
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
            em.close();
        }

        System.out.println();
        System.out.println("** Médiums après persistance: ");
        afficherMedium(gwenaëlle);
        afficherMedium(tran);
        afficherMedium(irma);
        afficherMedium(endora);
        afficherMedium(serena);
        afficherMedium(m);
        System.out.println();
    }
}