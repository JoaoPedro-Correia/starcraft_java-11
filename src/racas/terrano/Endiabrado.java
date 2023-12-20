/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racas.terrano;

import classes.Guerreiro;
import natureza.Natureza;

import java.util.LinkedList;

/**
 *
 * @author joao
 */
public class Endiabrado extends Terrano {

    public Endiabrado(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        int qntdInimigo;
        try {
            for (qntdInimigo = 0; qntdInimigo < 3; qntdInimigo++) {
                Guerreiro inimigo = inimigos.get(qntdInimigo);
                inimigo.dano((int) (this.getAtaque() - (qntdInimigo * 5)));
            }
        } catch (IndexOutOfBoundsException erro) {
        }
    }
}
