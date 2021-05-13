/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.OwnStructures;

/**
 *
 * @author kukkojoo
 */
public class OwnList {
    private Object[] data;
    private int size;

    public OwnList() {
        data = new Object[10];
        size = 0;
    }
    
    /**
     * Adds an object to list
     * 
     * @param a an object that is added to list
     */
    
    public void add(Object a) {
        if (size == data.length) {
            enlarge(size * 2);
        }
        data[size] = a;
        size++;
    }
    
    /**
     * Adds an list of objects to list
     *
     * @param list a list of object that is added to list
     */
    
    public void addAll(OwnList list) {
        if (size + list.size() >= data.length) {
            enlarge((size + list.size) * 2);
        }
        
        for (int i = 0; i < list.size; i++) {
            data[size] = list.get(i);
            size++;
        }
        
        
    }
    
    /**
     * Removes an object from list base on index
     * @param index an index which can be removed from list
     */
    
    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds");
        }
        
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative");
        }
        
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        
        size--;
        
        if (data.length / 4 > size) {
            reduce();
        }
    }
    
    /**
     * Returns an object base on given index
     * 
     * @param index an index of object that want to be returned
     * @return the object
     */
    
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
        
        return data[index];
    }
    /**
     * Returns size of list
     * @return an int which is size of list
     */
    
    public int size() {
        return size;
    }
    
    /**
     * Enlarges the list
     * @param newSize new size of list
     */

    private void enlarge(int newSize) {
        Object[] helpData = new Object[newSize];
        
        for (int i = 0; i < size; i++) {
            helpData[i] = data[i];
        }
        
        data = helpData;
    }
    
    /**
     * Decreases the list
     */

    private void reduce() {
        Object[] helpData = new Object[data.length / 2];
        
        for (int i = 0; i < size; i++) {
            helpData[i] = data[i];
        }
        
        data = helpData;
    }
    
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        
        String list = "[";
        
        for (int i = 0; i < size - 1; i++) {
            list +=  (i + 1) + ".(" + data[i].toString() + "), ";
        }
        
        list += size + ".(" + data[size-1].toString() + ")]";
        
        return list;
    }
    
    /**
     * Clears the list to default situation
     */

    public void clear() {
        data = new Object[10];
        size = 0;
    }
}
