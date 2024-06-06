package VascoPanigi;

import VascoPanigi.dao.EventsDAO;
import VascoPanigi.entities.Event;
import VascoPanigi.enums.EventType;
import VascoPanigi.exceptions.EventNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d2");

    public static void main(String[] args) {
//        EntityManager em = emf.createEntityManager();
//        EventsDAO sd = new EventsDAO(em);
//        Event event1 = new Event(5, EventType.PRIVATE, "dinner with obama", LocalDate.of(2024, 5, 13), "dinner");
//        Event event2 = new Event(300, EventType.PUBLIC, "stare at walls session", LocalDate.of(2029, 5, 13), "stare a wall together");
//
////        sd.save(event1);
////        sd.save(event2);
//
//        try {
//            Event event = sd.findById(252);
//            System.out.println(event);
//        } catch (EventNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            sd.findByIdAndDelete(303);
//            System.out.println("Event eliminated. :(");
//        } catch (EventNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }


        System.out.println("YIPPIEEEE :DDDDD");

    }
}
