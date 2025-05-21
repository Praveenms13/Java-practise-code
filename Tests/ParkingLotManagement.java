import java.util.*;

interface ParkingSystem {
    void vehicleEntry(Vehicle vehicle);
    void vehicleExit(String licensePlateNumber);
    void trackSlots();
    void displayAvailability();
    void manageOverflow();
}

abstract class Vehicle {
    protected String licensePlateNumber;
    protected long entryTime;
    public Vehicle(String licensePlateNumber, long entryTime) {
        this.licensePlateNumber = licensePlateNumber;
        this.entryTime = entryTime;
    }
    public String setLicensePlateNumber() {
        return this.licensePlateNumber;
    }
    public long setEntryTime() {
        return this.entryTime;
    }
}

class Parking extends Vehicle {
    public Parking(String licensePlateNumber, long entryTime) {
        super(licensePlateNumber, entryTime);
    }
}

class ParkingLot implements ParkingSystem {
    private int totalSlots;
    private int overallSlots;
    private List<Integer> occupiedSlots;
    private Map<Integer, Vehicle> parkedVehicles;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.overallSlots = totalSlots;
        this.occupiedSlots = new ArrayList<>();
        this.parkedVehicles = new HashMap<>();
    }

    public void vehicleEntry(Vehicle vehicle) {
        int assignedSlot = 0;
        for (int i = 1; i <= overallSlots; i++) {
            if (!occupiedSlots.contains(i)) {
                assignedSlot = i;
                break;
            }
        }
        if (assignedSlot != 0) {
            parkedVehicles.put(assignedSlot, vehicle);
            occupiedSlots.add(assignedSlot);
            totalSlots--;
            System.out.println("Successfully Parked The Vehicle, You are on Slot " + assignedSlot);
            System.out.println();
        } else {
            System.err.println("Could not find an available slot.");
        }
    }

    public void vehicleExit(String licensePlateNumber) {
        boolean found = false;
        for (Map.Entry<Integer, Vehicle> entry : parkedVehicles.entrySet()) {
            if (entry.getValue().licensePlateNumber.equalsIgnoreCase(licensePlateNumber)) {
                int slot = entry.getKey();
                occupiedSlots.remove(Integer.valueOf(slot));
                parkedVehicles.remove(slot);
                totalSlots++;
                long duration = (System.currentTimeMillis() - entry.getValue().entryTime) / 1000;
                System.out.println("Vehicle with number " + licensePlateNumber.toUpperCase() + " has exited from slot " + slot + ". Parked duration: " + duration + " seconds.");
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.err.println("Vehicle not found in the parking lot.");
            System.out.println();
        }
    }

    public void displayAvailability() {
        System.out.println("Total Slots Available: " + this.totalSlots);
        System.out.println();
    }

    public void trackSlots() {
        System.out.println("Total Slots: " + this.overallSlots);
        System.out.println("Total Slots Available: " + this.totalSlots);
        System.out.println("Total Occupied Slots: " + (this.overallSlots - this.totalSlots));
        System.out.println();
    }

    public void displayParkedVehicleDetails() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("Parking Lot is Empty ...");
            System.out.println();
        } else {
            for (Map.Entry<Integer, Vehicle> parkedVehiclesData : parkedVehicles.entrySet()) {
                System.out.println("Vehicle Parked At Slot: " + parkedVehiclesData.getKey() + ", Vehicle Number: " + parkedVehiclesData.getValue().licensePlateNumber.toUpperCase() + ", Parked Time: " + parkedVehiclesData.getValue().entryTime);
            }
            System.out.println();
        }
    }

    public void manageOverflow() {
        if (totalSlots == 0) {
            System.err.println("Slots Are Full, Kindly Wait... Byeee brooooooo");
            System.exit(0);
        }
    }
}

public class ParkingLotManagement {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to our Vehicle Parking.");
            System.out.println("Choose from the below option");
            System.out.println("1. Entry vehicle.");
            System.out.println("2. Exit vehicle.");
            System.out.println("3. Show Slots Available.");
            System.out.println("4. Track Slots.");
            System.out.println("5. Display the Vehicle Details.");
            System.out.println("6. Quit.");
            System.out.println();
            System.out.print("Enter Your Choice> ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                parkingLot.manageOverflow();
                System.out.print("Enter Vehicle Number> ");
                String licensePlateNumber = scanner.nextLine();
                Parking parking = new Parking(licensePlateNumber, System.currentTimeMillis());
                parkingLot.vehicleEntry(parking);
            } else if (choice == 2) {
                System.out.print("Enter Vehicle Number to Exit> ");
                String licensePlateNumber = scanner.nextLine();
                parkingLot.vehicleExit(licensePlateNumber);
            } else if (choice == 3) {
                parkingLot.displayAvailability();
            } else if (choice == 4) {
                parkingLot.trackSlots();
            } else if (choice == 5) {
                parkingLot.displayParkedVehicleDetails();
            }
        } while (choice != 6);
    }
}
