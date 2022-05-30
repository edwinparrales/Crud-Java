/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package epv.com.main.controlador;

import epv.com.main.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Administrador
 */
public class ClienteController {

    private Cliente cliente;
    private EntityManagerFactory emf;
    private EntityManager em;
    private String mensaje;
   

    public ClienteController() {
        emf = Persistence.createEntityManagerFactory("up_apirest");
        em = emf.createEntityManager();
        
    }

    public void guardar(Cliente cliente) {
        this.cliente = cliente;
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            this.mensaje = "Cliente guardado con exito";
        } catch (Exception e) {
            this.mensaje = e.getMessage();

        } finally {
            em.close();

        }

    }

    public List<Cliente> listar() {
         List<Cliente> clientestmp=new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<Cliente> lista = em.createNamedQuery("Cliente.findAll", Cliente.class);
            clientestmp = lista.getResultList();
            
           
        } catch (Exception e) {
            this.mensaje = e.getMessage();

        } finally {
            //em.close();
        

        }
        
   clientestmp.forEach((c)->{
       
       System.err.println("err"+c.toString());
   });
      
      return  clientestmp;
        
    }

    public String getMensaje() {
        return mensaje;
    }

}
