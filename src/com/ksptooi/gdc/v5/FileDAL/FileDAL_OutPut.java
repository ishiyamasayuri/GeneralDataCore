package com.ksptooi.gdc.v5.FileDAL;

import java.io.File;
import java.io.PrintWriter;

import com.ksptooi.gdc.Main.DataCore;

public class FileDAL_OutPut {

	
	FileDAL_Input inpDAL=new FileDAL_Input();
	
	
	//��ָ������д���ļ�(����)
	public boolean writeToFile(File File,String Content){
		
		try{
			
			PrintWriter pw=new PrintWriter(File,"UTF-8");
			
			pw.println(Content);
			pw.flush();
			pw.close();
			
			return true;
			
			
		}catch(Exception e){
			e.printStackTrace();
			DataCore.LogManager.logError("�ļ�ϵͳ���� at writeToFile");
		}
		
		return false;
		
	}
	
	//��ָ���������ӵ��ļ���
	public boolean addToFile(File File,String addContent){
		
		String fileOldContent=null;
		
		String fileNewContent=addContent;
			
		fileOldContent=inpDAL.getFileContent(File);
			
		
		if(this.writeToFile(File, fileOldContent+fileNewContent)==true){
			return true;
		}
			
		return false;

	}
	
	
	
	//�޸�keyֵ������
	public void modifyKeyValue(File File , String Key , String newContent,String SeparationSymbol){
		
		String allContent=inpDAL.getFileContent(File);
		
		String oldKeyLine=inpDAL.getFileKeyLine(File, Key,SeparationSymbol);
		
		String newKeyLine=Key+SeparationSymbol+newContent;
		
		
		try{
			
			this.writeToFile(File, allContent.replace(oldKeyLine, newKeyLine));
			
		}catch (NullPointerException e){
			DataCore.LogManager.logError("�ļ�ϵͳ����! - Keyδ�ҵ�("+Key+") - modifyKeyValue");
			DataCore.LogManager.logWarning("δ��ִ���ļ�����");
		}
		
		
	}
	
	
	
	
}