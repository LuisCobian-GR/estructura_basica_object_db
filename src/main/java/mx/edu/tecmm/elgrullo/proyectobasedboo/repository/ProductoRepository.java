/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.proyectobasedboo.repository;

import java.util.ArrayList;
import java.util.List;
import mx.edu.tecmm.elgrullo.proyectobasedboo.config.ConnectionService;
import mx.edu.tecmm.elgrullo.proyectobasedboo.model.Producto;

/**
 *
 * @author coby_
 */
public class ProductoRepository {
    
     /**
     * Metodo que permite modificar los valores del producto 
     * @param producto datos del producto
     * @return 
     */
    public static boolean update(Producto producto){
        var isSuccess = false; 
        var em = ConnectionService.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(producto); 
            em.getTransaction().commit();
            isSuccess = true; 
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            isSuccess = false; 
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally{
            em.close();
        }     
        return isSuccess;
    }
    
    /**
     * Metodo que sirve para buscar un producto 
     * @param id clave del producto 
     * @return 
     */
    public static Producto find(long id){
        Producto producto = null; 
        var em = ConnectionService.getEntityManager(); 
        try {
            producto = em.find(Producto.class, id);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            em.close();
        }        
        return producto;
    }
    
    
    /**
     * Metodo para agregar un nuevo producto a la base de datos
     * @param producto es el objeto con los valores
     * @return 
     */
    public static boolean add(Producto producto){
        var isSuccess = false;         
        var em = ConnectionService.getEntityManager();
        try {           
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            isSuccess = true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            isSuccess = false; 
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally{
            em.close();
        }        
        
        return isSuccess;
    }
    
    /**
     * Metodo para traerme todos los productos de la base de datos 
     * @return 
     */
    public static List<Producto> findAll(){
        var em = ConnectionService.getEntityManager(); 
        List<Producto> listaProductos; 
        try {
            var query = em.createQuery("SELECT p FROM Producto p WHERE p.estaActivo", Producto.class);
            listaProductos = query.getResultList();
        } catch (Exception e) {
            listaProductos = new ArrayList<>();
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            em.close();
        }        
        return listaProductos;
    }
    
}
