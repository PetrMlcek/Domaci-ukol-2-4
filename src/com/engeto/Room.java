package com.engeto;

import java.math.BigDecimal;

public class Room {
    private int number;
    private int beds;
    private boolean hasBalcony;
    private boolean seaView;
    private BigDecimal pricePerNight;

    public Room(int number, int beds, boolean hasBalcony,
                boolean seaView, BigDecimal pricePerNight) {
        this.number = number;
        this.beds = beds;
        this.hasBalcony = hasBalcony;
        this.seaView = seaView;
        this.pricePerNight = pricePerNight;
    }

    public int getNumber() {
        return number;
    }

    public int getBeds() {
        return beds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Pokoj číslo " + number +
                " (Počet lůžek " + beds +
                (hasBalcony ? " s balkónem" : " bez balkónu") + ", " +
                (seaView ? " s výhledem na moře" : "bez výhledu na moře") +
                ") za " + pricePerNight + " Kč/noc";
    }
}
