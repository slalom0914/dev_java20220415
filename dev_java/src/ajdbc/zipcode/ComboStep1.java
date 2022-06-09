package ajdbc.zipcode;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboStep1 extends JFrame implements ItemListener{
	JPanel 		jp_north 		= null;
	JComboBox 	jcb_top 		= null;
	JComboBox 	jcb_mid 		= null;
	JComboBox 	jcb_bottom 		= null;
	String 		totals[]        = {"전체"};
	String    	top   		    = null;
	String    	mid   		    = null;
	String    	bottom 		    = null;
	String    	top_item[] 		= {"전체","가전","컴퓨터","모바일"};
	String 		mid_item0[] 	= {"전체","주방가전","생활가전","계절가전"};
	String 		mid_item1[] 	= {"전체","노트북","브랜드PC","모니터"};
	String 		mid_item2[] 	= {"전체","태블릿","휴대폰","스마트워치"};
	String 		bottom_item0[] 	= {"전체","냉장고","전기밥솥","에어프라이어"};
	String 		bottom_item1[] 	= {"전체","세탁기","옷건조기","청소기"};
	String 		bottom_item2[] 	= {"전체","온수매트","선풍기","에어컨"};
	public ComboStep1() {
		jp_north 	= new JPanel();
		jcb_top 	= new JComboBox(top_item);
		jcb_mid 	= new JComboBox(totals);
		jcb_bottom 	= new JComboBox(totals);
	}
	public void initDisplay() {
		jcb_top.addItemListener(this);
		jcb_mid.addItemListener(this);
		jcb_bottom.addItemListener(this);
		jp_north.setBackground(Color.orange);
		jp_north.add(jcb_top);
		jp_north.add(jcb_mid);
		jp_north.add(jcb_bottom);
		this.add("North",jp_north);
		this.setTitle("대중소분류 실습 2021");
		this.setSize(500,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ComboStep1 cs1 = new ComboStep1();
		cs1.initDisplay();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == jcb_top) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				System.out.println("선택한 TOP ===> "+top_item[jcb_top.getSelectedIndex()]);
				top = top_item[jcb_top.getSelectedIndex()];
				jcb_mid.removeAllItems();
				if("가전".equals(top)) {
					for(int i=0;i<mid_item0.length;i++) {
						jcb_mid.addItem(mid_item0[i]);
					}
				}
				else if("컴퓨터".equals(top)) {
					for(int i=0;i<mid_item1.length;i++) {
						jcb_mid.addItem(mid_item1[i]);
					}
				}
				else if("모바일".equals(top)) {
					for(int i=0;i<mid_item2.length;i++) {
						jcb_mid.addItem(mid_item2[i]);
					}
				}
			}
		}//////////////////////end of top
		if(obj == jcb_mid) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				//top이 가전이니?
				if("가전".equals(top)) {
					System.out.println("선택한 MID ===> "+mid_item0[jcb_mid.getSelectedIndex()]);
					mid = mid_item0[jcb_mid.getSelectedIndex()];
					System.out.println("mid : "+mid);
					if("주방가전".equals(mid)) {
						jcb_bottom.removeAllItems();
						for(int i=0;i<bottom_item0.length;i++) {
							jcb_bottom.addItem(bottom_item0[i]);
						}						
					}
					else if("생활가전".equals(mid)) {
						jcb_bottom.removeAllItems();
						for(int i=0;i<bottom_item1.length;i++) {
							jcb_bottom.addItem(bottom_item1[i]);
						}						
					}
					else if("계절가전".equals(mid)) {
						jcb_bottom.removeAllItems();
						for(int i=0;i<bottom_item2.length;i++) {
							jcb_bottom.addItem(bottom_item2[i]);
						}						
					}
				}
				//top이 컴퓨터니?
				else if("컴퓨터".equals(top)) {
					System.out.println("선택한 MID ===> "+mid_item1[jcb_mid.getSelectedIndex()]);
					mid = mid_item1[jcb_mid.getSelectedIndex()];
					System.out.println("mid : "+mid);
				}
				//top이 모바일이니?
				else if("모바일".equals(top)) {
					System.out.println("선택한 MID ===> "+mid_item2[jcb_mid.getSelectedIndex()]);
					mid = mid_item2[jcb_mid.getSelectedIndex()];
					System.out.println("mid : "+mid);
				}
			}
		}//////////////////////end of top
	}//////////////////////////end of itemStateChanged
}
