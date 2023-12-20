/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racas.protons;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import classes.Guerreiro;
import natureza.Natureza;

/**
 *
 * @author joao
 */
public class Fanaticus extends Proton {

    public Fanaticus(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        try {
            Guerreiro inimigo = inimigos.getFirst();
            inimigo.dano((int) this.getAtaque());
        } catch (NoSuchElementException erro) {
        }
    }

    @Override
    public void curar(int cura) {
        int vida = 200;
        if (this.getEnergia() + cura >= vida) {
            this.setEnergia(vida);
        } else {
            this.setEnergia((int) this.getEnergia() + cura);
        }
        recuperacaoGelada();
    }
}
