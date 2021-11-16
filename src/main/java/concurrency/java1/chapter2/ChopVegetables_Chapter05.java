package concurrency.java1.chapter2;

public class ChopVegetables_Chapter05 extends Thread {

    private static boolean chopping = true;
    private int count = 0;

    public ChopVegetables_Chapter05(String name) {
        this.setName(name); //nadaje nazwę threadsowi
    }

    public static void main(String[] args) throws InterruptedException {
        ChopVegetables_Chapter05 onion = new ChopVegetables_Chapter05("Onion");
        ChopVegetables_Chapter05 carrot = new ChopVegetables_Chapter05("Carrot");

        onion.start();
        carrot.start();
        Thread.sleep(500); //działaj przez jedną sekundę
        System.out.println(Thread.currentThread());
        ChopVegetables_Chapter05.chopping = false;

        onion.join(); // join czeka aż thread zginie
        carrot.join();
        System.out.println("Chopped by onion " + onion.count);
        System.out.println("Chopped by carrot " + carrot.count);
    }

    @Override
    public void run() {
        while (chopping) {
            System.out.println("Vegetables chopping " + count);
            count++;
        }
    }


}


