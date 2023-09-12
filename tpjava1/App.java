package tpjava1;

import com.sun.security.jgss.GSSUtil;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int eleccionPrincipal;
        int eleccionTipoProducto;
        boolean fincompra = false;
        String nombreTienda;
        float saldoEnCaja;
        int eleccionVentas;
        String idProdAVender;
        int cantAVender;
        Scanner sc = new Scanner(System.in);

        //Pido Nombre de la tienda y saldo en caja para operar
        System.out.println("Bienvenido, ingrese nombre de la Tienda");
        nombreTienda = sc.next();
        System.out.println("Ingrese saldo en caja: ");
        saldoEnCaja = sc.nextFloat();
        //Instanciando Tienda le estoy mandando el saldo en caja
        Tienda productoTienda = new Tienda(nombreTienda, saldoEnCaja);

        do{
            System.out.println("1 para compra - 2 para venta - 3 FIN");
            eleccionPrincipal = sc.nextInt();

            if(eleccionPrincipal == 1){
                System.out.println("Que desea comprar?");
                System.out.println("1- Bebidas \n 2- Envasados \n 3. Limpieza");
                eleccionTipoProducto = sc.nextInt();
                //////////////////////////////////////////////////////////////////////////////
                ///////////////////////BEBIDAS///////////////////////////////////////////////
                if(eleccionTipoProducto == 1){
                    boolean codigoValido = false;
                    System.out.println("Ingrese codigo de producto formato AC123");
                    String id = sc.next();

                //VALIDACION CODIGO BEBIBLES AC123
                    do{
                        if(id.length()==5 &&
                            (id.charAt(0)=='A' || id.charAt(0)=='a') &&
                            (id.charAt(1)=='C' || id.charAt(1)=='c')){
                            codigoValido = true;
                        }else{
                            System.out.println("El codigo debe tener 5 caracteres y comenzar con A y C");
                            codigoValido = false;
                            System.out.println("Ingrese nuevamente codigo de producto: ");
                            id = sc.next();
                        }
                    }while(!codigoValido);

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
                    System.out.println("Actualmente no vendemos bebidas alcoholicas");
                    boolean esAlcoholica = false;
                    float graduacionAlcoholica = 0;
                    System.out.println("Actualmente no tenemos bebidas importadas");
                    boolean esImportada = false;
                    System.out.println("Se encuentra disponible para la venta");
                    boolean disponibleParaLaVenta = true;
                    //Hasta aca hago una nueva bebida y le pase por params lo que el usuario ingreso
                    Bebidas bebida = new Bebidas(id, descripcion, precioPorUnidad,costoPorUnidad,
                            esAlcoholica,graduacionAlcoholica,esImportada, disponibleParaLaVenta, cantidadDeProducto);

                    //Valido si saldo en caja es suficiente para abastecerme
                    boolean puedoAbastecerme = productoTienda.saldoEnCajaParacomprar(cantidadDeProducto,
                            costoPorUnidad);
                    if(puedoAbastecerme){
                        //Le paso el producto, el id y la cantidad para manejo de stock
                        productoTienda.compraDeProducto(bebida, cantidadDeProducto, id);
                    }else{
                        //Caso de no tener saldo disponible
                        System.out.println("No dispone de saldo suficiente para abastecerse.");
                    }
                } //Termina flujo compra de BEBIDA para abastecimiento
                ///////////////////////////////////////////////////////
                /////////////////ENVASADOS/////////////////////////////
                if(eleccionTipoProducto == 2){
                    boolean codigoValido = false;
                    System.out.println("Ingrese codigo de producto formato AB123");
                    String id = sc.next();

                    //VALIDACION CODIGO ENVASADOS AB123
                    do{
                        if(id.length()==5 &&
                                (id.charAt(0)=='A' || id.charAt(0)=='a') &&
                                (id.charAt(1)=='B' || id.charAt(1)=='b')){
                            codigoValido = true;
                        }else{
                            System.out.println("El codigo debe tener 5 caracteres y comenzar con A y B");
                            codigoValido = false;
                            System.out.println("Ingrese nuevamente codigo de producto: ");
                            id = sc.next();
                        }
                    }while(!codigoValido);


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
                    System.out.println("De momento no vendemos productos Importados");
                    boolean esImportado = false;
                    System.out.println("Todos nuestros productos estan disponibles para la venta");
                    boolean disponibleParaLaVenta = true;

                    //Hasta aca hago un nuevo envasado y le pase por params lo que el usuario ingreso
                    Envasados envasado = new Envasados(id, descripcion, cantidadDeProducto, precioPorUnidad,
                            costoPorUnidad, tipoEnvase, esImportado,disponibleParaLaVenta);


                    //Valido si saldo en caja es suficiente para abastecerme
                    boolean puedoAbastecerme = productoTienda.saldoEnCajaParacomprar(cantidadDeProducto,
                            costoPorUnidad);
                    if(puedoAbastecerme){
                        //Le paso el producto, el id y la cantidad para manejo de stock
                        productoTienda.compraDeProducto(envasado, cantidadDeProducto, id);
                    }else{
                        //Caso de no tener saldo disponible
                        System.out.println("No dispone de saldo suficiente para abastecerse.");
                    }
                }
                /////LIMPIEZA////
                if(eleccionTipoProducto == 3){
                    boolean codigoValido = false;
                    System.out.println("Ingrese codigo de producto formato AZ123");
                    String id = sc.next();

                    //VALIDACION CODIGO BEBIBLES AZ123
                    do{
                        if(id.length()==5 &&
                                (id.charAt(0)=='A' || id.charAt(0)=='a') &&
                                (id.charAt(1)=='Z' || id.charAt(1)=='z')){
                            codigoValido = true;
                        }else{
                            System.out.println("El codigo debe tener 5 caracteres y comenzar con A y Z");
                            codigoValido = false;
                            System.out.println("Ingrese nuevamente codigo de producto: ");
                            id = sc.next();
                        }
                    }while(!codigoValido);

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
                    System.out.println("Ingrese tipo de aplicacion: COCINA, PISOS, ROPA, MULTIUSO");
                    TipoDeAplicacion tipoAplicacion = TipoDeAplicacion.valueOf(sc.next());
                    boolean disponibleParaLaVenta = true;

                    //Hasta aca hago un nuevo prod Limpieza y le pase por params lo que el usuario ingreso
                    Limpieza limpieza = new Limpieza(id, descripcion, precioPorUnidad, costoPorUnidad, tipoAplicacion,
                            disponibleParaLaVenta, cantidadDeProducto);
                    boolean puedoAbastecerme = productoTienda.saldoEnCajaParacomprar(cantidadDeProducto,
                            costoPorUnidad);
                    if(puedoAbastecerme){
                        //Le paso el producto, el id y la cantidad para manejo de stock
                        productoTienda.compraDeProducto(limpieza, cantidadDeProducto, id);
                    }else{
                        //Caso de no tener saldo disponible
                        System.out.println("No dispone de saldo suficiente para abastecerse.");
                    }
                }//<--- Termina flujo abastecimiento productos de limpieza
                System.out.println("Desea realizar otra compra? 1-SI 2-VENTA 3-FIN PROGRAMA");
                eleccionPrincipal = sc.nextInt();
                if(eleccionPrincipal == 3){
                    fincompra = true;
                    System.out.println("Saldo en caja restante: "+ productoTienda.getSaldoEnCaja());
                }

            } //Termina el flujo de compra para abstecimiento
            //<----FIN

            ////FLUJO VENTA AL PUBLICO/////
            if(eleccionPrincipal == 2){
                System.out.println("Ingrese 1 para listar Stock - Ingrese 2 para compra con codigo");
                eleccionVentas = sc.nextInt();

                if(eleccionVentas==1){
                    System.out.println("A continuacion se listan los productos disponibles: ");
                    productoTienda.verProductos();
                }
                if(eleccionVentas==2){
                    System.out.println("Ingrese codigo de producto: ");
                    idProdAVender = sc.next();

                    //Llamo a metodo para buscar este producto y traigo la cantidad que hay
                    productoTienda.busquedaProducto(idProdAVender);
                    boolean encontro = productoTienda.busquedaProducto(idProdAVender);
                    if(encontro){
                        System.out.println("Cuantas unidades desea comprar?");
                        cantAVender = sc.nextInt();
                        productoTienda.compraDeProducto(idProdAVender, cantAVender);
                    }else{
                        System.out.println("Lo sentimos, no podemos venderle un producto inexistente");
                    }

                }
            }
            if(eleccionPrincipal == 3){
                fincompra = true;
                System.out.println("Saldo en caja restante: "+ productoTienda.getSaldoEnCaja());
            }

        }while(!fincompra);



    }//psvm
}
