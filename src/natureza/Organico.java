/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package natureza;

/**
 *
 * @author joao
 */
public class Organico extends Natureza {
    private Broto broto;
    private int veneno;

    public Organico() {
        this.veneno = 0;
        this.broto = new Broto();
    }

    public int getVeneno() {
        return veneno;
    }

    public void addVeneno(int veneno) {
        this.veneno += veneno;
    }

    public Broto getBroto() {
        return broto;
    }

    public void addBroto(int brotos) {
        this.broto.broto += brotos; // ADICIONO BROTO
        this.veneno += brotos; // ADICIONO O VENENO
    }
}
