package test;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.bytecode.opencsv.CSVReader;

import com.sample.dao.VarsDAO;
import com.sample.dbo.Vars;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		String filePath = "C:\\csv\\";
		String fileName = "test1.csv";
		
		try {
			readCSV(filePath, fileName, context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readCSV(String filePath, String fileName, ApplicationContext context) throws IOException {
		Integer contentId = 1;//test file template
		VarsDAO varsDAO = (VarsDAO) context.getBean("VarsDAO");
		List<Vars> varses = varsDAO.findByContentId(contentId);
		
		SimpleDateFormat tradeDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		CSVReader reader = new CSVReader(new FileReader(filePath + fileName));
		
		List<String[]> list = reader.readAll();
		
		System.out.println("Row Size: " + list.size());
		//Row
		for(int i = 0; i < 100; i++) {
			//Cell
			
			String[] cells = list.get(i);
			for(int j = 0; j < cells.length; j++) {
				System.out.print(cells[j] + "\t");
			}
			System.out.println("");
		}
		
		/*
		String[] headerList = {};
		int k = 0;
		if(fileName.contains("TAIBIR")){
			k = 4;
		}
		
		headerList = list.get(k);
		k = k+1;
		for(int i=k ; i<list.size() ; i++){
			String[] row = list.get(i);			
			for(int j = 0 ; j < row.length ; j++){
				String fieldName = headerList[j];
				String value = row[j];
				Date tradeDate = new Date();
				try {
					tradeDate = tradeDateFormat.parse(row[0]);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Excel excel = new Excel();
				excel.setFieldName(fieldName);
				excel.setValue(value);
				excel.setFileName(fileName);
				excel.setTradeDate(tradeDate);
				Timestamp time = new Timestamp(System.currentTimeMillis());
				excel.setInsertDate(time);
				try{
					if(value != null){
						excelDAO.save(excel);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}*/
	}
	
	
}
