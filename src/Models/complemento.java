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
public class complemento {
    private int livros_codigo;
    private String tipo;
    private String localizacao;

    public complemento(int livros_codigo, String tipo, String localizacao) {
        this.livros_codigo = livros_codigo;
        this.tipo = tipo;
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLivros_codigo() {
        return livros_codigo;
    }

    public void setLivros_codigo(int livros_codigo) {
        this.livros_codigo = livros_codigo;
    }
    
}
