package main;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.plaf.FileChooserUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import logicas.*;

public class MainWindow {

	private JFrame frmImagenes;
	
	DefaultCategoryDataset datos,datos2,datos3;
	JFreeChart graficaBarras,graficaBarras2,graficaBarras3;
	
	private int imgG1[] = new int[28];
	private int imgG2[] = new int[28];
	private int imgG3[] = new int[28];
		

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmImagenes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		datos = new DefaultCategoryDataset();
		datos2 = new DefaultCategoryDataset();
		graficaBarras = ChartFactory.createBarChart("Grices por promedio", 
				"colores", 
				"intensidad", 
				datos,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		
		graficaBarras2 = ChartFactory.createBarChart("Grices por MinMax", 
				"colores", 
				"intensidad", 
				datos2,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		
		graficaBarras3 = ChartFactory.createBarChart("Grices por ecuación", 
				"colores", 
				"intensidad", 
				datos3,
				PlotOrientation.HORIZONTAL,
				true,
				true,
				false);
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImagenes = new JFrame();
		frmImagenes.setTitle("imagenes");
		frmImagenes.setBounds(100, 100, 792, 418);
		frmImagenes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImagenes.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 203, 154);
		frmImagenes.getContentPane().add(scrollPane);

		JLabel label = new JLabel("");
		label.setIcon(null);
		scrollPane.setViewportView(label);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(292, 11, 203, 154);
		frmImagenes.getContentPane().add(scrollPane_1);

		JLabel label_1 = new JLabel("");
		scrollPane_1.setViewportView(label_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(531, 11, 203, 154);
		frmImagenes.getContentPane().add(scrollPane_2);

		JLabel label_2 = new JLabel("");
		scrollPane_2.setViewportView(label_2);
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(292, 178, 203, 191);
		frmImagenes.getContentPane().add(scrollPane_3);

		JLabel label_3 = new JLabel("");
		scrollPane_3.setViewportView(label_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(531, 176, 203, 191);
		frmImagenes.getContentPane().add(scrollPane_4);

		JLabel label_4 = new JLabel("");
		scrollPane_4.setViewportView(label_4);

		JButton btnSeleccionar = new JButton("Seleccionar...");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(null);
				File archivoImagen = fc.getSelectedFile();
				String ruta = archivoImagen.getPath();

				ImageIcon img = new ImageIcon(ruta);

				label.setIcon(img);
				
				
				for(int k =0;k<imgG2.length-1;k++) {
					imgG1[k]=0;
					imgG2[k]=0;
					imgG3[k]=0;
					
					
				}

				// gris:
				try {
					BufferedImage bf = ImageIO.read(archivoImagen);

					for (int x = 0; x < bf.getWidth(); x++) {
						for (int y = 0; y < bf.getHeight(); y++) {
							int rgb = bf.getRGB(x, y);
							Color color = new Color(rgb, true);
							int r = color.getRed();
							int g = color.getGreen();
							int b = color.getBlue();

							int grayLevel = (r + g + b) / 3;

							Color gris = new Color(grayLevel, grayLevel, grayLevel);
							bf.setRGB(x, y, gris.getRGB());
							
							if(grayLevel==229 && grayLevel==228 && grayLevel==226) imgG1[0]++;
		                    if(grayLevel==205 && grayLevel==205 && grayLevel==205) imgG1[1]++;
		                    if(grayLevel==215 && grayLevel==208 && grayLevel==183) imgG1[2]++;
		                    if(grayLevel==190 && grayLevel==190 && grayLevel==190) imgG1[3]++;
		                    if(grayLevel==180 && grayLevel==188 && grayLevel==192) imgG1[4]++;
		                    if(grayLevel==185 && grayLevel==184 && grayLevel==181) imgG1[5]++;
		                    if(grayLevel==145 && grayLevel==163 && grayLevel==176) imgG1[6]++;
		                    if(grayLevel==145 && grayLevel==163 && grayLevel==176) imgG1[7]++;
		                    if(grayLevel==150 && grayLevel==152 && grayLevel==154) imgG1[8]++;
		                    if(grayLevel==144 && grayLevel==144 && grayLevel==144) imgG1[9]++;
		                    if(grayLevel==155 && grayLevel==143 && grayLevel==121) imgG1[10]++;
		                    if(grayLevel==145 && grayLevel==136 && grayLevel==139) imgG1[11]++;
		                    if(grayLevel==139 && grayLevel==133 && grayLevel==137) imgG1[12]++;
		                    if(grayLevel==129 && grayLevel==135 && grayLevel==139) imgG1[13]++;
		                    if(grayLevel==132 && grayLevel==132 && grayLevel==130) imgG1[14]++;
		                    if(grayLevel==143 && grayLevel==129 && grayLevel==127) imgG1[15]++;
		                    if(grayLevel==115 && grayLevel==134 && grayLevel==120) imgG1[16]++;
		                    if(grayLevel==128 && grayLevel==128 && grayLevel==128) imgG1[17]++;
		                    if(grayLevel==135 && grayLevel==125 && grayLevel==96) imgG1[18]++;
		                    if(grayLevel==135 && grayLevel==121 && grayLevel==78) imgG1[19]++;
		                    if(grayLevel==83 && grayLevel==104 && grayLevel==120) imgG1[20]++;
		                    if(grayLevel==93 && grayLevel==103 && grayLevel==112) imgG1[21]++;
		                    if(grayLevel==102 && grayLevel==102 && grayLevel==102) imgG1[22]++;
		                    if(grayLevel==89 && grayLevel==100 && grayLevel==106) imgG1[23]++;
		                    if(grayLevel==73 && grayLevel==96 && grayLevel==99) imgG1[24]++;
		                    if(grayLevel==85 && grayLevel==85&& grayLevel==85) imgG1[25]++;
		                    if(grayLevel==52 && grayLevel==52 && grayLevel==52) imgG1[26]++;

						}
					}

					label_1.setIcon(new ImageIcon(bf));

					// negativo:

					BufferedImage bf2 = ImageIO.read(archivoImagen);

					for (int x = 0; x < bf2.getWidth(); x++) {
						for (int y = 0; y < bf2.getHeight(); y++) {
							int rgb = bf2.getRGB(x, y);
							Color color = new Color(rgb, true);
							int r = color.getRed();
							int g = color.getGreen();
							int b = color.getBlue();

							int resta = 255;

							Color negativo = new Color(resta - r, resta - g, resta - b);
							bf2.setRGB(x, y, negativo.getRGB());

						}
					}
					label_2.setIcon(new ImageIcon(bf2));

					// MIN MAX
					BufferedImage bf3 = ImageIO.read(archivoImagen);
					for (int x = 0; x < bf3.getWidth(); ++x) {
						for (int y = 0; y < bf3.getHeight(); ++y) {
							int rgb = bf3.getRGB(x, y);
							Color color = new Color(rgb, true);
							int r = color.getRed();
							int g = color.getGreen();
							int b = color.getBlue();

							int max = Math.max(Math.max((int) r, (int) g), (int) b);
							int min = Math.min(Math.min((int) r, (int) g), (int) b);

							int grayLevel = (max + min) / 2;

							Color grisMM = new Color(grayLevel, grayLevel, grayLevel);
							bf3.setRGB(x, y, grisMM.getRGB());
							
							if(grayLevel==229 && grayLevel==228 && grayLevel==226) imgG2[0]++;
		                    if(grayLevel==205 && grayLevel==205 && grayLevel==205) imgG2[1]++;
		                    if(grayLevel==215 && grayLevel==208 && grayLevel==183) imgG2[2]++;
		                    if(grayLevel==190 && grayLevel==190 && grayLevel==190) imgG2[3]++;
		                    if(grayLevel==180 && grayLevel==188 && grayLevel==192) imgG2[4]++;
		                    if(grayLevel==185 && grayLevel==184 && grayLevel==181) imgG2[5]++;
		                    if(grayLevel==145 && grayLevel==163 && grayLevel==176) imgG2[6]++;
		                    if(grayLevel==145 && grayLevel==163 && grayLevel==176) imgG2[7]++;
		                    if(grayLevel==150 && grayLevel==152 && grayLevel==154) imgG2[8]++;
		                    if(grayLevel==144 && grayLevel==144 && grayLevel==144) imgG2[9]++;
		                    if(grayLevel==155 && grayLevel==143 && grayLevel==121) imgG2[10]++;
		                    if(grayLevel==145 && grayLevel==136 && grayLevel==139) imgG2[11]++;
		                    if(grayLevel==139 && grayLevel==133 && grayLevel==137) imgG2[12]++;
		                    if(grayLevel==129 && grayLevel==135 && grayLevel==139) imgG2[13]++;
		                    if(grayLevel==132 && grayLevel==132 && grayLevel==130) imgG2[14]++;
		                    if(grayLevel==143 && grayLevel==129 && grayLevel==127) imgG2[15]++;
		                    if(grayLevel==115 && grayLevel==134 && grayLevel==120) imgG2[16]++;
		                    if(grayLevel==128 && grayLevel==128 && grayLevel==128) imgG2[17]++;
		                    if(grayLevel==135 && grayLevel==125 && grayLevel==96) imgG2[18]++;
		                    if(grayLevel==135 && grayLevel==121 && grayLevel==78) imgG2[19]++;
		                    if(grayLevel==83 && grayLevel==104 && grayLevel==120) imgG2[20]++;
		                    if(grayLevel==93 && grayLevel==103 && grayLevel==112) imgG2[21]++;
		                    if(grayLevel==102 && grayLevel==102 && grayLevel==102) imgG2[22]++;
		                    if(grayLevel==89 && grayLevel==100 && grayLevel==106) imgG2[23]++;
		                    if(grayLevel==73 && grayLevel==96 && grayLevel==99) imgG2[24]++;
		                    if(grayLevel==85 && grayLevel==85&& grayLevel==85) imgG2[25]++;
		                    if(grayLevel==52 && grayLevel==52 && grayLevel==52) imgG2[26]++;

						}
					}
					label_3.setIcon(new ImageIcon(bf3));

					BufferedImage bf4 = ImageIO.read(archivoImagen);
					int pixel = 0;
					for (int x = 0; x < bf4.getWidth(); ++x) {
						for (int y = 0; y < bf4.getHeight(); ++y) {
							int rgb = bf4.getRGB(x, y);
							Color color = new Color(rgb, true);
							int r = color.getRed();
							int g = color.getGreen();
							int b = color.getBlue();
							pixel++;
							int grayLevel = (int) ((0.299 * r) + (0.587 * g) + (0.114 * b));

							Color N = new Color(grayLevel, grayLevel, grayLevel);

							bf4.setRGB(x, y, N.getRGB());
							
							if(grayLevel==229 && grayLevel==228 && grayLevel==226) imgG3[0]++;
		                    if(grayLevel==205 && grayLevel==205 && grayLevel==205) imgG3[1]++;
		                    if(grayLevel==215 && grayLevel==208 && grayLevel==183) imgG3[2]++;
		                    if(grayLevel==190 && grayLevel==190 && grayLevel==190) imgG3[3]++;
		                    if(grayLevel==180 && grayLevel==188 && grayLevel==192) imgG3[4]++;
		                    if(grayLevel==185 && grayLevel==184 && grayLevel==181) imgG3[5]++;
		                    if(grayLevel==145 && grayLevel==163 && grayLevel==176) imgG3[6]++;
		                    if(grayLevel==145 && grayLevel==163 && grayLevel==176) imgG3[7]++;
		                    if(grayLevel==150 && grayLevel==152 && grayLevel==154) imgG3[8]++;
		                    if(grayLevel==144 && grayLevel==144 && grayLevel==144) imgG3[9]++;
		                    if(grayLevel==155 && grayLevel==143 && grayLevel==121) imgG3[10]++;
		                    if(grayLevel==145 && grayLevel==136 && grayLevel==139) imgG3[11]++;
		                    if(grayLevel==139 && grayLevel==133 && grayLevel==137) imgG3[12]++;
		                    if(grayLevel==129 && grayLevel==135 && grayLevel==139) imgG3[13]++;
		                    if(grayLevel==132 && grayLevel==132 && grayLevel==130) imgG3[14]++;
		                    if(grayLevel==143 && grayLevel==129 && grayLevel==127) imgG3[15]++;
		                    if(grayLevel==115 && grayLevel==134 && grayLevel==120) imgG3[16]++;
		                    if(grayLevel==128 && grayLevel==128 && grayLevel==128) imgG3[17]++;
		                    if(grayLevel==135 && grayLevel==125 && grayLevel==96) imgG3[18]++;
		                    if(grayLevel==135 && grayLevel==121 && grayLevel==78) imgG3[19]++;
		                    if(grayLevel==83 && grayLevel==104 && grayLevel==120) imgG3[20]++;
		                    if(grayLevel==93 && grayLevel==103 && grayLevel==112) imgG3[21]++;
		                    if(grayLevel==102 && grayLevel==102 && grayLevel==102) imgG3[22]++;
		                    if(grayLevel==89 && grayLevel==100 && grayLevel==106) imgG3[23]++;
		                    if(grayLevel==73 && grayLevel==96 && grayLevel==99) imgG3[24]++;
		                    if(grayLevel==85 && grayLevel==85&& grayLevel==85) imgG3[25]++;
		                    if(grayLevel==52 && grayLevel==52 && grayLevel==52) imgG3[26]++;

						}

					}

					label_4.setIcon(new ImageIcon(bf4));

					

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				
				//datos de la grafica
				
				for(int c =0;c<imgG3.length-1;c++) {
					int val=c+1;
					
					datos.addValue(imgG1[c], "Gris "+String.valueOf(val), "imagen 1");
					datos2.addValue(imgG2[c], "Gris "+String.valueOf(val), "imagen 2");
					datos3.addValue(imgG3[c], "Gris "+String.valueOf(val), "imagen 3");
					
				}
				
				
				
				
				
				//contenedor de la grafica 1
				
				ChartPanel pg = new ChartPanel(graficaBarras);
				JFrame vg = new JFrame("Grafica");
				vg.getContentPane().add(pg);
				vg.pack();
				vg.setVisible(true);
				
				//contenedor de la grafica 2
				
				ChartPanel pg2 = new ChartPanel(graficaBarras2);
				JFrame vg2 = new JFrame("Grafica");
				vg2.getContentPane().add(pg2);
				vg2.pack();
				vg2.setVisible(true);
				
				//contenedor de la grafica 3
				
				ChartPanel pg3 = new ChartPanel(graficaBarras3);
				JFrame vg3 = new JFrame("Grafica");
				vg3.getContentPane().add(pg3);
				vg3.pack();
				vg3.setVisible(true);
			}
		});
		btnSeleccionar.setBounds(59, 176, 110, 23);
		frmImagenes.getContentPane().add(btnSeleccionar);

	}

	/*
	 * public static BufferedImage imageToBufferedImage(Image im) { BufferedImage bi
	 * = new BufferedImage(im.getWidth(null), im.getHeight(null),
	 * BufferedImage.TYPE_INT_RGB); Graphics bg = bi.getGraphics(); bg.drawImage(im,
	 * 0, 0, null); bg.dispose(); return bi; }
	 */
}
