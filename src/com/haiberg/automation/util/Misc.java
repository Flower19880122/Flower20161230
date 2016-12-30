package com.haiberg.automation.util;


import org.openqa.selenium.os.WindowsUtils;


public class Misc {

	public static void setExecutionENV(){
		
		WindowsUtils.tryToKillByName("ChromeDriver.exe");
		//WindowsUtils.tryToKillByName("firefox.exe");
		
	}
}
