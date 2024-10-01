package homework13.onlineShop;

import java.util.Arrays;

public class Storage<T> {

    int size;
    private T[] elements = (T[]) new Object[10];
    private int quantity = 0;

    public void add(T element) {
        if (elements.length == size) {
            extendStorage();
        }
        elements[size++] = element;
        quantity++;
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                quantity--;
            }
        }
    }

    private void extendStorage() {
        elements = Arrays.copyOf(elements, size + 10);
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public T[] getElements() {
        return elements;
    }

    public T getByIndex(int index) {
        if (index < size) {
            return elements[index];
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
