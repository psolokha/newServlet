package ru.appline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import ru.appline.logic.Calc;


@WebServlet(urlPatterns = "/calc")
public class ServletCalc extends HttpServlet {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
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
		
		String a = jobj.get("a").getAsString();
		String b = jobj.get("b").getAsString();
		String math = jobj.get("math").getAsString();
		
		pw.print(gson.toJson(new Calc(a, b, math).getResult()));
	}

}
