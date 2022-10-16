package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Container;
import java.awt.FlowLayout;

public class MainContent extends JFrame implements ActionListener{

	private ImageIcon icon1 = new ImageIcon("bike.png");
	private ImageIcon icon2 = new ImageIcon("icon-user.png");
	private ImageIcon icon3 = new ImageIcon("bus.png");
	
	
	private JButton bike = new JButton(icon1);
	private JButton mask = new JButton(icon2);
	private JButton bus = new JButton(icon3);
	
	// 容器
	private Container contentArea = getContentPane();
	private JPanel mainPanel = new JPanel();
	
	public MainContent() {
		bike.addActionListener(this);
		mainPanel.add(bike);
		
		mask.addActionListener(this);
		mainPanel.add(mask);
		
		bus.addActionListener(this);
		mainPanel.add(bus);
		
		contentArea.add(mainPanel);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // 視窗作全滿
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == bike) {
			contentArea.remove(mainPanel);
			contentArea.revalidate(); // 重新整理畫面
			new BikeContent(contentArea,mainPanel);
		}
		if(event.getSource() == mask) {
			contentArea.remove(mainPanel);
			contentArea.revalidate(); // 重新整理畫面
			new AuthContent(contentArea,mainPanel);
		}
		if(event.getSource() == bus) {
			contentArea.remove(mainPanel);
			contentArea.revalidate(); // 重新整理畫面
			try {
				new TrainContent(contentArea,mainPanel);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
