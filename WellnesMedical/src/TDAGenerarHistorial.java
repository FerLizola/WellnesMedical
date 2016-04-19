/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nando
 */
public class TDAGenerarHistorial {
    private String NSS, nombre, cirujias,alergias,antecedentes,expediente;
    private float presion, altura, peso;
    
    public void setNSS(String NSS){
        this.NSS=NSS;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setCirujias(String cirujias){
        this.cirujias=cirujias;
    }
    
    public void setAlergias(String alergias){
        this.alergias=alergias;
    }
    
    public void setAntecendentes(String antecedentes){
        this.antecedentes=antecedentes;
    }
    
    public void setExpediente(String expediente){
        this.expediente=expediente;
    }
    
    public void setPresion(float presion){
        this.presion=presion;
    }
    
    public void setAltura(float altura){
        this.altura=altura;
    }
    
    public void setPeso(float peso){
        this.peso=peso;
    }
    public float getPeso(){
        return peso;
    }
}
