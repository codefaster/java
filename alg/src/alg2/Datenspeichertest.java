package alg2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;

public class Datenspeichertest {

    private static StringBuffer logBuffer = new StringBuffer();    
    
    private static class TestKeyable implements Keyable {
        
        private static Random rand = new Random(new Date().getTime());
        private static long nrCounter = 0;
        private int myKey;
        private long myNr;        
        
        public TestKeyable() {
            myKey = rand.nextInt(Integer.MAX_VALUE);
            myNr = nrCounter;
            nrCounter++;
        }

        @Override
        public int getKey() {            
            return myKey;
        }
    }


    private static void clearLog() {
        logBuffer = new StringBuffer();    
    }

    private static void log(String s) {
        logBuffer.append(s);
        logBuffer.append("\n");
    }
            
    private static String getLogMsg(String msg) {
        return msg + "\n\nTestlog:\n\n" +  logBuffer.toString();
    }
    
    @Test
    public void smallUnsortedArrayStorageInsertionTest() {
        insertionTest(100, new UnsortedArrayStorage());
    }
    
    
    @Test
    public void smallUnsortedArrayStorageRemovalTest() {
        removalTest(100, new UnsortedArrayStorage());
    }
    
    @Test
    public void smallUnsortedArrayStorageMaxMinTest() {
        maxMinTest(50, new UnsortedArrayStorage());
    }
    
    @Test
    public void largeUnsortedArrayStorageRemovalTest() {
        removalTest(50000, new UnsortedArrayStorage());
    }
    
   @Test
    public void largeUnsortedArrayStorageInsertionTest() {
        insertionTest(50000, new UnsortedArrayStorage());
    }
    
    
    @Test
    public void largeUnsortedArrayStorageMaxMinTest() {
        maxMinTest(10000, new UnsortedArrayStorage());
    }
    
    
    
    @Test
    public void smallLinkedListStorageInsertionTest() {
        insertionTest(100, new LinkedListStorage());
    }
    
    
    @Test
    public void smallLinkedListStorageRemovalTest() {
        removalTest(100, new LinkedListStorage());
    }
    
    @Test
    public void smallLinkedListStorageMaxMinTest() {
        maxMinTest(50, new LinkedListStorage());
    }
    
    
    @Test
    public void largeLinkedListStorageRemovalTest() {
        removalTest(50, new LinkedListStorage());
    }
    
    @Test
    public void largeLinkedListStorageInsertionTest() {
        insertionTest(50, new LinkedListStorage());
    }
    
    
    @Test
    public void largeLinkedListMaxMinTest() {
        maxMinTest(1000, new LinkedListStorage());
    }

    
    
    private void insertionTest(int size, Datenspeicher ds) {
        clearLog();
        log("Starte Einfügetest mit " + size + " Elementen.");
        LinkedList<Keyable> l = new LinkedList<Keyable>(); 
        for (int i=0; i<size; i++) {
            TestKeyable t = new TestKeyable();
            log("Füge Element mit Schlüssel " + t.getKey() + " hinzu.");
            l.add(t);
            ds.insert(t);
        }
        assertEquals(l.size(), ds.size());
        for (Keyable ka : l) {
            //log("Prüfe contains(int): " + ka.getKey());
            if (!ds.contains(ka.getKey()))
                assertTrue(getLogMsg("Element mit Schlüssel " + ka.getKey() + " konnte bei Aufruf von contains(int) nicht gefunden werden."),
                           ds.contains(ka.getKey()));
            //log("Prüfe contains(Keyable): " + ka.getKey());
            if (!ds.contains(ka))
                assertTrue(getLogMsg("Element mit Schlüssel " + ka.getKey() + " konnte bei Aufruf von contains(Keyable) nicht gefunden werden."),
                           ds.contains(ka));
        }
    }
    
    
    private void removalTest(int size, Datenspeicher ds) {
        clearLog();
        log("Starte Löschtest mit " + size + " Elementen.");
        LinkedList<Keyable> l = new LinkedList<Keyable>(); 
        for (int i=0; i<size; i++) {
        	TestKeyable t = new TestKeyable();
            l.add(t);
            log("Füge Element mit Schlüssel " + t.getKey() + " hinzu.");
            ds.insert(t);
        }
        int count = l.size();
        for (Keyable ka : l) {
            log("Entferne Element mit Schlüssel " + ka.getKey() + ".");
            ds.remove(ka.getKey());
            count--;
            if (ds.size()!= count)
                assertEquals(getLogMsg("Erwartete Größe des Speichers: " + count),
                             ds.size(), count);
        }
    }
    
    private void maxMinTest(int size, Datenspeicher ds) {    
        clearLog();
        log("Starte Max-/Mintest mit " + size + " Elementen.");
        LinkedList<Keyable> l = new LinkedList<Keyable>();
        TestKeyable min = null;
        TestKeyable max = null;
        HashSet<Integer> pool = new HashSet<Integer>();
        for (int i=0; i<size; i++) {
            TestKeyable t = new TestKeyable();
            while (pool.contains(t.getKey())) t = new TestKeyable();
            if (i==0) {
                min = t;
                max = t;
            } else {
                if (t.getKey() > max.getKey()) max = t;
                if (t.getKey() < min.getKey()) min = t;
            }
            log("Füge Element mit Schlüssel " + t.getKey() + " hinzu.");
            l.add(t);
            ds.insert(t);
        }
        Keyable minEle = ds.getMinimum();
        if (min != minEle)
            assertEquals(getLogMsg("Falsches kleinstes Element: " + minEle.getKey() + ". Erwartet: " + min.getKey() + "."),
                         min, minEle);
        TestKeyable maxEle = (TestKeyable)ds.getMaximum();
        if (max != maxEle)
            assertEquals(getLogMsg("Falsches größtes Element: " + maxEle.getKey() + ". Erwartet: " + max.getKey() + "."),
                         max, maxEle);
    }
    
    
    
    
}
