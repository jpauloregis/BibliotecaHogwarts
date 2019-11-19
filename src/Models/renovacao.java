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
public class renovacao {
    private int sr_renovacao;
    private java.sql.Date novadata_devolucao;

    public renovacao(int sr_renovacao, Date novadata_devolucao) {
        this.sr_renovacao = sr_renovacao;
        this.novadata_devolucao = novadata_devolucao;
    }

    public int getSr_renovacao() {
        return sr_renovacao;
    }

    public void setSr_renovacao(int sr_renovacao) {
        this.sr_renovacao = sr_renovacao;
    }

    public java.sql.Date getNovadata_devolucao() {
        return novadata_devolucao;
    }

    public void setNovadata_devolucao(java.sql.Date novadata_devolucao) {
        this.novadata_devolucao = novadata_devolucao;
    }
}
