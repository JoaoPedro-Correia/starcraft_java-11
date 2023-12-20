package racas.zergs;

import classes.Guerreiro;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import natureza.Natureza;
import natureza.Organico;

/**
 * Infestador
 */
public class Infestador extends Zerg {

    public Infestador(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        if (round == 1) {
            try {
                Guerreiro controlado = inimigos.removeFirst();
                controlado.atacar(aliados, inimigos, round);
                inimigos.addFirst(controlado);
            } catch (NoSuchElementException erro) {
            }
        } else {
            aliados.add(new Zergnideo(this.getNome() + ".zergnideo", this.getIdade(), this.getPeso(), 5, new Organico(),
                    50));
        }
    }
}
