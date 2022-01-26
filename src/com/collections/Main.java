package com.collections;

import java.util.HashMap;
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

        locations.get(1).addExit("W", 2);

        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }
            System.out.println("Go where?");
            loc = scanner.nextInt();
            if(!locations.containsKey(loc)){
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
