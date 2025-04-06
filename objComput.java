public class objComput 
{
    private String serial;
    private String marca;
    private int memoriaRam;
    private int discoDuro;
    private Double precio;
    private String nombreUsuario;
    private boolean disponible;
    public objComput() {
    }
    public objComput(String serial, String marca, int memoriaRam, int discoDuro, Double precio, String nombreUsuario,
            boolean disponible) {
        this.serial = serial;
        this.marca = marca;
        this.memoriaRam = memoriaRam;
        this.discoDuro = discoDuro;
        this.precio = precio;
        this.nombreUsuario = nombreUsuario;
        this.disponible = disponible;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getMemoriaRam() {
        return memoriaRam;
    }
    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }
    public int getDiscoDuro() {
        return discoDuro;
    }
    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
}
