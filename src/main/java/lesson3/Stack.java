package lesson3;

import java.util.EmptyStackException;

public class Stack <T>{

    private Element head;
    private int capacity;

    public Stack() {
    }

    public Stack(Element head, int capacity) {
        this.head = head;
        this.capacity = capacity;
    }

    public void push(T value)  {

            Element<T> element = new Element<>(value);

                if (head == null && capacity != 0) {
                    head = element;


                } else if (head != null && capacity != 0) {
                    int counter = 0;
                    Element current = head;

                    while (current.getNext() != null) {
                        current = current.getNext();
                        counter++;
                    }
                    counter++;

                    if (counter >= capacity) {


                        throw new StackOverflowError();


                    } else {

                        current.setNext(element);
                    }

                } else if (capacity == 0) {

                    throw new StackOverflowError();


                }




    }


    public void pop()  {


            if (head == null && capacity == 0) {

                throw new EmptyStackException();


            } else {
                Element current = head;

                Element prev = new Element(null);
                while (current.getNext() != null) {
                    prev = current;
                    current = current.getNext();

                }
                prev.setNext(null);
                capacity -= 1;

            }


    }

    public String peek (){

        Object result;

            if (head == null) {

                throw new EmptyStackException();
            }else{

                result = head.getValue();
            }

            return result.toString();
    }

    public String toString () {
        String stackString = "";
        if (head == null) {

            throw new EmptyStackException();

        } else {

            Element current = head;

            StringBuffer buffer = new StringBuffer(stackString);

            while (current.getValue() != null && current.getNext() != null) {



                    buffer.append(stackString += current.getValue() + ",");
                    current = current.getNext();

            }


            buffer.append(stackString += current.getValue());



        }
        return stackString;
    }


    public void setHead(Element head) {
        this.head = head;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Element getHead() {
        return head;
    }

    public int getCapacity() {
        return capacity;
    }
}
