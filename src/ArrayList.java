public class ArrayList<E>
{
    private E[] myArray;
    private int mySize;

    public ArrayList()
    {
        this.myArray = (E[]) new Object[10];
        this.mySize = 0;
    }

    public ArrayList(int capacity)
    {
        if (capacity < 0)
        {
            throw new IllegalArgumentException("IllegalArgumentException: " +
                    "Invalid capacity: " + capacity);
        }
        this.myArray = (E[]) new Object[capacity];
        this.mySize = 0;
    }

    public int size()
    {
        return this.mySize;
    }

    public void add(int i, E element)
    {
        if (i > this.mySize || i < 0)
        {
            throw new IndexOutOfBoundsException(
                    "IndexOutOfBoundsException: Index: " + i + " size: " + this.mySize);
        }
        if (this.myArray.length == 0)
        {
            this.myArray = (E[]) new Object[1];
        }
        else if (this.mySize == this.myArray.length)
        {
            E[] tempArray = (E[]) new Object[this.myArray.length * 2];
            for (int j = 0; j < this.myArray.length; j++)
            {
                tempArray[j] = this.myArray[j];
            }
            this.myArray = tempArray;
            for (int j = this.mySize; j > i; j--)
                this.myArray[j] = this.myArray[j - 1];
        }

        this.myArray[i] = element;
        this.mySize++;
    }

    public boolean add(E element)
    {
        this.add(this.mySize, element);
        return true;
    }

    public E remove(int i)
    {
        if (i >= this.mySize || i < 0)
        {
            throw new IndexOutOfBoundsException(
                    "IndexOutOfBoundsException: Index: " + i + " size: " + this.mySize);
        }
        E removedValue = this.myArray[i];
        for (int j = i; j < this.mySize - 1; j++)
        {
            this.myArray[j] = this.myArray[j + 1];
        }
        this.myArray[this.mySize - 1] = null;
        this.mySize--;
        return removedValue;
    }

    public E get(int i)
    {
        if (i >= this.mySize || i < 0)
        {
            throw new IndexOutOfBoundsException(
                    "IndexOutOfBoundsException: Index: " + i + " size: " + this.mySize);
        }
        return this.myArray[i];
    }

    public E set(int i, E replace)
    {
        if (i >= this.mySize || i < 0)
        {
            throw new IndexOutOfBoundsException(
                    "IndexOutOfBoundsException: Index: " + i + " size: " + this.mySize);
        }
        E oldValue = this.myArray[i];
        this.myArray[i] = replace;
        return oldValue;
    }
}