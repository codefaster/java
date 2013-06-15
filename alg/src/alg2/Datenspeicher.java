package alg2;

public interface Datenspeicher {

    /**
     * Fügt das gegebenen Element o in den Datenspeicher ein.
     */
    public void insert(Keyable o);
    /**
     * Gibt ein Element, das im Datenspeicher gespeichert ist und
     * den gegebenen Schlüssel besitzt zurück.
     * Existiert kein solches Element, wird null zurückgegeben.
     * Exisitieren mehr als nur ein Element mit dem Schlüssel, ist
     * nicht definiert, welches davon zurückggegeben wird.
     */
    public Keyable get(int key);
    /**
     * Gibt ein Element mit dem größten Schlüssel aus dem Datenspeicher
     * zurück. Falls der Datenspeicher leer ist, wird null zurückgegeben.
     * Gibt es mehrere Elemente mit maximalem Schlüssel, ist nicht klar
     * definiert, welches davon zurückgegeben wird.
     */
    public Keyable getMaximum();
    /**
     * Gibt ein Element mit dem kleinsten Schlüssel aus dem Datenspeicher
     * zurück. Falls der Datenspeicher leer ist, wird null zurückgegeben.
     * Gibt es mehrere Elemente mit minimalem Schlüssel, ist nicht klar
     * definiert, welches davon zurückgegeben wird.
     */
    public Keyable getMinimum();
    /**
     * Entfernt ein Element mit dem gegebenen Schlüssel und gibt das
     * Element, das entfernt wurde zurück. Enthält
     * der Datenspeicher kein solches Element, bleibt der Aufruf
     * dieser Methode ohne Wirkung auf den Inhalt des Speichers und
     * es wird null zurückgegeben.
     * Gibt es mehrere Elemente mit diesem Schlüssel, wird eines davon
     * entfernt, es ist aber nicht genau definiert, welches.
     */
    public Keyable remove(int key);
    /**
     * Entfernt das gegebene Element aus dem Datenspeicher. Ist das
     * Element nicht gespeichert, hat der Aufruf dieser Methode mit
     * einem solchen Argument keine Auswirkung auf den Datenspeicher.
     */
    public void remove(Keyable o);
    /**
     * Gibt genau dann true zurück, wenn das gegebene Element im 
     * Datenspeicher enthalten ist.
     */
    public boolean contains(Keyable o);
    /**
     * Gibt genau dann true zurück, wenn der Datenspeicher ein Element
     * mit dem gegebenen Schlüssel enthält.
     */
    public boolean contains(int key);
    /**
     * Gibt den Nachfolger des gegebenen Objekts zurück. Das
     * ist ein Element e aus dem Datenspeicher, so dass die
     * folgenden Bedingungen gelten:
     * <ol>
     * <li>e.getKey() > o.getKey()</li>
     * <li>Es gibt kein Element z aus dem Datenspeicher mit der Eigenschaft e.getKey() > z.getKey() > o.getKey.
     * </ol>
     * Sollte es kein solches Element geben, gibt die Methode null zurück.
     * Gibt es mehrere solcher Elemente, gibt die Methode eines von diesen
     * zurück, es ist aber nicht festgelegt, welches. 
     */
    public Keyable getSuccessor(Keyable o);
    /**
     * Gibt den Vorgänger des gegebenen Objekts zurück. Das
     * ist ein Element e aus dem Datenspeicher, so dass die
     * folgenden Bedingungen gelten:
     * <ol>
     * <li>e.getKey() < o.getKey()</li>
     * <li>Es gibt kein Element z aus dem Datenspeicher mit der Eigenschaft e.getKey() < z.getKey() < o.getKey.
     * </ol>
     * Sollte es kein solches Element geben, gibt die Methode null zurück.
     * Gibt es mehrere solcher Elemente, gibt die Methode eines von diesen
     * zurück, es ist aber nicht festgelegt, welches. 
     */
    public Keyable getPredecessor(Keyable o);
    /**
     * Gibt die Anzahl der gespeicherten Elemente zurück.
     */
    public int size();
    /**
     * Entfernt alle Elemente aus dem Datenspeicher.
     */
    public void clear();
    
}
