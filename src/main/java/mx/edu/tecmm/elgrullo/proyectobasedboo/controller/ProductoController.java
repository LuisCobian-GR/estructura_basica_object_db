/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.proyectobasedboo.controller;

import java.util.List;
import mx.edu.tecmm.elgrullo.proyectobasedboo.model.Producto;
import mx.edu.tecmm.elgrullo.proyectobasedboo.repository.ProductoRepository;

/**
 *
 * @author coby_
 */
public class ProductoController {
    
    public boolean registrarProducto(Producto producto) {
        
        boolean resultado = ProductoRepository.add(producto);
        if (resultado) {
            System.out.println("Producto registrado correctamente");
        } else {
            System.out.println("No se pudo registrar el producto");
        }
        return resultado;
    }
    
    public List<Producto> consultarTodos(){
        var listado = ProductoRepository.findAll();
        return listado;
    }
}
