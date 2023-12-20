package racas.protons;

import java.util.LinkedList;

import classes.Guerreiro;
import natureza.Natureza;

/**
 * Colosso
 */
public class Colosso extends Proton {

    public Colosso(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        // TODO Auto-generated method stub
        inimigos.forEach((personagem) -> {
            personagem.dano((int) this.getAtaque());
        });
        recuperacaoGelada();
    }
}
