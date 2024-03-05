package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import HelperClasses.BorderRadiusButton;
import HelperClasses.Database;
import HelperClasses.Helper;
import HelperClasses.WhereTo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class EntranceGUI extends JFrame 
{

	private JPanel mainPane;
	private Class initialClass = this.getClass();
	private WhereTo where = null;
	
	
	
	
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
					EntranceGUI frame = new EntranceGUI();
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
	public EntranceGUI() 
	{
		
		// Sistem ilk defa çalıştırıldığında veritabanını tasarlar.
		//NOT = Sistem her açıldığında Database.createSchemaAndTables(); komutu çalışacaktır. Bunu sadece bir kere çalışacak şekilde oluştur.
		Database.createSchemaAndTables();
		
		//Sistem ilk defa çalıştırıldığında yetkili kişinin kayıt bilgilerini isteyecek.
		
		
		ImageIcon frameIcon = Helper.sendNewSizeIcon(initialClass, "appointment.png");
		setIconImage(frameIcon.getImage());

		setBackground(new Color(255, 255, 255));
		setFocusable(true);
		setResizable(true);
		setTitle("Diş Hekimliği Randevu Sistemi Giriş Sayfası");
		
		setBounds(100,100,100, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        
		
        
		Dimension minSize = new Dimension(1000 , 600);
		setMinimumSize(minSize);

		mainPane = new JPanel();
		mainPane.setForeground(Color.WHITE);
		mainPane.setBackground(UIManager.getColor("Button.background"));
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new BorderLayout(20 , 20));

		JLabel lblDentist = new JLabel(Helper.sendNewSizeIcon(initialClass, "dentist.png",200,200));
		lblDentist.setVerticalAlignment(SwingConstants.TOP);
		lblDentist.setBackground(new Color(255, 255, 255));
		//mainPane.add(lblDentist);

		JLabel lblWelcome = new JLabel("               Diş Hekimliği Randevu Sistemine Hoşgeldiniz");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBackground(new Color(255, 255, 255));
		lblWelcome.setForeground(Color.BLACK);
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 15));
		//mainPane.add(lblDent);
		JPanel main_centerPane = new JPanel(null);
		main_centerPane.setLayout(new GridLayout(2,1));
		main_centerPane.add(lblDentist);
		
		JLabel lblDent = new JLabel(Helper.sendNewSizeIcon(initialClass, "tooth.png"));
		main_centerPane.add(lblDent);
		
		//centerPane.add(lblWelcome,BorderLayout.NORTH);
		//centerPane.add(lblDent,BorderLayout.SOUTH);
		mainPane.add(main_centerPane , BorderLayout.CENTER);

		JButton btnLoginAppointment = new BorderRadiusButton(Helper.sendNewSizeIcon(initialClass, "appointmentFile.png", 260, 170));
		btnLoginAppointment.setBackground(Color.WHITE);
		btnLoginAppointment.setBounds(267, 313, 250, 200);
		//mainPane.add(btnLoginUser);

		JButton btnLoginPatientInfo = new BorderRadiusButton(Helper.sendNewSizeIcon(initialClass, "file.png", 260, 170));
		btnLoginPatientInfo.setBackground(Color.WHITE);
		btnLoginPatientInfo.setBounds(605, 313, 250, 200);
		//mainPane.add(btnLoginManager);

		JLabel lblUserEntryPage = new JLabel("Randevu Sistemi");
		lblUserEntryPage.setVerticalAlignment(SwingConstants.TOP);
		lblUserEntryPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserEntryPage.setFont(new Font("Arial", Font.BOLD, 14));
		lblUserEntryPage.setForeground(Color.BLACK);
		lblUserEntryPage.setBackground(Color.WHITE);
		lblUserEntryPage.setBounds(244, 524, 287, 38);
		//mainPane.add(lblUserEntryPage);
		JPanel main_eastPane = new JPanel(new GridLayout(2,1));
		main_eastPane.add(btnLoginAppointment);
		main_eastPane.add(lblUserEntryPage);

		JLabel lblUserManagementPage = new JLabel("Hasta Bilgi Sayfası");
		lblUserManagementPage.setVerticalAlignment(SwingConstants.TOP);
		lblUserManagementPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserManagementPage.setForeground(Color.BLACK);
		lblUserManagementPage.setFont(new Font("Arial", Font.BOLD, 14));
		lblUserManagementPage.setBackground(new Color(255, 255, 255));
		lblUserManagementPage.setBounds(599, 524, 287, 38);
		//mainPane.add(lblUserManagementPage);
		JPanel main_westPane = new JPanel(new GridLayout(2,1));
		main_westPane.add(btnLoginPatientInfo);
		
		main_westPane.add(lblUserManagementPage);

		JButton btnLogOut = new BorderRadiusButton("Çıkış Yap");
		btnLogOut.setText("Çıkış Yap");
		btnLogOut.setToolTipText("");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(833, 11, 221, 49);
		JPanel main_northPane = new JPanel(new BorderLayout());
		main_northPane.setBackground(UIManager.getColor("Button.background"));
		main_northPane.add(lblWelcome , BorderLayout.CENTER);
		main_northPane.add(btnLogOut , BorderLayout.EAST);
		mainPane.add(main_northPane , BorderLayout.NORTH);
	
	
		mainPane.add(main_eastPane , BorderLayout.EAST);
		mainPane.add(main_westPane , BorderLayout.WEST);
		

		/** Eventler */
		/* ActionListener Eventleri */
		btnLoginAppointment.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				where = WhereTo.PatientAppointMentGUI;
				//Helper.changeFrames(new EnterPasswordGUI(where), EntranceGUI.this);
			}
		});

		btnLoginPatientInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				where = WhereTo.PatientInformationsGUI;
				//Helper.changeFrames(new EnterPasswordGUI(where), EntranceGUI.this);
			}
		});

		btnLogOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});

		/* MouseListener Eventleri */
		btnLogOut.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				Helper.setButtonHoverEffect(btnLogOut);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				Helper.breakButtonHoverEffect(btnLogOut);
			}

		});

		btnLoginPatientInfo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				Helper.setButtonHoverEffect(btnLoginPatientInfo);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				Helper.breakButtonHoverEffect(btnLoginPatientInfo);
			}

		});

		btnLoginAppointment.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				Helper.setButtonHoverEffect(btnLoginAppointment);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				Helper.breakButtonHoverEffect(btnLoginAppointment);
			}

		});

	}
}
