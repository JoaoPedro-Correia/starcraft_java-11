package racas.nagas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import classes.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

/**
 * Servo
 */
public class Servo extends Naga {

    public Servo(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        try {
            Guerreiro inimigo = inimigos.getFirst();

            if (inimigo.getNatureza() instanceof Organico) {
                Organico organico = (Organico) inimigo.getNatureza();
                organico.addBroto(1);
            }
        } catch (NoSuchElementException erro) {
        }
    }
}
