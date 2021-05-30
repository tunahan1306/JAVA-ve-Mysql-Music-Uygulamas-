import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.Frame;
import java.awt.Color;

public class frm2 extends JFrame {

	private JPanel contentPane;
	static int x = 0;
	String kull="";
	String pro="";
	private JTable table;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"ÞARKI NO","ÞARKI ADI","ÞARKICI","ÞARKI TUR","TARIH","ALBUM","SURE","DÝNLENME"};
	Object[] satirlar = new Object[8];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm2 frame = new frm2();
					
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setUndecorated(true);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm2() {
		setExtendedState(Frame.MAXIMIZED_HORIZ);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1310, 878);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\kullanici1.png"));
		lblNewLabel.setBounds(85, 10, 75, 75);
		contentPane.add(lblNewLabel);
		
		JLabel kullabel = new JLabel("");
		kullabel.setHorizontalAlignment(SwingConstants.CENTER);
		kullabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		kullabel.setBounds(10, 95, 219, 28);
		kullabel.setText(Login.ad);
		contentPane.add(kullabel);
		
		
		
		
		
		JLabel prolabel = new JLabel("");
		prolabel.setHorizontalAlignment(SwingConstants.CENTER);
		prolabel.setFont(new Font("Stencil", Font.PLAIN, 13));
		prolabel.setBounds(10, 133, 219, 37);
		prolabel.setText(Login.kull);
		contentPane.add(prolabel);
		
		JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(241, 176, 760, 463);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelim);
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(677, 295, 217, 197);
		scrollPane.setViewportView(table);
		
		JLabel sarisimlabel = new JLabel("");
		sarisimlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sarisimlabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sarisimlabel.setBounds(306, 683, 248, 45);
		contentPane.add(sarisimlabel);
		
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\next1.png"));
		btnNewButton_1.setBounds(597, 738, 35, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\back1.png"));
		btnNewButton_2.setBounds(508, 738, 35, 35);
		contentPane.add(btnNewButton_2);
		
		
		JLabel saridlabel = new JLabel("");
		saridlabel.setHorizontalAlignment(SwingConstants.CENTER);
		saridlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saridlabel.setBounds(241, 683, 70, 45);
		contentPane.add(saridlabel);
		//contentPane.add(table);
		
		JButton addbuton = new JButton("");
		addbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*//UPDATE sarkilar SET kime_ait = 2 WHERE sar_id = 1	
				String id = nolabel.getText();
				//SELECT kime_ait FROM sarkilar WHERE sar_id = 5
				
				String ait = "SELECT kime_ait FROM kullanicilar WHERE kullanici_ID ="+ id;
				System.out.print(ait);
				ResultSet myRs = baglanti.sorgula(ait);
				
				try {
					while(myRs.next()) {
						ait = "-" + myRs.getString("kime_ait") + "-";
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String sql_sorgu = "UPDATE kullanicilar SET kime_ait ='"+ ait +"-"  + Login.id + "-'"+ " WHERE kullanici_ID ="+ id;
				//baglanti.update(sql_sorgu);
				System.out.print(sql_sorgu);*/
				
				//UPDATE sarkilar SET kime_ait = 2 WHERE sar_id = 1	
				String id = saridlabel.getText();
				//SELECT kime_ait FROM sarkilar WHERE sar_id = 5
				
				String ait = "SELECT kime_ait FROM sarkilar WHERE sar_id ="+ id;
				ResultSet myRs = baglanti.sorgula(ait);
				
				try {
					while(myRs.next()) {
						ait = "-" + myRs.getString("kime_ait") + "-";
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String sql_sorgu = "UPDATE sarkilar SET kime_ait ='"+ ait +"-"  + Login.id + "-'"+ " WHERE sar_id ="+ id;
				baglanti.update(sql_sorgu);
				System.out.print(sql_sorgu);
			}
		});
		addbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\add1.png"));
		addbuton.setBounds(661, 738, 35, 35);
		contentPane.add(addbuton);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("OYNATMA L\u0130STELER\u0130M");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1001, 127, 298, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("KULLANICI EKRANI");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_2.setBounds(239, 10, 803, 75);
		contentPane.add(lblNewLabel_2);
		
		JLabel sarturlabel = new JLabel("");
		sarturlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sarturlabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sarturlabel.setBounds(690, 683, 121, 45);
		contentPane.add(sarturlabel);
		
		JLabel baslabel = new JLabel("");
		baslabel.setForeground(Color.MAGENTA);
		baslabel.setHorizontalAlignment(SwingConstants.CENTER);
		baslabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		baslabel.setBounds(239, 97, 685, 69);
		contentPane.add(baslabel);
		
		JLabel sanatcilabel = new JLabel("");
		sanatcilabel.setHorizontalAlignment(SwingConstants.CENTER);
		sanatcilabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sanatcilabel.setBounds(539, 683, 141, 45);
		contentPane.add(sanatcilabel);
		
		JLabel izlenmelabel = new JLabel("");
		izlenmelabel.setHorizontalAlignment(SwingConstants.CENTER);
		izlenmelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		izlenmelabel.setBounds(821, 683, 121, 45);
		contentPane.add(izlenmelabel);
		
		JLabel lblNewLabel_4 = new JLabel("TOP L\u0130STELER");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 246, 219, 55);
		contentPane.add(lblNewLabel_4);
		
		JButton toppop = new JButton("TOP 10 POP");
		toppop.setForeground(new Color(240, 128, 128));
		toppop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baslabel.setText("TOP 10 POP ÞARKI");
				modelim.setRowCount(0);
				//SELECT * FROM sarkilar WHERE sar_tur='caz' ORDER BY dinlenme DESC LIMIT 0,10;
				modelim.setRowCount(0);
				
				String sql_sorgu=null;
				
				String alan = "pop";
				
				ResultSet myRs = null;
				
				sql_sorgu = "SELECT * FROM sarkilar WHERE sar_tur='"+ alan +"' ORDER BY dinlenme DESC LIMIT 0,10;";
				
				//System.out.println(sql_sorgu);
				
				myRs = baglanti.sorgula(sql_sorgu);
				

				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				table.setModel(modelim);
				
				/*if(pro.equals(prolabel.getText().toString())) {
					sarisimlabel.setText("UZGUNUM PREMIUM UYE DEGÝLSÝNÝZ ...!;(");
				}else {
					sarisimlabel.setText("TEBRIKLER PREMIUM UYESÝNÝZ ...!:)");
					modelim.setRowCount(0);
					String sql_sorgu=null;
					int alan = Login.id;
					ResultSet myRs = null;
					sql_sorgu = "select * from sarkilar where kime_ait like '"+ alan +"%'";
					System.out.println(sql_sorgu);
					
					myRs = baglanti.sorgula(sql_sorgu);
					
					try {
						while(myRs.next()) {
							satirlar[0] = myRs.getString("sar_id");
							satirlar[1] = myRs.getString("sar_name");
							satirlar[2] = myRs.getString("sar_tur");					
							modelim.addRow(satirlar);
						}
					} catch (SQLException e1) {					
						e1.printStackTrace();
					}

					table.setModel(modelim);
				}*/
			}
		});
		toppop.setFont(new Font("Tahoma", Font.PLAIN, 24));
		toppop.setBounds(10, 297, 219, 111);
		contentPane.add(toppop);
		
		
		
		
		JButton topcaz = new JButton("TOP 10 CAZ");
		topcaz.setForeground(new Color(240, 128, 128));
		topcaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baslabel.setText("TOP 10 CAZ ÞARKI");
				
				modelim.setRowCount(0);
				//SELECT * FROM sarkilar WHERE sar_tur='caz' ORDER BY dinlenme DESC LIMIT 0,10;
				modelim.setRowCount(0);
				
				String sql_sorgu=null;
				
				String alan = "caz";
				
				ResultSet myRs = null;
				
				sql_sorgu = "SELECT * FROM sarkilar WHERE sar_tur='"+ alan +"' ORDER BY dinlenme DESC LIMIT 0,10;";
				
				//System.out.println(sql_sorgu);
				
				myRs = baglanti.sorgula(sql_sorgu);
				

				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		topcaz.setFont(new Font("Tahoma", Font.PLAIN, 24));
		topcaz.setBounds(10, 418, 219, 111);
		contentPane.add(topcaz);
		
		JButton topklasik = new JButton("TOP 10 KLAS\u0130K");
		topklasik.setForeground(new Color(240, 128, 128));
		topklasik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baslabel.setText("TOP 10 KLASÝK ÞARKI");
				modelim.setRowCount(0);
				//SELECT * FROM sarkilar WHERE sar_tur='caz' ORDER BY dinlenme DESC LIMIT 0,10;
				modelim.setRowCount(0);
				
				String sql_sorgu=null;
				
				String alan = "klasik";
				
				ResultSet myRs = null;
				
				sql_sorgu = "SELECT * FROM sarkilar WHERE sar_tur='"+ alan +"' ORDER BY dinlenme DESC LIMIT 0,10;";
				
				//System.out.println(sql_sorgu);
				
				myRs = baglanti.sorgula(sql_sorgu);
				

				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		topklasik.setFont(new Font("Tahoma", Font.PLAIN, 24));
		topklasik.setBounds(10, 539, 219, 138);
		contentPane.add(topklasik);
		JButton sarbuton = new JButton("TUM \u015EARKILAR");
		sarbuton.setBackground(Color.GREEN);
		sarbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baslabel.setText("TÜM ÞARKILAR");
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.yap();
				table.setModel(modelim);
				
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sarbuton.setFont(new Font("Tahoma", Font.BOLD, 16));
		sarbuton.setBounds(10, 176, 218, 60);
		contentPane.add(sarbuton);
		

		JButton cazbuton = new JButton("");
		cazbuton.setBackground(new Color(240, 230, 140));
		cazbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\jazz1.png"));
		cazbuton.setVerticalAlignment(SwingConstants.BOTTOM);
		cazbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				String sql_sorgu=null;
				
				String alan = "caz";
				//select * from sarkilar where sar_tur like 'caz%' and kime_ait = 1;
				ResultSet myRs = null;
				sql_sorgu = "select * from sarkilar where sar_tur like '" + alan +"%' and kime_ait like '%-" + Login.id +"-%'";
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cazbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cazbuton.setBounds(1032, 176, 207, 180);
		contentPane.add(cazbuton);
		
		JButton klasikbuton = new JButton("");
		klasikbuton.setBackground(new Color(240, 230, 140));
		klasikbuton.setHorizontalAlignment(SwingConstants.LEADING);
		klasikbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\klasik1.png"));
		klasikbuton.setVerticalAlignment(SwingConstants.BOTTOM);
		klasikbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelim.setRowCount(0);
				String sql_sorgu=null;
				
				String alan = "klasik";
				//select * from sarkilar where sar_tur like 'caz%' and kime_ait = 1;
				ResultSet myRs = null;
				sql_sorgu = "select * from sarkilar where sar_tur like '" + alan +"%' and kime_ait like '%-" + Login.id +"-%'";
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		klasikbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		klasikbuton.setBounds(1032, 365, 207, 180);
		contentPane.add(klasikbuton);
		
		JButton popbuton = new JButton("");
		popbuton.setBackground(new Color(240, 230, 140));
		popbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\pop1.png"));
		popbuton.setVerticalAlignment(SwingConstants.BOTTOM);
		popbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelim.setRowCount(0);
				String sql_sorgu=null;
				
				String alan = "pop";
				//select * from sarkilar where sar_tur like 'caz%' and kime_ait = 1;
				ResultSet myRs = null;
				sql_sorgu = "select * from sarkilar where sar_tur like '" + alan +"%' and kime_ait like '%-" + Login.id +"-%'";
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		popbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		popbuton.setBounds(1032, 555, 207, 180);
		contentPane.add(popbuton);
		
		JLabel lblNo = new JLabel("NO");
		lblNo.setForeground(Color.ORANGE);
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNo.setBounds(241, 641, 70, 45);
		contentPane.add(lblNo);
		
		JLabel lblarknnAd = new JLabel("\u015EARKININ ADI ");
		lblarknnAd.setForeground(Color.ORANGE);
		lblarknnAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblarknnAd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblarknnAd.setBounds(309, 641, 248, 45);
		contentPane.add(lblarknnAd);
		
		JLabel lblSanat = new JLabel("SANAT\u00C7I");
		lblSanat.setForeground(Color.ORANGE);
		lblSanat.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSanat.setBounds(552, 641, 141, 45);
		contentPane.add(lblSanat);
		
		JLabel lblarkTr = new JLabel("\u015EARKI T\u00DCR");
		lblarkTr.setForeground(Color.ORANGE);
		lblarkTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblarkTr.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblarkTr.setBounds(690, 641, 121, 45);
		contentPane.add(lblarkTr);
		
		JLabel lblDinlenmeSays = new JLabel("D\u0130NLENME SAYISI");
		lblDinlenmeSays.setForeground(Color.ORANGE);
		lblDinlenmeSays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinlenmeSays.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDinlenmeSays.setBounds(832, 641, 167, 45);
		contentPane.add(lblDinlenmeSays);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1051, 50, 203, 35);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NO","ÞARKI AD", "ÞARKI TÜR","SANATÇI","ALBUM"}));
		contentPane.add(comboBox);
		
		
		JTextPane bultext = new JTextPane();
		bultext.setBounds(1051, 10, 248, 28);
		contentPane.add(bultext);
		
		JButton bulbuton = new JButton("");
		bulbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				
				String sql_sorgu=null;
				
				String alan = bultext.getText();
				
				ResultSet myRs = null;
				
				int secilen = comboBox.getSelectedIndex();
				
				if(secilen == 0 ) {
					sql_sorgu = "select * from sarkilar where sar_id like '"+ alan +"%'";
				} else if(secilen == 1)
				{
					sql_sorgu = "select * from sarkilar where sar_name like '"+ alan +"%'";
				} else if(secilen == 2)
				{
					sql_sorgu = "select * from sarkilar where sar_tur like '"+ alan +"%'";
				} else if(secilen == 3)
				{
					sql_sorgu = "select * from sarkilar where sar_sanatci like '"+ alan +"%'";
				} else if(secilen == 4)
				{
					sql_sorgu = "select * from sarkilar where album like '"+ alan +"%'";
				} 
				
								
				//System.out.println(sql_sorgu);
				
				myRs = baglanti.sorgula(sql_sorgu);
				

				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("sar_id");
						satirlar[1] = myRs.getString("sar_name");
						satirlar[2] = myRs.getString("sar_sanatci");
						satirlar[3] = myRs.getString("sar_tur");
						satirlar[4] = myRs.getString("sar_tarih");
						satirlar[5] = myRs.getString("album");
						satirlar[6] = myRs.getString("sure");
						satirlar[7] = myRs.getString("dinlenme");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				table.setModel(modelim);
			}
		});
		bulbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\bul1.jpg"));
		bulbuton.setBounds(1264, 50, 35, 35);
		contentPane.add(bulbuton);
		
		JButton kulbuton = new JButton("KULAN\u0130C\u0130LAR");
		kulbuton.setBackground(Color.YELLOW);
		kulbuton.setForeground(Color.MAGENTA);
		kulbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm3 frame = new frm3();
				frame.setVisible(true);
			}
		});
		kulbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kulbuton.setBounds(10, 683, 219, 130);
		contentPane.add(kulbuton);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x==0) {
					btnNewButton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\pause1.jpg"));
					x=1;
					String id = saridlabel.getText();
					String izlenme = izlenmelabel.getText();
					int izlenme1 = Integer.parseInt(izlenme) + 1;
					String sql_sorgu = "UPDATE sarkilar SET dinlenme ="+ izlenme1 + " WHERE sar_id ="+ id;
					baglanti.ekle(sql_sorgu);
					System.out.print(sql_sorgu);	
					
				}else {
					btnNewButton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\play1.png"));
					x=0;
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\play1.png"));
		btnNewButton.setBounds(553, 738, 35, 35);
		contentPane.add(btnNewButton);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saridlabel.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
				sarisimlabel.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				sarturlabel.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
				sanatcilabel.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				izlenmelabel.setText((String) modelim.getValueAt(table.getSelectedRow(), 7));
				
			}
		});

	}
}
