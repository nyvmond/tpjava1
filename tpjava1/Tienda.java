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

    //Voy a hardcodear un producto a la lista
    Bebidas bebida = new Bebidas("ab123", "agua", 10, 10, false, 0, false, true, 5);
    

    public void compraDeProducto(Producto producto, int cant, String id){
        //Si no hay nada en la primer posicion de la lista agrego el producto
        if(this.productosEnStock.size()==0){
            System.out.println("Size de Lista igual a Cero");
            this.productosEnStock.add(producto);
            //Luego recorro lo que hay y lo imprimo en pantalla
            for (Producto p : this.productosEnStock) {
                System.out.println("DATOS: \n");
                System.out.println("ID: "+p.getId()+"\n");
                System.out.println("Descripcion: "+p.getDescription() + "\n");
                System.out.println("Cantidad en Stock: "+p.getCantidadEnStock() + "\n");
            }
            //boolean existe = false;
            //System.out.println("Imprimo el String que me pasan por param aca: "+id+"\n");
            //System.out.println("Voy a comprar el get.id con el id de paran: \n");
            //boolean comparacion = false;
//            if(productosEnStock.get(0).getId().equals(id)){
//                System.out.println("Dio Igual");
//            }else{
//                System.out.println("No dio igual");
//            }
//        boolean existe = productoExiste(id);
//        if(!existe){
//            productosEnStock.add(producto);
//            System.out.println("Tiene cantidad de productos en stock SI NO EXISTE: "
//                    + productosEnStock.get(0).getCantidadEnStock());
//        }else if(existe){
//            agregarStock(cant, id);
//            System.out.println("Tiene cantidad de productos en stock SI EXISTE: "
//                    + productosEnStock.get(0).getCantidadEnStock());
//        }
//            System.out.println("Entrando a Compra de producto");
//            //descontar de caja el saldo que estoy gastando
//            //avisar que se compro tal producto con exito - agregar datos del producto
//            System.out.println("Se ha comprado el producto con exito");
        //Aca comparo si ya existe en la primer posicion el id que entro por param:
        }else if(this.productosEnStock.size()>=1){
            if(this.productosEnStock.get(0).getId().equals(id)){
                System.out.println("Entro un codigo igual");
            }else{
                System.out.println("Entro codigo distinto");
            }

        }else{
            System.out.println("Validacion de que size no es mayor o igual a 1");
        }




    }//TERMINA COMPRA DE PRODUCTO


    public void recorrerLista(){
        for(Producto valor:productosEnStock){
            System.out.println("En La Lista Tenemos el siguiente id: " +valor.getId());
        }
    }

    //Validacion si existe el producto
    public boolean productoExiste(String id){
        for(Producto valor:productosEnStock){
            System.out.println(valor + "VALORRRR");
            System.out.println("EL ID EN EL ARRAY: "+valor.getId());
            if(valor.getId().equals(id)){
                System.out.println("valor.getId(): "+valor.getId());
                System.out.println("Id: "+id);
                return true;
            }
        }
        return false;
    }
    //Agregar stock a un producto
    public void agregarStock(int cant, String id){
        for(Producto valor:productosEnStock){
            System.out.println("EL ID EN EL ARRAY: "+valor.getId());
            if(valor.getId().equals(id)){

                valor.setCantidadEnStock(valor.getCantidadEnStock()+cant);
            }
        }
    }

    //Validacion saldo en caja suficiente para abastecerme de productos
    public boolean saldoEnCajaParacomprar(int cant, float costoPorUnidad, float saldoEnCaja){
        if(cant*costoPorUnidad <= saldoEnCaja){
            return true;
        }
        return false;
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
