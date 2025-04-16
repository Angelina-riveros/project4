package edu.pitt.project4;

public class Queue<T> implements QueueInterface<T>{
    private Node firstNode;
    private Node lastNode;

    public class Node{
      private T data;
      private Node next;
      private Node previous;

      private Node(T dataPortion){
        data = dataPortion;
        next = null;
        previous = null;
      } 
    }
    public Queue(){
      firstNode = null;
      lastNode = null;
    }
    public void enqueue(T newEntry){
      Node newNode = new Node(newEntry, null);
      if(isEmpty()){
        firstNode = newNode;
      }else{
        lastNode.next = newNode;
        newNode.previous = lastNode;
      }
      lastNode = newNode;
    }
    public T dequeue(){
      if(isEmpty()){
        throw new EmptyQueueException();
      }
      T firstOne = getFront();
      firstNode = firstNode.next;
      if(firstNode == null){
        lastNode = null;
      }else{
        firstNode.previous(null);
      }
      return firstOne;
    }
    public T getFront(){
      if(isEmpty()){
        throw new EmptyQueueException();
      }
      return firstNode.getData();
    }
    public boolean isEmpty(){
      return (firstNode == null) && (lastNode == null);
    }
    public void clear(){
      firstNode = null;
      lastNode = null;
    }
}
