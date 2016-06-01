
package negocio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import persistencia.Libro;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class EjbBdd {
    private final EntityManager em  = Persistence.createEntityManagerFactory("HolaLibroPU").createEntityManager();
    
    public Libro nuevo(String autor, String titulo) {
        Libro libro = new Libro();
        libro.setAutor(autor);
        libro.setTitulo(titulo);
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        return libro;
    }

    public Libro cambia(long id, String autor, String titulo) {
        Libro libro = em.find(Libro.class, id);
        if(libro == null) {
            libro = nuevo(autor, titulo);
        } else {
            libro.setAutor(autor);
            libro.setTitulo(titulo);
            em.merge(libro);            
        }
        return libro;
    }
    
    public List<Libro> todos() {
        Query q = em.createNamedQuery("todos");
        //Query q = em.createQuery("select l from Libro l", Libro.class);//Equivalente !
        return q.getResultList();
    }

    public List<Libro> algunos(String par) {
        Query q = em.createNamedQuery("algunos");
        q.setParameter("par1", "%" + par + "%");
        return q.getResultList();
    }

}
