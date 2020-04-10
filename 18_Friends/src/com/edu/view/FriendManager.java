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
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.edu.biz.FriendBiz;
import com.edu.dto.FriendDTO;


class FriendManager extends JFrame implements ActionListener, ListSelectionListener{
	private TextField name;
	private TextField jumin1;
	private TextField jumin2;
	private JComboBox<String> tel1;
	private TextField tel2;
	private TextField tel3;
	private JRadioButton male, female;
	private JCheckBox read, movie, music, game, shopping;
	private Button register, analysis, modify, delete, clear;
	private JTextArea output;
	
	//2단계----------------------------
	private JList<FriendDTO> list;
	private DefaultListModel<FriendDTO> listModel;
	List<FriendDTO> fList = null; // 반드시 전역변수로 사용
								  // listModel에서 fList를 사용하기 때문
	//2단계----------------------------
	
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
		male = new JRadioButton("남", true);
		female = new JRadioButton("여");
		ButtonGroup gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		read = new JCheckBox("독서");
		movie= new JCheckBox("영화");
		music = new JCheckBox("음악");
		game = new JCheckBox("게임");
		shopping = new JCheckBox("쇼핑");
		register = new Button("등록");
		analysis = new Button("분석");
		modify = new Button("수정");
		delete = new Button("삭제");
		clear = new Button("지우기");
		listModel = new DefaultListModel<FriendDTO>(); //2단계
		list = new JList<FriendDTO>(listModel);  //2단계
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
		
		JPanel wrapper = new JPanel(); // 전체 감싸는 패널
		wrapper.setLayout(null);
		wrapper.setBackground(Color.LIGHT_GRAY);
		JPanel inputPanel = new JPanel(); //개인 정보 입력 패널
		inputPanel.setLayout(new GridLayout(7,1,3,3));
		inputPanel.setBackground(Color.LIGHT_GRAY);
		inputPanel.add(new Label("개인정보입력",Label.CENTER));
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new Label("이        름 :"));
		p1.add(name);
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(new Label("주민번호 :"));
		p2.add(jumin1);
		p2.add(new Label(" -"));
		p2.add(jumin2);
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3.add(new Label("전화번호 :"));
		p3.add(tel1);
		p3.add(new Label(" -"));
		p3.add(tel2);
		p3.add(new Label(" -"));
		p3.add(tel3);
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4.add(new Label("성        별 :"));
		p4.add(male);
		p4.add(female);
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p5.add(new Label("취        미 :"));
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
		
		JPanel listPanel = new JPanel(new BorderLayout()); //전체 목록 패널
		listPanel.add("North", new Label("전 체 목 록", Label.CENTER));
		listPanel.add("Center", list);  //2단계
		listPanel.setBounds(410, 20, 110,260);
		listPanel.setBackground(Color.LIGHT_GRAY);
		wrapper.add(listPanel);
		
		JPanel infoPanel = new JPanel(new BorderLayout()); //개인정보 분석 패널
		infoPanel.add("North", new Label("개인정보분석", Label.CENTER));
		infoPanel.add("Center", scroll);
		infoPanel.setBounds(10, 280, 510, 190);
		infoPanel.setBackground(Color.LIGHT_GRAY);
		wrapper.add(infoPanel);
		
		getContentPane().add("Center",wrapper);
		setBounds(400, 90, 550,525);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		event(); // 1단계 :이벤트 등록
		erase();   //화면 Clear   ---2단계
		getList(); // 2단계 : 목록 출력
	} //init()
	
	//1단계-------------------------------------------------------------------
	public void event() {
		register.addActionListener(this);  // 등록
		analysis.addActionListener(this);  // 분석
		modify.addActionListener(this);    // 수정
		delete.addActionListener(this);    // 삭제
		clear.addActionListener(this);     // 화면지우기
		
		//3단계 ---------------------------------
		list.addListSelectionListener(this);
			//JList의 항목을 클릭했을떄 호출되는 이벤트
			//implements ListSelectionListener 추가
	}
	
	
	
	//1단계-------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			erase();
		}
		if(e.getSource()==register) {
			if(check()) {
				FriendBiz biz = new FriendBiz();
				FriendDTO dto = setDTOValue();
				int n = biz.insertFriend(dto);
				if(n>0) {
					output.setText("성공적으로 등록하였습니다.");
					getList();    //---2단계
				}
				erase();   //---2단계
			}else {
				output.setText("입력 내용에 오류가 있습니다.");
			}
		}
		if(e.getSource()==modify) {
			// 5단계
			String str = this.name.getText();
			FriendBiz biz = new FriendBiz();
			FriendDTO dto = setDTOValue();
			int n = biz.modifyFriend(dto);
			
			if(n>0) {
				output.setText(str + "님의 정보를 수정했습니다.");
				getList();
			}else {
				output.setText("수정에 실패했습니다.");
			}
				
			// 5단계
		}
		if(e.getSource()==delete) {
			//6단계
			String name = this.name.getText();
			FriendBiz biz = new FriendBiz();
			int n = biz.deleteFriend(name);
			if(n>0) {
				listModel.remove(list.getSelectedIndex());
				erase();
				output.setText(name + "님이 탈퇴하였습니다.");
				getList();
			}else {
				output.setText("삭제에 실패했습니다.");
			}
			
			//6단계
		}
		if(e.getSource()==analysis) {
			infoView();
		}
	}
	
	//2단계(전체보기 JList list)----------------------------------------------------------
	public void getList() { //테이블에서 모든 목록을 꺼내온 후 이름만 출력.
		listModel.clear();
		FriendBiz biz = new FriendBiz();
		fList=biz.getList(); //데이터베이스에서 가져온 friend list
		
		for(FriendDTO dto : fList) {
			listModel.addElement(dto); // 자동으로 dto의 toString을 호출하여 이름만 출력
		}
	}
	//2단계-------------------------------------------------------------------
	
	//3단계(JList를 클릭했을 떄 호출)------------------------------------------------
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting()) { //마우스 올라갔을때 첫번쨰 실행, 클릭했을때 두번쨰 실행 --> 조건걸어줘야 한번만 실행
//			String name = list.getSelectedValue().getName();
//			System.out.println(name);
			this.name.setText(list.getSelectedValue().getName());
			this.name.setEditable(false);    //수정을 금지한다
			this.jumin1.setText(list.getSelectedValue().getJumin1());
			this.jumin1.setEditable(false); 
			this.jumin2.setText(list.getSelectedValue().getJumin2());
			this.jumin2.setEditable(false); 
			this.tel1.setSelectedItem(list.getSelectedValue().getTel1());
			this.tel2.setText(list.getSelectedValue().getTel2());
			this.tel3.setText(list.getSelectedValue().getTel3());
			this.male.setSelected(list.getSelectedValue().getGender()==0?true:false);
			this.female.setSelected(list.getSelectedValue().getGender()==1?true:false);
			this.read.setSelected(list.getSelectedValue().getRead()==1?true:false);
			this.movie.setSelected(list.getSelectedValue().getMovie()==1?true:false);
			this.music.setSelected(list.getSelectedValue().getMusic()==1?true:false);
			this.game.setSelected(list.getSelectedValue().getGame()==1?true:false);
			this.shopping.setSelected(list.getSelectedValue().getShopping()==1?true:false);
			
			register.setEnabled(false);
			analysis.setEnabled(true);
			modify.setEnabled(true);
			delete.setEnabled(true);
			clear.setEnabled(true);	
		}
	}
	//3단계-------------------------------------------------------------------
	
	
	//4단계(분석단계)------------------------------------------------------------
	public void infoView() {
		output.setText("");
		output.append("이름 : " + name.getText());
		if(male.getSelectedObjects() != null) 
			output.append("\n성별 : 남자");
		else
			output.append("\n성별 : 여자");
		
		
		output.append("\n생년월일 : ");
		int year;
		if(jumin2.getText().charAt(0)==48 || jumin2.getText().charAt(0)==49)
			year = 1900 + (jumin1.getText().charAt(0)-48)*10 + (jumin1.getText().charAt(1)-48);
		else
			year = 2000 + (jumin1.getText().charAt(0)-48)*10 + (jumin1.getText().charAt(1)-48);
		
		output.append(year + "년" + jumin1.getText().substring(2,4) + "월" + jumin1.getText().substring(4,6) + "일");
		
		
		output.append("\n취미 : ");
		if(read.isSelected())
			output.append("독서/");
		if(movie.isSelected())
			output.append("영화감상/");
		if(game.isSelected())
			output.append("게임/");
		if(music.isSelected())
			output.append("음악감상/");
		if(shopping.isSelected())
			output.append("쇼핑");
		if(!read.isSelected() && !movie.isSelected() && !game.isSelected() && !music.isSelected() && !shopping.isSelected())
			output.append("선택없음");
		
		
	}
	//4단계-------------------------------------------------------------------
	
	//CRUD처리를 위해 데이터를 DTO에 저장하는 역할.
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

















