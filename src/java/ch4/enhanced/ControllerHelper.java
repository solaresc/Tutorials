package ch4.enhanced;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch3.defaultValidate.RequestDataDefault;
import shared.HelperBaseCh4;
import shared.ButtonMethod;

public class ControllerHelper extends HelperBaseCh4
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
        return "/WEB-INF/classes/ch4/enhanced/" + page;
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
        return jspLocation("Confirm.jsp");
    }

    @ButtonMethod(buttonName="processButton")
    public String processMethod() 
    {
        return jspLocation("Process.jsp");
    }

}
