/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starcraft;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

import classes.Guerreiro;

/**
 *
 * @author joao
 */
public class Batalha {
    private static String guerreiroLado1;
    private static String guerreiroLado2;
    private static final int PRIMEIRAFILA = 0;
    private static final int SEGUNDAFILA = 1;

    public static String getGuerreiroLado1() {
        return guerreiroLado1;
    }

    public static String getGuerreiroLado2() {
        return guerreiroLado2;
    }

    private static int sortearFila() {
        Random numero = new Random();
        return numero.nextInt(2);
    }

    private static int tamMaiorFila(LinkedList<Guerreiro> fila1, LinkedList<Guerreiro> fila2){
        if(fila1.size() > fila2.size())
            return fila1.size();
        else
            return fila2.size();
    }
    
    private static String getInfGuerreiro(Guerreiro lutador) {
        return lutador.getNome() + "," + lutador.getIdade() + "," + lutador.getPeso();
    }

    private static void ataques(LinkedList<Guerreiro> fila1, LinkedList<Guerreiro> fila2) {
        if (!fila1.isEmpty() && !fila2.isEmpty()) {
            Guerreiro lutador1 = fila1.getFirst();
            Guerreiro lutador2 = fila2.getFirst();

            // lutador1.print();
            lutador1.atacar(fila1, fila2, 1);

            if (lutador2.estaVivo()) {
                // lutador2.print();
                lutador2.atacar(fila2, fila1, 2);
            }
        }
    }

    private static void moverParaFinalDaFila(LinkedList<Guerreiro> fila) {
        if (!fila.isEmpty()) {
            Guerreiro lutador = fila.getFirst();
            fila.remove(lutador);
            fila.add(lutador);
        }
    }

    private static void ringue(LinkedList<Guerreiro> fila1, LinkedList<Guerreiro> fila2) throws NoSuchElementException {
        ataques(fila1, fila2);

        moverParaFinalDaFila(fila1);
        moverParaFinalDaFila(fila2);

        fila2.removeIf((personagem) -> (!personagem.estaVivo()));
        fila1.removeIf((personagem) -> (!personagem.estaVivo()));
    }

    public static void campoDeBatalha(LinkedList<Guerreiro> fila1, LinkedList<Guerreiro> fila2) {
        int tam = tamMaiorFila(fila1, fila2), qtAtaque=Guerreiro.getQntdAtaques();
        int i=0;
        do {
            i++;
            /*
             * MARCAR OS GUERREIROS QUE VÃO BATALHAR NO EXATO MOMENTO,
             * FAZER UM STRING QUE VAI ARMAZENAR AS INFORMAÇÕES DOS DOIS
             * SEMPRE RETORNAR ELA
             */
            Batalha.guerreiroLado1=getInfGuerreiro(fila1.getFirst());
            Batalha.guerreiroLado2=getInfGuerreiro(fila2.getFirst());
            
            int primeiroAtaque = sortearFila();
            switch (primeiroAtaque) {//LUTA NO RINGUE
                case PRIMEIRAFILA:
                    ringue(fila1, fila2); // FILA1 ATACA PRIMEIRO
                    break;
                case SEGUNDAFILA:
                    ringue(fila2, fila1); // FILA2 ATACA PRIMEIRO
                    break;
            }
            
            //VERIFICAR EMPATE
            if(i%tam==0){
                if(qtAtaque==Guerreiro.getQntdAtaques())
                    break;
                i=0;
                tam = tamMaiorFila(fila1, fila2);
                qtAtaque = Guerreiro.getQntdAtaques();
            }
        } while (!fila1.isEmpty() && !fila2.isEmpty());
    }
}
