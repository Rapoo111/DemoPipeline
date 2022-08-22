package com.bk_automation_testNG_prototype.helper.browserconfiguration.config;

import com.bk_automation_testNG_prototype.helper.browserconfiguration.BrowserType;

/**
 * 
 * @author  Rishabh Jain
 *
 */
public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();
	public String getInvalidUserName();
	public String getInvalidPassword();

}
