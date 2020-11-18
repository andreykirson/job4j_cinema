package controller;

import model.Seat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


public class ReserveSeatController extends HttpServlet {

    ConcurrentHashMap<String, Seat> hall = new ConcurrentHashMap<>(21){{
        put("11", new Seat("11", false));
        put("12", new Seat("12", false));
        put("13", new Seat("13", false));
        put("14", new Seat("14", false));
        put("15", new Seat("15", false));
        put("16", new Seat("16", false));
        put("17", new Seat("17", false));
        put("21", new Seat("21", false));
        put("22", new Seat("22", false));
        put("23", new Seat("23", false));
        put("24", new Seat("24", false));
        put("25", new Seat("25", false));
        put("26", new Seat("26", false));
        put("27", new Seat("27", false));
        put("31", new Seat("31", false));
        put("32", new Seat("32", false));
        put("33", new Seat("33", false));
        put("34", new Seat("34", false));
        put("35", new Seat("35", false));
        put("36", new Seat("36", false));
        put("37", new Seat("37", false));
    }};
    ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }
}
