/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject;

/**
 *
 * @author kukkojoo
 */
public class Move {
    private Coordinate oldCoordinate;
    private Coordinate newCoordinate;
    
    public Move(String move) {
        this.oldCoordinate = new Coordinate(move.substring(0,2));
        this.newCoordinate = new Coordinate(move.substring(2,4));
    }
    
    public int getOldX() {
        return this.oldCoordinate.getX();
    }

    public int getOldY() {
        return this.oldCoordinate.getY();
    }    

    public int getNewX() {
        return this.newCoordinate.getX();
    }

    public int getNewY() {
        return this.newCoordinate.getY();
    }
    
    public Coordinate getOldCoordinate() {
        return this.oldCoordinate;
    }
    
    public Coordinate getNewCoordinate() {
        return this.newCoordinate;
    }
}
