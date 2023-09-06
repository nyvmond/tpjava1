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

        //Si no hay nada en la primer posicion de la lista agrego el producto
        if(this.productosEnStock.size()==0){
            System.out.println("El store se encontraba vacio.");
            this.productosEnStock.add(producto);
            //Luego recorro lo que hay y lo imprimo en pantalla
            //Tambien actualizo saldo en caja
            for (Producto p : this.productosEnStock) {
                System.out.println("Se agrego el siguiente producto al store: \n");
                System.out.println("ID: "+p.getId()+"\n");
                System.out.println("Descripcion: "+p.getDescription() + "\n");
                System.out.println("Cantidad en Stock: "+p.getCantidadEnStock() + "\n");
                //Manejo saldo en caja
                saldoGastado = saldoAGastar(cant, p.getCostoPorUnidad());
                setSaldoEnCaja(getSaldoEnCaja()-saldoGastado);
                System.out.println("Saldo en caja restante: "+getSaldoEnCaja()+"\n");
            }

        //Comparo si ya existe el id que entro por paramcontra algun obj en la lista:
        }else if(this.productosEnStock.size()>=1){
            //Hago una busqueda y si existe el id
            //1. Manejo el stock
            //2. Manejo saldo en caja
            //3. Imprimo datos del producto
            for (Producto p : this.productosEnStock) {
                if(p.getId().equals(id)){
                    p.setCantidadEnStock(p.getCantidadEnStock()+cant);
                    System.out.println("Este producto ya existia, se agrega nuevo stock al mismo: \n");
                    System.out.println("Id: "+p.getId()+"\n");
                    System.out.println("Descripcion: "+p.getDescription() + "\n");
                    //Imprimo la cantidad en stock
                    System.out.println("Cantidad en stock actual: "+p.getCantidadEnStock());
                    //Saldo en Caja
                    saldoGastado = saldoAGastar(cant, p.getCostoPorUnidad());
                    System.out.println("saldo Gastado: "+saldoGastado);
                    setSaldoEnCaja(getSaldoEnCaja()-saldoGastado);
                    System.out.println("Saldo en caja restante para futuras operaciones: "+getSaldoEnCaja()+"\n");
                }else{
                    //Contemplo que el storage no este vacio pero entro otro id de producto

                }
            }

        }else{
            System.out.println("Validacion de que size no es mayor o igual a 1");
        }

    }//TERMINA COMPRA DE PRODUCTO


    //Validacion saldo en caja suficiente para abastecerme de productos
    public boolean saldoEnCajaParacomprar(int cant, float costoPorUnidad){
        if(cant*costoPorUnidad <= this.saldoEnCaja){
            return true;
        }
        return false;
    }

    //Cuanto gaste para abastecimiento de compra
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
    VALIDACION ID: BEBIBLES / ENVASADOS / LIMPIEZA
    */

    /*
    TODO
    VALIDACION SALDO EN CAJA MENOR QUE LO QUE QUIERO ABASTECER
     */

    /*
    TODO
    VALIDACION SI EL ITEM EXISTE TENGO QUE AGREGAR AL ATRIBUTO STOCK
    PARA ESTO DEBO REALIZAR UNA BUSQUEDA EN MI ARRAY
     */
}
