package ru.appline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import ru.appline.logic.Model;
import ru.appline.logic.User;

@WebServlet(urlPatterns = "/upd")
public class ServletPut extends HttpServlet{
	
	Model model = Model.getInstance();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuilder jb = new StringBuilder();
		String line;
		try {
			BufferedReader reader  = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		int id = jobj.get("id").getAsInt();
		String name = jobj.get("name").getAsString();
		String surname = jobj.get("surname").getAsString();
		double salary = jobj.get("salary").getAsDouble();
		
		if (model.getFromList().containsKey(id)) {
			User user = new User(name, surname, salary);
			pw.print("Sucsess!");
			model.updateUser(id, user);
		} else {
			pw.print("wrong UserID");
		}
	}
}
