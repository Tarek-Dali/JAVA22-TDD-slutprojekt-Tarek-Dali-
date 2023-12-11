package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import main.Item;
import test.mockedObjects.MockBuffer;
import test.mockedObjects.MockConsumer;
import test.mockedObjects.MockItem;
import test.mockedObjects.MockProducer;

public class TestBuffer {

    @Test
    @DisplayName("Check if buffer is not empty")
    void IsBufferNotEmpty() {
        MockBuffer mockBuffer = new MockBuffer();
        MockProducer mockProducer = new MockProducer(mockBuffer);
        MockConsumer mockConsumer = new MockConsumer(mockBuffer);
        MockItem mockItem = new MockItem("hej");
        mockProducer.additem(mockItem);
        assertEquals(mockItem, mockConsumer.removeItem());

    }
    
    
    @Test
    @DisplayName("Check if buffer is empty")
    void IsBufferEmpty() {
        MockBuffer mockBuffer = new MockBuffer();
        MockProducer mockProducer = new MockProducer(mockBuffer);
        MockConsumer mockConsumer = new MockConsumer(mockBuffer);
        MockItem mockItem = new MockItem("hej");
        mockProducer.additem(mockItem);
        mockConsumer.removeItem();
        assertTrue(mockBuffer.getBuffer().isEmpty());

    }
    
    @Test
    @DisplayName("Test output when adding new item")
    void testOutput() {
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	PrintStream originalOut = System.out;
    	System.setOut(new PrintStream(outContent));
    	outContent.reset();
    	
    	MockBuffer mockBuffer = new MockBuffer();
    	MockProducer mockProducer = new MockProducer(mockBuffer);
    	mockProducer.additem(new MockItem("viking"));
    	
    	assertTrue(outContent.toString().contains("[viking]"));
    	outContent.reset();
    	System.setOut(originalOut);
    }
    
    @Test
    @DisplayName("Test Buffer additem return true")
    void testReturnTrue() {
        MockBuffer mockBuffer = new MockBuffer();
        MockProducer mockProducer = new MockProducer(mockBuffer);
        MockItem mockItem = new MockItem("hej");
        assertTrue(mockProducer.additem(mockItem));
    }

    @Test
    @DisplayName("Test wait")
    void testWait() throws InterruptedException {
        MockBuffer mockBuffer = new MockBuffer();
        MockConsumer mockConsumer = new MockConsumer(mockBuffer);

        Thread thread = new Thread(() -> assertThrows(InterruptedException.class, ()-> mockConsumer.removeItem()));
        thread.start();
        thread.interrupt();
    }

}