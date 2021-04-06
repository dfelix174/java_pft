package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("94.45.153.1");
    assertTrue(ipLocation.contains("UA"));
  }


  @Test
  public void testInvalidMyIp(){
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("1.45.153.1");
    assertTrue(ipLocation.contains("CN"));
  }
}
