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
}
