package com.cacib;


import java.util.List;
import java.util.Set;

public class Serpent {

    private int longeur;
    private Position tete;
    private Position queue;
    
    private List<Position> cases;

    public List<Position> getCases() {
        return cases;
    }

    public void setCases(List<Position> cases) {
        this.cases = cases;
    }


    public int getLongeur() {
        return longeur;
    }

    public void setLongeur(int longeur) {
        this.longeur = longeur;
    }

    public Position getTete() {
        return tete;
    }

    public void setTete(Position tete) {
        this.tete = tete;
    }

    public Position getQueue() {
        return queue;
    }

    public void setQueue(Position queue) {
        this.queue = queue;
    }

}
