/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racas.terrano;

import classes.Guerreiro;
import natureza.Natureza;

/**
 *
 * @author joao
 */
public abstract class Terrano extends Guerreiro{

    public Terrano(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
    }

    public Terrano(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }
}
