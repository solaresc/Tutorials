package ch3.reorganised;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelperBase 
{
    protected HttpServlet servlet;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
        public HelperBase(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) 
        {
        this.servlet = servlet;
        this.request = request;
        this.response = response;
        }
}
