package ch5.persistentData;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.HelperBaseCh5;
import shared.ButtonMethod;
import shared.HibernateHelper;
import java.util.Properties;

public class ControllerHelper extends HelperBaseCh5
{
    protected RequestDataPersistent data = new RequestDataPersistent();
  
    public ControllerHelper(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) 
    {
    super(servlet, request, response);
    }
    
    static public void initHibernate(HttpServlet servlet) 
    {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.setProperty("hibernate.c3p0.min_size", "1");
        props.setProperty("hibernate.c3p0.max_size", "5");
        props.setProperty("hibernate.c3p0.timeout", "300");
        props.setProperty("hibernate.c3p0.max_statements", "50");
        props.setProperty("hibernate.c3p0.idle_test_period", "300");
        props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST");
        props.setProperty("hibernate.connection.username", "root");
        props.setProperty("hibernate.connection.password", "CGS-4854");

        boolean create = Boolean.parseBoolean(servlet.getInitParameter("create"));
        if (create) 
        {
            HibernateHelper.createTable(props, RequestDataPersistent.class);
        }
        HibernateHelper.initSessionFactory(props, RequestDataPersistent.class);
    } 
    
    public Object getData() 
    {
    return data;
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
        return "/WEB-INF/classes/ch5/persistentData/" + page;
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
        if (!isValid(data)) 
        {
            return jspLocation("Expired.jsp");
        }
        HibernateHelper.updateDB(data);
        java.util.List list = HibernateHelper.getListData(data.getClass());
        request.setAttribute("database", list);
        return jspLocation("Process.jsp");
    }
    
    public void doGet() throws ServletException, IOException 
    {  
        addHelperToSession("helper", SessionData.IGNORE);
        String address = editMethod();
        request.getRequestDispatcher(address).forward(request, response);
    }
    
    public void doPost() throws ServletException, java.io.IOException 
    {
    addHelperToSession("helper", SessionData.READ);
    String address = executeButtonMethod();
    request.getRequestDispatcher(address).forward(request, response);
    } 
}
