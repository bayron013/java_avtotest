package soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("185.251.242.3");
    assertEquals(geoIP, "<GeoIP><Country>US</Country><State>CA</State></GeoIP>");
  }
}
