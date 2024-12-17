/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

/**
 *
 * @author walth
 */

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Clase para crear gráficos de líneas utilizando JFreeChart.
 */
public class CreateLineChart {

    public static void main(String[] args) {
        // Llamamos al método para crear el gráfico de líneas
        CreateLineChart clc = new CreateLineChart();
        List<Double> listDoubles = new java.util.ArrayList<>(java.util.Arrays.asList(12.34, 34.34, 25.4, 234.4, 43.0));
        DefaultCategoryDataset dataset = clc.createDataset(listDoubles);

        // Creamos el gráfico de líneas con los datos
        JFreeChart chart = clc.createLineChart(dataset, "Gráfico de Líneas", Color.BLUE, Color.LIGHT_GRAY);

        // Guardamos el gráfico como una imagen PNG
        clc.saveChartAsPNG(chart, "C:\\Users\\walth\\Documents\\NetBeansProjects\\InterfazBaloncesto\\src\\main\\resources\\images\\lineas.png");
    }

    // Método para guardar el gráfico como PNG
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

    /**
     * Crea un dataset para un gráfico de líneas.
     *
     * @param pointsPerGame Una lista de los datos que quiero poner en el gráfico.
     * @return El dataset para el gráfico.
     */
    public DefaultCategoryDataset createDataset(List<Double> pointsPerGame) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < pointsPerGame.size(); i++) {
            String description = i + 1 + "º Game";
            dataset.addValue(pointsPerGame.get(i), "Puntos", description);
        }
        return dataset;
    }

    /**
     * Crea un gráfico de líneas a partir de un dataset proporcionado.
     *
     * @param dataset El dataset que contiene los valores para las líneas.
     * @param title El título del gráfico.
     * @param lineColor El color de las líneas.
     * @param backgroundColor El color de fondo del gráfico.
     * @return El gráfico de líneas generado.
     */
    public JFreeChart createLineChart(DefaultCategoryDataset dataset, String title, Color lineColor, Color backgroundColor) {
        // Crear el gráfico de líneas
        JFreeChart chart = ChartFactory.createLineChart(
                title,              // Título del gráfico
                "Categorías",       // Etiqueta del eje X
                "Valores",          // Etiqueta del eje Y
                dataset             // Dataset
        );

        // Configurar el plot del gráfico
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(backgroundColor); // Color de fondo del plot

        // Configurar las líneas
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();

        // Establecer el color para la línea
        renderer.setSeriesPaint(0, lineColor); // Color para la línea principal
        renderer.setSeriesShapesVisible(0, true); // Mostrar puntos en las intersecciones

        plot.setRenderer(renderer);

        // Quitar las líneas de la cuadrícula
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);

        return chart;
    }
}

