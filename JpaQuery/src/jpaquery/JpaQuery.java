
package jpaquery;

import negocio.EjbBdd;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class JpaQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjbBdd bdd = new EjbBdd();
        bdd.nuevo("Diego", "Libro1");
        bdd.nuevo("Vero", "Libro2");
        bdd.nuevo("Vero", "Libro3");
        System.out.println(bdd.todos());
        bdd.cambia(1, "Ana", "Libro4");
        System.out.println(bdd.todos());
        System.out.println(bdd.algunos("Vero"));
    }
    
}
