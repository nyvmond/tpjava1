package tpjava1;

public class Producto {
    private String id;
    private String description;
    private int cantidadEnStock;
    private float precioPorUnidad;
    private float costoPorUnidad;
    private boolean disponibleParaLaVenta;

    public Producto(String id, String description, float precioPorUnidad, float costoPorUnidad,
                    boolean disponibleParaLaVenta, int cantidadEnStock) {
        this.id = id;
        this.description = description;
        this.cantidadEnStock = cantidadEnStock;
        this.precioPorUnidad = precioPorUnidad;
        this.costoPorUnidad = costoPorUnidad;
        this.disponibleParaLaVenta = disponibleParaLaVenta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public float getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(float precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public float getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public void setCostoPorUnidad(float costoPorUnidad) {
        this.costoPorUnidad = costoPorUnidad;
    }

    public boolean isDisponibleParaLaVenta() {
        return disponibleParaLaVenta;
    }

    public void setDisponibleParaLaVenta(boolean disponibleParaLaVenta) {
        this.disponibleParaLaVenta = disponibleParaLaVenta;
    }
}
