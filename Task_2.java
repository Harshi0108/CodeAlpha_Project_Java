import java.util.*;
class Room{
    private int RoomNumber;
    private String type;
    private double Price;
    private boolean isAvailable;
    public Room(int RoomNumber,String type,double Price){
        this.RoomNumber=RoomNumber;
        this.type=type;
        this.Price=Price;
        isAvailable=true;

    }
    public double getPrice() {
        return Price;
    }
    public int getRoomNumber() {
        return RoomNumber;
    }
    public String getType() {
        return type;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void setAvailable(boolean Available){
        this.isAvailable=Available;
    }
    public String toString(){
        return "Room"+RoomNumber+"["+type+"]"+"Price: "+Price+"Available"+(isAvailable?"Yes":"No");
    }
 
}
class Reservation{
    private String Name;
    private Room room;
    public Reservation(String Name,Room room){
        this.Name=Name;
        this.room=room;
        this.room.setAvailable(false);
    }
    public String getName() {
        return Name;
    }
    public Room getRoom() {
        return room;
    }
    public String toString(){
        return "Guest_Name :" +Name+"Room :"+room;
    }
    


}
 class Hotel{
     List<Room> rooms;
    List<Reservation> reservations;

    public Hotel(){
        rooms=new ArrayList<>();
        reservations=new ArrayList<>();




    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public List<Room> SearchAvailableRooms(String type){
        List<Room> availablerRooms=new ArrayList<>();
        for(Room room :rooms){
            if(room.isAvailable() && room.getType().equalsIgnoreCase(type)){
                 availablerRooms.add(room);
            }
        }
        return availablerRooms;
    }
    public Reservation makeReservation(String customerName,Room room){
        if(room.isAvailable()){
            Reservation reservation=new Reservation(customerName, room);
            return reservation;

        }
        else {
            System.out.println();
            return null;
        }
    }
    public void viewReservation(){
        if(reservations.isEmpty()){
            System.out.println("There is no reservetion");

        }
        else{
            for(Reservation reservation:reservations){
                System.out.println(reservation);
            }
        }
    }
    public void Process_payment(String customerName,Room room){
        System.out.println("payment is Processing For" +customerName);
        System.out.println("Payment is done of Rupees" +room.getPrice());

    }
    
    
}
public class Task_2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Hotel hotel=new Hotel();
        hotel.addRoom(new Room(101,"Single",600));
        hotel.addRoom(new Room(102,"Double",1000));
        hotel.addRoom(new Room(103,"AC-King",1800));
        
        while (true) {

            System.out.println("1 : Check if room available");
            System.out.println("2 : Book or Reservation ");
            System.out.println("3 : view Reservation ");
            System.out.println("4 : Exit ");
            System.out.println("Enter a choice ");
            int choice =sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                System.out.println("Enter a Roomtype");
                String roomType=sc.nextLine();
                for(Room room:hotel.SearchAvailableRooms(roomType)){
                    System.out.println(room);
                }
                    
                    break;
                    case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = sc.nextInt();
                    Room selectedRoom = null;
                    for (Room room : hotel.rooms) {  // Directly loop through hotel.rooms, not filtered rooms
                        if (room.getRoomNumber() == roomNumber) {
                            selectedRoom = room;
                            break;
                        }
                    }
                
                    // Check if the room is found and is available for reservation
                    if (selectedRoom != null && selectedRoom.isAvailable()) {
                        Reservation reservation = hotel.makeReservation(customerName, selectedRoom);
                        if (reservation != null) {
                            hotel.Process_payment(customerName, selectedRoom);  // Process the payment after reservation
                            hotel.reservations.add(reservation);  // Add reservation to the hotel's list of reservations
                        }
                    } else {
                        System.out.println("Invalid room number or room not available.");
                    }
                    break;

                case 3:
                    hotel.viewReservation();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
            
                    break;
            }
            
        }
    }
    
}
