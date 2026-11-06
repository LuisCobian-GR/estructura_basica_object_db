
package mx.edu.tecmm.elgrullo.proyectobasedboo.view;

import mx.edu.tecmm.elgrullo.proyectobasedboo.controller.ProductoController;
import mx.edu.tecmm.elgrullo.proyectobasedboo.model.Producto;

/**
 *
 * @author coby_
 */
public class ProductosView {
    
    public void registroProductos(){
        var producto = new Producto(); 
        producto.setCodigobarras("002");
        producto.setDescripcion("Pepe Tron");
        producto.setPrecio(200); 
        producto.setEstaActivo(true);
        System.out.println(producto);
        var controladorProducto = new ProductoController(); 
        var res = controladorProducto.registrarProducto(producto);
        System.out.println("Resultado es " + res);
    }
    
    public void listado(){
        var controlador = new ProductoController();
        var listado = controlador.consultarTodos();
        listado.forEach(System.out::println);
    }
    
}
