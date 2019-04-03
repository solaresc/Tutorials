package ch3.reorganised;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch3.defaultValidate.RequestDataDefault;

public class ControllerHelper extends HelperBase
{
    protected RequestDataDefault data;
  
    public ControllerHelper(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) 
    {
    super(servlet, request, response);
    data= new RequestDataDefault();
    }
    
    public Object getData() 
    {
    return data;
    }
  
    public void doGet() throws ServletException, IOException 
    {  
    request.getSession().setAttribute("helper", this);
    data.setHobby(request.getParameter("hobby"));
    data.setHobby2(request.getParameter("hobby2"));
    
    String address;

    if (request.getParameter("processButton") != null) 
    {
      address= "Process.jsp";
    } 
    else if (request.getParameter("confirmButton") != null)
    {
      address= "Confirm.jsp";
    } 
    else 
    {
      address= "Edit.jsp";
    }
    
    RequestDispatcher dispatcher= request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
