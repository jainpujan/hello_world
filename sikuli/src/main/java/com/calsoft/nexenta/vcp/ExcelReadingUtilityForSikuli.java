package com.calsoft.nexenta.vcp;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadingUtilityForSikuli{

	public Map<Integer, List<ExcelPojoForSikuliGUI>> getSteps(String sectionName,String inputFilePath) throws Exception{
		Map<Integer,List<ExcelPojoForSikuliGUI>> mapIndexwithSteps = new HashMap<Integer,List<ExcelPojoForSikuliGUI>>();
				FileInputStream fis = new FileInputStream(inputFilePath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet inputSheet= wb.getSheet("Sheet1");
					int count=0;
						for(int i =1;i<=inputSheet.getLastRowNum();i++){
							if(!inputSheet.getRow(i).getCell(2).toString().equals("")){
								List<ExcelPojoForSikuliGUI> sikuliguiPojos =new ArrayList<ExcelPojoForSikuliGUI>();
								ExcelPojoForSikuliGUI guiPojo= new ExcelPojoForSikuliGUI(inputSheet.getRow(i).getCell(1).toString(),
									inputSheet.getRow(i).getCell(2).toString(), inputSheet.getRow(i).getCell(3).toString(), 
									inputSheet.getRow(i).getCell(4).toString());
							
							sikuliguiPojos.add(guiPojo);
							
							mapIndexwithSteps.put(count++, sikuliguiPojos);
						}
							else{
								ExcelPojoForSikuliGUI guiPojo= new ExcelPojoForSikuliGUI(inputSheet.getRow(i).getCell(1).toString(),
										inputSheet.getRow(i).getCell(2).toString(), inputSheet.getRow(i).getCell(3).toString(), 
										inputSheet.getRow(i).getCell(4).toString());
								
								mapIndexwithSteps.get(--count).add(guiPojo);
								count++;
							}
						}
		return mapIndexwithSteps;
	}
	
	public Map<Integer, ExcelPojoForSikuliGUI> getInfoFromDriverFile(String inputFilePath) throws Exception{
		Map<Integer,ExcelPojoForSikuliGUI> mapIndexwithSteps = new HashMap<Integer,ExcelPojoForSikuliGUI>();

				FileInputStream fis = new FileInputStream(inputFilePath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet inputSheet= wb.getSheet("VCP_Test");
					int count=0;
						for(int i =1;i<=inputSheet.getLastRowNum();i++){
								ExcelPojoForSikuliGUI guiPojo= new ExcelPojoForSikuliGUI(inputSheet.getRow(i).getCell(0).toString(),
										inputSheet.getRow(i).getCell(1).toString(), inputSheet.getRow(i).getCell(2).toString(), 
										inputSheet.getRow(i).getCell(3).toString(),inputSheet.getRow(i).getCell(4).toString());
								
								mapIndexwithSteps.put(--count,guiPojo);
								count++;
							}
		return mapIndexwithSteps;
	}
}

