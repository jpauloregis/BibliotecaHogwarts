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
public class item {

    private int numero_sequencia; 
    private int l_codigo_livro;
    private int r_id;
    private int s_codigo;

    public item(int numero_sequencia, int l_codigo_livro, int r_id, int s_codigo) {
        this.numero_sequencia = numero_sequencia;
        this.l_codigo_livro = l_codigo_livro;
        this.r_id = r_id;
        this.s_codigo = s_codigo;
    }

    public int getS_codigo() {
        return s_codigo;
    }

    public void setS_codigo(int s_codigo) {
        this.s_codigo = s_codigo;
    }

    public int getNumero_sequencia() {
        return numero_sequencia;
    }

    public void setNumero_sequencia(int numero_sequencia) {
        this.numero_sequencia = numero_sequencia;
    }

    public int getL_codigo_livro() {
        return l_codigo_livro;
    }

    public void setL_codigo_livro(int l_codigo_livro) {
        this.l_codigo_livro = l_codigo_livro;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }
    
    
}
