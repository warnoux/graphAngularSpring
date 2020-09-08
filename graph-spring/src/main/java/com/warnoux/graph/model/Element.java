package com.warnoux.graph.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Elements")
public class Element {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "poids")
    private Integer poids;

    public Element(int i) {
        this.poids = i;
    }
}
