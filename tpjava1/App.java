package tpjava1;

import com.sun.security.jgss.GSSUtil;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int eleccionPrincipal;
        int eleccionTipoProducto;
        int eleccion;
        boolean fincompra = false;
        Scanner sc = new Scanner(System.in);

        do{
            //Codigo
            System.out.println("Bienvenido");
            System.out.println("1 para compra - 2 para venta");
            eleccionPrincipal = sc.nextInt();

            if(eleccionPrincipal == 1){
                System.out.println("Que desea comprar?");
                System.out.println("1- Bebidas \n 2- Envasados \n 3. Limpieza");
                eleccionTipoProducto = sc.nextInt();
                //////////////////////////////////////////////////////////////////////////
                //BEBIDAS
                if(eleccionTipoProducto == 1){
                    System.out.println("Ingrese codigo de producto");
                    String id = sc.next();
                    System.out.println("Ingrese descripcion");
                    String descripcion = sc.next();
                    System.out.println("Ingrese Cantidad de productos a comprar");
                    int cantidadDeProducto = sc.nextInt();
                    System.out.println("Ingrese Precio Por Unidad");
                    //A que precio lo vendo como comerciante
                    float precioPorUnidad = sc.nextFloat();
                    System.out.println("Ingrese Costo por Unidad");
                    //A que precio lo compro como comerciante
                    float costoPorUnidad = sc.nextFloat();
                    System.out.println("Ingrese 1 si es alcoholica");
                    eleccion = sc.nextInt();
                    boolean esAlcoholica = false;
                    float graduacionAlcoholica = 0;
                    if(eleccion == 1){
                        esAlcoholica = true;
                        System.out.println("Ingrese Graduacion Alcoholica: ");
                        graduacionAlcoholica = sc.nextFloat();
                    }
                    System.out.println("Ingrese 1 si es importada");
                    eleccion = sc.nextInt();
                    boolean esImportada = false;
                    if(eleccion == 1){
                        esImportada = true;
                    }
                    System.out.println("Se encuentra disponible para la venta? SI");
                    boolean disponibleParaLaVenta = true;

                    //Hasta aca hago una nueva bebida y le pase por params lo que el usuario ingreso
                    Bebidas bebida = new Bebidas(id, descripcion, precioPorUnidad,costoPorUnidad,
                            esAlcoholica,graduacionAlcoholica,esImportada, disponibleParaLaVenta, cantidadDeProducto);

                    ///////////////////////CAJA//////////////////////////////////
                    //Consulto por el nombre de la Tienda y saldo en caja
                    System.out.println("Ingrese nombre de la tienda: ");
                    String nombreTienda = sc.next();
                    System.out.println("Ingrese monto en caja: ");
                    float saldoEnCaja = sc.nextFloat();

                    //Instancio Tienda para utilizar los metodos
                    Tienda productoTienda = new Tienda(nombreTienda, saldoEnCaja);
                    //Valido si saldo en caja es suficiente para abastecerme
                    boolean puedoAbastecerme = productoTienda.saldoEnCajaParacomprar(cantidadDeProducto,
                            costoPorUnidad,saldoEnCaja);
                    //puedoAbastecerme resulta en true
                    //boolean productoExiste = false;

                    if(puedoAbastecerme){
                        productoTienda.compraDeProducto(bebida, cantidadDeProducto, id);
//                        productoExiste = productoTienda.productoExiste(id);
                        //System.out.println("Producto Existe??? "+productoExiste);
                        //No existe
//                        if(productoExiste){
//                            System.out.println("Existo");
//                            //Siempre me da false
//                            //El flujo es que si existe hay que agregar en el stock
//                            //Quizas es porque tengo que acceder mediante el setter?
//                            productoTienda.agregarStock(cantidadDeProducto, id);
//                        }else{
//                            System.out.println("No existo");
//                            //Si no existe hago la compra de producto
//                            productoTienda.compraDeProducto(bebida, cantidadDeProducto, id);
//                        }


                    }else{
                        System.out.println("No dispone de saldo suficiente para abastecerse.");
                    }

                } //Termina flujo compra de BEBIDA para abastecimiento





                /////////////////ENVASADOS/////////////////////////////
                if(eleccionTipoProducto == 2){
                    System.out.println("Ingrese codigo de producto");
                    String id = sc.next();
                    System.out.println("Ingrese descripcion");
                    String descripcion = sc.next();
                    System.out.println("Ingrese Cantidad de productos a comprar");
                    int cantidadDeProducto = sc.nextInt();
                    System.out.println("Ingrese Precio Por Unidad");
                    //A que precio lo vendo como comerciante
                    float precioPorUnidad = sc.nextFloat();
                    System.out.println("Ingrese Costo por Unidad");
                    //A que precio lo compro como comerciante
                    float costoPorUnidad = sc.nextFloat();
                    System.out.println("Ingrese Tipo De Envase: PLASTICO, VIDRIO, LATA");
                    TipoEnvase tipoEnvase = TipoEnvase.valueOf(sc.next()); //Esto estara bien?
                    System.out.println("Es importado? Hardcode SI");
                    boolean esImportado = true;
                    System.out.println("Disponible para la venta? SI");
                    boolean disponibleParaLaVenta = true;

                    Envasados envasado = new Envasados(id, descripcion, cantidadDeProducto, precioPorUnidad,
                            costoPorUnidad, tipoEnvase, esImportado,disponibleParaLaVenta);
                    ///////////////////////CAJA//////////////////////////////////
                    //Consulto por el nombre de la Tienda y saldo en caja
                    System.out.println("Ingrese nombre de la tienda: ");
                    String nombreTienda = sc.next();
                    System.out.println("Ingrese monto en caja: ");
                    float saldoEnCaja = sc.nextFloat();

                    //Instancio Tienda para utilizar los metodos
                    Tienda productoTienda = new Tienda(nombreTienda, saldoEnCaja);
                    boolean puedoAbastecerme = productoTienda.saldoEnCajaParacomprar(cantidadDeProducto,
                            costoPorUnidad,saldoEnCaja);
                    //System.out.println(puedoAbastecerme + "Puedo Abastecerme? Da Vinky?");
                    if(puedoAbastecerme){
                        boolean productoExiste = productoTienda.productoExiste(id);
                        //Nunca entra aca...
                        if(productoExiste){
                            System.out.println("Existo");
                        }else{
                            System.out.println("No existo");
                        }
                        productoTienda.agregarStock(cantidadDeProducto, id);
                        productoTienda.compraDeProducto(envasado, cantidadDeProducto, id);
                    }
                    else{
                        System.out.println("No dispone de saldo suficiente para abastecerse.");
                    }

                }
                /////LIMPIEZA////


            } //Termina el flujo de compra para abstecimiento
            //<----FIN

            System.out.println("Desea realizar otra compra? 1- FIN COMPRA 2- SEGUIR COMPRANDO");
            int finCompraNum = sc.nextInt();
            if(finCompraNum == 1){
                fincompra = true;
            }
        }while(!fincompra);

        if(eleccionPrincipal == 2){
            System.out.println("Que desea vender?");
        }

    }
}
