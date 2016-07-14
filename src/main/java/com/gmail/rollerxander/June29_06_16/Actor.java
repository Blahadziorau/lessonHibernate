package com.gmail.rollerxander.June29_06_16;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Java on 29.06.2016.
 */
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name = "hello", joinColumns = @JoinColumn(name = "f_id"),inverseJoinColumns = @JoinColumn(name = "a_id"))
    private Set<Film> films= new HashSet<>();

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFilm(Film film){
        films.add(film);
        film.getActors().add(this);
    }

    public void removeFilm(Film film){
        films.remove(film);
        film.getActors().remove(this);
    }
}
