package racas.protons;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import classes.Guerreiro;
import natureza.Natureza;

/**
 * Transportadora
 */
public class Transportadora extends Proton {
    private int interceptadores;

    public Transportadora(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
        this.interceptadores = 0;
    }

    private void criarInterceptador() { // CRIA UM INTERCEPTADOR
        if (this.interceptadores < 8) {
            this.interceptadores++;
            this.setAtaque(this.interceptadores * 25);
        }
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        criarInterceptador();
        try{
            Guerreiro inimigo = inimigos.getFirst();
            inimigo.dano((int) this.getAtaque());
            recuperacaoGelada();
        }catch(NoSuchElementException erro){
        }
    }
}
