package com.rundatop.core.excel;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rundatop.core.utils.DateUtils;

@SuppressWarnings("unchecked")
public class ExeclTool07<T> {
	
	private static ExeclTool07 instance;
	private static XSSFFont font;
	private static XSSFFont font3;
	private ExeclTool07(){}

	//单例
	public static ExeclTool07 getInstance(){
		
		if(null==instance){
			instance = new ExeclTool07();
		}
		return instance;
	}
	
	/**
	 * 导出方法
	 * @param title：标题
	 * @param herders 封装了ExeclBean类的list，用于循环输出表头信息
	 * @param ds：数据源，实现了Collection接口的任意集合类
	 * @param out：OutputStream对象
	 * @throws Exception
	 */
	public void exportExecl(String title,List<ExeclBean> herders,Collection<T> ds,OutputStream out) throws Exception{
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		font = workbook.createFont(); 
        font.setColor(HSSFColor.VIOLET.index); 
        font.setFontHeightInPoints((short) 12); 
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 
        font3 = workbook.createFont(); 
        font3.setColor(HSSFColor.BLUE.index); 
		
		
		
        XSSFSheet sheet = workbook.createSheet(title); 
        
        sheet.setDefaultColumnWidth(15);
        
        XSSFRow titleRow = sheet.createRow(0); 
        XSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(title);
        titleCell.setCellStyle(getTitleStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, herders.size()-1));
        
        XSSFRow dateRow = sheet.createRow(1);
        if(herders.size()==1){
        	XSSFCell dateCell = dateRow.createCell(0);
        	dateCell.setCellValue("制单日期："+DateUtils.stringOfCnDate());
        }else{
        	dateRow.createCell(herders.size()-2).setCellValue("制单日期：");
        	dateRow.createCell(herders.size()-1).setCellValue(DateUtils.stringOfCnDate());
        }
        
        XSSFRow row = sheet.createRow(2); 
        
        XSSFCellStyle headerSytle = getHeaderStyle(workbook);
        
        XSSFCellStyle contentSyle = getContentStyle(workbook);
        
        //循环表头，设置样式
        for (int i = 0; i < herders.size(); i++) { 
        	
        	XSSFCell cell = row.createCell(i); 

            cell.setCellStyle(headerSytle); 
          
            XSSFRichTextString text = new XSSFRichTextString(herders.get(i).getName()); 

            cell.setCellValue(text); 

        }
        
        Iterator<T> it = ds.iterator();
        
        int idx = 2;
        
        String getMethod = "";
        
        //循环表体
        while(it.hasNext()){
        	idx++;
        	
        	row = sheet.createRow(idx);
        	
        	T t = it.next();
        	
        	Class tClass = t.getClass();
        	
        	String textValue = "";
        	
        	for (int i = 0; i < herders.size(); i++) {
        		
        		XSSFCell cell = row.createCell(i); 
        		
        		cell.setCellStyle(contentSyle); 
        		
        		getMethod = herders.get(i).getGetterMethod();
        		
        		Object value=null;
        		
        		if(t.getClass().isAssignableFrom(Map.class)){
        			value=((Map)t).get(getMethod);
        		}else{
        			//通过反射得到get方法
            		Method getter = tClass.getMethod(getMethod, null);
            		//通过反射执行get方法
            		value = getter.invoke(t, null);
        		}
        		
        		
        		
        		
        		if(null == value) value="";
        		
        		
        		//处理日期类型值的显示方法
        		if(value instanceof Date){
        			Date date = (Date)value;
        			
        			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 

                    textValue = sdf.format(date); 
        		}else{
        			textValue = value.toString();
        		}
        		
        		
        		//处理数字类型值的显示方法
        		Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$"); 

                Matcher matcher = p.matcher(textValue); 
                
                if (!value.getClass().getName().equals("java.lang.String") && matcher.matches()) { 

                    // 是数字当作double处理

                    cell.setCellValue(Double.parseDouble(textValue)); 

                } else { 

                	XSSFRichTextString richString = new XSSFRichTextString( 

                            textValue); 


                    richString.applyFont(font3); 

                    cell.setCellValue(richString); 

                } 
        	}
        }
        
        
        
        //向outputstream对象中输出
        workbook.write(out); 
        
	}

	
	/**
	 * 导出方法
	 * @param title：标题
	 * @param herders 封装了ExeclBean类的list，用于循环输出表头信息
	 * @param ds：数据源，实现了Collection接口的任意集合类
	 * @param out：OutputStream对象
	 * @throws Exception
	 */
	public void exportExecl(String title,List<ExeclBean> herders,Collection<T> ds,Map<String, String> others,OutputStream out) throws Exception{
		XSSFWorkbook workbook = new XSSFWorkbook(); 

		XSSFSheet sheet = workbook.createSheet(title); 
        
        sheet.setDefaultColumnWidth(15);
        
        XSSFRow titleRow = sheet.createRow(0); 
        XSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(title);
        titleCell.setCellStyle(getTitleStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, herders.size()-1));
        
        XSSFRow dateRow = sheet.createRow(1);
        if(herders.size()==1){
        	XSSFCell dateCell = dateRow.createCell(0);
        	dateCell.setCellValue("制表日期："+DateUtils.stringOfCnDate());
        }else{
        	dateRow.createCell(herders.size()-2).setCellValue("制表日期：");
        	dateRow.createCell(herders.size()-1).setCellValue(DateUtils.stringOfCnDate());
        }
        
        XSSFRow row = sheet.createRow(2); 
        
        XSSFCellStyle headerSytle = getHeaderStyle(workbook);
        
        XSSFCellStyle contentSyle = getContentStyle(workbook);
        
        //循环表头，设置样式
        for (int i = 0; i < herders.size(); i++) { 
        	
        	XSSFCell cell = row.createCell(i); 

            cell.setCellStyle(headerSytle); 
          
            HSSFRichTextString text = new HSSFRichTextString(herders.get(i).getName()); 

            cell.setCellValue(text); 

        }
        
        Iterator<T> it = ds.iterator();
        
        int idx = 2;
        
        String getMethod = "";
        
        //循环表体
        while(it.hasNext()){
        	idx++;
        	
        	row = sheet.createRow(idx);
        	
        	T t = it.next();
        	
        	Class tClass = t.getClass();
        	
        	String textValue = "";
        	
        	for (int i = 0; i < herders.size(); i++) {
        		
        		XSSFCell cell = row.createCell(i); 
        		
        		cell.setCellStyle(contentSyle); 
        		
        		getMethod = herders.get(i).getGetterMethod();
        		
        		//通过反射得到get方法
        		Method getter = tClass.getMethod(getMethod, null);
        		//通过反射执行get方法
        		Object value = getter.invoke(t, null);
        		
        		if(null == value) value="";
        		
        		
        		//处理日期类型值的显示方法
        		if(value instanceof Date){
        			Date date = (Date)value;
        			
        			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 

                    textValue = sdf.format(date); 
        		}else{
        			textValue = value.toString();
        		}
        		
        		
        		//处理数字类型值的显示方法
        		Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$"); 

                Matcher matcher = p.matcher(textValue); 
                
                if (!getter.getReturnType().getName().equals("java.lang.String") && matcher.matches()) { 

                    // 是数字当作double处理

                    cell.setCellValue(Double.parseDouble(textValue)); 

                } else { 

                    HSSFRichTextString richString = new HSSFRichTextString( 

                            textValue); 

                    XSSFFont font3 = workbook.createFont(); 

                    font3.setColor(HSSFColor.BLUE.index); 

                    richString.applyFont(font3); 

                    cell.setCellValue(richString); 

                } 
        	}
        }
        
        idx++;
        Iterator<String> oit = others.keySet().iterator();
        while(oit.hasNext()){
        	idx++;
        	String key = oit.next();
        	String value= others.get(key);
        	
        	row = sheet.createRow(idx);
        	XSSFCell keyCell = row.createCell(0); 
        	keyCell.setCellValue(key);
        	XSSFCell valueCell = row.createCell(1); 
        	valueCell.setCellValue(value);
        	
        }
        
        //向outputstream对象中输出
        workbook.write(out); 
        
	}
	
	//设置表头样式，可自定义
	public XSSFCellStyle getHeaderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle(); 

	        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index); 

	        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 

	        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); 

	        style.setBorderLeft(HSSFCellStyle.BORDER_THIN); 

	        style.setBorderRight(HSSFCellStyle.BORDER_THIN); 

	        style.setBorderTop(HSSFCellStyle.BORDER_THIN); 

	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 


	        

	        

	        style.setFont(font);
	        
			return style; 
	}
	
	
	public XSSFCellStyle getTitleStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle(); 

	       style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 

	       XSSFFont font = workbook.createFont(); 

	        font.setColor(HSSFColor.BLACK.index); 

	        font.setFontHeightInPoints((short) 16); 

	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 
	        
	        style.setFont(font);
	        
			return style; 
	}
	
	
	//设置表体样式，可自定义
	public XSSFCellStyle getContentStyle(XSSFWorkbook workbook){
		XSSFCellStyle style2 = workbook.createCellStyle(); 

        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index); 

        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 

        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN); 

        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN); 

        style2.setBorderRight(HSSFCellStyle.BORDER_THIN); 

        style2.setBorderTop(HSSFCellStyle.BORDER_THIN); 

        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER); 

        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 


        XSSFFont font2 = workbook.createFont(); 

        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL); 


        style2.setFont(font2);
        
		return style2; 
	}
	
	
}
