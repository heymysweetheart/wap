package mum.cs472;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerSelect extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String color = req.getParameter("color");
    List brands = new mum.cs472.BeerExpert().getBrands(color);
//    req.getSession().setAttribute("brands", brands);
    req.setAttribute("brands", brands);
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/bearDisplay.jsp");
    requestDispatcher.forward(req, resp);
  }
}

