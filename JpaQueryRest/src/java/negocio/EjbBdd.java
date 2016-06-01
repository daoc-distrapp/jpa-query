/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import persistencia.Libro;

/**
 *
 * @author dordonez
 */
@Stateless
public class EjbBdd {
    @PersistenceContext(unitName="JpaQueryPU")
    EntityManager em;
    
    public Libro nuevo(String autor, String titulo) {
        Libro libro = new Libro();
        libro.setAutor(autor);
        libro.setTitulo(titulo);
        em.persist(libro);
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
