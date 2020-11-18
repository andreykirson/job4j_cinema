package model;

import java.util.Objects;

public class Seat {
    private String number;
    private Boolean reserved;

    public Seat(String number, Boolean reserved) {
        this.number = number;
        this.reserved = reserved;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Seat seat = (Seat) o;
        return Objects.equals(number, seat.number) &&
                Objects.equals(reserved, seat.reserved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, reserved);
    }
}
