/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import classes.Guerreiro;
import natureza.*;
import racas.terrano.*;
import racas.protons.*;
import racas.zergs.*;
import racas.nagas.*;

/**
 *
 * @author joao
 */
public class LerFilas {

    public static void lerFila1(String arquivo, LinkedList<Guerreiro> fila) {
        try {
            FileInputStream fl = new FileInputStream(arquivo);
            Scanner scan = new Scanner(fl);

            do {
                int tipo = scan.nextInt();
                String nome = scan.next();
                int idade = scan.nextInt();
                double peso = scan.nextDouble();

                switch (tipo) {
                    case 1:
                        fila.add(new Soldado(nome, idade, peso, 20, new Organico()));
                        break;
                    case 2:
                        fila.add(new Endiabrado(nome, idade, peso, 15, new Mecanico()));
                        break;
                    case 3:
                        fila.add(new Ambunave(nome, idade, peso, 0, new Mecanico()));
                        break;
                    case 4:
                        fila.add(new CruzadorBatalha(nome, idade, peso, 50, new Mecanico(), 1000));
                        break;
                    case 5:
                        fila.add(new Fanaticus(nome, idade, peso, 30, new Organico()));
                        break;
                    case 6:
                        fila.add(new Tormento(nome, idade, peso, 30, new Organico()));
                        break;
                    case 7:
                        fila.add(new Colosso(nome, idade, peso, 20, new Mecanico()));
                        break;
                    case 8:
                        fila.add(new Transportadora(nome, idade, peso, 0, new Mecanico(), 500));
                        break;
                }
            } while (scan.hasNext());
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
        }
    }

    public static void lerFila2(String arquivo, LinkedList<Guerreiro> fila) {
        try {
            FileInputStream fl = new FileInputStream(arquivo);
            Scanner scan = new Scanner(fl);

            do {
                int tipo = scan.nextInt();
                String nome = scan.next();
                int idade = scan.nextInt();
                double peso = scan.nextDouble();

                switch (tipo) {
                    case 1:
                        fila.add(new Zergnideo(nome, idade, peso, 5, new Organico(), 50));
                        break;
                    case 2:
                        fila.add(new TatuBomba(nome, idade, peso, 100, new Organico()));
                        break;
                    case 3:
                        fila.add(new Infestador(nome, idade, peso, 0, new Organico()));
                        break;
                    case 4:
                        fila.add(new LordCastas(nome, idade, peso, 0, new Organico(), 200));
                        break;
                    case 5:
                        fila.add(new Servo(nome, idade, peso, 0, new Organico()));
                        break;
                    case 6:
                        fila.add(new Devoradora(nome, idade, peso, 0, new Organico()));
                        break;
                    case 7:
                        fila.add(new Empalador(nome, idade, peso, 50, new Organico(), 400));
                        break;
                }
            } while (scan.hasNext());
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");

        }
    }
}
