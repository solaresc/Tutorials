package ch5.requiredValidation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.HelperBaseCh5;
import shared.ButtonMethod;

public class ControllerHelper extends HelperBaseCh5
{
    protected RequestDataRequired data;
  
    public ControllerHelper(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) 
    {
    super(servlet, request, response);
    data= new RequestDataRequired();
    }
    
    public Object getData() 
    {
    return data;
    }
  
    public void doGet() throws ServletException, IOException 
    {  
        addHelperToSession("helper", SessionData.READ);
        String address = executeButtonMethod();
        request.getRequestDispatcher(address).forward(request, response);
    } 
    
    public void copyFromSession(Object sessionHelper)
    {
        if (sessionHelper.getClass() == this.getClass()) 
        {
            data = ((ControllerHelper)sessionHelper).data;
        }
    }
    
    protected String jspLocation(String page) 
    {
        return "/WEB-INF/classes/ch5/requiredValidation/" + page;
    }
  
    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() 
    {
        return jspLocation("Edit.jsp");
    }

    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() 
    {
        fillBeanFromRequest(data);
        String address;
        if (isValid(data)) 
        {
            address = jspLocation("Confirm.jsp");
        } 
        else 
        {
            address = jspLocation("Edit.jsp");
        }
        return address;
    }

    @ButtonMethod(buttonName="processButton")
    public String processMethod() 
    {
        return jspLocation("Process.jsp");
    }

}
