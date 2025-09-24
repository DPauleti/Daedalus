package model;

import structures.LinkedList;

public class Log extends LinkedList<String> {
    public Log() {
        super();
    }

    public void addEntry(String entry) {
        add(entry);
    }

    public String getLastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getTail().getValue();
    }

    public String getAllEntries() {
        StringBuilder allEntries = new StringBuilder();
        Node current = getHead();
        while (current != null) {
            allEntries.append(current.getValue()).append("\n");
            current = current.getNext();
        }
        return allEntries.toString();
    }

    public void clearLog() {
        head = null;
        tail = null;
    }
}
