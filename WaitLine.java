package edu.pitt.project4;

public class WaitLine implements WaitLineInterface{
  private int arrivalTotal;
  private int servedTotal;
  private int waitTotal;

  public WaitLine(){
    arrivalTotal = 0;
    servedTotal = 0;
    waitTotal = 0;
    super();
  }
  public void addCustomer(Customer newCustomer){
    arrivalTotal++;
    enqueue(newCustomer);
  }
  public boolean hasCustomer(){
    return !isEmpty();
  }
  public Customer serveCustomer(int time){
    Customer served = dequeue();
    servedTotal++;
    waitTotal += (time - served.getArrivalTime());
    return served;
  }
  public int getTotalNumArrivals(){
    return arrivalTotal;
  }
  public int getTotalCustomersServed(){
    return servedTotal;
  }
  public int getTotalTimeWaited(){
    return waitTotal;
  }
}
