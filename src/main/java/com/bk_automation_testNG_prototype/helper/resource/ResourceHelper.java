package com.bk_automation_testNG_prototype.helper.resource;

/**
 * 
 * @author  Rishabh Jain
 *
 */
public class ResourceHelper {

	public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        System.out.println(basePath +"/"+ path);
		return basePath +"/"+ path;		
		
	}
}
