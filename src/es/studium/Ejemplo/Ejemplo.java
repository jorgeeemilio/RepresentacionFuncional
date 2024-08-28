package es.studium.Ejemplo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Ejemplo extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public Ejemplo(String title, double[] data) 
    {
        super(title);

        // Crear el dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.length; i++) {
            dataset.addValue(data[i], "Serie 1", String.valueOf(i));
        }

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createLineChart(
                "Gráfico de Líneas", // Título del gráfico
                "Índice", // Etiqueta del eje X
                "Valor", // Etiqueta del eje Y
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Orientación del gráfico
                true, // Incluir leyenda
                true, // Incluir tooltips
                false // Incluir URLs
        );

        // Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            double[] data = {5.0,8.41344746068543,9.77249868051821,9.986501019683699,9.999683287581668,9.999997133484282,9.999999990134123,9.999999999987201,9.999999999999993,10.0,9.999999999999993,9.999999999987201,9.999999990134123,9.999997133484282,9.999683287581668,9.986501019683699,9.77249868051821,8.41344746068543,5.0};
            Ejemplo example = new Ejemplo("Gráfico de Líneas", data);
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
