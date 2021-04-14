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
public class Coordinate {
    String coordinate;
    
    public Coordinate(String coordinate) {
        this.coordinate = coordinate.trim().toLowerCase();
    }
    
    public Coordinate(int coordinateX, int coordinateY) {
        String coor = "";
        
        if (coordinateX == 1) {
            coor = "a";
        }
        
        if (coordinateX == 2) {
            coor = "b";
        }

        if (coordinateX == 3) {
            coor = "c";
        }

        if (coordinateX == 4) {
            coor = "d";
        }        

        if (coordinateX == 5) {
            coor = "e";
        }        

        if (coordinateX == 6) {
            coor = "f";
        }
        
        if (coordinateX == 7) {
            coor = "g";
        }

        if (coordinateX == 8) {
            coor = "h";
        }

        coor = coor + coordinateY;
        
        this.coordinate = coor;
        
    }
    
    public String getCoordinate() {
        return this.coordinate;
    }
    
    public int getX() {
        String character = this.coordinate.substring(0,1);
        
        if (character.equals("a")) {
            return 1;
        }
        
        if (character.equals("b")) {
            return 2;
        }
        if (character.equals("c")) {
            return 3;
        }
        if (character.equals("d")) {
            return 4;
        }        
        if (character.equals("e")) {
            return 5;
        }
        if (character.equals("f")) {
            return 6;
        }
        if (character.equals("g")) {
            return 7;
        }           
        return 8;
    }
    
    public int getY() {
        return Integer.parseInt(this.coordinate.substring(1));
    }
}
