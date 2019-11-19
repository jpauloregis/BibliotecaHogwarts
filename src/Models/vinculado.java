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
public class vinculado {
    private int codigoautor;
    private int livro_codigo;

    public vinculado(int codigoautor, int livro_codigo) {
        this.codigoautor = codigoautor;
        this.livro_codigo = livro_codigo;
    }

    public int getLivro_codigo() {
        return livro_codigo;
    }

    public void setLivro_codigo(int livro_codigo) {
        this.livro_codigo = livro_codigo;
    }

    public int getCodigoautor() {
        return codigoautor;
    }

    public void setCodigoautor(int codigoautor) {
        this.codigoautor = codigoautor;
    }
}
