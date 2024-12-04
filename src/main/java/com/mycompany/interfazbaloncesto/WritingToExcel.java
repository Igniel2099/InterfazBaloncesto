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
import java.util.HashMap;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author walth
 */
public class WritingToExcel {
    private String pathExcel;

    public WritingToExcel() {
        this.pathExcel = "informe_excel.xlsx";
    }

    public String getPathExcel() {
        return pathExcel;
    }

    public void setPathExcel(String pathExcel) {
        this.pathExcel = pathExcel;
    }
   
    public static void main(String[] args){
        WritingToExcel wte = new WritingToExcel();
        HashMap<String,String> hashMapDatos = new HashMap(){{
        put("Nombre","Lebron");
        put("TCA","3");
        put("T3A","3");
        put("TCI","3");
        put("%FG","100%");
        put("%eFG","120%");
        }};
        
        try{
            
            //wte.crearCabeceraInforme();
            wte.escribirDatosInforme(hashMapDatos);
            
        } catch(IOException e){
            System.out.println("Error creando el archivo " + e.getMessage());
        }
    }
    
    
    public void crearInformeExcel(String nombreArchivo) throws IOException {
        
        try (Workbook libroExcel = new XSSFWorkbook();){
            
            Sheet hoja = libroExcel.createSheet("MiHoja");
            Row fila = hoja.createRow(0);
            fila.createCell(0).setCellValue("Nombre");
            fila.createCell(1).setCellValue("Edad");
            fila.createCell(2).setCellValue("Ciudad");
            String[][] datos = { 
                    {"Juan", "25", "Madrid"},
                    {"María", "30", "Barcelona"},
                    {"Pedro", "28", "Sevilla"}
            };
            
            for (int i = 0; i < datos.length; i++) {
                fila = hoja.createRow(i + 1);
                for (int j = 0; j < datos[i].length; j++) {
                    fila.createCell(j).setCellValue(datos[i][j]);
                }
            }
            
            try (FileOutputStream archivo = new FileOutputStream(nombreArchivo)) {
                libroExcel.write(archivo);
            }
        }
    }
    
    public void crearCabeceraInforme() throws IOException {

        try(Workbook libroExcel = new XSSFWorkbook();){
            Sheet hoja = libroExcel.createSheet("MiHoja");
            Row fila = hoja.createRow(0);
            String[] cabecera = {"Nombre","TCA","T3A","TCI","%FG","%eFG"};
            for (int i = 0; i < cabecera.length; i++ ){
                fila.createCell(i).setCellValue(cabecera[i]);
            }
            
            try(FileOutputStream archivo = new FileOutputStream(getPathExcel())){
                libroExcel.write(archivo);
            }
            
        }
    }  
    
    public void escribirDatosInforme(HashMap<String,String> datos)throws IOException {
        
        try (Workbook libroExcel = new XSSFWorkbook(new FileInputStream(getPathExcel()))){
            Sheet hoja = libroExcel.getSheetAt(0);
            
            ArrayList<String> encabezados = new ArrayList();
            
            
            Row primeraFila = hoja.getRow(0); // Obtener la primera fila
            for (Cell cell : primeraFila) {
                encabezados.add(cell.toString().trim()); // Agregar encabezados sin espacios extra
            }
            
            for (String columna : encabezados){
                System.out.println(datos.get(columna));
            }
            
            
            int lastRowIndex = hoja.getLastRowNum();
            Row nuevaFila = hoja.createRow(lastRowIndex + 1);
            
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
            
            try (FileOutputStream achivoSalida = new FileOutputStream(getPathExcel())){
                libroExcel.write(achivoSalida);
            }
            
            System.out.println("Datos escritos correctamente.");
            
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
    
}
