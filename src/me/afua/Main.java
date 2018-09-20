package me.afua;

import java.util.*;

public class Main {

    public static final int KITCHEN=1;
    public static final int LIVING_ROOM=2;


    public static void main(String[] args) {

	// write your code here
        Main aMain = new Main();
        HashMap<Integer, Room> allRooms = (HashMap) aMain.setUp();
        Room theRoom;

        System.out.println("Available rooms:");

        for (int i=1; i<allRooms.size()+1; i++){
            System.out.print(allRooms.get(i).getName()+" - ");
        }
        System.out.println("Pick your room");

        Scanner keyboard = new Scanner(System.in);
        String selection = keyboard.nextLine().toLowerCase();

        System.out.println();


        switch(selection){
            case "kitchen":
                theRoom = allRooms.get(KITCHEN);
                System.out.println("These are the objects in the "+theRoom.getName());
                System.out.println(listObjects(theRoom));
                System.out.println("What do you want to touch?");

                //Find a way to touch an object, so you can see the associated action. You can change the data structure being used.

            break;
            case "living room":
                theRoom = allRooms.get(LIVING_ROOM);
                System.out.println("These are the objects in the "+theRoom.getName());
                System.out.println(listObjects(theRoom));
                break;
        }
    }

    public Map<Integer,Room> setUp()
    {
        //You can set up multiple rooms here

        //This is the kitchen
        Room kitchen = new Room("Kitchen");
        Tangible knife = new Tangible();
        knife.setName("knife");
        knife.setAction("Pick up");
        kitchen.getObjects().add(knife);

        //This is the living room
        Room livingroom = new Room("Living Room");
        Tangible couch = new Tangible();
        couch.setAction("Sit on");
        couch.setName("couch");
        livingroom.getObjects().add(couch);
        kitchen.getConnectedTo().add(livingroom);
        livingroom.getConnectedTo().add(kitchen);


        //This is the list of rooms in the house
        HashMap <Integer,Room> theRooms = new HashMap<>();
        theRooms.put(KITCHEN,kitchen);
        theRooms.put(LIVING_ROOM,livingroom);
        return theRooms;
    }

    public static String listObjects(Room theRoom)
    {
        StringBuffer threadSafe = new StringBuffer();
        for (Tangible eachObject:theRoom.getObjects()) {
            threadSafe.append(eachObject.getName());
        }
        return threadSafe.toString();
    }

    public static String touchObject(Tangible theObject)
    {
        return theObject.getAction();
    }
}
