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
    
    public Move(Coordinate oldCoordinate, Coordinate newCoordinate) {
        this.oldCoordinate = oldCoordinate;
        this.newCoordinate = newCoordinate;
    }
    
    /**
     * Returns old x coordinate as an Integer
     * @return x coordinate as an Integer
     */
    
    public int getOldX() {
        return this.oldCoordinate.getX();
    }
    
    /**
     * Returns old y coordinate as an Integer
     * @return y coordinate as an Integer
     */

    public int getOldY() {
        return this.oldCoordinate.getY();
    }    
    
    /**
     * Returns new x coordinate as an Integer
     * @return x coordinate as an Integer
     */

    public int getNewX() {
        return this.newCoordinate.getX();
    }
    
    /**
     * Returns new y coordinate as an Integer
     * @return y coordinate as an Integer
     */

    public int getNewY() {
        return this.newCoordinate.getY();
    }
    
    /**
     * Returns old coordinate
     * @return old coordinate
     */
    
    public Coordinate getOldCoordinate() {
        return this.oldCoordinate;
    }
    
    /**
     * Returns new coordinate
     * @return new coordinate
     */
    
    public Coordinate getNewCoordinate() {
        return this.newCoordinate;
    }
    
    /**
     * Returns move as String
     * @return move
     */
    
    public String getMove() {
        return this.oldCoordinate.getCoordinate() + this.newCoordinate.getCoordinate();
    }
    
    /**
     * Prints move
     */
    
    public void printMove() {
        System.out.println(this.oldCoordinate.getCoordinate() + this.newCoordinate.getCoordinate());
    }
}
