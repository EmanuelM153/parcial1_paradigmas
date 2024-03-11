package modelo;

public class Cliente {
    private int id;
    private String contrasena;
    private String nombre;

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String contrasena, String nombre) {
        this.id = id;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public Cliente(String contrasena, String nombre) {
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
