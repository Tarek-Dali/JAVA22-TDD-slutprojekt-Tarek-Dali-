package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.mockedObjects.MockItem;

public class TestItem {

    @Test
    @DisplayName("test uppercase to lowercase string")
    void testLowercase() {    
        MockItem mockItem = new MockItem("MAyBE");
        assertEquals("maybe", mockItem.getId());
    }
    
    @Test
    @DisplayName("test empty string")
    void testEmptyString() {
    	MockItem mockItem = new MockItem("");
    	assertEquals("", mockItem.getId());
    }
    
    @Test
    @DisplayName("test numbers string")
    void testNumbers() {    
        MockItem mockItem = new MockItem("123");
        assertEquals("123", mockItem.getId());
    }

    @Test
    @DisplayName("test id null")
    void testIdNull() {    
        assertThrows(NullPointerException.class, () -> new MockItem(null));
    }
    
    @Test
    @DisplayName("test numbers to string")
    void testNumbersToString() {    
        MockItem mockItem = new MockItem("123");
        assertEquals("123", mockItem.toString());
    }
    
    @Test
    @DisplayName("test string to lowercase")
    void testStringToLowerCaseString() {    
        MockItem mockItem = new MockItem("Hi There");
        assertEquals("hi there", mockItem.toString());
    }
    
    @Test
    @DisplayName("test empty string to string")
    void testEmptyToString() {    
        MockItem mockItem = new MockItem("");
        assertEquals("", mockItem.toString());
    }
    
    
    @Test
    @DisplayName("test set id to lowercase")
    void testSetIDLowerCase() {
    	MockItem mockItem = new MockItem("CHILLY");
    	mockItem.setId("chilly");
    	assertEquals("chilly", mockItem.getId());
    }
    
    @Test
    @DisplayName("test set id to empty string")
    void testSetIDEmptyString() {
    	MockItem mockItem = new MockItem("Pizza");
    	mockItem.setId("");
    	assertEquals("", mockItem.getId());
    }
    
    @Test
    @DisplayName("test set id to numbers string")
    void testSetIDStringNumbers() {
    	MockItem mockItem = new MockItem("Pizza");
    	mockItem.setId("2023");
    	assertEquals("2023", mockItem.getId());
    }
    
    
    @Test
    @DisplayName("test set ID null")
    void testSetIDNull() throws NullPointerException {
    	MockItem mockItem = new MockItem("Test");
    	assertThrows(NullPointerException.class,() -> mockItem.setId(null));
    }
    
    

}