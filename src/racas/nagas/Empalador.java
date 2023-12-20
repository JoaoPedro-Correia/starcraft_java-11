package racas.nagas;

import java.util.LinkedList;

import classes.Guerreiro;
import java.util.NoSuchElementException;
import natureza.Natureza;

/**
 * Empalador
 */
public class Empalador extends Naga {

    public Empalador(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        Guerreiro inimigo = inimigos.getFirst();
        inimigo.dano((int) this.getAtaque());

        try {
            if (this.getEnergia() <= 100) {
                aliados.remove(1);
                this.setEnergia(this.getEnergiaMax());
            }
        } catch (IndexOutOfBoundsException | NoSuchElementException erro) {
        }
    }
}
