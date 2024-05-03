package ens18trn.cs.umu.se;

import java.util.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class HashMapDouble<K,V> extends HashMap<K, V> {
    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 11;


    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static class Node<K,V> implements Entry<K,V> {
        final int hash;
        int dhash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, int dhash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.dhash = dhash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }
    /* ---------------- Static utilities -------------- */

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     */

    /*static final int hash1(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }*/
    static final int hash1(Object key) {
        int h = (Math.abs((h = key.hashCode()) ^ (h << 16)));
        return (key == null) ? 0 : h;
    }

    static final int hash2(Object key) {
        int h = (Math.abs((h = key.hashCode() * 5381)));
        return (key == null) ? 0 : h;
    }

    /**
     * Returns x's Class if it is of the form "class C implements
     * Comparable<C>", else null.
     */
    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (Type t : ts) {
                    if ((t instanceof ParameterizedType) &&
                            ((p = (ParameterizedType) t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
            }
        }
        return null;
    }

    /**
     * Returns k.compareTo(x) if x matches kc (k's screened comparable
     * class), else 0.
     */
    @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
    static int compareComparables(Class<?> kc, Object k, Object x) {
        return (x == null || x.getClass() != kc ? 0 :
                ((Comparable)k).compareTo(x));
    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    /* ---------------- Fields -------------- */

    /**
     * The table, initialized on first use, and resized as
     * necessary. When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     */
    transient Node<K,V>[] table;

    /**
     * Holds cached entrySet(). Note that AbstractMap fields are used
     * for keySet() and values().
     */
    transient Set<Entry<K,V>> entrySet;

    /**
     * The number of key-value mappings contained in this map.
     */
    transient int size;

    int sizePos = 0;
    int[] sizes = {11, 23, 47, 97, 197, 397, 797, 1597, 3203, 6421, 12853,
                            25717, 51437, 102877, 205759, 411527, 823117, 1646237, 3292489, 6584983,
                            13169977, 26339969, 52679969, 105359939, 210719881, 421439783, 842879579, 1685759167, 2147483647};
    /**
     * The number of times this HashMap has been structurally modified
     * Structural modifications are those that change the number of mappings in
     * the HashMap or otherwise modify its internal structure (e.g.,
     * rehash).  This field is used to make iterators on Collection-views of
     * the HashMap fail-fast.  (See ConcurrentModificationException).
     */
    transient int modCount;

    /**
     * The next size value at which to resize (capacity * load factor).
     *
     * @serial
     */
    // (The javadoc description is true upon serialization.
    // Additionally, if the table array has not been allocated, this
    // field holds the initial array capacity, or zero signifying
    // DEFAULT_INITIAL_CAPACITY.)
    int threshold;

    /**
     * The load factor for the hash table.
     *
     * @serial
     */
    final float loadFactor;

    /* ---------------- Public operations -------------- */

    /**
     * Constructs an empty {@code HashMap} with the specified initial
     * capacity and load factor.
     *
     * @apiNote
     * To create a {@code HashMap} with an initial capacity that accommodates
     * an expected number of mappings, use {@link #(int) newHashMap}.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public HashMapDouble(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        int i = 0;
        while(initialCapacity > sizes[i]){
            i++;
        }
        sizePos = i;
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[sizes[sizePos]];
        table = newTab;
        this.loadFactor = loadFactor;
        this.threshold = (int)(sizes[sizePos] * this.loadFactor);
    }

    /**
     * Constructs an empty {@code HashMap} with the specified initial
     * capacity and the default load factor (0.75).
     *
     * @apiNote
     * To create a {@code HashMap} with an initial capacity that accommodates
     * an expected number of mappings, use {@link #newHashMap(int) newHashMap}.
     *
     * @param  initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public HashMapDouble(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty {@code HashMap} with the default initial capacity
     * (16) and the default load factor (0.75).
     */
    public HashMapDouble() {
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[sizes[sizePos]];
        table = newTab;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = (int)(sizes[sizePos] * this.loadFactor);
    }

    /**
     * The bin count threshold for using a tree rather than list for a
     * bin.  Bins are converted to trees when adding an element to a
     * bin with at least this many nodes. The value must be greater
     * than 2 and should be at least 8 to mesh with assumptions in
     * tree removal about conversion back to plain bins upon
     * shrinkage.
     */
    /**
     * Basic hash bin node, used for most entries. Taken from HashMap
     * (See below for TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     */

    @Override public V get(Object key){
        Node<K, V> e;
        return (e = getNode(key)) == null ? null : e.value;
    }

    /**
     * Implements the Double hashing algorithm for Lookup and getting the value
     * for the key if it exists.
     *
     * @param key
     * @return Node if the key exists, null if it doesnt exists.
     */
    final Node<K,V> getNode(Object key) {
        Node<K,V>[] tab;
        Node<K,V> node;
        int m, hash, i;
        K k;
        Node<K, V> node1 = doubleHashingLookup(key);
        if (node1 != null) return node1;
        return null;
    }

    private Node<K, V> doubleHashingLookup(Object key) {
        Node<K, V>[] tab;
        int i;
        int m;
        int hash = hash1(key);
        Node<K, V> node;
        K k;
        if ((tab = table) != null && (m = tab.length) > 0 && (node = tab[i = getIndex(hash, m)]) != null) {
            // get the hash index and checks if the key matches with the indexes key
            if (node.hash == hash && ((k = node.key) == key || (key != null && key.equals(k)))) {
                // returns the node at the index if it does.
                return node;
            }// if it doesn't hash the key again using the second hash function h2(k)
            else {
                int hash2 = hash2(key);
                int c = getC(hash2, m);
                int j = i - c;
                do {
                    if (j < 0) {
                        j += m;
                    }
                    if ((node = tab[j]) != null && node.hash == hash && ((k = node.key) == key || (key != null && key.equals(k)))) {
                        return node;
                    }
                    j = j - c;
                } while (node != null); // Loop through until it finds the node.
            }
        }
        return null;
    }



    private Node<K, V> doubleHashingInsert(int hash, K key, V value, Node<K, V>[] tab, int m, Node<K, V> oldNode) {
        int i;
        Node<K, V> p;
        p = tab[i = getIndex(hash, m)];
        // If the index is empty then it places the value in the table
        if (p == null) {
            // Used when resizing as to not create a new node.
            if(oldNode != null){
                tab[i] = oldNode;
            }
            else{
                tab[i] = newNode(hash,0, key, value, null);
            }

            return null;
        }
        // Checks if the key is already mapped and if it is just return the node
        else if (p.hash == hash && (p.key == key || key.equals(p.key))) {
            return p;
        }
        // Loop through the array until it finds an empty slot.
        else{
            boolean loop = m < sizes[28];
            int hash2 = hash2(key);
            int c = getC(hash2, m);
            int j = i - c;
            do {
                if(j < 0){
                    j += m;
                }else if (j == i) {
                    return null;
                }
                if((p = tab[j]) == null){
                    if(oldNode != null){
                        tab[j] = oldNode;
                    }
                    else{
                        tab[j] = newNode(hash,0, key, value, null);
                    }
                    return null;
                } else if (p.hash == hash && (p.key == key || key.equals(p.key))) {
                    return p;
                }
                j = j - c;
            }while(loop);
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     */
    @Override public V put(K key, V value){
        return putVal(hash1(key), key, value, true, true);
    }

    /**
     * Inserts the value using the Double hashing insert algorithm.
     *
     * @param hash, the hashed key.
     * @param key
     * @param value
     * @param onlyIfAbsent, if true don't change the existing value.
     * @param evict, if false, the table is in creation mode.
     * @return
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict){
        Node<K,V>[] tab = table;
        Node<K,V> p;
        int m, i;
        // Checks if there is a table or if the table is size 0 it will resize the table.

        if ((tab == null) || (m = tab.length) == 0) {
            m = (tab = resize()).length;
        }
        p = doubleHashingInsert(hash, key, value, tab, m, null);
        if(p != null){
            V oldVal = p.value;
            if(!onlyIfAbsent || oldVal == null){
                p.value = value;
            }
            afterNodeAccess(p);
            return oldVal;
        }
        if(++size > threshold){
            resize();
        }
        return null;
    }

    // Gets the value used to calculate the length of the jumps in the traversal
    private int getC(int hash2, int m) {
        //return ((m-2) & hash2) + 1;
        return (hash2 % (m - 2)) + 1;
    }

    // Gets the index to place in the table
    private int getIndex(int hash, int m){
        return (hash % m);
        //return ((m - 1) & hash);
    }

    /**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in field threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the table
     */
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = sizes[sizePos];
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = sizes[++sizePos]) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = (int) (newCap * loadFactor); // double threshold
        }
        else {               // zero initial threshold signifies using defaults
            newCap = sizes[++sizePos];
            newThr = (int) (newCap * loadFactor);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;

            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes", "unchecked"})
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;
        if(oldTab != null){
            for(int j = 0; j < oldCap; ++j){
                Node<K,V> e;
                if((e = oldTab[j]) != null){
                    oldTab[j] = null;
                    doubleHashingInsert(e.hash,e.key,e.value,newTab,newCap, e);
                }
            }
        }
        return newTab;
    }

    Node<K,V> newNode(int hash, int dhash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, dhash, key, value, next);
    }
    void afterNodeAccess(Node<K,V> p) { }
}

