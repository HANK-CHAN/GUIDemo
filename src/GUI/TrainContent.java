package GUI;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.*;
import java.sql.*;

import DB.TrainSQL;
import Web.GetTNBike;

public class TrainContent implements ActionListener{
	Container contentArea;
	JPanel panel = new JPanel();
	JScrollPane scroll;
	JPanel mainPanel;
	JTable table;
	Object[][] data;
	JButton back = new JButton("返回");
	
	public TrainContent(Container contentArea,JPanel mainPanel) throws SQLException {
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		TrainSQL train = new TrainSQL();
		try {
			ResultSet rs = train.queryAll();
			data = new Object[242][2];
			int i = 0;
			while(rs.next()) {
				data[i][0] = rs.getInt("id");
				data[i][1] = rs.getString("name");
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		String[] columns = {"編號","車站名稱"};
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
