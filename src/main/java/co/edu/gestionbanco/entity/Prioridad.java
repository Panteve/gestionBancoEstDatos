/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package co.edu.gestionbanco.entity;


public enum Prioridad {
    LEVEL1("DISCAPACITADO",1),
    LEVEL2("EMBARAZADA",2),
    LEVEL3("MAYOR",3);
    
    private final int LEVEL;
    private final String DESCRIPTION;
    
    private Prioridad(String description, int level) {
        this.LEVEL = level;
        this.DESCRIPTION = description;
    }
    
    public int getLEVEL() {
        return LEVEL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
    
     public static Prioridad fromLevel(int level) {
        for (Prioridad p : Prioridad.values()) {
            if (p.getLEVEL() == level) {
                return p;
            }
        }
        return null;
    } 
}
