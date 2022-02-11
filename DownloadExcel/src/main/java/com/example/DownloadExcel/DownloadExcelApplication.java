package com.example.DownloadExcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;

@SpringBootApplication
public class DownloadExcelApplication {

		public static void main(String[] args)
				throws FileNotFoundException, IOException {

			Workbook wb = new HSSFWorkbook();
			User user = new User();
			for (Field field : user.getClass().getDeclaredFields()) {
				Sheet sheet = wb.createSheet(field.getName());
			}
			OutputStream fileOut
					= new FileOutputStream("new.xlsx");

			System.out.println(
					"Sheets Has been Created successfully");

			wb.write(fileOut);
		}

	}
