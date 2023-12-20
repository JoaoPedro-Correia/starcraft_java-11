/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racas.protons;

import classes.Guerreiro;
import natureza.Natureza;

/**
 *
 * @author joao
 */
public abstract class Proton extends Guerreiro {

    public Proton(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
    }

    public Proton(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }
    
    protected void recuperacaoGelada(){
        if(this.getEnergia()<(this.getEnergiaMax()*0.5)){
            curar((int) (this.getEnergiaMax()*0.05));
        }
    }
}
