/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

/**
 *
 * @author walth
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.axis.NumberAxis;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.jfree.chart.ChartUtils;

public class CombinedChartExample {

    public static void main(String[] args) {
        
    }
    
    public void saveChartAsPNG(JFreeChart chart, String filePath) {
        try {
            File file = new File(filePath);
            ChartUtils.saveChartAsPNG(file, chart, 800, 600); // Especifica el tamaño del gráfico
            System.out.println("Gráfico guardado como PNG en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar el gráfico.");
            e.printStackTrace();
        }
    }
    
    public JFreeChart createCombinedChart( String titleMain, String serieTitle, java.util.List<Double> data ) {

        // Dataset para las líneas
        DefaultCategoryDataset lineDataset = createLineDataset(data);

        // Dataset para las barras
        DefaultCategoryDataset barDataset = createBarDataset(data ,serieTitle);

        // Crear el gráfico combinado (líneas y barras)
        JFreeChart chart = ChartFactory.createBarChart(
                titleMain, 
                "Categorías", 
                serieTitle, 
                barDataset, 
                PlotOrientation.VERTICAL, 
                true, true, false);

        // Obtener el gráfico principal y configurarlo
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Añadir las líneas primero
        plot.setDataset(0, lineDataset);
        plot.mapDatasetToRangeAxis(0, 1); // Mapea el eje Y para las líneas
        LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();
        lineRenderer.setSeriesPaint(0, Color.BLUE); // Color azul para las líneas
        plot.setRenderer(0, lineRenderer);

        // Añadir las barras encima de las líneas
        plot.setDataset(1, barDataset);
        BarRenderer barRenderer = new BarRenderer();
        barRenderer.setSeriesPaint(0, Color.RED); // Color rojo para las barras
        plot.setRenderer(1, barRenderer);

        // Configurar el eje Y para las barras
        NumberAxis yAxis2 = new NumberAxis("Promedio Acumulado");
        plot.setRangeAxis(1, yAxis2);

        // Ajustar los márgenes del eje X para evitar solapamientos
        plot.getDomainAxis().setLowerMargin(0.05);
        plot.getDomainAxis().setUpperMargin(0.05);

        return chart;
    }

    public DefaultCategoryDataset createBarDataset(java.util.List<Double> datos, String serieTitle) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int num = 1; 
        for (Double dato : datos){
            dataset.addValue(dato, serieTitle, num + "ºpartido");
            num++;
             
         }
         
        return dataset;
    }

    public DefaultCategoryDataset createLineDataset(java.util.List<Double> datos) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
        Double sumatoria = 0.0; // Mover la sumatoria fuera del ciclo principal

        for (int i = 0; i < datos.size(); i++) {
            sumatoria += datos.get(i);  // Acumular el valor de datos.get(i)

            // Calcular el promedio acumulado
            Double numAvg = sumatoria / (i + 1);  // Promedio de todos los elementos hasta el índice i

            // Añadir al dataset
            System.out.println(numAvg);
            dataset.addValue(numAvg, "Promedio Acumulado", (i + 1) + "ºpartido" );
        }
        return dataset;
    }
}
