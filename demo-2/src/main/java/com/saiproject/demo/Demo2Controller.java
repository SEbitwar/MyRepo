package com.saiproject.demo;


import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Demo2Controller {	
	
	String str1=null,str2=null,str=null;
	int c=0,ct=0;
	boolean flag=true;

	@RequestMapping("/hii")
	public String fun() throws EncryptedDocumentException, InvalidFormatException, IOException
	{		
		read();		
		return str;
	}
	
	public void read() throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		String path = "E://excel.xls";		
		Workbook workbook = WorkbookFactory.create(new File(path));
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		for (Row row: sheet)
		{
			ct++;
		}		
		
		ct=0;
		for (Row row: sheet) {
            for(org.apache.poi.ss.usermodel.Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
                if(c==0)
                {
                	str1= new String(cellValue);
                	c++;
                }
                else
                {
                    	str2= new String(cellValue);
                    	c=0;
                }
                
            }
           
            if(flag==true) {
            str=str1+","+str2;
            flag=false;
            }
            else
                str=str+","+str1+","+str2;
        }
		}
	}
	
	
	

