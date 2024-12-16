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
import java.util.List;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author walth
 */
public class WritingToExcel {
    private String pathExcelAngelsLakers;
    private String pathExcelGoldenStateWarriors;
    private String[] cabecera;
    

    public WritingToExcel() {
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
    
    public static void main(String[] args){
        
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
        
        WritingToExcel wte = new WritingToExcel();
        //try{
            
            // wte.crearCabeceraInforme();
            // wte.clearSheet();
            //wte.escribirDatosInforme(hashMapDatos);
            
        //} catch(IOException e){
          //  System.out.println("Error creando el archivo " + e.getMessage());
        //}
    }
    
    public Sheet crearCabeceraInforme(Workbook libroExcel, int indexSheet) throws IOException {
        
        Sheet hoja = libroExcel.getSheetAt(indexSheet);
        Row fila = hoja.createRow(0);

        for (int i = 2; i < getCabecera().length; i++ ){
            fila.createCell(i-2).setCellValue(getCabecera()[i]);
        }

        return hoja;
        
    }
    
    /**
     * Este método se encarga de revisar si una hoja en especifico existe dentro
     * del archivo.
     * @param workbook
     * @param nameSheet
     * @return me retorna un true si la hoja especifija existe, sino, un false
     * @throws IOException 
     */
    public boolean sheetsReview(Workbook workbook, String nameSheet)throws IOException{

        return workbook.getSheet(nameSheet) != null;
    }
    
    /**
     * Este metodo se encarga de revisar si una hoja especifica del archivo tiene 
     * contenido o no.
     * @param workbook
     * @param nameSheet
     * @return me retorna un true si tiene contenido, sino, un false
     * @throws IOException 
     */
    public boolean headerReview(Workbook workbook,String nameSheet) throws IOException {
        
        for (int i = 0; i < workbook.getNumberOfSheets(); i++){
            if (workbook.getSheetName(i).equals(nameSheet)){
                return workbook.getSheetAt(i).getRow(0) != null;
            }
        }
        return false;
    }
    
    /**
     * Este método sirve para crear una hoja si esta no existe
     * @param workbook
     * @param existsSheet
     * @param nameSheet
     * @return me devuelve el indice de la hoja
     * @throws IOException 
     */
    public int getSheetIndex(Workbook workbook,boolean existsSheet, String nameSheet) throws IOException {
            
        if (!existsSheet){
            workbook.createSheet(nameSheet);
        }
        return workbook.getSheetIndex(nameSheet);

    }
    
    /**
     * Me revisa si la cabecera del excel coincide con mi cabecera.
     * @param workbook 
     * @param indexSheet
     * @return me devuelve un true si todos los valores coinciden, sino, me 
     * devuelve un false.
     */
    public boolean headerContentReview(Workbook workbook, int indexSheet){
        Row firstRow = workbook.getSheetAt(indexSheet).getRow(0); // primera fila
        for (int i = 0; i < firstRow.getPhysicalNumberOfCells();i++) {
            if (!firstRow.getCell(i).toString().equals(getCabecera()[i])){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Este método obtiene la ultima linea escrita, si writable es false, quiere 
     * decir que no existe ningun dato por lo que escribe la cabecera.
     * @param workbook
     * @param writable booleano que sabe si el archivo tiene escrito la cabecera
     *                 o no.
     * @param indexSheet este es el indice de la hoja en la que vamos a tratar.
     * @return me retorna el indice de la ultima linea escrita.
     * @throws IOException 
     */
    public int getHeaderIndex(Workbook workbook, boolean writable, int indexSheet)throws IOException {
        
        Sheet sheet = workbook.getSheetAt(indexSheet);

        if (!writable || !headerContentReview(workbook,indexSheet)){
            sheet = crearCabeceraInforme(workbook,indexSheet);
        }

        return sheet.getLastRowNum();
       
    }
    
    
    /**
     * Este método me inserta en las celdas de cada columna una funcion del
     * propio excel calculando las medias de las datos que voy insertando.
     * Utilizo un mapa dinamico que me ayuda a saber en que columna estoy y como
     * se denomina en Excel.
     * @param libroExcel el libro en cuestión al que le quiero añadir los promedios
     * @param rowAvgInt la ultima linea en al que tengo que poner los promedios
     * @param indexSheet
     * @throws IOException 
     */
    public void writeAverages(Workbook libroExcel, Integer rowAvgInt, int indexSheet) throws IOException{
        
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
          put(9,"J");
          put(10,"K");
        }};
        
        Sheet sheet = libroExcel.getSheetAt(indexSheet);
        
        Row newRow = sheet.createRow(rowAvgInt);
        
        /**
         * Esto lo hago para no tener numeros magicos, porque, los campos, Equipo
         * y Jugador ya no los tengo que meter dentro del excel pero si
         * necesito esa información, y prefiero no eliminar de los datos principales
        */
        List<String> newListHeader = new ArrayList<>(Arrays.asList(getCabecera()));
        newListHeader.removeFirst();
        newListHeader.removeFirst();
        
        
        for (int i = 0; i <= newListHeader.size(); i++){
            if (i != newListHeader.size()){
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
    
    public List<String> getColumnsAvg(Workbook libroExcel, Integer rowAvgInt, int indexSheet, String namePlayer){
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
          put(9,"J");
          put(10,"K");
        }};
        
        /**
         * Esto lo hago para no tener numeros magicos, porque, los campos, Equipo
         * y Jugador ya no los tengo que meter dentro del excel pero si
         * necesito esa información, y prefiero no eliminar de los datos principales
        */
        List<String> newListHeader = new ArrayList<>(Arrays.asList(getCabecera()));
        newListHeader.removeFirst();
        newListHeader.removeFirst();
        
        List<String> formulasAvg = new ArrayList<>();
        for (int i = 0; i < newListHeader.size(); i++){
            String excelColumnFinal = excelColumn.get(i) + (rowAvgInt + 1);
            
            String formula = "'"  + namePlayer + "'!" + excelColumnFinal;
            formulasAvg.add(formula);
        }
        System.out.println(formulasAvg);
        return formulasAvg;
    }
    
    
    public void writeAvgAllPlayers(Workbook libroExcel, String namePlayer, List<String> formulasAvg){
        
        /**
         * Esto lo hago para no tener numeros magicos, porque, los campos, Equipo
         * y Jugador ya no los tengo que meter dentro del excel pero si
         * necesito esa información, y prefiero no eliminar de los datos principales
        */
        
        List<String> newListHeader = new ArrayList<>(Arrays.asList(getCabecera()));
        newListHeader.removeFirst();
        newListHeader.removeFirst();
        
        
        
        Sheet sheet = libroExcel.getSheet("final");
        System.out.println("Nombre jugador writeAvgAll: " + namePlayer);
        int indexTargetRow = -1;
        for (int i = 0; i <= sheet.getLastRowNum();i++){
            System.out.println("Comparación jugador writeAvgAll: " + sheet.getRow(i).getCell(0).toString());
            if (sheet.getRow(i).getCell(0).toString().equals(namePlayer)){
                indexTargetRow = i;
                break;
            }
        } 
        
        if (indexTargetRow != -1) {
            System.out.println("Ha encontrado al jugador");
            Row targetRow = sheet.getRow(indexTargetRow);

            // Sobrescribir celdas de la fila con nuevos valores
            for (int j = 0; j <= newListHeader.size(); j++) { // getCabecera() te da el tamaño de las columnas
                Cell cell = targetRow.getCell(j); // Obtiene la celda
                if (cell == null) {
                    cell = targetRow.createCell(j); // Crea la celda si no existe
                }

                // Establece un nuevo valor en la celda
                if (j == 0) {
                    cell.setCellValue(namePlayer); // Columna 0: Nombre del jugador
                } else {
                    
                    cell.setCellFormula(formulasAvg.get(j-1));
                    
                    FormulaEvaluator evaluator = libroExcel.getCreationHelper().createFormulaEvaluator();
                    evaluator.evaluateFormulaCell(cell); // le he hecho caso al chat.
                }
            }
        }
        
        
        
        
    }
    
    
    public void escribirDatosInforme(String pathExcel, HashMap<String,String> datos)throws IOException {
        
        try (Workbook libroExcel = new XSSFWorkbook(new FileInputStream(pathExcel))){
            String nameSheet = datos.get("Jugador");
            boolean existsSheet = sheetsReview(libroExcel, nameSheet);
            int indexSheet = getSheetIndex(libroExcel, existsSheet, nameSheet);
            boolean writable = headerReview(libroExcel, nameSheet);
            int lastIndexRow = getHeaderIndex(libroExcel, writable, indexSheet);
            
            Sheet hoja = libroExcel.getSheetAt(indexSheet);
            
            if (writable){
                lastIndexRow--;
            }
            Row nuevaFila = hoja.createRow(lastIndexRow + 1);
            
            
            /**
             * Esto lo hago para no tener numeros magicos, porque, los campos, Equipo
             * y Jugador ya no los tengo que meter dentro del excel pero si
             * necesito esa información, y prefiero no eliminar los datos principales
             */
            List<String> newListHeader = new ArrayList<>(Arrays.asList(getCabecera()));
            newListHeader.removeFirst();
            newListHeader.removeFirst();
            HashMap<String,String> newData = new HashMap<>(datos);
            newData.remove("Equipo");
            newData.remove("Jugador");
            
            for (int i = 0; i < newListHeader.size();i++){
                
                String dato = datos.get(newListHeader.get(i));
                
                if (dato.contains(",") ){
                    
                    dato = dato.replace(',','.');
                }
                nuevaFila.createCell(i).setCellValue(Double.parseDouble(dato));
            }
            
            
            writeAverages(libroExcel, lastIndexRow + 2, indexSheet);
            List<String> formulasAvg = getColumnsAvg(libroExcel, lastIndexRow + 2, indexSheet, datos.get("Jugador"));
            writeAvgAllPlayers(libroExcel, datos.get("Jugador"), formulasAvg);
            
            try (FileOutputStream achivoSalida = new FileOutputStream(pathExcel)){
                libroExcel.write(achivoSalida);
            }
            
            System.out.println("Datos escritos correctamente.");
            
        }
    }
    
    
    
    
    /**
     * Este método lo que hace es abrir un excel dependiendo de la cantidad de
     * equipos que tenga, primero verifica si la cantidad de equipos posibles
     * son dos (para controlar lo que pasa si añado a mas equipos), una vez
     * compruebe eso, dependiendo de que equipo sea 
     * @param pathExcel
     */
    public void abrirExcel(String pathExcel){
        try {
            
            File archivoExcel = new File(pathExcel);

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
    
    /**
     * Este método me elige el path del archivo del excel dependiendo de que equipo
     * sea, primero me comprueba si son dos equipos, porque si son más necesito
     * otra logica.
     * @param cantidadEquipos la cantidad de equipos que tengo
     * @param datos
     * @return me retornan el path del archivo que debo modificar o un null
     */
    public String selectionPathExcel( String[] cantidadEquipos, HashMap<String,String> datos ){
        String pathExcel = "";
        if (cantidadEquipos.length == 2){
           pathExcel = datos.get("Equipo").equals("Angeles Lakers") 
                ? getPathExcelAngelsLakers() 
                : datos.get("Equipo").equals("Golden State Warriors") 
                ? getPathExcelGoldenStateWarriors()
                : null ;
        }
        // condición ? valor_si_true : valor_si_false;
        return pathExcel;
    }
    
    
    /**
     * Me limpia el archivo del excel
     * @param pathExcel el enlace del archivo que quiero modificar
     * @throws IOException 
     */
    public void clearSheet(String pathExcel) throws IOException {
         try (FileInputStream fis = new FileInputStream(pathExcel);
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
            try (FileOutputStream fos = new FileOutputStream(pathExcel)) {
                workbook.write(fos);
                System.out.println("El contenido de la hoja ha sido borrado.");
            }

        }
    }
    
}
