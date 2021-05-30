import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class kayit extends JFrame {

	private JPanel contentPane;
	private JTextField adtext;
	private JTextField niktext;
	private JTextField sifretext;
	private JTextField mailtext;
	private static int id ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayit frame = new kayit();
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
	public kayit() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 918, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KULLANICI KAY\u0130T EKRANI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(10, 10, 894, 77);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kullan\u0131c\u0131 ADI : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(234, 97, 178, 37);
		contentPane.add(lblNewLabel_1);
		
		adtext = new JTextField();
		adtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adtext.setBounds(422, 99, 231, 37);
		contentPane.add(adtext);
		adtext.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kullan\u0131c\u0131 Nick : ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(234, 144, 178, 37);
		contentPane.add(lblNewLabel_1_1);
		
		niktext = new JTextField();
		niktext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		niktext.setColumns(10);
		niktext.setBounds(422, 146, 231, 37);
		contentPane.add(niktext);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kullan\u0131c\u0131 \u015E\u0130FRE : ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(234, 191, 178, 37);
		contentPane.add(lblNewLabel_1_2);
		
		sifretext = new JTextField();
		sifretext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sifretext.setColumns(10);
		sifretext.setBounds(422, 193, 231, 37);
		contentPane.add(sifretext);
		
		JLabel lblNewLabel_1_3 = new JLabel("Kullan\u0131c\u0131 MA\u0130L : ");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(234, 238, 178, 37);
		contentPane.add(lblNewLabel_1_3);
		
		mailtext = new JTextField();
		mailtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mailtext.setColumns(10);
		mailtext.setBounds(422, 240, 231, 37);
		contentPane.add(mailtext);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("PREMIUM ABONEL\u0130K : ");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(234, 285, 178, 37);
		contentPane.add(lblNewLabel_1_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(422, 287, 231, 35);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Premium Abonelik Olsun","Premium Abonelik Olmasin"}));
		contentPane.add(comboBox);
		JLabel bilgilabel = new JLabel("");
		bilgilabel.setHorizontalAlignment(SwingConstants.CENTER);
		bilgilabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		bilgilabel.setBounds(400, 404, 284, 51);
		contentPane.add(bilgilabel);
		JButton btnNewButton = new JButton("KAYIT OL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id_sorgu=null;
				
				ResultSet my = null;
				
				id_sorgu = "SELECT kullanici_ID FROM kullanicilar "+"ORDER BY kullanici_ID DESC LIMIT 0,1;";
				
				System.out.println(id_sorgu);
				my = baglanti.yap();
				my = baglanti.sorgula(id_sorgu);
				

				try {
					while(my.next()) {
						id = my.getInt("kullanici_ID") + 1;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				int secilen = comboBox.getSelectedIndex();
				String ad,nik,mail,sifre,tarih,album,sure,dinlenme,sql_sorgu ="";
				Random rnd = new Random();
				ad = adtext.getText();
				nik = niktext.getText();
				mail = mailtext.getText();
				sifre = sifretext.getText();
				
				
				
				
				if(secilen == 0 ) {
					sql_sorgu = "INSERT INTO kullanicilar (kullanici_ID,kullanici_NAME,kullanici_PASS,kullanici_pro,kullanici_mail,kullanici_adi) VALUES ("+id
							+",'"+ nik + "','" + sifre + "'," + "0" + ",'" + mail + "','" + ad + "')" ;
				} else if(secilen == 1)
				{
					sql_sorgu = "INSERT INTO kullanicilar (kullanici_NAME,kullanici_PASS,kullanici_pro,kullanici_mail,kullanici_adi) VALUES ('"+
							nik + "','" + sifre + "'," + "1" + ",'" + mail + "','" + ad + "')" ;
				}
				ResultSet myRs = baglanti.yap();

				System.out.println(sql_sorgu);

				baglanti.ekle(sql_sorgu);
				id++;
				bilgilabel.setText("BAÞARIYLA KAYIT EKLENDÝ");
				
			}
		});
		btnNewButton.setBounds(422, 348, 231, 46);
		contentPane.add(btnNewButton);
		
		
	}
}
