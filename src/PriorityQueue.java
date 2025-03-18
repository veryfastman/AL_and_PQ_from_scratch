import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PriorityQueue<E>
{
    private ArrayList<E> queueList;

    public PriorityQueue()
    {
        this.queueList = new ArrayList<E>();
        this.queueList.add(null);
    }

    public void add(E item)
    {
        if (item != null)
        {
            this.queueList.add(item);
            heapUp(this.queueList.size() - 1);
        }
    }

    public boolean isEmpty()
    {
        return this.queueList.size() == 2;
    }

    public E peek()
    {
        try
        {
            return this.queueList.get(1);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public E remove()
    {
        if (this.queueList.size() == 1) {
            throw new NoSuchElementException("NoSuchElementException: null");
        }
        E removedValue = this.queueList.set(1, this.queueList.get(this.queueList.size() - 1));
        this.queueList.remove(this.queueList.size() - 1);
        heapDown(1);
        return removedValue;
    }

    // helper for add
    private void heapUp(int index)
    {
        int parentIndex = index / 2;
        E child = this.queueList.get(index), parent = this.queueList.get(parentIndex);
        if (index > 1 && parentIndex > 0) {
            if (((Comparable) parent).compareTo(child) > 0) {
                this.queueList.set(index, parent);
                this.queueList.set(parentIndex, child);
                heapUp(parentIndex);
            }
        }
    }

    // helper for remove
    private void heapDown(int index)
    {
        if (index * 2 >= this.queueList.size() || index * 2 + 1 >= this.queueList.size())
        {
            return;
        }
        int leftChildIndex = index * 2, rightChildIndex = index * 2 + 1;
        E parent = this.queueList.get(index), leftChild = this.queueList.get(leftChildIndex), rightChild = this.queueList.get(rightChildIndex);
        if (((Comparable) leftChild).compareTo(parent) < 0 || ((Comparable) rightChild).compareTo(parent) < 0) {
            // Greater than or equal to so that parent still goes in right child even if left and right are equal
            if (((Comparable) leftChild).compareTo(rightChild) <= 0) {
                this.queueList.set(index, leftChild);
                this.queueList.set(leftChildIndex, parent);
                heapDown(leftChildIndex);
            } else {
                this.queueList.set(index, rightChild);
                this.queueList.set(rightChildIndex, parent);
                heapDown(rightChildIndex);
            }
        }
    }
}
