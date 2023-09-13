import java.util.ArrayList;
import java.util.List;

class Hotel {
    private String name;
    private int availableRooms;

    public Hotel(String name, int availableRooms) {
        this.name = name;
        this.availableRooms = availableRooms;
    }

    public String getName() {
        return name;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void bookRoom() {
        if (availableRooms > 0) {
            availableRooms--;
            System.out.println("Room booked at " + name);
        } else {
            System.out.println("No available rooms at " + name);
        }
    }
}

class HotelManager {
    private List<Hotel> hotels;

    public HotelManager() {
        hotels = new ArrayList<>();
        // Initialize hotels with some available rooms
        hotels.add(new Hotel("Hotel A", 10));
        hotels.add(new Hotel("Hotel B", 15));
        hotels.add(new Hotel("Hotel C", 5));
    }

    public void listAvailableHotels() {
        System.out.println("Available Hotels:");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getName() + " - Available Rooms: " + hotel.getAvailableRooms());
        }
    }

    public void bookRoom(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                hotel.bookRoom();
                return;
            }
        }
        System.out.println("Hotel not found: " + hotelName);
    }
}

public class AccommodationAvailabilityApp {
    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();

        // Display available hotels
        hotelManager.listAvailableHotels();

        // Simulate booking a room
        hotelManager.bookRoom("Hotel A");

        // Display updated available hotels
        hotelManager.listAvailableHotels();
    }
}

