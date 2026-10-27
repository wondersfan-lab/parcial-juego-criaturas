package com.uniajc;

public class Dragon extends Criatura {
    // Atributo específico encapsulado
    private String escamas;

    
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    
    @Override
    public void atacar(Criatura objetivo) {
        int dañoGenerado = this.fuerza * 2;
        System.out.println(this.nombre + " lanza una llamarada feroz contra " + objetivo.getNombre() + " causando " + dañoGenerado + " puntos de daño potencial.");
        objetivo.defender(dañoGenerado);
    }

    
    @Override
    public void defender(int daño) {
        int dañoMitigado = Math.max(0, daño - 5);
        this.salud = Math.max(0, this.salud - dañoMitigado);
        System.out.println(this.nombre + " se defiende con sus escamas (" + this.escamas + "). Recibe " + dañoMitigado + " de daño (mitigó 5). Salud restante: " + this.salud);
    }

  
    public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }
}
