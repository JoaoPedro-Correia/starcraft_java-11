package racas.zergs;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import classes.Guerreiro;
import natureza.Natureza;

/**
 * Zergnideo
 */
public class Zergnideo extends Zerg {

    public Zergnideo(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        try {
            Guerreiro inimigo = inimigos.getFirst();
            inimigo.dano((int) this.getAtaque());
        } catch (NoSuchElementException erro) {
        }
    }
}
