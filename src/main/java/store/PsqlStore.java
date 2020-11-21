package store;

import model.Account;
import model.Seat;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store {

    private final BasicDataSource pool = new BasicDataSource();
    private static final Logger LOG = LoggerFactory.getLogger(PsqlStore.class.getName());

    private PsqlStore() {
        Properties cfg = new Properties();
        try (BufferedReader io = new BufferedReader(
                new FileReader("db.properties")
        )) {
            cfg.load(io);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        pool.setDriverClassName(cfg.getProperty("jdbc.driver"));
        pool.setUrl(cfg.getProperty("jdbc.url"));
        pool.setUsername(cfg.getProperty("jdbc.username"));
        pool.setPassword(cfg.getProperty("jdbc.password"));
        pool.setMinIdle(5);
        pool.setMaxIdle(10);
        pool.setMaxOpenPreparedStatements(100);
    }

    private static final class Lazy {
        private static final Store INST = new PsqlStore();
    }

    public static Store instOf() {
        return Lazy.INST;
    }

    @Override
    public Collection<Seat> getAllSeats() {
        List<Seat> seats = new ArrayList<>();
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("SELECT * FROM hall")
        ) {
            try (ResultSet it = ps.executeQuery()) {
                while (it.next()) {
                    seats.add(new Seat(it.getInt("seat_id"), it.getInt("seat_row"), it.getInt("seat_number")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seats;
    }

    @Override
    public void buy(List<Seat> seats) throws SQLException {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("insert into hall(seat_row, seat_number) values (?, ?)")
         ) {
            for (Seat seat:seats) {
                ps.setInt(1, seat.getRow());
                ps.setInt(2, seat.getNumber());
                ps.execute();
            }
        } catch(SQLException se) {
            LOG.debug("Error Code=: {}", se.getErrorCode());
            LOG.debug("SQL State=: {}", se.getSQLState());
            LOG.debug("Message =: {}", se.getMessage());
            throw se;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveAccount(Account account) {
        if (account.getId() == 0) {
            createAccount(account);
        }
    }

    @Override
    public Account createAccount(Account account) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("INSERT INTO accounts (username, email, password)  VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, account.getName());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getPassword());
            try (ResultSet id = ps.getGeneratedKeys()) {
                if (id.next()) {
                    account.setId(id.getInt(1));
                }
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public Account findAccountById(int id) {
        Account account = null;
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("SELECT * FROM accounts WHERE user_id = ?;")
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    account = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account findAccountByEmail(String email) {
        Account account = null;
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("SELECT * FROM accounts WHERE email LIKE ?;")
        ) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    account = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

}
