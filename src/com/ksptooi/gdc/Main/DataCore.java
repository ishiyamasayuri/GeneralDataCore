package com.ksptooi.gdc.Main;

import com.ksptooi.gdc.Log.LogManager;
import com.ksptooi.gdc.Log.gdcLog;

public class DataCore {

	
	public static void main(String[] args) {
		
		System.out.println("GeneralDataCore�汾:"+DataCore.gdc_Version);
		
		System.out.println("GeneralDataCore - Developer Version");
		
	}
	
	
	public static final String gdc_Version="V7.08-A";
	
	public static LogManager LogManager=new gdcLog();
	
	public static String getVersion() {
		return gdc_Version;
	}
	
	
	
}
