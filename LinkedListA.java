package chapter15;

/**
 *
 * @author Jacob Stewart, 11/3/2020, Doubly linked list, CIT-130
 */

public class LinkedListA<T extends PubliclyCloneable>
        implements PubliclyCloneable {

    private class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node() {
            data = null;
            next = null;
            prev = null;
        }

        public Node(T newData, Node<T> prevLink, Node<T> nextLink) {
            data = newData;
            prev = prevLink;
            next = nextLink;
        }
    } // End of Node<T> inner class

    public class LinkedListAIterator {

        private Node<T> position = null;

        public LinkedListAIterator() {
            position = head;
        }

        public void restart() {
            position = head;
        }

        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            T currentData = position.data;
            position = position.next;
            return currentData;
        }

        /**
         * Returns the next value to be returned by next(). Throws an
         * IllegalStateExpression if hasNext() is false.
         */
        public T peek() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            return position.data;
        }

        public boolean hasNext() {
            return (position != null);
        }

        public void insertHere(T newData) {
            if (position == null && head != null) {
                Node<T> temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new Node<>(newData, temp, null);
            } else if (head == null || position.prev == null) {
                LinkedListA.this.addToStart(newData);
            } else {
                Node<T> temp = new Node<>(newData, position.prev, position);
                position.prev.next = temp;
                position.prev = temp;
            }
        }

        public void delete() {
            if (position == null) {
                throw new IllegalStateException();
            } else if (position.prev == null) {
                head = head.next;
                position = head;
            } else if (position.next == null) {
                position.prev.next = null;
                position = null;
            } else {
                position.prev.next = position.next;
                position.next.prev = position.prev;
                position = position.next;
            }
        }

    } // End LinkedListAIterator

    private Node<T> head;

    public LinkedListAIterator iterator() {
        return new LinkedListAIterator();
    }

    public LinkedListA() {
        head = null;
    }

    /**
     * Produces a new linked list, but it is not a true deep copy. Throws a
     * NullPointerException if other is null.
     */
    public LinkedListA(LinkedListA<T> otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        }
        if (otherList.head == null) {
            head = null;
        } else {
            head = copyOf(otherList.head);
        }
    }

    public LinkedListA<T> clone() {
        try {
            LinkedListA<T> copy = (LinkedListA<T>) super.clone();
            if (head == null) {
                copy.head = null;
            } else {
                copy.head = copyOf(head);
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            // This should not happen.
            return null; // To keep the compiler happy.
        }
    }

    /*
    Precondition: otherHead != null
    Returns a reference to the head of a copy of the list
    headed by otherHead. Returns a true deep copy.
     */
    private Node<T> copyOf(Node<T> otherHead) {
        Node<T> position = otherHead; // moves down other's list.
        Node<T> newHead; // will point to head of the copy list.
        Node<T> end = null; // positioned at end of new growing list.

        // Create first node:
        newHead = new Node<T>((T) (position.data).clone(), null, null);
        end = newHead;
        position = position.next;

        while (position != null) {
            // Copy node at position to end of new list
            end.next = new Node<>((T) (position.data).clone(), end, null);
            end = end.next;
            position = position.next;
        }
        return newHead;
    }

    /**
     * Adds a node at the start of the list with the specified data. The added
     * node will be the first node in the list.
     */
    public void addToStart(T itemData) {
        Node<T> newHead = new Node<>(itemData, null, head);
        if (head != null) {
            head.prev = newHead;
        }
        head = newHead;
    }

    /**
     * Removes the head node and returns true if the list contains at least one
     * node. Returns false if the list is empty.
     */
    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.next;
            head.prev = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of nodes in the list.
     */
    public int size() {
        int count = 0;
        Node<T> position = head;
        while (position != null) {
            count++;
            position = position.next;
        }
        return count;
    }

    public boolean contains(T item) {
        return (find(item) != null);
    }

    /**
     * Finds the first node containing the target item, and returns a reference
     * to that node. If target is not in the list, null is returned.
     */
    private Node<T> find(T target) {
        Node<T> position = head;
        T itemAtPosition;
        while (position != null) {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target)) {
                return position;
            }
            position = position.next;
        }
        return null;
    }

    /**
     * Finds the first node containing the target and returns a reference to the
     * data in that node. If target is not in the list, null is returned.
     */
    public T findData(T target) {
        return find(target).data;
    }

    public String toString() {
        Node<T> position = head;
        String list = "";
        while (position != null) {
            list = list + position.data + "\n";
            position = position.next;
        }
        return list;
    }

    public void outputListBackwards() {
        Node<T> position = head;
        if (position == null) {
            System.out.println("Empty list.");
        } else {
            while (position.next != null) {
                position = position.next;
            }
            System.out.println(position.data);
            while (position.prev != null) {
                System.out.println(position.prev.data);
                position = position.prev;
            }
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = null;
    }

    /**
     * For two lists to be equal they must contain the same data items in the
     * same order. The equals method of T is used to compare data items.
     */
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            LinkedListA<T> otherList = (LinkedListA<T>) otherObject;
            if (size() != otherList.size()) {
                return false;
            }
            Node<T> position = head;
            Node<T> otherPosition = otherList.head;
            while (position != null) {
                if (!(position.data.equals(otherPosition.data))) {
                    return false;
                }
                position = position.next;
                otherPosition = otherPosition.next;
            }
            return true;
        }
    }
}
