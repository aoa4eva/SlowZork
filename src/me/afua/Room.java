package me.afua;

import java.util.ArrayList;
import java.util.HashSet;

public class Room {
    private String name;
    private HashSet<Room> connectedTo;
    private ArrayList<Tangible> objects;

    public Room(String name) {
        this.name = name;
        connectedTo = new HashSet<>();
        objects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Room> getConnectedTo() {
        return connectedTo;
    }

    public void setConnectedTo(HashSet<Room> connectedTo) {
        this.connectedTo = connectedTo;
    }

    public ArrayList <Tangible> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Tangible> objects) {
        this.objects = objects;
    }

}
