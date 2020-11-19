package store;

import model.Account;
import model.Seat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface Store {
    Collection<Seat> getAllSeats();
    void buy(ArrayList<Seat> seats) throws SQLException;
    Account createAccount(Account account);
    void saveAccount(Account account);
    Account findAccountById(int id);
    Account findAccountByEmail(String email);
}
