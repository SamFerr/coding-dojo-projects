// Hash Table
// Question: Write a basic implementation of HashTable

public class HashTable {
    private class Node
{
public Object key;
public Object value;
public Node next;
public Node(Object key, Object value)
    {
        this.key = key;
        this.value = value;
    }
}
private Node[] buckets;
private int tableSize;
private int size;
public HashTable(int tableSize)
{
    this.tableSize = tableSize;
    buckets = new Node[tableSize];
    size = 0;
}
public void put(Object key, Object value) throws
NullPointerException
{
    if (key == null)
        throw new
            NullPointerException("Key cannot be null!");
    int location = key.hashCode() % tableSize;
    if (buckets[location] == null) {
        buckets[location] = new Node(key,
            value);
    }
    else {
        Node n = buckets[location];
        Node p = null;
        while (n != null) {
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
            p = n;

            n = n.next;
        }
        p.next = new Node(key, value);
    }
    size++;
}
public Object get(Object key) throws
NullPointerException
{
    if (key == null)
        throw new
            NullPointerException("Key cannot be null!");
    int location = key.hashCode() % tableSize;
    Node n = buckets[location];
    while (n != null && !n.key.equals(key))
        n = n.next;
    if (n == null)
        return null;
    else
        return n.value;
}
public Object remove(Object key) throws
NullPointerException
{
    if (key == null)
        throw new
            NullPointerException("Key cannot be null!");
    int location = key.hashCode() % tableSize;
    Node n = buckets[location];
    Node p = null;
    while (n != null && !n.key.equals(key)) {
        p = n;

        n = n.next;
    }
    if (n == null)
        return null;
    size - ;
    if (p == null)
        buckets[location] = n.next;
    else
        p.next = n.next;
    return n.value;
}
public int size()
{
    return size;
}
public boolean isEmpty()
{
    return size == 0;
}
}


// Subsets
// Question: Find all subsets of a set. Example: input: {a,b} output: {}{a}{b}{a,b} input: {a,b,c} output: {}{a}{b}{c}{a,b}{a,c}{b,c}{a,b,c} input:{abcd} output:{} {d} {b} {c} {a} {bc} {da} {ca} {dc} {db} {ba} {dbca} {bca} {dba} {dca} {dbc} Sample Answer:
public static Set < Set < Object >> getSubsets(Set < Object > set)
{
Set < Set < Object >> subsets = new HashSet<Set<Object>>();
    subsets.add(new HashSet<Object>());
    for (Object o : set) {
        Set < Set < Object >> temp = new HashSet<Set<Object>>();
        for (Set < Object > s: subsets)
        temp.add(new HashSet<Object>(s));
        for (Set < Object > s : temp)
        s.add(o);
        subsets.addAll(temp);
    }
    return subsets;
}
public static Set < Set < Object >> getSubsets(List < Object > list)
{
    Set < Set < Object >> subsets = new HashSet<Set<Object>>();
    for (int i = 0; i < Math.pow(2, list.size()); i++)
    {
        Set < Object > subset = new HashSet<Object>();
        int j = 1; for (int k = 0; k < list.size(); k++ )
        {
            if ((j & i) != 0) {
                subset.add(list.get(k));
            }
            j = j << 1;
        }
        subsets.add(subset);
    }
    return subsets;
}
