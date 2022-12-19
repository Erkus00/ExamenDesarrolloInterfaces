package main.examen1tr_desarrollointerfaces;

public class Persona {
    private String nombre;
    private String sexo;
    private Integer edad;
    private Integer peso;
    private Integer altura;
    private String actividad;

    private double ger;

    private double get;

    public Persona(String nombre, String sexo, int edad, int peso, int altura, String actividad, double ger, double get) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.actividad = actividad;
        this.ger = ger;
        this.get = get;
    }
    public Persona(){

    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public String getActividad() {
        return actividad;
    }

    public double getGer() {
        return ger;
    }

    public double getGet() {
        return get;
    }

    public void setGer(double ger) {
        this.ger = ger;
    }

    public void setGet(double get) {
        this.get = get;
    }
}
