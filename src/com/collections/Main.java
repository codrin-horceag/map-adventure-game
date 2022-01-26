package com.collections;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        locations.put(0, new Location(0, "Game ended. You are in the main menu."));
        locations.put(1, new Location(1, "You are at game start."));
        locations.put(2, new Location(2, "You are at a vault point."));
        locations.put(3, new Location(3, "You are at an exit gate."));
        locations.put(4, new Location(4, "You are at a pallet."));
        locations.put(5, new Location(5, "You are at a generator."));

        locations.get(1).addExit("W", 5);
        locations.get(1).addExit("N", 2);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("E", 3);

        locations.get(2).addExit("W", 5);
        locations.get(2).addExit("E", 3);

        locations.get(3).addExit("S", 4);
        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("W", 5);
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("E", 3);

        locations.get(5).addExit("E", 1);
        locations.get(5).addExit("N", 2);
        locations.get(5).addExit("S", 4);

        System.out.println("Q - Quit game \n" +
                "N - North \n" +
                "E - East \n" +
                "S - South \n" +
                "W - West \n");
        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available directions are: ");

            for (String d : exits.keySet()) {
                System.out.print(d + ", ");
            }

            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
