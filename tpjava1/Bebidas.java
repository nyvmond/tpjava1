package tpjava1;

public class Bebidas extends Producto implements ProductosComestibles, ProductosConDescuentos{
    //Falta el id
    private boolean esAlcoholica;
    private float graduacionAlcoholica;
    private boolean esImportada;

    public boolean isEsAlcoholica() {
        return esAlcoholica;
    }

    public void setEsAlcoholica(boolean esAlcoholica) {
        this.esAlcoholica = esAlcoholica;
    }

    public float getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(float graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public boolean isEsImportada() {
        return esImportada;
    }

    public void setEsImportada(boolean esImportada) {
        this.esImportada = esImportada;
    }

    public Bebidas(String id, String description, float precioPorUnidad,
                   float costoPorUnidad, boolean esAlcoholica, float graduacionAlcoholica,
                   boolean esImportada, boolean disponibleParaLaVenta, int cantidadEnStock) {
        super(id, description, precioPorUnidad, costoPorUnidad, disponibleParaLaVenta, cantidadEnStock);
        this.esAlcoholica = esAlcoholica;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.esImportada = esImportada;
    }

    @Override
    public void setFechaDeVencimiento() {

    }

    @Override
    public String getFechaDeVencimiento() {
        return null;
    }

    @Override
    public void setCalorias() {

    }

    @Override
    public int getCalorias() {
        return 0;
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
