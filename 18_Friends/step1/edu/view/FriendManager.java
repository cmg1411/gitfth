package com.edu.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.edu.biz.FriendBiz;
import com.edu.dto.FriendDTO;


class FriendManager extends JFrame implements ActionListener{
	private TextField name;
	private TextField jumin1;
	private TextField jumin2;
	private JComboBox<String> tel1;
	private TextField tel2;
	private TextField tel3;
	private JRadioButton male, female;
	private JCheckBox read, movie, music, game, shopping;
	private Button register, analysis, modify, delete, clear;
//	private JList<FriendDTO> list;
//	private DefaultListModel<FriendDTO> listModel;
	private JTextArea output;
	
	public FriendManager() {
		super("Friend Manager");
	}
	
	public void init() {
		name = new TextField(16);
		jumin1 = new TextField(5);
		jumin2 = new TextField(5);
		tel1 = new JComboBox<String>();
		tel1.addItem("010");
		tel1.addItem("011");
		tel1.addItem("016");
		tel1.addItem("019");
		tel2 = new TextField(3);
		tel3 = new TextField(3);
		male = new JRadioButton("��", true);
		female = new JRadioButton("��");
		ButtonGroup gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		read = new JCheckBox("����");
		movie= new JCheckBox("��ȭ");
		music = new JCheckBox("����");
		game = new JCheckBox("����");
		shopping = new JCheckBox("����");
		register = new Button("���");
		analysis = new Button("�м�");
		modify = new Button("����");
		delete = new Button("����");
		clear = new Button("�����");
//		listModel = new DefaultListModel<FriendDTO>();
//		list = new JList<FriendDTO>(listModel);
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		male.setBackground(Color.LIGHT_GRAY);
		female.setBackground(Color.LIGHT_GRAY);
		read.setBackground(Color.LIGHT_GRAY);
		movie.setBackground(Color.LIGHT_GRAY);
		music.setBackground(Color.LIGHT_GRAY);
		game.setBackground(Color.LIGHT_GRAY);
		shopping.setBackground(Color.LIGHT_GRAY);
		
		analysis.setEnabled(false);
		modify.setEnabled(false);
		delete.setEnabled(false);
		clear.setEnabled(false);
		
		JPanel wrapper = new JPanel(); // ��ü ���δ� �г�
		wrapper.setLayout(null);
		wrapper.setBackground(Color.LIGHT_GRAY);
		JPanel inputPanel = new JPanel(); //���� ���� �Է� �г�
		inputPanel.setLayout(new GridLayout(7,1,3,3));
		inputPanel.setBackground(Color.LIGHT_GRAY);
		inputPanel.add(new Label("���������Է�",Label.CENTER));
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new Label("��        �� :"));
		p1.add(name);
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(new Label("�ֹι�ȣ :"));
		p2.add(jumin1);
		p2.add(new Label(" -"));
		p2.add(jumin2);
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3.add(new Label("��ȭ��ȣ :"));
		p3.add(tel1);
		p3.add(new Label(" -"));
		p3.add(tel2);
		p3.add(new Label(" -"));
		p3.add(tel3);
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4.add(new Label("��        �� :"));
		p4.add(male);
		p4.add(female);
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p5.add(new Label("��        �� :"));
		p5.add(read);
		p5.add(movie);
		p5.add(music);
		p5.add(game);
		p5.add(shopping);
		JPanel p6 = new JPanel();
		p6.add(register);
		p6.add(analysis);
		p6.add(modify);
		p6.add(delete);
		p6.add(clear);
		p1.setBackground(Color.LIGHT_GRAY);
		p2.setBackground(Color.LIGHT_GRAY);
		p3.setBackground(Color.LIGHT_GRAY);
		p4.setBackground(Color.LIGHT_GRAY);
		p5.setBackground(Color.LIGHT_GRAY);
		p6.setBackground(Color.LIGHT_GRAY);
		inputPanel.add(p1);
		inputPanel.add(p2);
		inputPanel.add(p3);
		inputPanel.add(p4);
		inputPanel.add(p5);
		inputPanel.add(p6);
		inputPanel.setBounds(10,10,400,260);
		wrapper.add(inputPanel);
		
		JPanel listPanel = new JPanel(new BorderLayout()); //��ü ��� �г�
		listPanel.add("North", new Label("�� ü �� ��", Label.CENTER));
//		listPanel.add("Center", list);
		listPanel.setBounds(410, 20, 110,260);
		listPanel.setBackground(Color.LIGHT_GRAY);
		wrapper.add(listPanel);
		
		JPanel infoPanel = new JPanel(new BorderLayout()); //�������� �м� �г�
		infoPanel.add("North", new Label("���������м�", Label.CENTER));
		infoPanel.add("Center", scroll);
		infoPanel.setBounds(10, 280, 510, 190);
		infoPanel.setBackground(Color.LIGHT_GRAY);
		wrapper.add(infoPanel);
		
		getContentPane().add("Center",wrapper);
		setBounds(400, 90, 550,525);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		event(); // 1�ܰ� :�̺�Ʈ ���
	} //init()
	
	//1�ܰ�-------------------------------------------------------------------
	public void event() {
		register.addActionListener(this);  // ���
		analysis.addActionListener(this);  // �м�
		modify.addActionListener(this);    // ����
		delete.addActionListener(this);    // ����
		clear.addActionListener(this);     // ȭ�������
	}
	
	
	
	//1�ܰ�-------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			erase();
		}
		if(e.getSource()==register) {
			if(check()) {
				FriendBiz biz = new FriendBiz();
				FriendDTO dto = setDTOValue();
				try {
					int n = biz.insertFriend(dto);
					if(n>0)
						output.setText("���������� ����Ͽ����ϴ�.");
				} catch (SQLException e1) {
					output.setText("�Է� ���뿡 ������ �ֽ��ϴ�.");
				}
			}else {
				output.setText("�Է� ���뿡 ������ �ֽ��ϴ�.");
			}
		}
		if(e.getSource()==modify) {
			
		}
		if(e.getSource()==delete) {
			
		}
		if(e.getSource()==analysis) {
			
		}
	}
	
	
	//CRUDó���� ���� �����͸� DTO�� �����ϴ� ����.
	private FriendDTO setDTOValue() {
		FriendDTO dto=new FriendDTO();
		dto.setName(name.getText());
		dto.setJumin1(jumin1.getText());
		dto.setJumin2(jumin2.getText());
		dto.setTel1((String)tel1.getSelectedItem());
		dto.setTel2(tel2.getText());
		dto.setTel3(tel3.getText());
		if(male.isSelected())
			dto.setGender(0);
		else
			dto.setGender(1);
		dto.setRead(read.isSelected()?1:0);
		dto.setMovie(movie.isSelected()?1:0);
		dto.setMusic(music.isSelected()?1:0);
		dto.setGame(game.isSelected()?1:0);
		dto.setShopping(shopping.isSelected()?1:0);
		
		return dto;
	}

	public boolean check() {
		if(name.getText().length()==0||jumin1.getText().length()!=6||jumin2.getText().length()!=7||
				tel2.getText().length()==0||tel3.getText().length()==0) {
			return false;
		}else {
			return true;
		}
	}
	
	public void erase() {
		name.setText("\0");
		jumin1.setText("\0");
		jumin2.setText("\0");
		tel1.setSelectedIndex(0);
		tel2.setText("\0");
		tel3.setText("\0");
		male.setSelected(true);
		read.setSelected(false);
		game.setSelected(false);
		music.setSelected(false);
		shopping.setSelected(false);
		movie.setSelected(false);
	
		name.setEnabled(true);
		name.setEditable(true);
		register.setEnabled(true);
		analysis.setEnabled(false);
		modify.setEnabled(false);
		delete.setEnabled(false);
		clear.setEnabled(true);
	}
	
	public static void main(String[] args) {
		FriendManager fm=new FriendManager();
		fm.init();
	}

}

















