class ScoreFrame extends JFrame implements ActionListener, MouseListener {
	ScoreDAO scoreDAO;//만들고 왔습니다.
	ScoreDTO scoreDTO;//만들고 
	JLabel jlName, jlKor, jlEng, jlMat;
	JTextField jtName, jtKor, jtEng, jtMat;
	JButton jbAdd, jbDel, jbChange;
	JTable table;
	Vector data, col;
	
	public ScoreFrame() {//생성자 호출
		setLayout(null);
		scoreDAO = new ScoreDAO();
		
		//이름
		add(jlName = new JLabel("이름", JLabel.CENTER));
		jlName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlName.setBorder(BorderFactory.createBevelBorder(0));
		jlName.setBounds(10, 10, 120, 50);
		add(jtName = new JTextField());
		jtName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtName.setHorizontalAlignment(JTextField.CENTER);
		jtName.setBounds(140, 10, 120, 50);
		
		//국어
		add(jlKor = new JLabel("국어점수", JLabel.CENTER));
		jlKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlKor.setBorder(BorderFactory.createBevelBorder(0));
		jlKor.setBounds(10, 70, 120, 50);
		add(jtKor = new JTextField());
		jtKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtKor.setHorizontalAlignment(JTextField.CENTER);
		jtKor.setBounds(140, 70, 120, 50);
		
		//영어
		add(jlEng = new JLabel("영어점수", JLabel.CENTER));
		jlEng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlEng.setBorder(BorderFactory.createBevelBorder(0));
		jlEng.setBounds(10, 130, 120, 50);
		add(jtEng = new JTextField());
		jtEng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtEng.setHorizontalAlignment(JTextField.CENTER);
		jtEng.setBounds(140, 130, 120, 50);
		
		//수학
		add(jlMat = new JLabel("수학점수", JLabel.CENTER));
		jlMat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlMat.setBorder(BorderFactory.createBevelBorder(0));
		jlMat.setBounds(10, 190, 120, 50);
		add(jtMat = new JTextField());
		jtMat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtMat.setHorizontalAlignment(JTextField.CENTER);
		jtMat.setBounds(140, 190, 120, 50);
		
		//버튼 jbAdd, jbDel, jbChange
		add(jbAdd = new JButton("추가"));
		jbAdd.setFont(new Font("맑은 고딕", Font.BOLD,20));
		jbAdd.setBounds(270, 10, 120, 50);
		jbAdd.addActionListener(this);
		add(jbDel = new JButton("제거"));
		jbDel.setFont(new Font("맑은 고딕", Font.BOLD,20));
		jbDel.setBounds(270, 70, 120, 50);
		jbDel.addActionListener(this);
		add(jbChange = new JButton("수정"));
		jbChange.setFont(new Font("맑은 고딕", Font.BOLD,20));
		jbChange.setBounds(270, 130, 120, 50);
		jbChange.addActionListener(this);
		
		//컬럼데이터
		col = new Vector();
		col.add("이름");
		col.add("국어 점수");
		col.add("영어 점수");
		col.add("수학 점수");
		col.add("총점");
		col.add("평균");
		
		//테이블
		DefaultTableModel model = new DefaultTableModel(scoreDAO.getScore(), col) {
			//수정못하게 막기
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//스크롤
		table = new JTable(model);
		table.addMouseListener(this);
		JScrollPane scroll = new JScrollPane(table);
		jTableSet();//테이블을 갱신하는 메소드
		//없으니 아래에 만들겠습니다.
		add(scroll);
		scroll.setBounds(415, 10, 770, 250);
		
		//창크기 계산
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 1200) / 2, (screenSize.height - 300) / 2);
		
		setResizable(false);
		setSize(1200, 300);
		setTitle("성적 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	//jTableSet()
	public void jTableSet() {
		//이동과 길이조절 등등을 모두 막습니다.
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		//컬럼 정렬에 필요한 메소드
		DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		DefaultTableCellRenderer cellAlignLeft = new DefaultTableCellRenderer();
		cellAlignLeft.setHorizontalAlignment(JLabel.LEFT);
		
		//컬럼별 사이즈 조절 & 정렬
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setCellRenderer(cellAlignCenter);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setCellRenderer(cellAlignCenter);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setCellRenderer(cellAlignCenter);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setCellRenderer(cellAlignCenter);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setCellRenderer(cellAlignCenter);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setCellRenderer(cellAlignCenter);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		jtName.setText(table.getValueAt(rowIndex, 0) + "");
		jtKor.setText(table.getValueAt(rowIndex, 1) + "");
		jtEng.setText(table.getValueAt(rowIndex, 2) + "");
		jtMat.setText(table.getValueAt(rowIndex, 3) + "");
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonFlag = e.getActionCommand();
		scoreDTO = new ScoreDTO();
		scoreDAO = new ScoreDAO();
		if(buttonFlag.equals("추가")) {
			try {
				contentSet();
				int result = scoreDAO.insertScore(scoreDTO);
				if(result == 1 && !jtName.getText().equals(null) &&!jtName.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "추가 되었습니다.");
					jTableRefresh();
					contentClear();
				}
			}catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, "이름을 입력하세요!");
				e2.printStackTrace();			
			}
			
			
		}else if(buttonFlag.equals("제거")){
			try {
				contentSet();
				int result = scoreDAO.deleteScore(scoreDTO);
				if(result == 1 && !jtName.getText().equals(null) &&!jtName.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "제거 되었습니다.");
					jTableRefresh();
					contentClear();
				}
			}catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, "이름을 입력하세요!");
				e2.printStackTrace();			
			}
		}else if(buttonFlag.equals("수정")) {
			try {
				contentSet();
				int result = scoreDAO.updateScore(scoreDTO);
				if(result == 1 && !jtName.getText().equals(null) &&!jtName.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "수정 되었습니다.");
					jTableRefresh();
					contentClear();
					jtName.setFocusable(true);
				}
			}catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, "이름을 입력하세요!");
				e2.printStackTrace();			
			}
		}
	}
	public void jTableRefresh() {
		DefaultTableModel model = new DefaultTableModel(scoreDAO.getScore(), col) {
			//수정못하게 막기
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
		jTableSet();
	}
	public void contentSet() {
		scoreDTO = new ScoreDTO();
		
		String name = jtName.getText();
		if(name.equals("") || name.equals(null)) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요!");
		}
		int kor, eng, mat, tot;
		double avg;
		
		if(jtKor.getText().equals("")||jtKor.getText().equals(null)) {
			kor = 0;
		}else {
			kor = Integer.parseInt(jtKor.getText());
		}
		if(jtEng.getText().equals("")||jtEng.getText().equals(null)) {
			eng = 0;
		}else {
			eng = Integer.parseInt(jtEng.getText());
		}
		if(jtMat.getText().equals("")||jtMat.getText().equals(null)) {
			mat = 0;
		}else {
			mat = Integer.parseInt(jtMat.getText());
		}
		tot = kor + eng + mat;
		avg = (double)(tot/3);
		
		scoreDTO.setName(name);
		scoreDTO.setKor(kor);
		scoreDTO.setEng(eng);
		scoreDTO.setMat(mat);
		scoreDTO.setTot(tot);
		scoreDTO.setAvg(avg);
	}
	public void contentClear() {
		jtName.setText("");
		jtKor.setText("");
		jtEng.setText("");
		jtMat.setText("");
	}

}
public class Score{
	public static void main(String[] args) {
		new ScoreFrame();
	}
}

//ScoreDAO
public class ScoreDAO {
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/ramg";
			conn = DriverManager.getConnection(url,"root", "990212");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}//getConn()
	//데이터 불러오기 getScore()
	public Vector getScore() {
		Vector data = new Vector();
		Connection conn = getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql ="select * from score order by name asc";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector row = new Vector<>();
				row.add(rs.getString("name"));
				row.add(rs.getInt("kor"));
				row.add(rs.getInt("eng"));
				row.add(rs.getInt("mat"));
				row.add(rs.getInt("tot"));
				row.add(rs.getDouble("avg"));
				
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(rs != null) {stmt.close();}
				if(rs != null) {conn.close();}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return data;
	}
	//데이터 저장하기 insertScore()
	public int insertScore(ScoreDTO dto) {
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		String sql="insert into score values(?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getTot());
			pstmt.setDouble(6, dto.getAvg());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	//데이터 수정하기 updateScore()
	public int updateScore(ScoreDTO dto) {
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		String sql = "update score set kor=?, eng=?, mat=?, tot=?, avg=? where name=? ";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setInt(4, dto.getTot());
			pstmt.setDouble(5, dto.getAvg());
			pstmt.setString(6, dto.getName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	//데이터 삭제하기 deleteScore()
	public int deleteScore(ScoreDTO dto) {
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		String sql ="delete from score where name=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
//ScoreDTO
public class ScoreDTO {
	private int kor, eng, mat, tot;
	private double avg;
	private String name;
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
