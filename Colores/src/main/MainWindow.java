package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.plaf.FileChooserUI;
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

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private int azabache=0,pizarra=0,frio=0,campaña=0,plomo=0,payne=0,gris=0,platino=0,ceniza=0;
	private int lino=0,gris_medio=0,blanco_humo=0,aluminio=0,humo=0,elefante=0,acero=0,zinc=0,niquel=0,xanadu=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 203, 154);
		frame.getContentPane().add(scrollPane);

		JLabel label = new JLabel("");
		label.setIcon(null);
		scrollPane.setViewportView(label);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(292, 11, 203, 154);
		frame.getContentPane().add(scrollPane_1);

		JLabel label_1 = new JLabel("");
		scrollPane_1.setViewportView(label_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(531, 11, 203, 154);
		frame.getContentPane().add(scrollPane_2);

		JLabel label_2 = new JLabel("");
		scrollPane_2.setViewportView(label_2);
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(292, 178, 203, 191);
		frame.getContentPane().add(scrollPane_3);

		JLabel label_3 = new JLabel("");
		scrollPane_3.setViewportView(label_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(531, 176, 203, 191);
		frame.getContentPane().add(scrollPane_4);

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
							// int r = (rgb >> 16) & 0xFF;
							// int g = (rgb >> 8) & 0xFF;
							// int b = (rgb & 0xFF);

							int max = Math.max(Math.max((int) r, (int) g), (int) b);
							int min = Math.min(Math.min((int) r, (int) g), (int) b);

							int res = (max + min) / 2;

							// int grayLevel = (r + g + b) / 3;
							// int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;

							Color grisMM = new Color(res, res, res);
							bf3.setRGB(x, y, grisMM.getRGB());

						}
					}
					label_3.setIcon(new ImageIcon(bf3));

					BufferedImage bf4 = ImageIO.read(archivoImagen);
                      int pixel=0;
					for (int x = 0; x < bf4.getWidth(); ++x) {
						for (int y = 0; y < bf4.getHeight(); ++y) {
							int rgb = bf4.getRGB(x, y);
							Color color = new Color(rgb, true);
							int r = color.getRed();
							int g = color.getGreen();
							int b = color.getBlue();
                            pixel++;
							int nitidez = (int) ((0.299*r)+(0.587*g)+(0.114*b));
							
							Color N = new Color(nitidez,nitidez,nitidez);
							
							bf4.setRGB(x, y, N.getRGB());
							
							
							
						}

					}
					
					label_4.setIcon(new ImageIcon(bf4));
					
					
                        
						for (int x = 0; x < bf.getWidth(); x++) {
							for (int y = 0; y < bf.getHeight(); y++) {
								int rgb = bf.getRGB(x, y);
								Color color = new Color(rgb, true);
								int r = color.getRed();
								int g = color.getGreen();
								int b = color.getBlue();
                               if(r==52&&g==52&&b==52) {
                            	   azabache++;
                               }
                               else if(r==85&&g==85&&b==85) {
                            	   pizarra++;
                            	   
                            	   
                               }
                               else if(r==73&&g==96&&b==95) {
                            	   frio++;
                            	   
                            	   
                               }
                               else if(r==229&&g==228&&b==226) {
                            	   platino++;
                            	   
                            	   
                               }
                               else if(r==205&&g==205&&b==205) {
                            	   ceniza++;
                            	   
                            	   
                               }
                               else if(r==215&&g==208&&b==183) {
                            	   lino++;
                            	   
                            	   
                               }
                               else if(r==190&&g==190&&b==190) {
                            	   gris_medio++;
                            	   
                            	   
                               }
                               else if(r==180&&g==188&&b==192) {
                            	   humo++;
                            	   
                            	   
                               }
                               else if(r==185&&g==184&&b==181) {
                            	   aluminio++;
                            	   
                            	   
                               }
                               
                               else if(r==145&&g==136&&b==139) {
                            	   zinc++;
                            	   
                            	   
                               }
                               else if(r==139&&g==133&&b==137) {
                            	   acero++;
                            	   
                            	   
                               }
                               else if(r==143&&g==129&&b==127) {
                            	   niquel++;
                            	   
                            	   
                               }
                               else if(r==115&&g==134&&b==220) {
                            	   xanadu++;
                            	   
                            	   
                               }
                               
						
					
							
							}
						}	
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(azabache);
				System.out.println(pizarra);
				System.out.println(xanadu);
				System.out.println(zinc);
				System.out.println(platino);
				System.out.println(humo);
				System.out.println(niquel);
				System.out.println(ceniza);
				System.out.println(frio);

			}
		});
		btnSeleccionar.setBounds(59, 176, 110, 23);
		frame.getContentPane().add(btnSeleccionar);

	}

	public static BufferedImage imageToBufferedImage(Image im) {
		BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics bg = bi.getGraphics();
		bg.drawImage(im, 0, 0, null);
		bg.dispose();
		return bi;
	}
}
