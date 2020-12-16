package ru.appline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import ru.appline.logic.Model;
import ru.appline.logic.User;

@WebServlet(urlPatterns = "/del")
public class ServletDel extends HttpServlet{
	
	Model model = Model.getInstance();
	private AtomicInteger counter = new AtomicInteger(model.getFromList().size()+1);
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (model.getFromList().containsKey(id)) {
			model.delUser(id);
			pw.print(gson.toJson(model.getFromList()));
		} else {
			pw.print("wrong ID");
		}
		
	}

}
