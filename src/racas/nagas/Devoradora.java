package racas.nagas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import classes.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

/**
 * Devoradora
 */
public class Devoradora extends Naga {

    public Devoradora(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        Guerreiro aliado = aliados.getFirst();
        Guerreiro inimigo = inimigos.getFirst();

        try {
            Guerreiro comido = aliados.get(1);

            if (comido instanceof Empalador) { // ENGOLIU EMPALADOR
                aliado.setEnergia(0); // MORRE
                for (int i = 0; i < 4; i++) { // CRIA 4 SERVOS
                    aliados.add(new Servo("Servo" + i, 0, 0, 0, new Organico()));
                }
            } else {
                aliado.setAtaque((int) (comido.getEnergia() * 2)); // COME O ALIADO DE TRAS
                aliados.remove(comido);
                inimigo.dano(this.getAtaque());
            }

        } catch (IndexOutOfBoundsException erro) {
            aliado.setAtaque(0); // SE NAO TIVER MAIS NENHUM ALIADO
        }
    }
}
