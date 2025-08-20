package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/session" })
public class LoginServlet2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
	     PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if ("trungnh".equals(username) && "123".equals(password)) {
		    out.print("Chào mừng bạn, " + username);

		    HttpSession session = req.getSession();
		    session.setAttribute("name", username);

		} else {
		    out.print("Tài khoản hoặc mật khẩu không chính xác");
		    req.getRequestDispatcher("Login.html")
		           .include(req, resp);
		}

	}
}
