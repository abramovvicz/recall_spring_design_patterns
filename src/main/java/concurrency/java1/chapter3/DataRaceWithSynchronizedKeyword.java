package concurrency.java1.chapter3;

class ShopperSecond extends Thread {

    static int garlicCount = 0;

    private static synchronized void addGarlic() {
        garlicCount++;
    }

    /*
        attention: this static should be cause,
        it is realted with ShopperSecond class, if it`s not this synchronized keyword
        would be about reference to object ShopperSecond class
     */


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Shopper.class) {
                //could use this to synchronized block and add keyword synchronized to value
                //garlicCount and change it to Integer but this would not prevent Data Race
                //cause Integer is immutable so create new object every time when increase it
                //should be careful to choose objects
                garlicCount++;
            }
        }
    }
}


public class DataRaceWithSynchronizedKeyword {

    public static void main(String[] args) throws InterruptedException {

        Thread olivia = new ShopperSecond();
        Thread baron = new ShopperSecond();

        baron.start();
        olivia.start();


        baron.join();
        olivia.join();
        System.out.println("We should buy: " + ShopperSecond.garlicCount + " garlic");


    }
}
