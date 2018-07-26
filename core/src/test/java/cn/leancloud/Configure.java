package cn.leancloud;

import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AVOSService;
import cn.leancloud.utils.StringUtil;

public class Configure {
  public static final String TEST_APP_ID;
  private static final String TEST_APP_KEY;
  private static final AVOSCloud.REGION reGion;
  private static final String API_HOST;
  static {
    String app = System.getenv("APP_ID");
    TEST_APP_ID = StringUtil.isEmpty(app) ? "ohqhxu3mgoj2eyj6ed02yliytmbes3mwhha8ylnc215h0bgk" : app;
    String appKEY = System.getenv("APP_KEY");
    TEST_APP_KEY = StringUtil.isEmpty(appKEY) ? "6j8fuggqkbc5m86b8mp4pf2no170i5m7vmax5iypmi72wldc" : appKEY;
    String regionStr = System.getenv("APP_REGION");
    reGion = StringUtil.isEmpty(regionStr) ? AVOSCloud.REGION.NorthChina : AVOSCloud.REGION.valueOf(regionStr);
    API_HOST = System.getenv("API_HOST");
  }

  public static void initializeRuntime() {
    AVOSCloud.setRegion(reGion);
    AVOSCloud.setLogLevel(AVLogger.Level.VERBOSE);
    AVOSCloud.initialize(TEST_APP_ID, TEST_APP_KEY);
    if (!StringUtil.isEmpty(API_HOST)) {
      AVOSCloud.setServer(AVOSService.API, API_HOST);
    }
  }
}
