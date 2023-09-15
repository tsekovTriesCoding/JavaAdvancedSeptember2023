package A7Workshop.Lab.SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void resize() {
        this.capacity *= 2;
        int[] copyArr = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            copyArr[i] = this.data[i];
        }

        this.data = copyArr;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        if (index< 0 && index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Index %d out of bound for length %d%n",index, this.size)
            );
        }
    }

    public int remove(int index) {
        checkIndex(index);
        int element = this.data[index];
        shiftLeft(index);
        this.size--;

        if (this.size <= this.capacity / 4) {
            shrink();
        }

        return element;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] copyArr = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            copyArr[i] = this.data[i];
        }

        this.data = copyArr;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size ; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = 0;
    }

    public boolean contains(int element) {
        for (int num : this.data) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        checkIndex(index);
        if (index == this.size -1) {
            add(this.data[this.size -1]);
            this.data[this.size -2] = element;
        } else {
            if (this.size == this.capacity) {
                resize();
            }
            shiftRight(index);
            this.size++;
            this.data[index] = element;
        }
    }

    private void shiftRight(int index) {
        for (int i = this.size; i > index ; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.data.length; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
