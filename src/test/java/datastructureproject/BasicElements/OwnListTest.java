/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.BasicElements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import datastructureproject.OwnStructures.OwnList;
/**
 *
 * @author kukkojoo
 */
public class OwnListTest {
    OwnList list;
    
    public OwnListTest() {
        list = new OwnList();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }
    
    @Test
    public void testOwnListConstructor() {
        assertEquals(0, list.size());
    }
    
    @Test
    public void testOwnListAdd() {
        String test = "Hello";
        list.add(test);
        assertEquals(1, list.size());
        assertEquals("Hello", list.get(0));
    }
    
    @Test
    public void testOwnListAddMoreThanTen() {
        for (int i = 0; i < 20; i++) {
            String test = "a" + i;
            list.add(test);
        }
        assertEquals(20, list.size());
    }
    
    @Test
    public void testOwnListRemove() {
        String test = "Hello";
        list.add(test);
        assertEquals(1, list.size());
        assertEquals("Hello", list.get(0));
        list.remove(0);
        assertEquals(0, list.size());
    }
    
    @Test
    public void testOwnListClear() {
        String test = "Hello";
        list.add(test);
        assertEquals(1, list.size());
        assertEquals("Hello", list.get(0));
        list.clear();
        assertEquals(0, list.size());
    }
}
