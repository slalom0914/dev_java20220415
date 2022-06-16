package jdbc.member;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import address.view2.DBConnectionMgr;

public class MemberLogin extends JFrame implements ActionListener{
	String nickName="";
	String imgPath="src\\ajdbc\\dept\\";
	JLabel jlb_id = new JLabel("아이디");
	JLabel jlb_pw = new JLabel("패스워드");

	Font jl_font = new Font("휴먼매직체", Font.BOLD, 17);
	JTextField jtf_id = new JTextField("test");
	JTextField jtf_pw = new JTextField("123");

	JButton jbtn_login = new JButton(
			new ImageIcon(imgPath+"login.png"));
			//new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\login.png"));
	JButton jbtn_join = new JButton(
			new ImageIcon(imgPath+"confirm.png"));
			//new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\co   nfirm.png"));

	// JPanel에 쓰일 이미지아이콘
	//ImageIcon ig = new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\main.png");
	ImageIcon ig = new ImageIcon(imgPath+"main.PNG");
	
	/////////////////////////////////////////////////////
	/* 생성자 */
	/////////////////////////////////////////////////////
	public MemberLogin(){
		initDisplay();
	}

	/* 배경이미지 */
	class mypanal extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponents(g);
		}
	}

	/////////////////////////////////////////////////////
	/* 화면처리 */
	/////////////////////////////////////////////////////
	public void initDisplay() {
		setContentPane(new mypanal());
		this.setLayout(null);
		// id 라인
		jlb_id.setBounds(45, 200, 80, 40);
		jlb_id.setFont(jl_font);
		jtf_id.setBounds(110, 200, 185, 40);
		this.add(jlb_id);
		this.add(jtf_id);

		// pw 라인
		jlb_pw.setBounds(45, 240, 80, 40);
		jlb_pw.setFont(jl_font);
		jtf_pw.setBounds(110, 240, 185, 40);
		this.add(jlb_pw);
		this.add(jtf_pw);

		// 로그인 버튼 라인
		jbtn_login.setBounds(175, 285, 120, 40);
		this.add(jbtn_login);

		// 회원가입 버튼 라인
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_join);			
		/* 버튼과 텍스트필드 구성 */
		jbtn_join.addActionListener(this);
		jbtn_login.addActionListener(this);

		this.setTitle("회원관리 실습 ver.1.0");
		this.setSize(350, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(800, 250);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	
	}
	public static void main(String[] args) {
		new MemberLogin();

	}
	/**********************************************************************************
	 * 로그인 구현
	 * @param mem_id - 사용자가 입력한 아이디 받아오기
	 * @param mem_pw - 사용자가 입력한 비번 받아오기
	 * @return
	 *********************************************************************************/
	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		// 물리적으로 떨어져 있는 오라클 서버와 연결통로 만들기
		Connection 			con 	= null;
		// 오라클 서버에 작성한 select문 전달하고 오라클 서버에 처리 요청할 때 사용
		PreparedStatement 	pstmt 	= null;
		// 조회 결과를 자바코드로 가져올 때 필요 -  오라클 서버의 커서를 조작하는데 필요함.
		ResultSet           rs	 	= null;
		String result = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                                       ");
	    sql.append("   	   result                                ");
	    sql.append("  FROM (                                     ");
	    sql.append("    SELECT                                   ");
	    sql.append("          CASE WHEN mem_id=? THEN            ");
	    sql.append("            CASE WHEN mem_pw=? THEN mem_name ");
	    sql.append("                ELSE '0'                     ");
	    sql.append("            END                              ");
	    sql.append("          ELSE '-1'                          ");
	    sql.append("          END as result                      ");
	    sql.append("      FROM member2022                        ");
	    sql.append("     ORDER BY result desc                    ");
	    sql.append("   )                                         ");
	    sql.append("WHERE rownum = 1                             ");
	    DBConnectionMgr dbMgr = new DBConnectionMgr();
		try {
			con = dbMgr.getConnection();
			// ? 자리에 들어갈 아이디를 설정해야 함
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pw);
			// select처리시는 executeQuery()호출
			// insert,update,delete 처리시는 executeUpdate()호출
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mem_name = rs.getString("result");
			}
			System.out.println("result : "+ result);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return mem_name;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_login) {
			System.out.println("로그인 호출 성공");
			// 사용자가 화면에 입력하는 아이디를 담기
			String user_id = jtf_id.getText();
			// 사용자가 화면에 입력하는 비번을 담기
			String user_pw = jtf_pw.getText();
			// 오라클 서버에서 반환 값 담기
			String result = "";// 이름(1) or 0(비번이 틀림) or -1(아이디가 존재하지 않음)
			result = login(user_id, user_pw);
			//위에서 오라클 서버에 요청한 결과를 출력하기
			System.out.println("로그인 실행 결과  : "+result);
			if(result.length() > 0) {
				this.dispose();
				new MemberManager();
			}
		}
		else if(obj == jbtn_join) {
			System.out.println("회원가입 호출 성공");
			MemberShip ms = new MemberShip();
			ms.initDisplay();
		}
	}
}

