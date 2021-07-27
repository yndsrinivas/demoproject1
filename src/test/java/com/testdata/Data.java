package com.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	
	static Workbook wb=null;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
	ArrayList<Object[]> getdata=new ArrayList<Object[]>();
		try
		{
			//open excel in read mode
			File f=new File("Input.xlsx");
			FileInputStream fi=new FileInputStream(f);
			wb= new XSSFWorkbook(fi);
			
			
			//goto to sheet1
			Sheet sh=wb.getSheet("Sheet1");
			int nour=sh.getPhysicalNumberOfRows();
			int nouc=sh.getRow(0).getLastCellNum();
			
			System.out.println("No. of used rows is" +nour);
			System.out.println("No. of used columns is "+nouc);
			
			
		/*	for(int i=0;i<nour;i++)
			{
				for(int j=0;j<nouc;j++)
				{
					sh.getRow(i).getCell(j).setCellType(CellType.STRING);
					String x=sh.getRow(i).getCell(j).getStringCellValue();
					System.out.print(x+"\t");
				}
				System.out.println();				
			}
		}
		catch(Exception e)
		{
			
		}*/
			 for(int i=1;i<nour;i++)
			 {
		
					 String firstname=sh.getRow(i).getCell(0).getStringCellValue();
					 String lastname=sh.getRow(i).getCell(1).getStringCellValue();
					 String email=sh.getRow(i).getCell(2).getStringCellValue();
					 String pwd=sh.getRow(i).getCell(3).getStringCellValue();
					 
					 Object ob[]= {firstname,lastname,email,pwd};
					 getdata.add(ob);
			 }
		}
			 catch (Exception e)
				{
					e.printStackTrace();
				}
		return getdata;
		
	}
}
