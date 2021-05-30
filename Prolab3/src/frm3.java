import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class frm3 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"KULLANICI NO","KULLANICI ADI"};
	Object[] satirlar = new Object[2];
	String kul_id ="";
	private JTable table_1;
	DefaultTableModel modelim1 = new DefaultTableModel();
	Object[] kolonlar1 = {"ÞARKI NO","ÞARKI ADI","ÞARKICI","ÞARKI TUR","TARIH","ALBUM","SURE","DÝNLENME"};
	Object[] satirlar1 = new Object[8];
	static int x=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm3 frame = new frm3();
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
	public frm3() {
		setExtendedState(Frame.MAXIMIZED_HORIZ);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0, 0, 1310, 878);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 166, 761, 224);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(modelim);
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(677, 295, 217, 197);
		scrollPane.setViewportView(table);
		
		JLabel adlabel = new JLabel("");
		adlabel.setBounds(647, 342, 70, 35);
		contentPane.add(adlabel);
		
		JLabel nolabel = new JLabel("");
		nolabel.setBounds(520, 342, 70, 35);
		contentPane.add(nolabel);
		
		JLabel lblNewLabel_2 = new JLabel("KULLANICI EKRANI");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_2.setBounds(222, 10, 803, 75);
		contentPane.add(lblNewLabel_2);
		
		JLabel sarlabel = new JLabel("\u015EARKILAR");
		sarlabel.setForeground(Color.BLUE);
		sarlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sarlabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		sarlabel.setBounds(248, 400, 761, 57);
		contentPane.add(sarlabel);
		
		JButton popbuton = new JButton("");
		popbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim1.setRowCount(0);
				sarlabel.setText(adlabel.getText() + " POP ÞARKILAR");
				String sql_sorgu=null;
				kul_id = nolabel.getText();
				String alan = "pop";
				//select * from sarkilar where sar_tur like 'caz%' and kime_ait = 1;
				ResultSet myRs = null;
				sql_sorgu = "select * from sarkilar where kime_ait like '%-"+ kul_id +"-%' and sar_tur = '" + alan + "'";
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						satirlar1[0] = myRs.getString("sar_id");
						satirlar1[1] = myRs.getString("sar_name");
						satirlar1[2] = myRs.getString("sar_sanatci");
						satirlar1[3] = myRs.getString("sar_tur");
						satirlar1[4] = myRs.getString("sar_tarih");
						satirlar1[5] = myRs.getString("album");
						satirlar1[6] = myRs.getString("sure");
						satirlar1[7] = myRs.getString("dinlenme");
						modelim1.addRow(satirlar1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		popbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\pop1.png"));
		popbuton.setVerticalAlignment(SwingConstants.BOTTOM);
		popbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		popbuton.setBackground(new Color(240, 230, 140));
		popbuton.setBounds(1029, 549, 207, 180);
		contentPane.add(popbuton);
		
		JButton klasikbuton = new JButton("");
		klasikbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim1.setRowCount(0);
				sarlabel.setText(adlabel.getText()+" KLASÝK ÞARKILAR");
				String sql_sorgu=null;
				kul_id = nolabel.getText();
				String alan = "klasik";
				//select * from sarkilar where sar_tur like 'caz%' and kime_ait = 1;
				ResultSet myRs = null;
				sql_sorgu = "select * from sarkilar where kime_ait like '%-"+ kul_id +"-%' and sar_tur = '" + alan + "'";
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						satirlar1[0] = myRs.getString("sar_id");
						satirlar1[1] = myRs.getString("sar_name");
						satirlar1[2] = myRs.getString("sar_sanatci");
						satirlar1[3] = myRs.getString("sar_tur");
						satirlar1[4] = myRs.getString("sar_tarih");
						satirlar1[5] = myRs.getString("album");
						satirlar1[6] = myRs.getString("sure");
						satirlar1[7] = myRs.getString("dinlenme");
						modelim1.addRow(satirlar1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		klasikbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\klasik1.png"));
		klasikbuton.setVerticalAlignment(SwingConstants.BOTTOM);
		klasikbuton.setHorizontalAlignment(SwingConstants.LEADING);
		klasikbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		klasikbuton.setBackground(new Color(240, 230, 140));
		klasikbuton.setBounds(1029, 359, 207, 180);
		contentPane.add(klasikbuton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("OYNATMA L\u0130STELER\u0130");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(998, 121, 298, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNo = new JLabel("NO");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setForeground(Color.ORANGE);
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNo.setBounds(253, 699, 70, 45);
		contentPane.add(lblNo);
		
		JLabel lblarknnAd = new JLabel("\u015EARKININ ADI ");
		lblarknnAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblarknnAd.setForeground(Color.ORANGE);
		lblarknnAd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblarknnAd.setBounds(321, 699, 248, 45);
		contentPane.add(lblarknnAd);
		
		JLabel lblSanat = new JLabel("SANAT\u00C7I");
		lblSanat.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanat.setForeground(Color.ORANGE);
		lblSanat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSanat.setBounds(564, 699, 141, 45);
		contentPane.add(lblSanat);
		
		JLabel lblarkTr = new JLabel("\u015EARKI T\u00DCR");
		lblarkTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblarkTr.setForeground(Color.ORANGE);
		lblarkTr.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblarkTr.setBounds(702, 699, 121, 45);
		contentPane.add(lblarkTr);
		
		JLabel lblDinlenmeSays = new JLabel("D\u0130NLENME SAYISI");
		lblDinlenmeSays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinlenmeSays.setForeground(Color.ORANGE);
		lblDinlenmeSays.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDinlenmeSays.setBounds(844, 699, 167, 45);
		contentPane.add(lblDinlenmeSays);
		
		JLabel izlenmelabel = new JLabel("");
		izlenmelabel.setHorizontalAlignment(SwingConstants.CENTER);
		izlenmelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		izlenmelabel.setBounds(833, 741, 121, 45);
		contentPane.add(izlenmelabel);
		
		JLabel sarturlabel = new JLabel("");
		sarturlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sarturlabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sarturlabel.setBounds(702, 741, 121, 45);
		contentPane.add(sarturlabel);
		
		JLabel sanatcilabel = new JLabel("");
		sanatcilabel.setHorizontalAlignment(SwingConstants.CENTER);
		sanatcilabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sanatcilabel.setBounds(551, 741, 141, 45);
		contentPane.add(sanatcilabel);
		
		JLabel sarisimlabel = new JLabel("");
		sarisimlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sarisimlabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sarisimlabel.setBounds(318, 741, 248, 45);
		contentPane.add(sarisimlabel);
		
		JLabel saridlabel = new JLabel("");
		saridlabel.setHorizontalAlignment(SwingConstants.CENTER);
		saridlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saridlabel.setBounds(253, 741, 70, 45);
		contentPane.add(saridlabel);
		
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
		btnNewButton.setBounds(565, 796, 35, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\next1.png"));
		btnNewButton_1.setBounds(609, 796, 35, 35);
		contentPane.add(btnNewButton_1);
		
		JButton addbuton = new JButton("");
		addbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\add1.png"));
		addbuton.setBounds(673, 796, 35, 35);
		contentPane.add(addbuton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\back1.png"));
		btnNewButton_2.setBounds(520, 796, 35, 35);
		contentPane.add(btnNewButton_2);

		
		
		JLabel kullanlabel = new JLabel("PREMIUM KULLANICILAR");
		kullanlabel.setHorizontalAlignment(SwingConstants.CENTER);
		kullanlabel.setForeground(Color.BLUE);
		kullanlabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		kullanlabel.setBounds(248, 100, 761, 57);
		contentPane.add(kullanlabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\admin1.png"));
		lblNewLabel_3.setBounds(85, 10, 75, 75);
		contentPane.add(lblNewLabel_3);
		
		JLabel kullabel = new JLabel((String) null);
		kullabel.setHorizontalAlignment(SwingConstants.CENTER);
		kullabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		kullabel.setBounds(10, 95, 219, 28);
		kullabel.setText(Login.ad);
		contentPane.add(kullabel);
		
		JLabel prolabel = new JLabel("NORMAL");
		prolabel.setHorizontalAlignment(SwingConstants.CENTER);
		prolabel.setFont(new Font("Stencil", Font.PLAIN, 13));
		prolabel.setBounds(10, 133, 219, 37);
		prolabel.setText(Login.kull);
		contentPane.add(prolabel);
		
		JButton toppop = new JButton("KULLANICILAR");
		toppop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				String sql_sorgu=null;
				ResultSet myRs = null;
				table.setModel(modelim);
				kullanlabel.setText("PREMIUM KULLANICILAR");
				sql_sorgu = "select * from kullanicilar where kullanici_pro like '"+ "1" +"%'";
				
				myRs = baglanti.sorgula(sql_sorgu);
				

				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("kullanici_ID");
						satirlar[1] = myRs.getString("kullanici_adi");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				table.setModel(modelim);
			}
		});
		toppop.setForeground(new Color(240, 128, 128));
		toppop.setFont(new Font("Tahoma", Font.PLAIN, 24));
		toppop.setBounds(10, 184, 219, 111);
		contentPane.add(toppop);
		
		JButton kullanicilarim = new JButton("KULLANICILARIM");
		kullanicilarim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				kullanlabel.setText("KULLANICILARIM");
				String sql_sorgu=null;
				ResultSet myRs = null;
				//select * from kullanicilar where kime_ait like '%-11-%'
				sql_sorgu = "select * from kullanicilar where kime_ait like '%-" + Login.id +"-%'";
				myRs = baglanti.sorgula(sql_sorgu);
				System.out.print(sql_sorgu);
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("kullanici_ID");
						satirlar[1] = myRs.getString("kullanici_adi");
						
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		kullanicilarim.setForeground(new Color(240, 128, 128));
		kullanicilarim.setFont(new Font("Tahoma", Font.PLAIN, 24));
		kullanicilarim.setBounds(10, 305, 219, 111);
		contentPane.add(kullanicilarim);
		
		JButton topklasik = new JButton("TAK\u0130P ET");
		topklasik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//UPDATE sarkilar SET kime_ait = 2 WHERE sar_id = 1	
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
				baglanti.update(sql_sorgu);
				System.out.print(sql_sorgu);
			}
		});
		topklasik.setForeground(new Color(240, 128, 128));
		topklasik.setFont(new Font("Tahoma", Font.PLAIN, 24));
		topklasik.setBounds(10, 426, 219, 138);
		contentPane.add(topklasik);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(245, 467, 767, 240);
		contentPane.add(scrollPane_1);
		
		
		
		JButton cazbuton = new JButton("");
		cazbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim1.setRowCount(0);
				sarlabel.setText(adlabel.getText() + " CAZ ÞARKILAR");
				String sql_sorgu=null;
				kul_id = nolabel.getText();
				String alan = "caz";
				//select * from sarkilar where kime_ait like '%-7-%' and sar_tur = 'pop'
				ResultSet myRs = null;
				sql_sorgu = "select * from sarkilar where kime_ait like '%-"+ kul_id +"-%' and sar_tur = '" + alan + "'";
				System.out.println(sql_sorgu);
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						satirlar1[0] = myRs.getString("sar_id");
						satirlar1[1] = myRs.getString("sar_name");
						satirlar1[2] = myRs.getString("sar_sanatci");
						satirlar1[3] = myRs.getString("sar_tur");
						satirlar1[4] = myRs.getString("sar_tarih");
						satirlar1[5] = myRs.getString("album");
						satirlar1[6] = myRs.getString("sure");
						satirlar1[7] = myRs.getString("dinlenme");
						modelim1.addRow(satirlar1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cazbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\jazz1.png"));
		cazbuton.setVerticalAlignment(SwingConstants.BOTTOM);
		cazbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cazbuton.setBackground(new Color(240, 230, 140));
		cazbuton.setBounds(1029, 170, 207, 180);
		contentPane.add(cazbuton);
		
		table_1 = new JTable();
		table_1.setBounds(49, 617, 75, 45);
		//contentPane.add(table_1);
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(modelim1);
		
		JTextPane bultext = new JTextPane();
		bultext.setBounds(1020, 20, 248, 28);
		contentPane.add(bultext);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1020, 60, 203, 35);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NO","KULLANICI ADI"}));
		contentPane.add(comboBox);
		
		JButton bulbuton = new JButton("");
		bulbuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\bul1.jpg"));
		bulbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
modelim.setRowCount(0);
				
				String sql_sorgu=null;
				
				String alan = bultext.getText();
				
				ResultSet myRs = null;
				
				int secilen = comboBox.getSelectedIndex();
				
				if(secilen == 0 ) {
					sql_sorgu = "select * from kullanicilar where kullanici_ID like '"+ alan +"%'";
				} else if(secilen == 1)
				{
					sql_sorgu = "select * from kullanicilar where kullanici_adi like '"+ alan +"%'";
				} 
								
				//System.out.println(sql_sorgu);
				
				myRs = baglanti.sorgula(sql_sorgu);
				

				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("kullanici_ID");
						satirlar[1] = myRs.getString("kullanici_adi");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				table.setModel(modelim);
			}
		});
		bulbuton.setBounds(1233, 60, 35, 35);
		contentPane.add(bulbuton);
		
		
		modelim1.setColumnIdentifiers(kolonlar1);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nolabel.setText(modelim.getValueAt(table.getSelectedRow(), 0).toString());
				adlabel.setText(modelim.getValueAt(table.getSelectedRow(), 1).toString());
			}
		});
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saridlabel.setText((String) modelim1.getValueAt(table_1.getSelectedRow(), 0));
				sarisimlabel.setText((String) modelim1.getValueAt(table_1.getSelectedRow(), 1));
				sarturlabel.setText((String) modelim1.getValueAt(table_1.getSelectedRow(), 3));
				sanatcilabel.setText((String) modelim1.getValueAt(table_1.getSelectedRow(), 2));
				izlenmelabel.setText((String) modelim1.getValueAt(table_1.getSelectedRow(), 7));
			}
		});
	}
}
