/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Paulo
 */
public class solicitacao {
    private int codigo_solicitacao;
    private int us_codigo;
    private java.sql.Date data_solicitacao;

    public solicitacao(int codigo_solicitacao, int us_codigo, Date data_solicitacao) {
        this.codigo_solicitacao = codigo_solicitacao;
        this.us_codigo = us_codigo;
        this.data_solicitacao = data_solicitacao;
    }

    public int getCodigo_solicitacao() {
        return codigo_solicitacao;
    }

    public void setCodigo_solicitacao(int codigo_solicitacao) {
        this.codigo_solicitacao = codigo_solicitacao;
    }

    public int getUs_codigo() {
        return us_codigo;
    }

    public void setUs_codigo(int us_codigo) {
        this.us_codigo = us_codigo;
    }

    public java.sql.Date getData_solicitacao() {
        return data_solicitacao;
    }

    public void setData_solicitacao(java.sql.Date data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }
    
    
}
