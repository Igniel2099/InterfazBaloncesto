/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

/**
 *
 * @author walth
 */
import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.jfree.data.category.DefaultCategoryDataset;

public class DataInPdf {

    public void createPdf(String fileName, String teamName, String playerName,
                                  JFreeChart chart1, JFreeChart chart2,
                                  double fgMade, double fgPercent, double eFgPercent, double tsPercent) throws Exception {
        // Step 1: Create a Document
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        // Step 2: Add Team Title
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph(teamName, titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Step 3: Add Player Subtitle
        Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.ITALIC);
        Paragraph subtitle = new Paragraph(playerName, subtitleFont);
        subtitle.setAlignment(Element.ALIGN_CENTER);
        document.add(subtitle);

        document.add(Chunk.NEWLINE);

        // Step 4: Add Charts Side by Side
        PdfPTable chartTable = new PdfPTable(2);
        chartTable.setWidthPercentage(100);

        chartTable.addCell(createChartCell(chart1, writer));
        chartTable.addCell(createChartCell(chart2, writer));

        document.add(chartTable);

        // Step 5: Add Subtitle for Statistics
        Paragraph statsSubtitle = new Paragraph("Otras Estadísticas", subtitleFont);
        statsSubtitle.setAlignment(Element.ALIGN_CENTER);
        document.add(statsSubtitle);

        document.add(Chunk.NEWLINE);

        // Step 6: Add Statistics
        PdfPTable statsTable = new PdfPTable(2);
        statsTable.setWidthPercentage(50);
        statsTable.setHorizontalAlignment(Element.ALIGN_CENTER);

        statsTable.addCell("TCA:");
        statsTable.addCell(String.valueOf(fgMade));

        statsTable.addCell("% FG:");
        statsTable.addCell(String.valueOf(fgPercent));

        statsTable.addCell("% eFG:");
        statsTable.addCell(String.valueOf(eFgPercent));

        statsTable.addCell("% TS:");
        statsTable.addCell(String.valueOf(tsPercent));

        document.add(statsTable);

        // Close Document
        document.close();
    }

    public PdfPCell createChartCell(JFreeChart chart, PdfWriter writer) throws IOException, BadElementException {
        PdfContentByte contentByte = writer.getDirectContent();
        float width = 300;
        float height = 300;

        PdfTemplate template = contentByte.createTemplate(width, height);
        Graphics2D graphics2D = new PdfGraphics2D(template, width, height, null);

        // Dibuja el gráfico en el template
        chart.draw(graphics2D, new java.awt.geom.Rectangle2D.Double(0, 0, width, height));
        graphics2D.dispose();

        // Convierte el template en una imagen para el PDF
        com.itextpdf.text.Image chartImage = com.itextpdf.text.Image.getInstance(template);
        PdfPCell cell = new PdfPCell(chartImage);
        cell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER); // Usa la clase completa para evitar conflictos
        return cell;
    }

     public static void main(String[] args) {
        try {
            // Example charts (replace with actual charts in your implementation)
            DataInPdf dif = new DataInPdf();
            CombinedChartExample cce = new CombinedChartExample();
            CreateLineChart clc = new CreateLineChart();
            JFreeChart chart1 = cce.createCombinedChart("Puntos: Lebron", "puntos", new ArrayList(Arrays.asList(12.3, 34.3, 42.3)));
            DefaultCategoryDataset dataset = clc.createDataset(new ArrayList(Arrays.asList(23.34, 234.5, 34.4)));
            JFreeChart chart2 = clc.createLineChart(dataset, "Valoration", Color.yellow, Color.darkGray);
            
            // Output file
            String fileName = "equipo_estadisticas.pdf";

            // Generate PDF
            dif.createPdf(fileName, "Equipo Ejemplo", "Jugador Ejemplo", chart1, chart2, 25, 45.3, 50.2, 60.1);

            // Open the PDF file
            dif.openPdf(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openPdf(String fileName) {
        try {
            File pdfFile = new File(fileName);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Desktop no soportado. Abre el archivo manualmente.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

