package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public static List<Kisi> readFromExcel(String filePath) {
        
        List<Kisi> list = new ArrayList<Kisi>();


        try (FileInputStream inputStream = new FileInputStream(filePath)) {

            Workbook workbook = new XSSFWorkbook(inputStream);
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);

                int rows = sheet.getLastRowNum();
                int cols = sheet.getRow(1).getLastCellNum();

                for (int r = 1; r <= rows; r++) {
                    Row row = sheet.getRow(r);
                    int tempid = 0;
                    int tempint = 0;
                    String tempstr =null;
                    String tempisim = null, tempsoyisim = null, tempdogumTarihi = null, tempesi = null, tempanneAdi = null, tempbabaAdi = null, tempkanGrubu = null, tempmeslek = null, tempmedeniHal = null, tempkizlikSoyismi =" ", tempcinsiyet = null;
                    for (int c = 0; c < cols; c++) {
                        Cell cell = row.getCell(c);
                        if(cell == null) continue;
                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.print(cell.getStringCellValue());
                                tempstr = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                    System.out.print(dateFormat.format(cell.getDateCellValue()));
                                    tempstr = String.valueOf(dateFormat.format(cell.getDateCellValue()));

                                } else {
                                    System.out.print(cell.getNumericCellValue());
                                    tempint = (int) cell.getNumericCellValue();

                                }
                                break;
                            default:
                                System.out.print("null");
                                tempstr = "null";

                        }
                        if (c == 0) {
                            tempid = tempint;
                        }
                        if (c == 1) {
                            tempisim = tempstr;
                        }
                        if (c == 2) {
                            tempsoyisim = tempstr;
                        }
                        if (c == 3) {
                            tempdogumTarihi = tempstr;
                        }
                        if (c == 4) {
                            tempesi = tempstr;
                        }
                        if (c == 5) {
                            tempanneAdi = tempstr;
                        }
                        if (c == 6) {
                            tempbabaAdi = tempstr;
                        }
                        if (c == 7) {
                            tempkanGrubu = tempstr;
                        }
                        if (c == 8) {
                            tempmeslek = tempstr;
                        }
                        if (c == 9) {
                            tempmedeniHal = tempstr;
                        }
                        if (c == 10) {
                            tempkizlikSoyismi = tempstr;
                        }
                        if (c == 11) {
                            tempcinsiyet = tempstr;
                        }

                        System.out.print(" | ");
                    }
                    Kisi kisi = new Kisi(tempid, tempisim, tempsoyisim, tempdogumTarihi, tempesi, tempanneAdi, tempbabaAdi, tempkanGrubu, tempmeslek, tempmedeniHal, tempkizlikSoyismi, tempcinsiyet);

                    if(list.size()==0){
                        list.add(kisi);
                    }
                    else{
                        boolean flag = false;
                        for (Kisi value : list) {
                            if (value.getId() == kisi.getId()) {
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            list.add(kisi);
                        }
                    }
                    System.out.println();
                }
//                System.out.println(list);
//                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
