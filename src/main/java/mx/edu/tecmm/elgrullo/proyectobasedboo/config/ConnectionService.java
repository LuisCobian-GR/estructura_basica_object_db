/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.proyectobasedboo.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author coby_
 */
public class ConnectionService {
    
    
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PapeleriaPU");
    
    public static EntityManager getEntityManager(){
        EntityManager em = emf.createEntityManager();
        return em; 
    }
    
    public static void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
