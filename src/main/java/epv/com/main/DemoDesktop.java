/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package epv.com.main;

import epv.com.main.modelo.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class DemoDesktop {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNombres("Pancracion Luis");
        cliente.setApellidos("Ramirez Gonzales");
        cliente.setCiudad("Cali");
        cliente.setDireccion("Calle 36 No 5-2");
        cliente.setDni("522656329565656");
        cliente.setEmail("pancracion@gmail.com");
        cliente.setNumCelular("322560225");
        cliente.setTelefono("4552526");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("up_apirest");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            em.close();

        }

        System.out.println("Hello World!");
    }
}
