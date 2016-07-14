package com.gmail.rollerxander.June29_06_16;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Java on 29.06.2016.
 */
@Entity
@Table(name = "film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany(mappedBy = "films")
    private Set<Actor> actors= new HashSet<>();

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addActor(Actor actor){
        actors.add(actor);
        actor.getFilms().add(this);

    }
    public  void removeActtor(Actor actor){
        actors.remove(actor);
        actor.getFilms().remove(this);
    }
}
