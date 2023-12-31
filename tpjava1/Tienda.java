package tpjava1;

import java.util.*;

public class Tienda {
    String nombre;
    final int MAX_PRODUCTOS_EN_STOCK = 500;
    float saldoEnCaja;
    List<Producto> productosEnStock = new ArrayList<>();

    public Tienda(String nombre, float saldoEnCaja) {
        this.nombre = nombre;
        this.saldoEnCaja = saldoEnCaja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMAX_PRODUCTOS_EN_STOCK() {
        return MAX_PRODUCTOS_EN_STOCK;
    }

    public float getSaldoEnCaja() {
        return saldoEnCaja;
    }

    public void setSaldoEnCaja(float saldoEnCaja) {
        this.saldoEnCaja = saldoEnCaja;
    }

    public List<Producto> getProductosEnStock() {
        return productosEnStock;
    }

    public void setProductosEnStock(List<Producto> productosEnStock) {
        this.productosEnStock = productosEnStock;
    }
    Scanner sc = new Scanner(System.in);
    float saldoGastado = 0;

    //La cantidad que entra por param viene en el producto tmb asi como el id, habria que sacar ese param
    public void compraDeProducto(Producto producto, int cant, String id){

        boolean nuevoProducto = false;
        //Si no hay nada en la primer posicion de la lista agrego el producto
        if(this.productosEnStock.size()==0){
            System.out.println("El store se encontraba vacio.");
            this.productosEnStock.add(producto);
            //Luego recorro lo que hay y lo imprimo en pantalla
            //Tambien actualizo saldo en caja
            for (Producto p : this.productosEnStock) {
                System.out.println("Se agrego el siguiente producto al store: \n");
                System.out.print("ID: "+p.getId()+"\n");
                System.out.print("Descripcion: "+p.getDescription() + "\n");
                System.out.print("Cantidad en Stock: "+p.getCantidadEnStock() + "\n");
                //Manejo saldo en caja
                saldoGastado = saldoAGastar(cant, p.getCostoPorUnidad());
                setSaldoEnCaja(getSaldoEnCaja()-saldoGastado);
                System.out.print("Saldo en caja restante: "+getSaldoEnCaja()+"\n");
            }
        //Caso en el cual ya existe algo en el Store:
        }//FIN SIZE LISTA = 0
        else if(this.productosEnStock.size()>=1) {
            //Hago una busqueda y utilizo una bandera para saber si ya existe ese producto.
            //1. Manejo el stock
            //2. Manejo saldo en caja
            //3. Imprimo datos del producto
            for(Producto p: this.productosEnStock){
                if (p.getId().equals(id)) {
                    nuevoProducto = false;
                }else{
                    nuevoProducto = true;
                }
            }
                if (!nuevoProducto) {
                    producto.setCantidadEnStock(producto.getCantidadEnStock() + cant);
                    System.out.println("Este producto ya existe, se agrega nuevo stock al mismo: \n");
                    System.out.print("Id: " + producto.getId() + "\n");
                    System.out.print("Descripcion: " + producto.getDescription() + "\n");
                    //Imprimo la cantidad en stock
                    System.out.print("Cantidad en stock actual: " + producto.getCantidadEnStock());
                    //Saldo en Caja
                    saldoGastado = saldoAGastar(cant, producto.getCostoPorUnidad());
                    System.out.print("saldo Gastado: " + saldoGastado);
                    setSaldoEnCaja(getSaldoEnCaja() - saldoGastado);
                    System.out.print("Saldo en caja restante para futuras operaciones: " + getSaldoEnCaja() + "\n");
                }
               if(nuevoProducto){
                   System.out.println("El producto que esta ingresando no existia en el Store");
                   this.productosEnStock.add(producto);
                   System.out.println("Se agrego el siguiente producto al store: \n");
                   System.out.print("ID: "+producto.getId()+"\n");
                   System.out.print("Descripcion: "+producto.getDescription() + "\n");
                   System.out.print("Cantidad en Stock: "+producto.getCantidadEnStock() + "\n");
                   //Manejo saldo en caja
                   saldoGastado = saldoAGastar(cant, producto.getCostoPorUnidad());
                   setSaldoEnCaja(getSaldoEnCaja()-saldoGastado);
                   System.out.print("Saldo en caja restante: "+getSaldoEnCaja()+"\n");
               }
        }
    }////TERMINA COMPRA DE PRODUCTO

    //Validacion saldo en caja suficiente para abastecimiento del Store
    public boolean saldoEnCajaParacomprar(int cant, float costoPorUnidad){
        if(cant*costoPorUnidad <= this.saldoEnCaja){
            return true;
        }
        return false;
    }

    //Cuanto gaste en abastecer mi store
    public float saldoAGastar(int cant, float costoPorUnidad){
        return cant * costoPorUnidad;
    }

    public void ventaDeProducto(){
        //eliminar de stock de producto en el array el producto vendido
        //agregar saldo en caja
        //avisar que se realizo venta con exito - agregar datos del producto
        System.out.println("Se ha realizado la venta con exito");
    }

    /*
    TODO
    Metodo para recorrer array y traer algunos datos
    Metodo para que busque un prod en particular y me diga el stock y precio
    */

    public void verProductos(){
        if(this.productosEnStock.size()>0){
            for (Producto p : this.productosEnStock) {
                System.out.println("Detalle de producto: \n");
                System.out.print("ID: " + p.getId() + "\n");
                System.out.print("Descripcion: " + p.getDescription() + "\n");
                System.out.print("Precio: " + p.getPrecioPorUnidad() + "\n");
                System.out.print("Cantidad en Stock: " + p.getCantidadEnStock() + "\n");
            }
        }else{
            System.out.println("No hay productos en el Store, lo sentimos mucho!");
        }

    }

    public boolean busquedaProducto(String id){
        if(this.productosEnStock.size()>0){
            for (Producto p : this.productosEnStock) {
                if(p.getId().equals(id)){
                    System.out.println("Hay "+p.getCantidadEnStock()+" unidades del producto "+p.getDescription());
                    return true;
                }else{
                    System.out.println("No hay del producto solicitado disponible");
                    return false;
                }
            }
        }else{
            System.out.println("No hay productos en el Store, lo sentimos mucho!");
            return false;
        }
        return false;
    }

    public void compraDeProducto(String id, int cant){
        if(this.productosEnStock.size()>0){
            for (Producto p : this.productosEnStock) {
                if(p.getId().equals(id)){
                    int cantActual = p.getCantidadEnStock();
                    p.setCantidadEnStock(cantActual-cant);
                    System.out.println("Quedan en stock: "+p.getCantidadEnStock());
                    float saldoGastado = p.getPrecioPorUnidad()*cant;
                    this.saldoEnCaja += saldoGastado;
                    System.out.println("Usted gasto "+saldoGastado);
                }else{
                    System.out.println("No hay del producto solicitado disponible");
                }
            }
        }else{
            System.out.println("No hay productos en el Store, lo sentimos mucho!");
        }
    }



}
