import com.engeto.Booking;
import com.engeto.BookingManager;
import com.engeto.Room;
import com.engeto.Guest;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Správa rezervací
        BookingManager manager = new BookingManager();

        // Testovacé data
        fillBookings(manager);

        // Všechny rezervace
        manager.printAllBookings();


        // Průměrný počet hostů na rezervaci
        double averageGuests = manager.getAverageGuests();
        System.out.println("Průměrný počet hostů na rezervaci: " + averageGuests);
        System.out.println();

        // Prvních 8 rezervací
        int count = 8;
        printRecreationalBookings(manager, count);

        // Vypíše hosty s jedním, dvěma, třemi a více hosty
        printGuestStatistics(manager);

        System.out.println();

    }

    public static void fillBookings(BookingManager manager) {

        // Hosti Adéla a Jana
        Guest adela = new Guest("Adéla", "Malíková",
                LocalDate.of(1993, 3, 13));
        Guest jana = new Guest("Jana", "Dvořáčková",
                LocalDate.of(1995, 5, 5));
        System.out.println(adela);
        System.out.println(jana);
        System.out.println();

        // Pokoje (1,2,3)
        Room room1 = new Room(1, 1, true,
                true, BigDecimal.valueOf(1000));
        Room room2 = new Room(2, 1, true,
                true, BigDecimal.valueOf(1000));
        Room room3 = new Room(3, 3, false,
                true, BigDecimal.valueOf(2400));
        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);
        System.out.println();



        // Rezervace pro Karel Dvořák
        Guest karel1 = new Guest("Karel", "Dvořák",
                LocalDate.of(1990, 5, 15));
        Booking booking3 = new Booking(room3, Arrays.asList(karel1),
                LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 7), false, room3.getPricePerNight());
        manager.addBooking(booking3);

        // Rezervace pro Karel Dvořák
        Guest karel2 = new Guest("Karel", "Dvořák",
                LocalDate.of(1979, 1, 3));
        Booking booking4 = new Booking(room2, Arrays.asList(karel2),
                LocalDate.of(2023, 7, 18),
                LocalDate.of(2023, 7, 21), true, room2.getPricePerNight());
        manager.addBooking(booking4);

        // Rezervace pro Karolína Tmavá
        Guest karolina1 = new Guest("Karolína", "Tmavá",
                LocalDate.of(1985, 4, 12));
        for (int i = 1; i <= 10; i++) {
            LocalDate startDate = LocalDate.of(2023, 8, i * 2 - 1);
            LocalDate endDate = startDate.plusDays(1);
            Booking booking = new Booking(room2, Arrays.asList(karolina1),
                    startDate, endDate, true, room2.getPricePerNight());
            manager.addBooking(booking);


        }
        // Rezervace pro Karolína Tmavá
        Guest karolina2 = new Guest("Karolína", "Tmavá",
                LocalDate.of(1985, 4, 12));
        Booking booking5 = new Booking(room3, Arrays.asList(karolina1),
                LocalDate.of(2023, 8, 1),
                LocalDate.of(2023, 8, 31), true,
                room3.getPricePerNight());
        manager.addBooking(booking5);
    }

    private static void printRecreationalBookings(BookingManager manager, int n) {
        List<Booking> bookings = manager.getBookings();
        int printedCount = 0;

        System.out.println("Prvních " + n + " rekreačních rezervací:");

        for (Booking booking : bookings) {
            if (booking.getTypeOfVacation()) {
                LocalDate startDate = booking.getStartDate();
                LocalDate endDate = booking.getEndDate();
                Room room = booking.getRoom();
                List<Guest> guests = booking.getGuests();


                Guest mainGuest = guests.get(0);
                String seaView = room.isSeaView() ? "ano" : "ne";
                int totalGuests = guests.size();


                BigDecimal pricePerNight = room.getPricePerNight();
                int totalNights = (int) (endDate.toEpochDay() - startDate.toEpochDay());
                BigDecimal getPrice = pricePerNight.multiply(new BigDecimal(totalNights));


                System.out.println(startDate + " až " + endDate + ": " + mainGuest + " (" +
                        mainGuest.getBirthDate() + ") [" + totalGuests + ", " + seaView + "] za " +
                        getPrice + " Kč");


                printedCount++;
                if (printedCount == n) {
                    break;
                }
            }
        }
    }
    private static void printGuestStatistics(BookingManager manager) {
        List<Booking> bookings = manager.getBookings();
        int oneGuest = 0;
        int twoGuests = 0;
        int threeAndMoreGuests = 0;

        for (Booking booking : bookings) {
            List<Guest> guests = booking.getGuests();
            int numberOfGuests = guests.size();

            if (numberOfGuests == 1) {
                oneGuest++;
            } else if (numberOfGuests == 2) {
                twoGuests++;
            } else if (numberOfGuests > 2) {
                threeAndMoreGuests++;
            }
        }

        // Rezervace s jedním, dvěma, třemi a více hosty
        System.out.println("Celkový počet rezervací s jedním hostem: " + oneGuest);
        System.out.println("Celkový počet rezervací se dvěma hosty: " + twoGuests);
        System.out.println("Celkový počet rezervací se třemi a více hosty: " + threeAndMoreGuests);
        System.out.println();
    }
}