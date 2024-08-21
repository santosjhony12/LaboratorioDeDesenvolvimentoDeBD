package br.gov.sp.fatec.projeto_spring20242.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ant_anotacao")
public class Anotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    @JsonView(View.ViewAnotacao.class)
    private Long id;

    @Column(name = "ant_texto")
    @JsonView({View.ViewUsuario.class, View.ViewAnotacao.class})
    private String texto;

    @Column(name = "ant_data_hora")
    @JsonView(View.ViewUsuario.class)
    private LocalDateTime data_hora;

    // O EAGER EU USO QUANDO SEMPRE PRECISO ACESSAR O OBJETO RELACIONADO. ENQUANTO O LAZY ELE SÓ VAI REALIZAR O SELECT QUANDO EU CHAMAR UM GET
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ant_usr_id")
    @JsonView(View.ViewAnotacao.class)
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
