package com.tf2ranked.web.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Player implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(name = "rank")
    @NotNull
    private float rank;

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

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o instanceof Player)
            return false;
        Player player = (Player) o;
        return Float.compare(player.rank, rank) == 0 && id.equals(player.id) && name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rank);
    }
}
