/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.LinkedList;

import natureza.Natureza;
import natureza.Organico;

/**
 *
 * @author joao
 */
public abstract class Guerreiro implements Personagem{
    private static int qntdAtaques;
    private String nome;
    private int idade;
    private double peso;
    private int energiaMax; // ENERGIA INICIAL DO PERSONAGEM
    private int energia; // ENERGIA CORRENTE
    private int ataque;
    private Natureza natureza;

    // ============CONSTRUTOR========================
    public Guerreiro(String nome, int idade, double peso, int ataque, Natureza natureza, int energia) {
        this.energia = energia;
        this.energiaMax = energia;
        this.idade = idade;
        this.nome = nome;
        this.peso = peso;
        this.ataque = ataque;
        this.natureza = natureza;
    }

    public Guerreiro(String nome, int idade, double peso, int ataque, Natureza natureza) {
        this.energiaMax = 100;
        this.energia = 100;
        this.idade = idade;
        this.nome = nome;
        this.peso = peso;
        this.ataque = ataque;
        this.natureza = natureza;
    }

    // ===========IDADE========================
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // ============NOME========================
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // ============PESO========================
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // ============ENERGIA========================
    public double getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    // ============ATAQUE========================

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    // ============ENERGIA MAXIMA========================
    public int getEnergiaMax() {
        return energiaMax;
    }

    // ============NATUREZA========================
    public Natureza getNatureza() {
        return natureza;
    }

    // ============quantidade de ataques========================
    public static int getQntdAtaques() {
        return qntdAtaques;
    }

    public boolean estaVivo() {
        return this.energia > 0;
    }

    @Override
    public void curar(int cura) {
        if (this.energia + cura >= this.energiaMax) {
            this.energia = this.energiaMax;
        } else {
            this.energia = this.energia + cura;
        }
    }

    @Override
    public void dano(int dano) {
        this.energia -= dano;
        if (this.natureza instanceof Organico) {
            Organico org = (Organico) this.natureza;
            this.energia -= org.getVeneno();
        }
        qntdAtaques++;
    }

    public abstract void atacar(LinkedList<Guerreiro> aliados, LinkedList<Guerreiro> inimigos, int round);
}
