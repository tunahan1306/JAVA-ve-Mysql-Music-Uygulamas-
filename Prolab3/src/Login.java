import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField adminadtext;
	private JTextField adminsiftext;
	private JTextField kuladtext;
	private JTextField kulsifretext;
	static String ad;
	static int id;
	static String sifre;
	static String kull="NORMAL";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		adminadtext = new JTextField();
		adminadtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adminadtext.setBounds(208, 174, 181, 34);
		contentPane.add(adminadtext);
		adminadtext.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ADM\u0130N G\u0130R\u0130\u015E\u0130");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(21, 116, 341, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblifre = new JLabel("\u015Eifre :  ");
		lblifre.setForeground(new Color(199, 21, 133));
		lblifre.setBackground(Color.YELLOW);
		lblifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblifre.setBounds(21, 222, 163, 34);
		contentPane.add(lblifre);
		
		adminsiftext = new JTextField();
		adminsiftext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adminsiftext.setColumns(10);
		adminsiftext.setBounds(208, 222, 181, 34);
		contentPane.add(adminsiftext);
		
		JLabel adlabel = new JLabel("");
		adlabel.setBounds(287, 377, 318, 67);
		contentPane.add(adlabel);
		
		JButton adminbuton = new JButton("G\u0130R\u0130\u015E");
		adminbuton.setBackground(Color.PINK);
		adminbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = adminadtext.getText();
				sifre = adminsiftext.getText();
				
				String sql_sorgu = "select count(admin_id) as giris from admin where admin_ad='"+ad+
						"' and admin_sifre='"+sifre+"'";
				
				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()){
						if(myRs.getInt("giris")==1) {
							frm1 frame = new frm1();
							frame.setVisible(true);
							setVisible(false);
						} else { adlabel.setText("hatalý giriþ"); }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		adminbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adminbuton.setBounds(246, 283, 106, 34);
		contentPane.add(adminbuton);
		
		JLabel lblNewLabel_1_1 = new JLabel("KULLANICI G\u0130R\u0130\u015E\u0130");
		lblNewLabel_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1.setBackground(Color.RED);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(463, 117, 341, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kullanici ADI :  ");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBackground(Color.CYAN);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(463, 175, 163, 34);
		contentPane.add(lblNewLabel_2);
		
		kuladtext = new JTextField();
		kuladtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kuladtext.setColumns(10);
		kuladtext.setBounds(650, 175, 181, 34);
		contentPane.add(kuladtext);
		
		kulsifretext = new JTextField();
		kulsifretext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kulsifretext.setColumns(10);
		kulsifretext.setBounds(650, 223, 181, 34);
		contentPane.add(kulsifretext);
		
		JLabel lblifre_1 = new JLabel("\u015Eifre :  ");
		lblifre_1.setForeground(new Color(0, 0, 255));
		lblifre_1.setBackground(Color.CYAN);
		lblifre_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifre_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblifre_1.setBounds(463, 223, 163, 34);
		contentPane.add(lblifre_1);
		
		JButton kulbuton = new JButton("G\u0130R\u0130\u015E");
		kulbuton.setBackground(Color.MAGENTA);
		kulbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = kuladtext.getText();
				sifre = kulsifretext.getText();
				
				String sql_sorgu = "select count(kullanici_ID) as giris from kullanicilar where kullanici_NAME='"+ad+
						"' and kullanici_PASS='"+sifre+"'";
				//select kullanici_pro from kullanicilar where  kullanici_NAME="cakir";
				
				
				ResultSet myRs = baglanti.yap();
				
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()){
						if(myRs.getInt("giris")==1) {
							String pro_sorgu = "select kullanici_pro from kullanicilar where  kullanici_NAME='"+ad+"'"; 
							myRs = baglanti.sorgula(pro_sorgu);
							while(myRs.next()) {
								if(myRs.getInt("kullanici_pro") == 1) {
									kull ="PREMIUM";
								}
							}
							String id_sorgu = "select kullanici_ID,kullanici_adi from kullanicilar where  kullanici_NAME='"+ad+"'"; 
							myRs = baglanti.sorgula(id_sorgu);
							while(myRs.next()) {
								ad = myRs.getString("kullanici_adi");
								id = myRs.getInt("kullanici_ID");
							}
							frm2 frame = new frm2();
							frame.setVisible(true);
							setVisible(false);
							
						} else { adlabel.setText("hatalý giriþ"); }
					}/*
					
					*/
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		kulbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kulbuton.setBounds(578, 283, 106, 34);
		contentPane.add(kulbuton);
		
		JLabel lblKullaniciAdi = new JLabel("Kullanici ADI : ");
		lblKullaniciAdi.setForeground(new Color(199, 21, 133));
		lblKullaniciAdi.setBackground(new Color(128, 128, 128));
		lblKullaniciAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKullaniciAdi.setBounds(21, 174, 163, 34);
		contentPane.add(lblKullaniciAdi);
		
		JLabel lblNewLabel = new JLabel("JAVA MUZ\u0130K UYGULAMASI G\u0130R\u0130\u015E EKRANI");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 29, 810, 77);
		contentPane.add(lblNewLabel);
		
		JButton kayitbuton = new JButton("KAYIT OL");
		kayitbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kayit frame = new kayit();
				frame.setVisible(true);
			}
		});
		kayitbuton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kayitbuton.setBackground(new Color(255, 0, 255));
		kayitbuton.setBounds(711, 283, 106, 34);
		contentPane.add(kayitbuton);
		
		
		
		
	}
}
