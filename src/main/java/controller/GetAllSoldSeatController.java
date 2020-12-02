package controller;

import com.google.gson.Gson;
import model.Seat;
import store.PsqlStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * @author Andrey
 * @date 15/11/2020
 */


public class GetAllSoldSeatController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Collection<Seat> seats = PsqlStore.instOf().getAllSeats();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String json = new Gson().toJson(seats);
        writer.println(json);
        writer.flush();
        writer.close();
    }

}
