/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author walth
 */
public class CreateBarChart {

    public static void main(String[] args) {
        // Llamamos al método para crear el gráfico de barras
        CreateBarChart cbc = new CreateBarChart();
        List<Double> listDoubles = new java.util.ArrayList(java.util.Arrays.asList(12.34,34.34,25.4,234.4,43.0));
        DefaultCategoryDataset dataset = cbc.createDataset(listDoubles);

        // Creamos el gráfico de barras con los datos
        JFreeChart chart = cbc.createBarChart(dataset, "Gráfico de Barras", new Color(0xB21B1B), Color.GRAY);

        // Guardamos el gráfico como una imagen PNG
        cbc.saveChartAsPNG(chart, "C:\\Users\\walth\\Documents\\NetBeansProjects\\InterfazBaloncesto\\src\\main\\resources\\images\\barras.png");
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
     * Crea un dataset para un gráfico de barras.
     *
     * @param pointsPerGame una lista de los datos que quiero poner el sitio
     * @return El dataset para el gráfico.
     */
    public DefaultCategoryDataset createDataset(List<Double> pointsPerGame) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < pointsPerGame.size();i++){
            String description = i + 1 + "º Game";
            dataset.addValue(pointsPerGame.get(i),description,description);
        }
        return dataset;
    }

    /**
     * Crea un gráfico de barras a partir de un dataset proporcionado.
     *
     * @param dataset El dataset que contiene los valores para las barras.
     * @param title El título del gráfico.
     * @param barColor El color de las barras.
     * @param backgroundColor El color de fondo del gráfico.
     * @return El gráfico de barras generado.
     */
    public JFreeChart createBarChart(DefaultCategoryDataset dataset, String title, Color barColor, Color backgroundColor) {
        // Crear el gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                title,              // Título del gráfico
                "Categorías",       // Etiqueta del eje X
                "Valores",          // Etiqueta del eje Y
                dataset             // Dataset
        );

        // Configurar el plot del gráfico
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(backgroundColor); // Color de fondo del plot

        // Configurar las barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Establecer el color para todas las barras
        for (int i = 0; i < dataset.getRowCount(); i++) {
            renderer.setSeriesPaint(i, barColor); // Todas las barras tendrán el mismo color
        }

        // Quitar las líneas de la cuadrícula
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);

        return chart;
    }
}