package model;

import java.util.Objects;

public class Seat {
    private int id;
    private int number;
    private Boolean reserved = false;

    public Seat(int number, Boolean reserved) {
        this.number = number;
        this.reserved = reserved;
    }

    public Seat(int id, int number, Boolean reserved) {
        this.id = id;
        this.number = number;
        this.reserved = reserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id == seat.id &&
                Objects.equals(number, seat.number) &&
                Objects.equals(reserved, seat.reserved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, reserved);
    }
}
