/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package starcraft;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import arquivo.LerFilas;
import classes.Guerreiro;

/**
 *
 * @author joao
 */
public class Starcraft {

    /**
     * @param lista
     * @return
     */
    public static double somaPeso(LinkedList<Guerreiro> lista) {
        double pesoTotal = 0;
        for (Guerreiro personagem : lista) {
            pesoTotal += personagem.getPeso();
        }
        return pesoTotal;
    }

    public static Guerreiro maiorIdade(LinkedList<Guerreiro> lista) {
        try {
            int maiorValor = lista.getFirst().getIdade();
            Guerreiro velho = lista.getFirst();
            for (Guerreiro personagem : lista) {
                int valorAtual = personagem.getIdade();
                if (valorAtual > maiorValor) {
                    maiorValor = valorAtual;
                    velho = personagem;
                }
            }
            return velho;
        } catch (NoSuchElementException erro) {
            System.out.println("Lista vazia");
            return null;
        }
    }

    public static Guerreiro maisVelho(LinkedList<Guerreiro> fila1, LinkedList<Guerreiro> fila2) {
        Guerreiro guerreiroVelho1 = maiorIdade(fila1);
        Guerreiro guerreiroVelho2 = maiorIdade(fila2);

        if (guerreiroVelho1.getIdade() > guerreiroVelho2.getIdade()) {
            return guerreiroVelho1;
        } else {
            return guerreiroVelho2;
        }
    }

    public static void main(String[] args) {
        String arq1 = "fila1b.txt"; // ARQUIVO DA PRIMEIRA FILA
        String arq2 = "fila2b.txt"; // ARQUIVO DA SEGUNDA FILA

        LinkedList<Guerreiro> fila1 = new LinkedList<>();
        LinkedList<Guerreiro> fila2 = new LinkedList<>();

        LerFilas.lerFila1(arq1, fila1);
        LerFilas.lerFila2(arq2, fila2);

        double pesoTerranosProtons = somaPeso(fila1);
        double pesoNagasZergs = somaPeso(fila2);

        Guerreiro guerreiroVelho = maisVelho(fila1, fila2); // APONTO PARA O GUERREIRO MAIS VELHO

        // campo de batalha
        Batalha.campoDeBatalha(fila1, fila2); // INFORMACOES DO ULTIMOS GUERREIROS

        /* PRINT FINAL */
        System.out.printf("Terranos e Protons pesam - %.2f unidades\n", pesoTerranosProtons);
        System.out.printf("Zergnideos e Nagas pesam - %.2f unidades\n", pesoNagasZergs);
        System.out.println(
                guerreiroVelho.getNome() + " é o personagem mais velho com " + guerreiroVelho.getIdade() + " unidaes");

        if (fila1.isEmpty() && fila2.isEmpty()) {
            System.out.println("EMPATE! Todos morreram");
            System.out.println("Ultimos que atacaram:");
            System.out.println(Batalha.getGuerreiroLado1());
            System.out.println(Batalha.getGuerreiroLado2());
        } else if (!fila1.isEmpty() && !fila2.isEmpty()) {// PRINT DO VENCEDOR
            System.out.println("EMPATE!");
            System.out.println("Ninguem está atacando :(");
        } else if (!fila2.isEmpty()) {
            System.out.println("Nagas e Zergs Venceram!");
            System.out.println(Batalha.getGuerreiroLado2());
            System.out.println(Batalha.getGuerreiroLado1());
        } else {
            System.out.println("Terranos e Protons Venceram!");
            System.out.println(Batalha.getGuerreiroLado1());
            System.out.println(Batalha.getGuerreiroLado2());
        }
    }
}
