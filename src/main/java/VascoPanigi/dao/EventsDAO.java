package VascoPanigi.dao;

import VascoPanigi.entities.Concert;
import VascoPanigi.entities.Event;
import VascoPanigi.exceptions.EventNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

public class EventsDAO {

    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("The event " + event.getTitle() + " has been added. Yippieee :D");
    }

    public Event findById(UUID eventId) {
        Event event = em.find(Event.class, eventId);
        if (event == null) throw new EventNotFoundException(eventId);
        return event;
    }

    public void findByIdAndDelete(UUID eventId) {
        Event found = this.findById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The event " + found.getTitle() + " has been eliminated from our system!");
    }

//    public Concert getConcertsInStreaming(){
//        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c", Concert.class); // SELECT * FROM animals WHERE tipo_animale = 'Cane' (Per la single table)
//
//        if (concert == null) throw new EventNotFoundException(concertId);
////        "SELECT e FROM Evento e WHERE e.inStreaming = :inStreaming"
//
//
//        return concert;
//    }

//    TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE c.genre = :genre", Concert.class);
}
