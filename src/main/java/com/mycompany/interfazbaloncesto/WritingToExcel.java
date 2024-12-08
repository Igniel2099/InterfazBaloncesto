/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author walth
 */
public class WritingToExcel {
    private String pathExcel;
    private String[] cabecera;

    public WritingToExcel() {
        this.pathExcel = "informe_excel.xlsx";
        this.cabecera = new String[] {"Nombre","TCA","T3A","TCI","TLI","Puntos","%FG","%eFG","%TS"};
    }

    public String getPathExcel() {
        return pathExcel;
    }

    public void setPathExcel(String pathExcel) {
        this.pathExcel = pathExcel;
    }

    public String[] getCabecera() {
        return cabecera;
    }

    public void setCabecera(String[] cabecera) {
        this.cabecera = cabecera;
    }
    
    public static void main(String[] args){
        WritingToExcel wte = new WritingToExcel();
        HashMap<String,String> hashMapDatos = new HashMap(){{
        put("Nombre","Lebron");
        put("TCA","78");
        put("T3A","3");
        put("TCI","180");
        put("TLI","4");
        put("Puntos","300");
        put("%FG","100");
        put("%eFG","120");
        put("%TS","100");
        }};
        
        try{
            
            // wte.crearCabeceraInforme();
            wte.clearSheet();
            //wte.escribirDatosInforme(hashMapDatos);
            
        } catch(IOException e){
            System.out.println("Error creando el archivo " + e.getMessage());
        }
    }
    
    public Sheet crearCabeceraInforme(Workbook libroExcel) throws IOException {

        
            Sheet hoja = libroExcel.getSheetAt(0);
            Row fila = hoja.createRow(0);
            
            for (int i = 0; i < getCabecera().length; i++ ){
                fila.createCell(i).setCellValue(getCabecera()[i]);
            }
            
            return hoja;
            
      
        
    }  
    
    public void escribirDatosInforme(HashMap<String,String> datos)throws IOException {
        
        try (Workbook libroExcel = new XSSFWorkbook(new FileInputStream(getPathExcel()))){
            Sheet hoja = libroExcel.getSheetAt(0);
            
            ArrayList<String> encabezados = new ArrayList();
            
            Row primeraFila = hoja.getRow(0); // Obtener la primera fila
            
            
            boolean escribible = false;
            
            if (primeraFila != null){
                
                escribible = true;
                
                
                for (Cell cell : primeraFila) {
                    
                    encabezados.add(cell.toString().trim()); // Agregar encabezados sin espacios extra
                }
                
                
                for (int i = 0; i < encabezados.size();i++){
                    if (!encabezados.get(i).equals(getCabecera()[i])){
                        escribible = false;
                        break;
                    }
                }
            }
            
            
            
            
            int newLastRowIndex = 0;
            if (!escribible){
                hoja = crearCabeceraInforme(libroExcel);
                encabezados = new ArrayList(Arrays.asList(getCabecera()));
                newLastRowIndex++;
            }
            
            int lastRowIndex = hoja.getLastRowNum();
            newLastRowIndex += lastRowIndex;
            
            
            
            Row nuevaFila = hoja.createRow(newLastRowIndex);
            
            
            for (int i = 0; i < encabezados.size();i++){
                String dato = datos.get(encabezados.get(i));
                if (!encabezados.get(i).equals("Nombre")){
                    if (datos.get(encabezados.get(i)).contains(",") ){
                        dato = dato.replace(',','.');
                    }

                    nuevaFila.createCell(i).setCellValue(Double.parseDouble(dato));
                    
                    
                }else{
                    nuevaFila.createCell(i).setCellValue(datos.get(encabezados.get(i)));
                }
            }
            
            writeAverages(libroExcel, newLastRowIndex + 1);
            
            try (FileOutputStream achivoSalida = new FileOutputStream(getPathExcel())){
                libroExcel.write(achivoSalida);
            }
            
            System.out.println("Datos escritos correctamente.");
            
        }
    }
    
    public void writeAverages(Workbook libroExcel, Integer rowAvgInt) throws IOException{
        
        
        HashMap<Integer,String> excelColumn = new HashMap<>(){{
          put(0,"A");
          put(1,"B");
          put(2,"C");
          put(3,"D");
          put(4,"E");
          put(5,"F");
          put(6,"G");
          put(7,"H");
          put(8,"I");
        }};
        
        Sheet sheet = libroExcel.getSheetAt(0);
        
        Row newRow = sheet.createRow(rowAvgInt);
        
        for (int i = 0; i < getCabecera().length; i++){
            if (i != 0){
                String excelColumnStart = excelColumn.get(i) + 2;
                String excelColumnFinal = excelColumn.get(i) + rowAvgInt;
                String formula = "AVERAGE(" + excelColumnStart + ":" + excelColumnFinal + ")";

                Cell formulaCell = newRow.createCell(i);
                formulaCell.setCellFormula(formula);

                FormulaEvaluator evaluator = libroExcel.getCreationHelper().createFormulaEvaluator();
                evaluator.evaluateFormulaCell(formulaCell);
            }else{
                newRow.createCell(i).setCellValue("promedios");
            }
        }
        
        
    }
    
    public void abrirExcel(){
        try {
            // Ruta al archivo de Excel
            File archivoExcel = new File(getPathExcel());

            // Comprobar si se puede abrir con la aplicación predeterminada
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (archivoExcel.exists()) {
                    desktop.open(archivoExcel);
                } else {
                    System.out.println("El archivo no existe.");
                }
            } else {
                System.out.println("La función no es soportada en este sistema.");
            }
        } catch (IOException e) {
            System.out.println("Error al intentar abrir el archivo: " + e.getMessage());
        }
    }
    
    
    public void clearSheet() throws IOException {
         try (FileInputStream fis = new FileInputStream(getPathExcel());
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Obtén la hoja que deseas borrar (por índice o nombre)
            Sheet hoja = workbook.getSheetAt(0); // Primera hoja (índice 0)

            // Borrar todas las filas de la hoja
            int numeroDeFilas = hoja.getLastRowNum();
            for (int i = numeroDeFilas; i >= 0; i--) {
                Row fila = hoja.getRow(i);
                if (fila != null) {
                    hoja.removeRow(fila); // Eliminar la fila
                }
            }

            // Sobrescribir el archivo original con los cambios
            try (FileOutputStream fos = new FileOutputStream(getPathExcel())) {
                workbook.write(fos);
                System.out.println("El contenido de la hoja ha sido borrado.");
            }

        }
    }
    
}
