package A7Workshop.Lab.CustomStack;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] items;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[INITIAL_CAPACITY];
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.items[this.size++] = element;
    }

    private void resize() {
        this.capacity *= 2;
        int[] copyArr = new int[this.capacity];
        for (int i = 0; i < this.items.length; i++) {
            copyArr[i] = this.items[i];
        }
        this.items = copyArr;
    }

    public int pop() {
        checkIfStackIsEmpty();
        int lastElement = this.items[this.size - 1];
        this.items[this.size - 1] = 0;
        this.size--;
        if (this.size <= this.capacity / 4) {
            shrink();
        }

        return lastElement;
    }

    private void checkIfStackIsEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException(("CustomStack is Empty"));
        }
    }

    private void shrink() {
        this.capacity /= 2;
        int[] copyArr = new int[this.capacity];

        for (int i = 0; i < this.items.length; i++) {
            copyArr[i] = this.items[i];
        }

        this.items = copyArr;
    }

    public int peek() {
        checkIfStackIsEmpty();
        return this.items[this.size - 1];
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.items.length; i++) {
            consumer.accept(this.items[i]);
        }
    }

    public boolean contains(int element) {
        for (int num : this.items) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
