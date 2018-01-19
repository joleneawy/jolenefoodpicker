package jolene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FoodPicker {

	public static void main(String[] args) {
		try {
			if(args.length==0){
				System.exit(0);
			}
			
			String filename = null;
			String type = null;
			
			if(args.length==2){
				filename = args[0];
				type = args[1];
			
				if(filename==null || filename.equalsIgnoreCase("") || type==null || type.equalsIgnoreCase("")){
					System.exit(0);
				}
				
				System.out.println("filename: "+filename);
				System.out.println("type: "+type);
			}

            FileInputStream excelFile = new FileInputStream(new File(filename));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            List<String> restaurantList10 = new ArrayList<String>();
            List<String> restaurantList20 = new ArrayList<String>();
            List<String> restaurantList30 = new ArrayList<String>();
            List<String> restaurantList40 = new ArrayList<String>();
            List<String> restaurantList50 = new ArrayList<String>();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                    if (!currentRow.getCell(0).getStringCellValue().equalsIgnoreCase("Restaurant") && !currentRow.getCell(0).getStringCellValue().equalsIgnoreCase("Type")) {
                        
                        if(currentRow.getCell(1).getStringCellValue().equalsIgnoreCase("10")){
                        	restaurantList10.add(currentRow.getCell(0).getStringCellValue());
                        }else if(currentRow.getCell(1).getStringCellValue().equalsIgnoreCase("20")){
                        	restaurantList20.add(currentRow.getCell(0).getStringCellValue());
                        }else if(currentRow.getCell(1).getStringCellValue().equalsIgnoreCase("30")){
                        	restaurantList30.add(currentRow.getCell(0).getStringCellValue());
                        }else if(currentRow.getCell(1).getStringCellValue().equalsIgnoreCase("40")){
                        	restaurantList40.add(currentRow.getCell(0).getStringCellValue());
                        }else if(currentRow.getCell(1).getStringCellValue().equalsIgnoreCase("50")){
                        	restaurantList50.add(currentRow.getCell(0).getStringCellValue());
                        }
                    } 
                }
            
            if(type.equalsIgnoreCase("10")){
            	String random = restaurantList10.get(new Random().nextInt(restaurantList10.size()));
            	System.out.println("Chosen for type 10: "+random);
            }else if(type.equalsIgnoreCase("20")){
            	String random = restaurantList20.get(new Random().nextInt(restaurantList20.size()));
            	System.out.println("Chosen for type 20: "+random);
            }else if(type.equalsIgnoreCase("30")){
            	String random = restaurantList30.get(new Random().nextInt(restaurantList30.size()));
            	System.out.println("Chosen for type 30: "+random);
            }else if(type.equalsIgnoreCase("40")){
            	String random = restaurantList40.get(new Random().nextInt(restaurantList40.size()));
            	System.out.println("Chosen for type 40: "+random);
            }else if(type.equalsIgnoreCase("50")){
            	String random = restaurantList50.get(new Random().nextInt(restaurantList50.size()));
            	System.out.println("Chosen for type 50: "+random);
            }

            System.out.println();
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
