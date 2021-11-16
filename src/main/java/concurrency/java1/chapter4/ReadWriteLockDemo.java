package concurrency.java1.chapter4;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CalendarUser extends Thread {
    private static final List<String> WEEKDAYS = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
    private static int today = 0;
    private static ReentrantReadWriteLock marker = new ReentrantReadWriteLock();
    private static Lock readMarker = marker.readLock();
    private static Lock writeMarker = marker.writeLock();

    public CalendarUser(String name) {
        this.setName(name);
    }


    public void run() {
        while (today < WEEKDAYS.size() - 1) {
            if (this.getName().contains("Writer")) {//update the share calendar
                writeMarker.lock();
                try {
                    today = (today + 1) % 7;
                    System.out.println("today number"  + today);
                    System.out.println(this.getName() + " update date to " + WEEKDAYS.get(today));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                {
                    writeMarker.unlock();
                }
            } else {//check to see what day is today
                readMarker.lock();
                try {
                    System.out.println(this.getName() + " see that today is " + WEEKDAYS.get(today) + " total readers: " + marker.getReadLockCount());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    readMarker.unlock();
                }
            }
        }
    }
}


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) { //10 readers
            new CalendarUser("Reader-" + i).start();
        }

        for (int i = 0; i < 2; i++) { //only 2 writers
            new CalendarUser("Writer-" + i).start();
        }
    }


}
