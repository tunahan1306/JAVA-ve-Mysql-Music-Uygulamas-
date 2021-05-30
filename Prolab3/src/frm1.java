import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class frm1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String kull="";
	String pro="";
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"ÞARKI NO","ÞARKI ADI","ÞARKICI","ÞARKI TUR","TARIH","ALBUM","SURE","DÝNLENME"};
	Object[] satirlar = new Object[8];
	private JTextField saradtext;
	private JTextField sarsantext;
	private JTextField saridtext;
	private JTextField aratext;
	private JTextField saralbumtext;
	private JTextField sarturtext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm1 frame = new frm1();
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
	public frm1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		
		table.setBounds(197, 291, 334, 180);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(24, 148, 651, 422);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Listele");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setForeground(new Color(148, 0, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(772, 517, 144, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u015EARKI L\u0130STES\u0130");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(24, 107, 651, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("YEN\u0130 \u015EARKI G\u0130R\u0130\u015E\u0130");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(772, 110, 176, 31);
		contentPane.add(lblNewLabel_1);
		
		saradtext = new JTextField();
		saradtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saradtext.setBounds(796, 224, 192, 31);
		contentPane.add(saradtext);
		saradtext.setColumns(10);
		
		sarsantext = new JTextField();
		sarsantext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sarsantext.setBounds(796, 285, 192, 31);
		contentPane.add(sarsantext);
		sarsantext.setColumns(10);
		
		JButton eklebuton = new JButton("EKLE");
		eklebuton.setBackground(new Color(255, 255, 0));
		eklebuton.setForeground(new Color(0, 128, 0));
		eklebuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// INSERT INTO ogrenci (ogr_no,ogr_ad,ogr_soyad,ogr_veli) VALUES (6,'Hasan','Harman','Hüseyin')

				String no,ad,sanatci,tur,ait,tarih,album,sure,dinlenme,sql_sorgu;
				Random rnd = new Random();
				no = saridtext.getText();
				ad = saradtext.getText();
				sanatci = sarsantext.getText();
				tur = sarturtext.getText();
				album = saridtext.getText();
				ait="0";
				tarih = "16-05-2021";
				sure = "3.34";
				dinlenme = Integer.toString(rnd.nextInt(10000));

				sql_sorgu = "INSERT INTO sarkilar (sar_id,sar_name,sar_tur,kime_ait,sar_sanatci,sar_tarih,album,sure,dinlenme) VALUES ("+
						no + ",'" + ad + "'," + "'" + tur + "'," + ait + ",'" + sanatci + "','" + tarih + "'," + album + "," + sure + "," + dinlenme + ")" ;

				//System.out.println(sql_sorgu);

				baglanti.ekle(sql_sorgu);

			}
		});
		eklebuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eklebuton.setBounds(685, 444, 85, 37);
		contentPane.add(eklebuton);
		
		JLabel lblNewLabel_2 = new JLabel("\u015EARKI ADI : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(659, 224, 127, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SANAT\u00C7I : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(642, 285, 144, 31);
		contentPane.add(lblNewLabel_3);
		
		saridtext = new JTextField();
		saridtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saridtext.setColumns(10);
		saridtext.setBounds(796, 169, 192, 31);
		contentPane.add(saridtext);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u015EARKI NO : ");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(659, 169, 127, 31);
		contentPane.add(lblNewLabel_2_1);
		
		JButton duzenlebuton = new JButton("D\u00DCZENLE");
		duzenlebuton.setBackground(new Color(255, 255, 0));
		duzenlebuton.setForeground(new Color(64, 224, 208));
		duzenlebuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String no,ad,sanatci,tur,ait,tarih,album,sure,dinlenme,sql_sorgu;
				Random rnd = new Random();
				no = saridtext.getText();
				ad = saradtext.getText();
				sanatci = sarsantext.getText();
				tur = sarturtext.getText();
				album = saridtext.getText();
				ait="0";
				tarih = "16-05-2021";
				sure = "3.34";
				dinlenme = Integer.toString(rnd.nextInt(10000));
				
				sql_sorgu = "UPDATE sarkilar SET sar_id="+no+","+
							"sar_name='"+ad+"',sar_tur='"+tur + "',"+ "album="+album+"," +"sar_sanatci='"+sanatci+ 
							"' WHERE sar_id="+no;
							
				//System.out.println(sql_sorgu);
				
				baglanti.update(sql_sorgu);
			}
		});
		duzenlebuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		duzenlebuton.setBounds(780, 444, 117, 37);
		contentPane.add(duzenlebuton);
		
		JButton silbuton = new JButton("S\u0130L");
		silbuton.setBackground(new Color(255, 255, 0));
		silbuton.setForeground(new Color(75, 0, 130));
		silbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no,sql_sorgu;

				no = saridtext.getText();
				
				//DELETE FROM ogrenci WHERE ogr_no=no
				
				sql_sorgu = "DELETE FROM sarkilar WHERE sar_id="+no;
				
				baglanti.sil(sql_sorgu);
				
			}
		});
		silbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		silbuton.setBounds(907, 444, 117, 37);
		contentPane.add(silbuton);
		
		JLabel kullabel = new JLabel(Login.ad);
		kullabel.setForeground(new Color(0, 255, 255));
		kullabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		kullabel.setHorizontalAlignment(SwingConstants.CENTER);
		kullabel.setBounds(24, 95, 79, 25);
		contentPane.add(kullabel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\admin1.png"));
		lblNewLabel_4.setBounds(24, 10, 75, 75);
		contentPane.add(lblNewLabel_4);
		
		aratext = new JTextField();
		aratext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aratext.setBounds(796, 22, 206, 33);
		contentPane.add(aratext);
		aratext.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NO","ÞARKI AD", "ÞARKI TÜR","SANATÇI","ALBUM"}));
		comboBox.setBounds(796, 65, 167, 35);
		contentPane.add(comboBox);
		
		JButton arabuton = new JButton("");
		arabuton.setIcon(new ImageIcon("D:\\Kodlamalar\\JAVA PROJECTS\\Deneme\\Music\\bul1.jpg"));
		arabuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				
				String sql_sorgu=null;
				
				String alan = aratext.getText();
				
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
		arabuton.setBounds(967, 65, 35, 35);
		contentPane.add(arabuton);
		
		JLabel lblNewLabel_2_2 = new JLabel("ALBUM : ");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(659, 397, 127, 31);
		contentPane.add(lblNewLabel_2_2);
		
		saralbumtext = new JTextField();
		saralbumtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saralbumtext.setColumns(10);
		saralbumtext.setBounds(796, 397, 192, 31);
		contentPane.add(saralbumtext);
		
		sarturtext = new JTextField();
		sarturtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sarturtext.setColumns(10);
		sarturtext.setBounds(796, 342, 192, 31);
		contentPane.add(sarturtext);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u015EARKI TUR : ");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(659, 342, 127, 31);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("ADM\u0130N EKRANI");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(138, 10, 642, 87);
		contentPane.add(lblNewLabel_5);
		
		
		
		modelim.setColumnIdentifiers(kolonlar);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				saridtext.setText(modelim.getValueAt(table.getSelectedRow(), 0).toString());
				saradtext.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				sarsantext.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				sarturtext.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
				saralbumtext.setText((String) modelim.getValueAt(table.getSelectedRow(), 5));
				
				
			}
		});
	}
}
