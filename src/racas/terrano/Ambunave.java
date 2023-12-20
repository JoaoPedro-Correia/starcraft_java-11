/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racas.terrano;

import classes.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

import java.util.LinkedList;

/**
 *
 * @author joao
 */
public class Ambunave extends Terrano {

    public Ambunave(String nome, int idade, double peso, int ataque, Natureza natureza) {
        super(nome, idade, peso, ataque, natureza);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round) {
        aliados.stream().filter((personagem) -> (personagem.getNatureza() instanceof Organico))
                .forEachOrdered((personagem) -> {
                    personagem.curar(50);
                });
    }
}
