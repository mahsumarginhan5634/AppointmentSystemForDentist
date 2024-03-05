//Bu GUI sınıfı hastaların randevu işlemleri(CRUD) ile uğraşacak olan  sınıftır.
package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HelperClasses.Helper;
import Model.Personel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import HelperClasses.BorderRadiusButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientAppointmentGUI extends JFrame 
{

	private JPanel contentPane;
	private Class initialClass = this.getClass();
	private static Personel personel = new Personel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PatientAppointmentGUI frame = new PatientAppointmentGUI(personel);
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientAppointmentGUI(Personel personel) 
	{
		setTitle("Randevu Yönetim Sayfası");
		setResizable(false);
		
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1204, 728);
		ImageIcon frameIcon = Helper.sendNewSizeIcon(initialClass, "appointment.png");
		setIconImage(frameIcon.getImage());
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeUser = new JLabel("Hoşgeldiniz Sayın , "+personel.getName().toUpperCase());
		lblWelcomeUser.setVerticalAlignment(SwingConstants.TOP);
		lblWelcomeUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeUser.setForeground(Color.BLACK);
		lblWelcomeUser.setFont(new Font("Arial", Font.BOLD, 17));
		lblWelcomeUser.setBounds(10, 11, 545, 25);
		contentPane.add(lblWelcomeUser);
		
		JTabbedPane wTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		wTabbedPane.setForeground(Color.BLACK);
		wTabbedPane.setFont(new Font("Arial", Font.BOLD, 12));
		wTabbedPane.setBackground(Color.WHITE);
		wTabbedPane.setBounds(0, 60, 1188, 629);
		contentPane.add(wTabbedPane);
		
		JPanel panelAddAppointment = new JPanel();
		panelAddAppointment.setBackground(Color.WHITE);
		wTabbedPane.addTab("Randevu Ekle", null, panelAddAppointment, null);
		panelAddAppointment.setLayout(null);
		
		JPanel panelShowAppointment = new JPanel();
		panelShowAppointment.setBackground(Color.WHITE);
		wTabbedPane.addTab("Randevu Düzenle", null, panelShowAppointment, null);
		
		BorderRadiusButton btnBack = new BorderRadiusButton("Çıkış Yap");
		btnBack.setText("Kaydet ve Geri Dön");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Arial", Font.BOLD, 16));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(957, 11, 221, 49);
		contentPane.add(btnBack);
		
		/*ActionListener Eventleri*/

		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Helper.changeFrames(new EnterPasswordGUI(null), PatientAppointmentGUI.this);
			}
		});
		
		
		/*MouseListener Eventleri*/

		btnBack.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				Helper.setButtonHoverEffect(btnBack);
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				Helper.breakButtonHoverEffect(btnBack);
			}
		});
		

		contentPane.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				PatientAppointmentGUI.this.requestFocusInWindow();
			}
			
		});
	}
}
