package lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest{
    Stack <Object> stack;
    Element <Object> element;

    @BeforeEach
    void createNewStack() {
        stack = new Stack<>();
        element = new Element<>(null);
        stack.setHead(element);
    }


    @Test
    public void testPush_headNullAndCapacityNotNull_returnNewElement(){
        stack.setHead(null);
        stack.setCapacity(4);
        stack.push("7");
        Assertions.assertEquals("7", stack.peek());

    }

    @Test
    public void testPush_headNotNullAndCapacityNotNull_returnNewElement (){
        stack.setCapacity(3);
        element = new Element<>("kek");
        stack.setHead(element);
        Assertions.assertEquals("kek", stack.peek());
    }

    @Test
    public void testPush_headAndCapacityNotNullStackIsFull_returnStackOverFlowException(){
        stack.setCapacity(3);
        stack.setHead(null);
        stack.push("1");
        stack.push("2");
        stack.push("3");

        assertThrows(StackOverflowError.class, () -> stack.push("4"));

    }

    @Test
    public void testPush_headAndCapacityNull_returnStackOverFlowException(){
        stack.setCapacity(0);
        stack.setHead(null);
        assertThrows(StackOverflowError.class, ()-> stack.push("test"));

    }


    @Test
    public void testPop_headAndCapacityNotNull_returnEmptyStackException(){
        stack.setCapacity(0);
        stack.setHead(null);
        assertThrows(EmptyStackException.class, () -> stack.pop());

    }

    @Test
    public void testPop_headAndCapacityNotNull_returnHeadToString(){
        stack.setCapacity(3);
        stack.setHead(null);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        Assertions.assertEquals(2, stack.getCapacity());
        Assertions.assertEquals("1,2", stack.toString());

    }

    @Test
    public void testPeek_headNull_returnEmptyStackException(){
        stack.setHead(null);
        stack.setCapacity(0);
        assertThrows(EmptyStackException.class, () -> stack.peek());

    }

    @Test
    public void testPeek_headNotNull_returnString(){
        stack.setCapacity(8);
        element = new Element<>("kek");
        stack.setHead(element);
        Assertions.assertEquals("kek", stack.peek());
    }

    @Test
    public void testToString_headAndCapacityNotNull_returnString(){
        stack.setCapacity(3);
        stack.setHead(null);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals("1,2,3", stack.toString());


    }

    @Test
    public void testToSting_headAndCapacityNull_returnEmptyStackException(){
        stack.setCapacity(0);
        stack.setHead(null);
        assertThrows(EmptyStackException.class, () -> stack.toString());
    }





}
