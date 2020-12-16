package ru.appline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.appline.logic.Model;
import ru.appline.logic.User;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet{
	
	Model model = Model.getInstance();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		if (id == 0) {
			pw.print(gson.toJson(model.getFromList()));
			
		} else if(id > 0 ) {
			if (id > model.getFromList().size()) {
				pw.print("wrong ID");
			} else {
				pw.print(gson.toJson(model.getUser(id)));
			}
			
		} else {
			pw.print("ID should be greater than 0");
		}
	}

}
