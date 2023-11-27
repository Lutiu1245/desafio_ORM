package com.example.desafio_ORM.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_participantes")
public class Participantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "tb_participante_atividade", joinColumns = @JoinColumn(name = "participantes_id"), inverseJoinColumns = @JoinColumn(name = "atividades_id"))
    private Set<Atividade> atividades = new HashSet<>();

    public Participantes(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participantes that = (Participantes) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
