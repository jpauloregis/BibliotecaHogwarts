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
public class emprestimo {
    private int se_codigo;
    private java.sql.Date data_vencimento;

    public emprestimo(int se_codigo, Date data_vencimento) {
        this.se_codigo = se_codigo;
        this.data_vencimento = data_vencimento;
    }

    public java.sql.Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(java.sql.Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public int getSe_codigo() {
        return se_codigo;
    }

    public void setSe_codigo(int se_codigo) {
        this.se_codigo = se_codigo;
    }
    
}
