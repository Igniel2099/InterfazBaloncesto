/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author walth
 */
public class GetDataExcel {
    private String pathExcelAngelsLakers;
    private String pathExcelGoldenStateWarriors;
    private String[] cabecera;
    

    public GetDataExcel() {
        this.pathExcelAngelsLakers = "informe_AngelsLakers.xlsx";
        this.pathExcelGoldenStateWarriors = "informe_GoldenStateWarriors.xlsx";
        this.cabecera = new String[] {"Equipo","Jugador","TCA","T3A","TCI","TLI","Puntos","%FG","%eFG","%TS","Valoration"};
    }

    public String getPathExcelAngelsLakers() {
        return pathExcelAngelsLakers;
    }

    public void setPathExcelAngelsLakers(String pathExcelAngelsLakers) {
        this.pathExcelAngelsLakers = pathExcelAngelsLakers;
    }

    public String getPathExcelGoldenStateWarriors() {
        return pathExcelGoldenStateWarriors;
    }

    public void setPathExcelGoldenStateWarriors(String pathExcelGoldenStateWarriors) {
        this.pathExcelGoldenStateWarriors = pathExcelGoldenStateWarriors;
    }

    public String[] getCabecera() {
        return cabecera;
    }

    public void setCabecera(String[] cabecera) {
        this.cabecera = cabecera;
    }
    
    
    public static void main(String[] args) {
        GetDataExcel gde = new GetDataExcel();
        List<Double> nums = gde.getData("Angels Lakers","Austin Reaves","Puntos");
        System.out.println(nums);
    }
    
    
    /**
     * Este método sirve para elegir el archivo del que voy a obtener sus datos.
     * @param teamName nombre del equipo.
     * @return me retorna el path del archivo excel del equipo o si el nombre del
     * equipo no coincide con ninguno que yo tenga registrado, devolvere un nulo.
     */
    public String choosePath(String teamName){
        if (teamName.equals("Angeles Lakers")){
            return getPathExcelAngelsLakers();
        }else if (teamName.equals("Golden State Warriors")){
            return getPathExcelGoldenStateWarriors();
        }
        return null;
    }
    
    /**
     * Este método se encarga de revisar si una hoja en especifico existe dentro
     * del archivo.
     * @param workbook
     * @param sheetName
     * @return me retorna un true si la hoja especifija existe, sino, un false
     * @throws IOException 
     */
    public boolean sheetsReview(Workbook workbook, String sheetName)throws IOException{

        return workbook.getSheet(sheetName) != null;
        
    }
    
    
    /**
     * Este método devuelve un Sheet si el sheetName existe, sino, me devuelve un
     * nulo.
     * @param workbook libro de excel
     * @param sheetName nombre de la hoja
     * @return
     * @throws IOException 
     */
    public Sheet headerReview(Workbook workbook,String sheetName) throws IOException {
        
        if (sheetsReview(workbook, sheetName)){
            return workbook.getSheet(sheetName);
        }
        return null;
    }
    
    /**
     * Este método se encarga de buscar el indice de una columna especifica
     * que si no encuentra devuelve un -1.
     * @param sheet
     * @param columnName
     * @return 
     */
    private int findColumnIndex(Sheet sheet, String columnName) {
        // Obtener la primera fila (cabecera)
        Row headerRow = sheet.getRow(0);

        if (headerRow != null) {
            for (Cell cell : headerRow) {
                if (cell.getCellType() == CellType.STRING) {
                    if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                        return cell.getColumnIndex();
                    }
                }
            }
        }
        return -1; // No encontrado
    }
    
    /**
     * Este método se encarga de obtener los valores de un columna en concreto 
     * @param teamName
     * @param sheetName
     * @param nameColumn
     * @return 
     */
    public List<Double> getData(String teamName, String sheetName, String nameColumn){
        List<Double> listValueMatches = new ArrayList<>();
        String excelPath = choosePath(teamName);
        if (excelPath != null){
            
            try (Workbook workbook = new XSSFWorkbook(new FileInputStream(excelPath))){
                
                Sheet sheet = headerReview(workbook, sheetName);
                if (sheet != null){
                    int indexColumn = findColumnIndex(sheet,nameColumn);
                    if (indexColumn != -1){
                        for (Row row : sheet) {
                            
                            if (row.getRowNum() == 0) {
                                continue;
                            }
                            
                            Cell cell = row.getCell(indexColumn);

                            // Evitar nulos
                            if (cell != null) {
                                
                                double value = cell.getNumericCellValue();
                                listValueMatches.add(value);
                                
                                
                            }
                        }
                        
                    }else{
                        System.out.println("No se ha encontrado la Columna.");
                    }
                    
                }else{
                    System.out.println("No se encontro la hoja " + sheetName);
                }
            }catch (IOException e){
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }else{
            System.out.println("No puedo acceder a un archivo de un equipo que no tengo registrado");
        }
        return listValueMatches;
    }
    
}
