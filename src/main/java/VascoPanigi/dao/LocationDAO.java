package VascoPanigi.dao;

import VascoPanigi.entities.Individual;
import VascoPanigi.entities.Location;
import VascoPanigi.exceptions.EventNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {


    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("The location " + location.getLocation_name() + " has been added. Yippieee :D");
    }

    public Location findById(UUID Id) {
        Location location = em.find(Location.class, Id);
        if (location == null) throw new EventNotFoundException(Id);
        return location;
    }

    public void findByIdAndDelete(UUID Id) {
        Location found = this.findById(Id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The location " + found.getLocation_name() + " has been eliminated from our system!");
    }
}
