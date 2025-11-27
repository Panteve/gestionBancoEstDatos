/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package co.edu.gestionbanco.entity;


public enum TriagePrioridad {
    LEVEL1("DISCAPACITADO",1),
    LEVEL2("EMBARAZADA",2),
    LEVEL3("MAYOR",3);
    
    private final int LEVEL;
    private final String DESCRIPTION;
    
    private TriagePrioridad(String description, int level) {
        this.LEVEL = level;
        this.DESCRIPTION = description;
    }
    
    public int getLEVEL() {
        return LEVEL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
    
     public static TriagePrioridad fromLevel(int level) {
        for (TriagePrioridad p : TriagePrioridad.values()) {
            if (p.getLEVEL() == level) {
                return p;
            }
        }
        return null;
    } 
}
