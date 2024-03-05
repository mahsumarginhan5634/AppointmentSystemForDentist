package HelperClasses;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class Helper 
{
	
	private static Timer hoverTimer = null ;
	private  int popupMenuItem = -1;
	private String popupVerificationCode;
	
	public String getPopupVerificationCode() 
	{
		return popupVerificationCode;
	}
	public void setPopupVerificationCode(String popupVerificationCode) 
	{
		this.popupVerificationCode = popupVerificationCode;
	}
	public void setPopupMenuItem(int popupMenuItem)
	{  
		this.popupMenuItem = popupMenuItem;
	}
	public int getPopupMenuItem()
	{
		return popupMenuItem;
	}
	public static ImageIcon sendNewSizeIcon(Class initialClass , String png)
	{
		URL iconUrl = initialClass.getResource("/Icons/"+png);
		ImageIcon icon = new ImageIcon(iconUrl);
		return icon;
	}
	
	public static ImageIcon sendNewSizeIcon(Class initialClass , String png  , int width ,int height)
	{
		URL iconUrl = initialClass.getResource("/Icons/"+png);
		ImageIcon icon = new ImageIcon(iconUrl);	
		Image originalImage = icon.getImage();
        Image newImage = originalImage.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH);
        ImageIcon newSizeIcon = new ImageIcon(newImage);
        return newSizeIcon;
	}
	
	public static void changeFrames(JFrame openedFrame,JFrame closedFrame)
	{
		openedFrame.setVisible(true);
		closedFrame.dispose();
	}
	
	public static void showMessage(String str)
	{
		String message = str ;
		
		switch(str)
		{
			case "fill":
				message = "Lütfen istenen bilgileri boş alan bırakmadan doldurunuz";
				break;
			case "error":
				message = "Beklenmedik bir hata ile karşılaşıldı";
				break;
		
		}
		
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 13));
		
		JOptionPane.showMessageDialog(null, message, "Dikkat!!!!", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void setButtonHoverEffect(JButton button)
	{
		
		if(hoverTimer != null)
		{
			hoverTimer.cancel();
		}
		
		hoverTimer = new Timer();
		hoverTimer.schedule(new TimerTask() 
		{
			
			@Override
			public void run() 
			{
				SwingUtilities.invokeLater(() -> 
				{	
					button.setForeground(Color.BLACK);
					button.setBackground(new Color(250, 243, 240));
					button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                });
				
			}
		}, 125); /*250 ms(milisaniye) bekleme(delay) yapacak*/
		
		
		
		
	}
	
	public static void breakButtonHoverEffect(JButton button)
	{
		
		if (hoverTimer != null) 
		{
            hoverTimer.cancel();
            hoverTimer = null;
        }
		button.setForeground(Color.GRAY);
		button.setBackground(Color.WHITE);
		button.setCursor(Cursor.getDefaultCursor());
		
	}
	
	public static void showCapsLockInfo(JLabel label , boolean status)
	{
		if(status)
		{
			label.setText("DİKKAT : 'Caps Lock' tuşu açık. Sistem büyük/küçük harfe duyarlıdır.");
		}
		else
		{
			label.setText(null);
		}
	}
	
	public static void setVisibleOrNonVisibleObjects(Component[] components ,boolean set)
	{
		for(int i = 0 ; i < components.length; i++)
		{
			components[i].setVisible(set);
		}
	}

	public static String generateAccountVerificationCode()
	{
		Random randInt = new Random();
		return Integer.toString(randInt.nextInt(1000,9999));
	}
	
	
	public static void sendAccountVerificationCodeWithEMail(String email,String  verificationCode,String subject,String text)
	{

    	final String senderEmail = "arginhanmahsum5634@gmail.com";
    	final String senderPassword = "vzgspyyhnqlccmsj";//Bu şifreyi google kendisi veriyor
    	

        // Gmail SMTP sunucu ayarları
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Oturum açma işlemi için kullanıcı bilgileri
        Session session = Session.getInstance(props, new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try 
        {
            // Mesaj oluşturma
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(text + " Kodunuz : " + verificationCode);

            // E-posta gönderme
            Transport.send(message);

           //System.out.println("E-posta gonderildi.");

        } 
        
        catch (MessagingException e) 
        {
            e.printStackTrace();
        }
    
	}
	
	public static void sendAccountVerificationCodeWithPhoneNumber(String phoneNumber , String verificationCode)
	{
		
	}
	
	
	
	public static DefaultTableModel updateAssistantTable()
	{
		return null;
		
	}
}
