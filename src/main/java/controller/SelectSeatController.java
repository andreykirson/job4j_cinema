package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model.Seat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/**
 * @author Andrey
 * @date 15/11/2020
 */


public class SelectSeatController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Collection<Seat> seats = (Collection<Seat>) req.getSession().getAttribute("seats");
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
            HttpSession session = req.getSession();
            session.setAttribute("seats", seats);
            doGet(req, resp);
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

}
