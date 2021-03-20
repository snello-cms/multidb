package io.snello.multidb.model.pojo;

public class SimpleEvent {
    public String id;

    public SimpleEvent(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SimpleEvent{" +
                "id='" + id + '\'' +
                '}';
    }
}
