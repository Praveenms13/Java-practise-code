import java.util.*;

interface HostelRoomAllocationSystem {
    void initializeRooms(List<Room> rooms);
    void registerStudent(Student student);
    void mapStudentDataToRooms();
    void allocateRoom(Student student, Room room);
    void updateRoomStatus(Room room);
}

class Student {
    private String name;
    private String gender;
    private int age;
    private String roomPrefernce;

    Student(String name, String gender, int age, String roomPrefernce) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.roomPrefernce = roomPrefernce;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRoomPrefernce() {
        return roomPrefernce;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gender='" + gender + "', age=" + age + ", preference='" + roomPrefernce + "'}";
    }
}

class Room {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;

    Room(int roomNumber, String roomType, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean val) {
        this.isAvailable = val;
    }
}

class HostelRoomBooking implements HostelRoomAllocationSystem {
    private List<Student> students = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private Map<Integer, Student> mappedDatas = new HashMap<>();
    private List<Student> unallocatedStudents = new ArrayList<>();

    public void initializeRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void mapStudentDataToRooms() {
        for (Student student : students) {
            boolean allocated = false;

            for (Room room : rooms) {
                if (!room.isAvailable()) continue;
                if (room.getRoomType().equalsIgnoreCase(student.getRoomPrefernce())) {
                    allocateRoom(student, room);
                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                unallocatedStudents.add(student);
            }
        }
    }

    public void allocateRoom(Student student, Room room) {
        mappedDatas.put(room.getRoomNumber(), student);
        updateRoomStatus(room);
    }

    public void updateRoomStatus(Room room) {
        room.setIsAvailable(false);
    }

    public void displayDatas() {
        System.out.println("Allocated Students to Rooms:");
        for (Map.Entry<Integer, Student> entry : mappedDatas.entrySet()) {
            System.out.println("Room " + entry.getKey() + " -> " + entry.getValue());
        }

        if (!unallocatedStudents.isEmpty()) {
            System.out.println("\nStudents not allocated due to unavailability of preferred rooms:");
            for (Student s : unallocatedStudents) {
                System.out.println(s);
            }
        }
    }
}


public class HostelRoomAllocation {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(101, "AC", true));
        rooms.add(new Room(102, "Non AC", true));
        rooms.add(new Room(103, "Non AC", true));
        rooms.add(new Room(104, "Non AC", true));
        rooms.add(new Room(105, "AC", true));
        rooms.add(new Room(106, "AC", true));
        rooms.add(new Room(107, "Non AC", true));
        rooms.add(new Room(108, "Non AC", true));
        rooms.add(new Room(109, "Non AC", true));
        rooms.add(new Room(110, "AC", true));

        HostelRoomBooking hostelRoomBooking = new HostelRoomBooking();
        hostelRoomBooking.initializeRooms(rooms);

        hostelRoomBooking.registerStudent(new Student("Praveen", "Male", 22, "Ac"));
        hostelRoomBooking.registerStudent(new Student("Ragul", "Male", 22, "Ac"));
        hostelRoomBooking.registerStudent(new Student("Koushik", "Male", 22, "Ac"));
        hostelRoomBooking.registerStudent(new Student("Vibusha", "Female", 22, "Ac"));
        hostelRoomBooking.registerStudent(new Student("Harshitha", "Female", 22, "Ac"));

        hostelRoomBooking.mapStudentDataToRooms();
        hostelRoomBooking.displayDatas();
    }
}
