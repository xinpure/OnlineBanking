package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.util.Chart;
import com.banking.util.Export;

@Controller
public class StatisticsController {

  @RequestMapping(value = "/export", method = RequestMethod.GET)
  public void getXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
    new Export().downloadXLS(response);
  }

  @RequestMapping(value = "/chart", method = RequestMethod.GET)
  public void getChart(HttpServletRequest request,HttpServletResponse response) throws IOException{
    System.out.println("getting chart");
    response.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();
    List<Map<String,Object>> list = null;
    list = new Chart().pieFindInfo();
    JSONArray json = JSONArray.fromObject(list);
    out.print(json);
  }

}
