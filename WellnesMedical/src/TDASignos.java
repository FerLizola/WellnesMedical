/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nando
 */
public class TDASignos {
    private String NSS,nombre;
    private float peso,altura,presion,temperatura;
    
    public String getNombre() {
        return nombre;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public void setAltura(float altura){
        this.altura=altura;
    }
    
    public float getAltura(){
        return altura;
    }
    
    public void setPresion(float presion){
        this.presion=presion;
    }
    
    public float getPresion(){
        return presion;
    }
    
    public void setTemperatura(float temperatura){
        this.temperatura=temperatura;
    }
    
    public float getTemperatura(){
        return temperatura;
    }
    
}
