package racas.zergs;

import java.util.LinkedList;
import java.util.Random;

import classes.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

/**
 * LordCastas
 */
public class LordCastas extends Zerg {
    private static final int ZERGNIDEO = 0;
    private static final int TATUBOMBA = 1;
    private static final int INFESTADOR = 2;

    public LordCastas(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        super(nome, idade, peso, ataque, natureza, energia);
    }

    private int sortearZerg() {
        Random numero = new Random();
        return numero.nextInt(3);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        int sorteado = sortearZerg();
        
        switch (sorteado) {
            case ZERGNIDEO:
                for (int i = 0; i < 3; i++) {
                    aliados.add(new Zergnideo((this.getNome()+".zergnideo"+i), 0, 0, 5, new Organico(), 50));
                }
                break;
            case TATUBOMBA:
                for (int i = 0; i < 2; i++) {
                    aliados.add(new TatuBomba((this.getNome()+".tatubomba"+i), 0, 0, 100, new Organico()));
                }
                break;
            case INFESTADOR:
                aliados.add(new Infestador((this.getNome()+".infestador"), 0, 0, 0, new Organico()));
                break;
            default:
                break;
        }
    }
}
