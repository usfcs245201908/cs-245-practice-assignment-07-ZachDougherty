/***********************************************
 * I would have liked to throw exceptions instead
 * of printing "Out of Bounds Error" but original
 * interface did not include functions that threw
 * exceptions.
 ***********************************************/


public class ArrayList<T> implements List<T> {
    private T[] arr;
    private int size;

    public ArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    public void add(T item) {
        if (size == arr.length) {
            grow();
        }
        arr[size++] = item;
    }

    public void add(int index, T item) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception();
        }
        if (size == arr.length) {
            grow();
        } 
        for (int i = size-1; i >= index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        size++;
    }

    public T remove(int index) throws Exception {
        if (index < 0 || index > size-1) {
            throw new Exception();
        }
        T data = arr[index];
        for (int i=index; i < size - 1; i ++) {
            arr[i] = arr[i+1];
        }
        size--;
        return data;
    }

    public T get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception();
        }
        return arr[index];
    }

    public int size() {
        return size;
    }

    private void grow() {
        T[] temp_arr = (T[]) new Object[arr.length*2];
        for (int i=0; i < arr.length-1; i++) {
            temp_arr[i] = arr[i];
        }
        arr = temp_arr;
    }

}