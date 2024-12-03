/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author walth
 */
public class WritingToExcel {
    public static void main(String[] args){
        try{
            crearCabeceraInforme("informe_excel.xlsx");
            
        }catch(IOException e){
            System.out.println("Error creando el archivo " + e.getMessage());
        }
    }
    
    
    private static void crearInformeExcel(String nombreArchivo) throws IOException {
        
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
    
    private static void crearCabeceraInforme(String nombreArchivo) throws IOException {

        try(Workbook libroExcel = new XSSFWorkbook();){
            Sheet hoja = libroExcel.createSheet("MiHoja");
            Row fila = hoja.createRow(0);
            String[] cabecera = {"Nombre","TCA","T3A","TCI","%FG","%eFG"};
            for (int i = 0; i < cabecera.length; i++ ){
                fila.createCell(i).setCellValue(cabecera[i]);
            }
            
            try(FileOutputStream archivo = new FileOutputStream(nombreArchivo)){
                libroExcel.write(archivo);
            }
            
        }
    }  
    
    private static void escribirDatosInforme(String nombreArchivo)throws IOException {
        // try (Workbook libroExcel = new XSSFWorkbook(new FileInputStream(nombreArchivo))){
            // Sheet hoja = 
        // }
    }
    
}
