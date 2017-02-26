package com.javservice.service;

import com.javservice.model.Country;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

/**
 * Created by Administrator on 2/26/2017.
 */
public interface IpService {
  public Country fromIP(String ip) throws Exception;
}
