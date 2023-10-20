package com.ads02.desafioADS.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Table(name = "tb_livro")
public class LivroModel {
    @Id
    private Long id;
    private String titulo;
    private String autor;
    private Date dataPublicacao;
    private String editora;

    public LivroModel() {

    }

    public LivroModel(String titulo, String autor, Date dataPublicacao, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.editora = editora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
