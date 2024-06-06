package VascoPanigi.dao;

import VascoPanigi.entities.Individual;
import VascoPanigi.exceptions.EventNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class IndividualDAO {

    private final EntityManager em;

    public IndividualDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Individual individual) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(individual);
        transaction.commit();
        System.out.println("The individual " + individual.getName() + " has been added. Yippieee :D");
    }

    public Individual findById(UUID individualId) {
        Individual individual = em.find(Individual.class, individualId);
        if (individual == null) throw new EventNotFoundException(individualId);
        return individual;
    }

    public void findByIdAndDelete(UUID individualId) {
        Individual found = this.findById(individualId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The individual " + found.getName() + " has been eliminated from our system!");
    }
}
