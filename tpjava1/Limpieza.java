package tpjava1;

public class Limpieza extends Producto implements ProductosConDescuentos{
    //ID
    private TipoDeAplicacion tipoDeAplicacion;

    public TipoDeAplicacion getTipoDeAplicacion() {
        return tipoDeAplicacion;
    }

    public void setTipoDeAplicacion(TipoDeAplicacion tipoDeAplicacion) {
        this.tipoDeAplicacion = tipoDeAplicacion;
    }

    public Limpieza(String id, String description, float precioPorUnidad,
                    float costoPorUnidad, TipoDeAplicacion tipoDeAplicacion, boolean disponibleParaLaVenta,
                    int cantidadEnStock) {
        super(id, description, cantidadEnStock, precioPorUnidad, disponibleParaLaVenta, cantidadEnStock);
        this.tipoDeAplicacion = tipoDeAplicacion;
    }

    @Override
    public void setPorcentajeDeDescuento() {

    }

    @Override
    public float getPorcentajeDeDescuento() {
        return 0;
    }

    @Override
    public void setPrecioDeVentaConDescuento() {

    }

    @Override
    public float getPrecioDeVentaConDescuento() {
        return 0;
    }
}
