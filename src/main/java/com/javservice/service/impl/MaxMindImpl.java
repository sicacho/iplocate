package com.javservice.service.impl;

import com.javservice.model.Country;
import com.javservice.service.IpService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2/26/2017.
 */
@Service
public class MaxMindImpl implements IpService {

  ClassPathResource classPathResource = new ClassPathResource("GeoLite2-Country.mmdb");
  InputStream database = classPathResource.getInputStream();
  DatabaseReader reader = new DatabaseReader.Builder(database).build();

  public MaxMindImpl() throws IOException {
  }


  @Override
  public Country fromIP(String ip) throws Exception {
    InetAddress ipAddress = InetAddress.getByName(ip);
    CountryResponse countryResponse = reader.country(ipAddress);
    return new Country(countryResponse.getCountry().getName(),countryResponse.getCountry().getIsoCode());
  }
}
