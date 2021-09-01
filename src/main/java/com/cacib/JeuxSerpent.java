package com.cacib;

public class JeuxSerpent {
    private Serpent serpent;
    private int canvaslargeur;
    private int canvashauteur;


    public Serpent getSerpent() {
        return serpent;
    }

    public void setSerpent(Serpent serpent) {
        this.serpent = serpent;
    }

    public int getCanvaslargeur() {
        return canvaslargeur;
    }

    public void setCanvaslargeur(int canvaslargeur) {
        this.canvaslargeur = canvaslargeur;
    }

    public int getCanvashauteur() {
        return canvashauteur;
    }

    public void setCanvashauteur(int canvashauteur) {
        this.canvashauteur = canvashauteur;
    }

    public boolean isSerpentDansLeCadre(int x, int y) {
        return (x >=0 || x <= this.canvaslargeur)
                && (y >=0 || y <= this.canvashauteur);
    }

    public Position moveTB() {
        int newX = this.serpent.getTete().getX() - 1;
        int newY = this.serpent.getTete().getY();
        if (isSerpentDansLeCadre(newX, newY) && !iscaseoccupee(newX, newY)) {
            return new Position(newX, newY);
        }
        return null;
    }

    public Position moveTH() {
        int newX = this.serpent.getTete().getX() + 1;
        int newY = this.serpent.getTete().getY();
        if (isSerpentDansLeCadre(newX, newY) && !iscaseoccupee(newX, newY)) {
            return new Position(newX, newY);
        }
        return null;
    }

    public Position moveTD() {
        int newX = this.serpent.getTete().getX();
        int newY = this.serpent.getTete().getY() + 1;
        if (isSerpentDansLeCadre(newX, newY) && !iscaseoccupee(newX, newY)) {
            return new Position(newX, newY);
        }
        return null;
    }

    public Position moveTG() {
        int newX = this.serpent.getTete().getX();
        int newY = this.serpent.getTete().getY() - 1;
        if (isSerpentDansLeCadre(newX, newY) && !iscaseoccupee(newX, newY)) {
            return new Position(newX, newY);
        }
        return null;
    }

    public boolean iscaseoccupee(int x, int y) {
        return this.serpent.getCases().stream().anyMatch(p -> p.getX() == x && p.getY() ==y);
    }

    public Position moveB(int x, int y) {
        return new Position(x - 1, y);
    }

    public Position moveH(int x, int y) {
        return new Position(x + 1, y);
    }

    public Position moveD(int x, int y) {
        return new Position(x,  y + 1);
    }

    public Position moveG(int x, int y) {
        return new Position(x, y - 1);
    }
}
