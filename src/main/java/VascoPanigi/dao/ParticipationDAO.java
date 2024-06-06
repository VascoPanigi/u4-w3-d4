package VascoPanigi.dao;

import VascoPanigi.entities.Location;
import VascoPanigi.entities.Participation;
import VascoPanigi.exceptions.EventNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ParticipationDAO {

    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation participation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(participation);
        transaction.commit();
        System.out.println("The participation with id " + participation.getParticipation_id() + "for the event "+ participation.getEvent().getTitle()+ " has been added. Yippieee :D");
    }

    public Participation findById(UUID Id) {
        Participation participation = em.find(Participation.class, Id);
        if (participation == null) throw new EventNotFoundException(Id);
        return participation;
    }

    public void findByIdAndDelete(UUID Id) {
        Participation found = this.findById(Id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The participation with id " + found.getParticipation_id() + "for the event "+ found.getEvent().getTitle()+" has been eliminated from our system!");
    }
}
