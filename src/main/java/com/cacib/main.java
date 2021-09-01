package com.cacib;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Serpent serpent = new Serpent();
        serpent.setLongeur(5);
        serpent.setTete(new Position(4,0));
        ArrayList<Position> casesoccupees = new ArrayList<Position>() {{
            add(new Position(0,0));
            add(new Position(1,0));
            add(new Position(2,0));
            add(new Position(3,0));
            add(new Position(4,0));
        }};
        serpent.setCases(casesoccupees);

        JeuxSerpent jeuxSerpent = new JeuxSerpent();
        jeuxSerpent.setCanvashauteur(100);
        jeuxSerpent.setCanvaslargeur(100);
        jeuxSerpent.setSerpent(serpent);

        String parcours  = "DDBBBDHHGGHDDDBDBDDHGGBDBGGBBGGHGBBGHGHHHDHHDDDDBB";

        char[] parcoursArray = parcours.toCharArray();

        for (char deplacement: parcoursArray) {
            Position newP = null;
            switch (deplacement) {
                case 'H':
                    newP = jeuxSerpent.moveTH();
                    break;
                case 'B':
                    newP = jeuxSerpent.moveTB();
                    break;
                case 'D':
                    newP = jeuxSerpent.moveTD();
                    break;
                case 'G':
                    newP = jeuxSerpent.moveTG();
                    break;
            }

            if (newP != null) {
                serpent.setTete(newP);
                serpent.setCases(serpent.getCases().stream().map(p -> {
                    Position newPosition = null;
                    switch (deplacement) {
                        case 'H':
                            newPosition = jeuxSerpent.moveH(p.getX(), p.getY());
                            break;
                        case 'B':
                            newPosition = jeuxSerpent.moveB(p.getX(), p.getY());
                            break;
                        case 'D':
                            newPosition = jeuxSerpent.moveD(p.getX(), p.getY());
                            break;
                        case 'G':
                            newPosition = jeuxSerpent.moveG(p.getX(), p.getY());
                            break;
                    }
                    return newPosition;
                }).collect(Collectors.toList()));
            }
        }


        System.out.println("la position finale (X, Y) : (" + serpent.getCases().get(0).getX() + "," + serpent.getCases().get(0).getY() +")");


    }
}
