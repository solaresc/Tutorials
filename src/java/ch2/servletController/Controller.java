package ch2.servletController;

import ch3.startExample.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException
    {
        String address;
        if (request.getParameter("confirmButton") != null)
        {
          address = "Confirm.jsp";  
        } 
        else if (request.getParameter("processButton") != null)
        {
          address = "Process.jsp"; 
        }
        else 
        {
            address = "Edit.jsp"; 
        }
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
    }
}
