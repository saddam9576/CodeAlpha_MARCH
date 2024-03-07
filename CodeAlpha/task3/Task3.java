/**
 *
 * @author LENOVO
 */import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 
 
 class Room 
{
     private int roomId;
     private String type;
     private double price;
     private boolean isAvailable;
 
     public Room(int roomId, String type, double price) {
         this.roomId = roomId;
         this.type = type;
         this.price = price;
         this.isAvailable = true;
     }
 
      public int getRoomId() {
         return roomId;
     }
 
     public String getType() {
         return type;
     }
 
     public double getPrice() {
         return price;
     }
 
     public boolean isAvailable() {
         return isAvailable;
     }
 
     public void setAvailable(boolean available) {
         isAvailable = available;
     }
 }
 
 class Booking {
     private int bookingId;
     private String customerName;
     private Room room;
     private int numOfNights;
     private double totalPrice;
 
     public Booking(int bookingId, String customerName, Room room, int numOfNights) {
         this.bookingId = bookingId;
         this.customerName = customerName;
         this.room = room;
         this.numOfNights = numOfNights;
         this.totalPrice = room.getPrice() * numOfNights;
         room.setAvailable(false);
     }
 
     public int getBookingId() {
         return bookingId;
     }
 
     public String getCustomerName() {
         return customerName;
     }
 
     public Room getRoom() {
         return room;
     }
 
     public int getNumOfNights() {
         return numOfNights;
     }
 
     public double getTotalPrice() {
         return totalPrice;
     }
 }
 
 class Hotel {
     private List<Room> rooms;
     private List<Booking> bookings;
     private int nextBookingId;
 
     public Hotel() {
         rooms = new ArrayList<>();
         bookings = new ArrayList<>();
         nextBookingId = 1;
         initializeRooms();
     }
 
     private void initializeRooms() {
         rooms.add(new Room(101, "Single", 1500.0));
         rooms.add(new Room(102, "Double", 2000.0));
         rooms.add(new Room(103, "Suite", 3000.0));
     }
 
     public void displayAvailableRooms() {
         System.out.println("Available Rooms:");
         for (Room room : rooms) {
             if (room.isAvailable()) {
                 System.out.println("Room ID: " + room.getRoomId() + ", Type: " + room.getType() + ", Price: $" + room.getPrice());
             }
         }
     }
 
     public boolean makeReservation(int roomId, String customerName, int numOfNights) {
         for (Room room : rooms) {
             if (room.getRoomId() == roomId && room.isAvailable()) {
                 Booking booking = new Booking(nextBookingId++, customerName, room, numOfNights);
                 bookings.add(booking);
                 System.out.println("Reservation successful. Your booking ID is: " + booking.getBookingId());
                 return true;
             }
         }
         System.out.println("Room not available or invalid room ID.");
         return false;
     }
 
     public void displayBookingDetails(int bookingId) {
         for (Booking booking : bookings) {
             if (booking.getBookingId() == bookingId) {
                 System.out.println("Booking ID: " + booking.getBookingId());
                 System.out.println("Customer Name: " + booking.getCustomerName());
                 System.out.println("Room ID: " + booking.getRoom().getRoomId());
                 System.out.println("Room Type: " + booking.getRoom().getType());
                 System.out.println("Number of Nights: " + booking.getNumOfNights());
                 System.out.println("Total Price: R" + booking.getTotalPrice());
                 return;
             }
         }
         System.out.println("Booking not found.");
     }
 }
 public class Task3{
 
     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) 
{
         Hotel hotel = new Hotel();
         Scanner scanner = new Scanner(System.in);
         boolean running = true;
 
         while (running) {
             System.out.println("\nWelcome to the Hotel Reservation System");
             System.out.println("1. Display Available Rooms");
             System.out.println("2. Make a Reservation");
             System.out.println("3. View Booking Details");
             System.out.println("4. Exit");
             System.out.print("Enter your choice: ");
             int choice = scanner.nextInt();
 
             switch (choice) {
                 case 1:
                     hotel.displayAvailableRooms();
                     break;
                 case 2:
                     System.out.print("Enter Room ID: ");
                     int roomId = scanner.nextInt();
                     scanner.nextLine(); // consume newline
                     System.out.print("Enter Customer Name: ");
                     String customerName = scanner.nextLine();
                     System.out.print("Enter Number of Nights: ");
                     int numOfNights = scanner.nextInt();
                     hotel.makeReservation(roomId, customerName, numOfNights);
                     break;
                 case 3:
                     System.out.print("Enter Booking ID: ");
                     int bookingId = scanner.nextInt();
                     hotel.displayBookingDetails(bookingId);
                     break;
                 case 4:
                     running = false;
                     break;
                 default:
                     System.out.println("Invalid choice. Please enter a number between 1 and 4.");
             }
         }
 
         System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
         scanner.close();
}
}