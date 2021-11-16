package concurrency.java2.chapter1;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class HungryPerson extends Thread {

    private static Lock slowCookerLid = new ReentrantLock();
    private static int servings = 11;
    private static Condition soupTaken = slowCookerLid.newCondition(); // condition variable
    private int personID;

    public HungryPerson(int personID) {
        this.personID = personID;
    }


    public void run() {
        while (servings > 0) {
            slowCookerLid.lock();
            try {
                while ((personID != servings % 5) && servings > 0) {
                    soupTaken.await();
                    //you should wait for your turn
                    //check if it`s your turn
                    System.out.format("Pesron %d checked, but left lid back \n", personID);
                }
                if (servings > 0) {
                    servings--;
                    System.out.format("Pesron %d took some soup, servings left %d \n", personID, servings);
                    soupTaken.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                slowCookerLid.unlock();
            }
        }
    }
}


public class ConditionVariableDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new HungryPerson(i).start();
        }
    }
}
