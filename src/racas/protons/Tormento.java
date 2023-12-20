package racas.protons;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import classes.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

/**
 * Tormento
 * 
 * @author joao pedro
 */
public class Tormento extends Proton {

    public Tormento(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
    }

    public Tormento(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        if (round == 1 && !this.getNome().contains(".clone")) { // PRIMEIRO A ATACAR E NAO É CLONE
            Tormento personagem = new Tormento((this.getNome() + ".clone"), this.getIdade(), this.getPeso(), 0,
                    new Organico(), 50);

            Guerreiro aliado = aliados.getFirst();
            aliados.remove(aliado);
            aliados.add(aliado);
            aliados.add(0, personagem);
        } else {
            try {
                Guerreiro inimigo = inimigos.getFirst();
                inimigo.dano((int) this.getAtaque());
            } catch (NoSuchElementException erro) {
            }
        }
        recuperacaoGelada();
    }
}
