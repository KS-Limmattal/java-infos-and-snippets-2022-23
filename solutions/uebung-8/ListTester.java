import java.util.Random;

/*
 * Erstellen Sie hier eine List vom Typ int, mit der Sie die Funktionalität und Performance von
 * "ArrayList" und "DynamicArrayList" testen.
 * Initialisieren Sie die Liste vom Typ Integer, pushen die Zahlen 1, 2, 3 und 4
 * und geben die so gefüllte Liste auf der Konsole aus.
 * Poppen Sie dann zwei Zahlen und geben Sie sie auf der Konsole aus, ebenso die resultierende Liste.
 * Machen Sie die gleichen Tests mit queue und dequeue.
 * 
 * Testen Sie dann die Effizienz von push und pop bzw. queue und dequeue, indem Sie sie einige Tausend Mal
 * hintereinander ausführen und dann die Anzahl steigern. Füttern Sie dazu die List mit randomisierten int-Werten.
 * Für die Zeitstoppung können Sie den folgenden Code verwenden:
 * 
 * start = System.nanoTime();
 * // TODO Insert test code
 * elapsed = System.nanoTime() - start;
 * System.out.println("Elapsed millisec for test code" + elapsed * 1.0 / 1000000);
 * 
 * Sobald Sie DynamicArrayList implementiert haben, testen Sie wieder, ob sie funktioniert
 * und untersuchen Sie danach auf Effizienz.
 */

public class ListTester {

    public static void StackTester(List<Integer> list) {
        System.out.println("Test of " + list.getClass().toString() + " as Stack");
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        System.out.println(list.toString());
        System.out.println("pop: " + list.pop());
        System.out.println("pop: " + list.pop());
        System.out.println(list.toString());
        // The following code was important to test removing the last remaining item from the list.
        // System.out.println("pop: " + list.pop());
        // System.out.println("pop: " + list.pop());
        // System.out.println(list.toString());
    }

    public static void QueueTester(List<Integer> list) {
        System.out.println("Test of " + list.getClass().toString() + " as Queue");
        list.queue(1);
        list.queue(2);
        list.queue(3);
        list.queue(4);
        System.out.println(list.toString());
        System.out.println("dequeue: " + list.dequeue());
        System.out.println("dequeue: " + list.dequeue());
        System.out.println(list.toString());
        // The following code was important to test removing the last remaining item from the list.
        // System.out.println("dequeue: " + list.dequeue());
        // System.out.println("dequeue: " + list.dequeue());
        // System.out.println(list.toString());
        System.out.println();
    }

    public static void StackPerformanceTester(List<Integer> list, int sampleSize) {
        Random rnd = new Random();
        long start, elapsed;
        System.out.println("Stack performance test on " + list.getClass().toString() + " with sample size " + sampleSize);
        
        // push
        start = System.nanoTime();
        for (int i = 1; i <= sampleSize; ++i) {
            list.push(rnd.nextInt());
        }
        elapsed = System.nanoTime() - start;
        System.out.println("Elapsed millisec for push " + elapsed * 1.0 / 1000000);

        // pop
        start = System.nanoTime();
        for (int i = 1; i <= sampleSize; ++i) {
            list.pop();
        }
        elapsed = System.nanoTime() - start;
        System.out.println("Elapsed millisec for pop " + elapsed * 1.0 / 1000000 + "\n\r");
    }

    public static void QueuePerformanceTester(List<Integer> list, int sampleSize) {
        Random rnd = new Random();
        long start, elapsed;
        System.out.println("Queue performance test on " + list.getClass().toString() + " with sample size " + sampleSize);
        
        // queue
        start = System.nanoTime();
        for (int i = 1; i <= sampleSize; ++i) {
            list.queue((int) rnd.nextInt());
        }
        elapsed = System.nanoTime() - start;
        System.out.println("Elapsed millisec for queue " + elapsed * 1.0 / 1000000);

        // dequeue
        start = System.nanoTime();
        for (int i = 1; i <= sampleSize; ++i) {
            list.dequeue();
        }
        elapsed = System.nanoTime() - start;
        System.out.println("Elapsed millisec for dequeue " + elapsed * 1.0 / 1000000 + "\n\r");
    }

    public static void main(String[] args) {

        /*
         * Functionality tests of the implemented List classes
         */
        StackTester(new ArrayList<Integer>());
        QueueTester(new ArrayList<Integer>());

        StackTester(new DynamicArrayList<Integer>());
        QueueTester(new DynamicArrayList<Integer>());

        StackTester(new DynamicRingList<Integer>());
        QueueTester(new DynamicRingList<Integer>());


        /*
         * Performance tests on the implemented List classes
         */
        int sampleSize = 10000;

        StackPerformanceTester(new ArrayList<Integer>(), sampleSize);
        QueuePerformanceTester(new ArrayList<Integer>(), sampleSize);
        
        StackPerformanceTester(new DynamicArrayList<Integer>(), sampleSize);
        QueuePerformanceTester(new DynamicArrayList<Integer>(), sampleSize);

        StackPerformanceTester(new DynamicRingList<Integer>(), sampleSize);
        QueuePerformanceTester(new DynamicRingList<Integer>(), sampleSize);
    }
}

