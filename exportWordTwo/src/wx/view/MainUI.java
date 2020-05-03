package wx.view;

import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class MainUI {
	// region 属性
	// 定义组件
	JFrame jf;
	JLabel jlOne, jlTwo, jlThree;
	JTextField jtfOne, jtfTwo, jtfThree;
	JButton jbOne, jbTwo, jbThree;
	JPanel jpOne, jpTwo, jpThree, jpFour;
	JList jliOne;

	String num, total = null;

	public MainUI() {
		init();
	}

	private void init() {
//		JFrame jf = new JFrame();
//		jf.setTitle("导出word文件");
//		jf.setBounds(100, 100, 600, 380);
//		jf.getContentPane().setLayout(null);
//		jf.setLocationRelativeTo(null);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		jpOne = new JPanel();
//		jpOne.setBounds(0, 6, 435, 50);
//		jpTwo = new JPanel();
//		jpThree = new JPanel();
//		jpFour = new JPanel();
//		// 创建组件
//		jlOne = new JLabel("导入文件路径：");
//		jlOne.setHorizontalAlignment(SwingConstants.LEFT);
//		jlTwo = new JLabel("查询地块编号：");
//		jlTwo.setHorizontalAlignment(SwingConstants.LEFT);
//		jlThree = new JLabel("导出文件存储地址：");
//		jlThree.setHorizontalAlignment(SwingConstants.LEFT);
//
//		jtfOne = new JTextField(20);
//		jtfTwo = new JTextField(10);
//		jtfThree = new JTextField(20);
//		jliOne = new JList<WordTemplate>();
//		jbOne = new JButton("导入文件");
//		jbTwo = new JButton("查询");
//		jbThree = new JButton("导出文件");
//
//		// 设置监听
//		// jbOne.addActionListener(this);
//
//		// 面板加载第一部分
//		jpOne.add(jlOne);
//		jpOne.add(jtfOne);
//		jpOne.add(jbOne);
//
//		// 面板加载第二部分
//		jpTwo.add(jlTwo);
//		jpTwo.add(jtfTwo);
//		jpTwo.add(jbTwo);
//		// 面板加载第三部分
//		jpThree.add(jliOne);
//		jpThree.setLayout(new FlowLayout());
//		// 面板加载第四部分
//		jpFour.add(jlThree);
//		jpFour.add(jtfThree);
//		jpFour.add(jbThree);
//		// 添加到框架
//
//		jpTwo.setBounds(-27, 49, 435, 39);
//		jpThree.setBounds(0, 100, 289, 156);
//		jpFour.setBounds(0, 255, 435, 62);
//		jf.add(jpOne);
//		jf.add(jpTwo);
//		jf.add(jpThree);
//		jf.add(jpFour);
//
//		jf.setVisible(true);
		// jf.setResizable(false);

		jf = new JFrame();
		jf.setBounds(100, 100, 500, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);

		jpOne = new JPanel();
		jpOne.setBounds(0, 6, 435, 50);
		jf.getContentPane().add(jpOne);

		jlOne = new JLabel("导入文件路径：");
		jpOne.add(jlOne);
		jlOne.setHorizontalAlignment(SwingConstants.LEFT);

		jtfOne = new JTextField();
		jpOne.add(jtfOne);
		jtfOne.setText("123");
		jtfOne.setColumns(20);

		jbOne = new JButton("导入文件");
		jpOne.add(jbOne);

		jpTwo = new JPanel();
		jpTwo.setBounds(-27, 49, 435, 39);
		jf.getContentPane().add(jpTwo);

		jlTwo = new JLabel("查询地块编号：");
		jlTwo.setHorizontalAlignment(SwingConstants.LEFT);

		jpTwo.add(jlTwo);

		jtfThree = new JTextField();
		jpTwo.add(jtfThree);
		jtfThree.setColumns(15);

		jbTwo = new JButton("查询");
		jpTwo.add(jbTwo);

		jpThree = new JPanel();
		jpThree.setBounds(0, 100, 289, 156);
		jf.getContentPane().add(jpThree);
		// panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jliOne = new JList();
		jliOne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jliOne.setModel(new AbstractListModel() {
			String[] values = new String[] { "mk-oin-001", "mk-oin-002", "mk-oin-003" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		jliOne.setSelectedIndex(0);
		jliOne.setVisibleRowCount(5);
		jpThree.add(jliOne);

		jpFour = new JPanel();
		jpFour.setBounds(0, 255, 435, 62);
		jf.getContentPane().add(jpFour);

		jlThree = new JLabel("导出文件存储地址：");
		jpFour.add(jlThree);

		jtfThree = new JTextField();
		jpFour.add(jtfThree);
		jtfThree.setColumns(20);

		jbThree = new JButton("导出文件：");
		jpFour.add(jbThree);

	}

	public static void main(String[] args) {
		// new MainUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainUI().jf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
