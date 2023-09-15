package A7Workshop.Exercise;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private class ListNode {
        private int item;
        private ListNode next;
        private ListNode prev;

        private ListNode(int item) {
            this.item = item;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void addFirst(int element) {
        ListNode newHead = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
        }

        this.size++;
    }

    public void addLast(int element) {
        ListNode newTail = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.prev = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }

        this.size++;
    }

    public int getIndex(int index) {
        checkIndex(index);
        ListNode currentNode;
        if (index <= this.size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode.item;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
    }

    public int removeFirst() {
        checkSize();
        int firstElement = this.head.item;
        this.head = this.head.next;

        if (this.head == null) {
            // 1 element:
            this.tail = null;
        } else {
            // multiple elements:
            this.head.prev = null;
        }

        this.size--;
        return firstElement;
    }

    private void checkSize() {
        if (this.size == 0) {
            throw new NoSuchElementException("List is empty!");
        }
    }

    public int removeLast() {
        checkSize();
        int lastElement = this.tail.item;
        this.tail = this.tail.prev;

        if (this.tail == null) {
            // 1 element:
            this.head = null;
        } else {
            // multiple elements:
            this.tail.next = null;
        }

        this.size--;
        return lastElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        ListNode currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        int index = 0;
        ListNode currentNode = this.head;

        while (currentNode != null) {
            array[index++] = currentNode.item;
            currentNode = currentNode.next;
        }

        return array;
    }

}

