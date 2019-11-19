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
public class livro {
    private int codigo_livro;
    private String titulo;
    private String resumo;
    private int ano_publicacao;
    private String volume;
    private String editora;
    private String edicao;
    private Double altura;
    private Double peso;
    private Double largura;
    private String isbn_issn;

    public livro(String titulo, String resumo, int ano_publicacao, String volume, String editora, String edicao, Double altura, Double peso, Double largura, String isbn_issn) {
        
        this.titulo = titulo;
        this.resumo = resumo;
        this.ano_publicacao = ano_publicacao;
        this.volume = volume;
        this.editora = editora;
        this.edicao = edicao;
        this.altura = altura;
        this.peso = peso;
        this.largura = largura;
        this.isbn_issn = isbn_issn;
    }

    public String getIsbn_issn() {
        return isbn_issn;
    }

    public void setIsbn_issn(String isbn_issn) {
        this.isbn_issn = isbn_issn;
    }

    public int getCodigo_livro() {
        return codigo_livro;
    }

    public void setCodigo_livro(int codigo_livro) {
        this.codigo_livro = codigo_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }
    
}
