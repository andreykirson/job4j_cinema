package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model.Seat;
import store.PsqlStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Andrey
 * @date 15/11/2020
 */


public class BuySeatController extends HttpServlet {

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
            PsqlStore.instOf().buy(seats);
           }  catch (IOException | SQLException e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}

