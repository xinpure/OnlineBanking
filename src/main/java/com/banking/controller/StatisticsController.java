package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.util.Chart;
import com.banking.util.Export;
import com.google.gson.Gson;

@Controller
public class StatisticsController {
  
  private static Logger logger = Logger.getLogger("controller");

  @RequestMapping(value = "/export", method = RequestMethod.GET)
  public void getXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
    logger.debug("Received request to download report as an XLS");
    System.out.println("generating xls");
    new Export().downloadXLS(response);
  }

  @RequestMapping(value = "/chart", method={RequestMethod.GET,RequestMethod.POST})
  public void getChart(HttpServletRequest request,HttpServletResponse response) throws IOException{
    System.out.println("getting chart");
    response.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();
    List<Map<String,Object>> list = null;
    list = new Chart().pieFindInfo();
    Gson gson = new Gson();
    String json = gson.toJson(list);
    out.print(json);
  }

}
