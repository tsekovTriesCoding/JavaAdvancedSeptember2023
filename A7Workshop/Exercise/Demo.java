package A7Workshop.Exercise;

public class Demo {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.addFirst(4);
        doublyLinkedList.addFirst(5);

        doublyLinkedList.addLast(15);
        doublyLinkedList.addLast(24);

        System.out.println(doublyLinkedList.getIndex(2));
        doublyLinkedList.removeFirst();
        System.out.println(doublyLinkedList.removeLast());

        doublyLinkedList.forEach(System.out::println);
        int[] arr = doublyLinkedList.toArray();

    }
}
