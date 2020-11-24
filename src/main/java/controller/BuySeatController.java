package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import jdk.jfr.StackTrace;
import model.Seat;
import store.PsqlStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class BuySeatController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Collection<Seat> seats = (Collection<Seat>) req.getAttribute("seats");
        seats.add(new Seat(1,1,1));
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String json = new Gson().toJson(seats);
        writer.println(json);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Seat> seats = new ArrayList<>();
        try (BufferedReader reader = req.getReader()) {
            StringBuilder fullLine = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fullLine.append(line);
            }
            JsonElement jsonElement =  new JsonParser().parse(String.valueOf(fullLine));
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
               String[] arr = jsonArray.get(i).getAsString().split(",");
               seats.add(new Seat(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
            }
            req.setAttribute("seats", seats);
            doGet(req, resp);
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

}
