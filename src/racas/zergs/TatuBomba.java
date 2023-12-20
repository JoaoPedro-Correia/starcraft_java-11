package racas.zergs;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import classes.Guerreiro;
import natureza.Natureza;

/**
 * TatuBomba
 */
public class TatuBomba extends Zerg {

    public TatuBomba(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        try {
            Guerreiro inimigo = inimigos.getFirst();
            inimigo.dano((int) this.getAtaque());
            this.setEnergia(0);
        } catch (NoSuchElementException erro) {
        }
    }
}
