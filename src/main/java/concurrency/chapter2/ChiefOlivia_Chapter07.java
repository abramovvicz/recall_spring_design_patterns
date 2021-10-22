package concurrency.chapter2;

class ChiefOlivia extends Thread {
//class ChiefOlivia implements Runnable {


    public void run() {
        System.out.println("Olivia started and waiting for sausage to thaw for 3s");
        try {
            Thread.sleep(3000);
            System.out.println("Olivia is cutting sausage now for 3 sec");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Olivia is done cutting the sausage");
    }


}
public class ChiefOlivia_Chapter07 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Baron started and requesting olivia for help.");

        Thread olivia = new ChiefOlivia();
//        Thread olivia = new Thread (new ChiefOlivia()); when using runnable we need pass constructor method
        System.out.println(" Olivia state: " + olivia.getState());
        System.out.println("Olivia thread ID" + olivia.getId());
        System.out.println("Olivia currentThread" + Thread.currentThread());
        System.out.println("Baron says Olivia to start");
        olivia.start();
        System.out.println(" Olivia state: " + olivia.getState());

        System.out.println("Baron cintiunous cooking the soup");
        Thread.sleep(500);
        System.out.println(" Olivia state: " + olivia.getState());

        System.out.println("Baron is waits for Olivia finish  and join");
        olivia.join();
        System.out.println(" Olivia state: " + olivia.getState());

        System.out.println("B and O done");
    }
}


