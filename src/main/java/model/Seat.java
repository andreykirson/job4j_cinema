package model;

import java.util.Objects;

public class Seat {
    private int id;
    private int number;
    private int row;

    public Seat(int row, int number) {
        this.number = number;
        this.row = row;
    }

    public Seat(int id, int row, int number) {
        this.id = id;
        this.row = row;
        this.number = number;
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id == seat.id &&
                Objects.equals(number, seat.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "Seat{" +
                ", row=" + row +
                "number=" + number +
                '}';
    }
}
