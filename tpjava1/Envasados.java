package tpjava1;

public class Envasados extends Producto implements ProductosComestibles{
    //Me falta el identificador unico
    private TipoEnvase tipoEnvase;
    private boolean esImportado;

    public TipoEnvase getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(TipoEnvase tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    public Envasados(String id, String description, int cantidadEnStock, float precioPorUnidad, float costoPorUnidad,
                     TipoEnvase tipoEnvase, boolean esImportado, boolean disponibleParaLaVenta) {
        super(id, description, precioPorUnidad, costoPorUnidad, disponibleParaLaVenta, cantidadEnStock);
        this.tipoEnvase = tipoEnvase;
        this.esImportado = esImportado;
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
}
