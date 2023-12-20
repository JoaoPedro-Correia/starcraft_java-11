/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racas.terrano;

import classes.Guerreiro;
import natureza.Natureza;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author joao
 */
public class CruzadorBatalha extends Terrano {
    private int ataques;

    public CruzadorBatalha(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
        this.ataques = 0;
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        try {
            Guerreiro tropa = inimigos.getFirst(); // PRIMEIRO INIMIGO DA LISTA
            // CONTO A QUANTIDADE DE ATAQUES
            ataques++;

            if (ataques % 3 == 0) { // SUPER ATAQUE
                tropa.dano(tropa.getEnergiaMax());
            } else {
                tropa.dano((int) this.getAtaque());
            }
        } catch (NoSuchElementException erro) {
        }
    }
}
