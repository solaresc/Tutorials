package shared;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;

public abstract class HelperBaseCh4 
{
    protected enum SessionData 
    {
        READ, IGNORE
    };
    
    protected HttpServlet servlet;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Logger logger;
    private Method methodDefault = null;
    
    public HelperBaseCh4(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) 
    {
    this.servlet = servlet;
    this.request = request;
    this.response = response;
    initLogger();
    }

    protected void initLogger() 
    {
    String logName = "bytesizebook.webdev";
    String initName = servlet.getInitParameter("logName");
    if (initName != null) logName = initName;

    Level logLevel = Level.DEBUG;
    String strLevel = servlet.getInitParameter("logLevel");
    if (strLevel != null) 
    {
        logLevel = Level.toLevel(strLevel);
    }

    logger = Logger.getLogger(logName);
    logger.setLevel(logLevel);
    }

    protected abstract void copyFromSession(Object helper);
    
    public void addHelperToSession(String name, SessionData state) 
    {
        if (SessionData.READ == state) 
        {
            Object sessionObj = request.getSession().getAttribute(name);
            if (sessionObj != null) 
            {
                copyFromSession(sessionObj);
            }
        }
        request.getSession().setAttribute(name, this);
    }

    protected String executeButtonMethod() throws ServletException, IOException 
    {
    String result = "";
    methodDefault = null;
    Class clazz = this.getClass();
    Class enclosingClass = clazz.getEnclosingClass();
    while (enclosingClass != null) 
    {
        clazz = this.getClass();
        enclosingClass = clazz.getEnclosingClass();
    }

    try 
    {
        result = executeButtonMethod(clazz, true);
    } 
    catch (IllegalAccessException | InvocationTargetException ex) 
    {
        writeError(request, response,
                "Button Method Error", ex);
        return "";
    }

    return result;
    }

    protected String executeButtonMethod(Class clazz, boolean searchForDefault) throws IllegalAccessException, InvocationTargetException 
    {
        String result = "";
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) 
        {
            ButtonMethod annotation = method.getAnnotation(ButtonMethod.class);
            if (annotation != null) 
            {
                if (searchForDefault && annotation.isDefault()) 
                {
                    methodDefault = method;
                }
                if (request.getParameter(annotation.buttonName()) != null) 
                {
                    result = invokeButtonMethod(method);
                    break;
                }
            }
        }
        if (result.equals("")) 
        {
            Class superClass = clazz.getSuperclass();
            if (superClass != null) 
            {
                result = executeButtonMethod(superClass, methodDefault == null);
            }
            if (result.equals("")) 
            {
                if (methodDefault != null) 
                {
                    result = invokeButtonMethod(methodDefault);
                } 
                else 
                {
                    logger.error("(executeButtonMethod) No default method " + "was specified, but one was needed.");
                    result = "No default method was specified,.";
                }
            }
        }
        return result;
    }

    protected String invokeButtonMethod(Method buttonMethod) throws IllegalAccessException, InvocationTargetException 
    {
        String resultInvoke = "Could not invoke method";
        try 
        {
            resultInvoke = (String) buttonMethod.invoke(this, (Object[]) null);
        } 
        catch (IllegalAccessException iae) 
        {
            logger.error("(invoke) Button method is not public.", iae);
            throw iae;
        } 
        catch (InvocationTargetException ite) 
        {
            logger.error("(invoke) Button method exception", ite);
            throw ite;
        }
        return resultInvoke;
    }
    
    public void fillBeanFromRequest(Object data) 
    {
        try 
        {
            org.apache.commons.beanutils.BeanUtils.populate(data, request.getParameterMap());
        } 
        catch (IllegalAccessException iae) 
        {
            logger.error("Populate - Illegal Access.", iae);
        }
        catch (InvocationTargetException ite) 
        {
            logger.error("Populate - Invocation Target.", ite);
        }  
    }

    static public void writeError(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String title, Exception ex) 
    throws IOException, ServletException 
    {
        java.io.PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>" + title + "</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("<h2>" + title + "</h2>");
        if (ex.getMessage() != null) 
        {
            out.println("    <h3>" + ex.getMessage() + "</h3>");
        }
        if (ex.getCause() != null) 
        {
            out.println("    <h4>" + ex.getCause() + "</h4>");
        }
        StackTraceElement[] trace = ex.getStackTrace();
        if (trace != null && trace.length > 0) 
        {
            out.print("<pre>");
        }
        ex.printStackTrace(out);
        out.println("</pre>");
        out.println("  </body>");
        out.println("</html>");
        out.close();
        
        
        
    }
}