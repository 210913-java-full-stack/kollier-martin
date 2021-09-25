/**
 * My implementation of a Java ArrayList. Way less functionality than the official Java 8 ArrayList
 *
 * @date 09/23/2021
 * @author Kollier Martin
 */

package MyCollections;

import java.util.Arrays;

public class MyArrayList<T> implements MyListInterface<T>{
    // Initial capacity and list length expansion variable
    private final int INIT_CAPACITY = 5;

    private int size;

    private Object[] theList;

    /**
     * This empty array instance has meaning:
     * The EMPTY_LIST is used as a reference and an initializer
     */
    private static final Object[] EMPTY_LIST = {};

    public MyArrayList()
    {
        this.theList = EMPTY_LIST;
    }

    public MyArrayList(int arrayCapacity) {
        if (arrayCapacity > 0)
        {
            // Initialize the list with a type Object with the given capacity
            theList = new Object[arrayCapacity];
        }
        else if (arrayCapacity == 0)
        {
            // Else if the given capacity is 0, turn theList into a list of 5 elements
            theList = EMPTY_LIST;
        } else
        {
            // Else throw exception for not putting a valid integer
            throw new IllegalArgumentException("Silly human. This capacity isn't a whole number: "+
                    arrayCapacity);
        }
    }

    @Override
    public void add(T t) {
        if (theList == EMPTY_LIST || size < theList.length)
        {
            grow();
        }

        // Add the element
        theList[size++] = t;
    }

    @Override
    public void add(T t, int index) {
        if (index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds.");
        }
        else
        {
            System.arraycopy(theList, index, theList, index + 1, size - index);
            theList[size++] = t;
        }
    }

    @Override
    public T get(int index) {
        return (T) theList[index];
    }

    @Override
    public void remove(int index) {
        // ArrayLists shift every other element to the left upon removal
        OutOfBoundsCheck(index);

        // remove element at specified position to show that the right element was removed
        T oldVal = (T) theList[index];

        // keep up with number of elements moved
        // size - index : indicates an element being taken away and the shifts needed to compensate for the missing element
        // - 1 : compensates the fact that we start counting indexes at 0
        int numMoved = size - index - 1;

        // if numMoved is greater than 0, then the index is in bouds
        if (numMoved > 0) {
            /**
             *  Copies the array, but differently than Arrays.copyOf()
             *  src − This is the source array.
             *  srcPos − This is the starting position in the source array.
             *  dest − This is the destination array.
             *  destPos − This is the starting position in the destination data
             *  length − This is the number of array elements to be copied.
             */
            System.arraycopy(theList, index + 1, theList, index, numMoved);
        }
        else {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds");
        }

        theList[--size] = null; // decrements the value of size, sets that element to null, then assigns size

        System.out.println(oldVal + " was removed.");
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
        {
            theList[i] = null;
        }

        size = 0;
    }

    @Override
    public void replace(T t, int index) {
        theList[index] = t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T t) {
        boolean doesContain = false;

        for (Object obj : theList)
        {
            if (obj.equals(t))
            {
                doesContain = true;
            }
        }

        return doesContain;
    }

    @Override
    public String toString() {
        String[] listAsString = new String[size];
        for (int i = 0; i < size; i++) {
            listAsString[i] = theList[i].toString();
        }
        return String.join(" | ", listAsString);
    }

    /**
     * Unnecessary unless 'grow()' increases theList.length by more than 1, but implemented because why not
     */
    @Override
    public void trimToSize() {
        int oldSize = theList.length;
        if (size < oldSize)
        {
            Arrays.copyOf(theList, size);
        }
    }

    /**
     * Checks to make sure the array is not out of bounds
     * @param index
     */
    private void OutOfBoundsCheck(int index) {
        if (index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds.");
        }
    }

    /**
     * Increases theList by 1
     */
    private void grow() {
        theList = Arrays.copyOf(theList, INIT_CAPACITY + 1);
    }
}
