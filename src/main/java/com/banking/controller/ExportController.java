package com.banking.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.util.Export;

@Controller
public class ExportController {
  private static Logger logger = Logger.getLogger("controller");

  /**
   * Downloads the report as an Excel format. 
   * <p>
   * Make sure this method doesn't return any model. Otherwise, you'll get 
   * an "IllegalStateException: getOutputStream() has already been called for this response"
   */
  @RequestMapping(value = "/export", method = RequestMethod.GET)
  public void getXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
    logger.debug("Received request to download report as an XLS");
    System.out.println("generating");
    new Export().downloadXLS(response);
  }
}
