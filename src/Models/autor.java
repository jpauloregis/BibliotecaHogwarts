/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Paulo
 */
public class autor {
    private int codigo_autor;
    private String nomea;
    private String biografia;

    public autor(String nomea, String biografia) {
       
        this.nomea = nomea;
        this.biografia = biografia;
    }

    public int getCodigo_autor() {
        return codigo_autor;
    }

    public void setCodigo_autor(int codigo_autor) {
        this.codigo_autor = codigo_autor;
    }

    public String getNomea() {
        return nomea;
    }

    public void setNomea(String nomea) {
        this.nomea = nomea;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
