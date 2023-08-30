package exampleMVC.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampleMVC.User;

public class EmailListServlet extends HttpServlet{

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "/index.html";

    String action = request.getParameter("action");

    if(action == null)
        action="join";

    if(action.equals("join"))
        url = "/index.html";

    else if (action.equals("add")){
        String firstname =  request.getParameter("firstName");
        String lastname =  request.getParameter("lastName");
        String email =  request.getParameter("email");
        User user = new User(lastname, firstname, email);

        request.setAttribute("user", user);
        url = "/thanks.jsp";
    }
	
	    getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    doPost(request, response);
	}
}
