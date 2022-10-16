package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Web.GetTNBike;
public class BikeContent implements ActionListener{

	Container contentArea;
	JPanel panel = new JPanel();
	JScrollPane scroll;
	JPanel mainPanel;
	JTable table;
	Object[][] data;
	JButton back = new JButton("返回");
	
	public BikeContent(Container contentArea,JPanel mainPanel) {
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		GetTNBike bike = new GetTNBike();
		try {
			data = bike.getBike();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String[] columns = {"站名","可借","可停"};
		table = new JTable(data,columns);
		scroll = new JScrollPane(table);
		
		table.setRowHeight(30);
		back.addActionListener(this);
		panel.add(back);
		
		contentArea.add(panel);
		contentArea.add(scroll);
		contentArea.repaint(); // 重新整理
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == back) {
			contentArea.remove(panel);
			contentArea.remove(scroll);
			
			contentArea.revalidate();
			contentArea.repaint();
			
			contentArea.add(mainPanel);
			contentArea.repaint();
		}
		
	}

}
