package com.javservice.controller;

import com.javservice.model.Country;
import com.javservice.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2/26/2017.
 */
@Controller
public class index {

  @Autowired
  IpService ipService;

  @RequestMapping(value = "/country",method = RequestMethod.GET,produces = "application/json")
  public @ResponseBody
  Country fromIP(@RequestParam String ip) {
    try {
      return ipService.fromIP(ip);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
