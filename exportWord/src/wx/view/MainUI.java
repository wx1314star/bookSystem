package wx.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainUI {
	// region 属性
	// 定义组件
	JLabel jlOne, jlTwo, jlThree;
	JTextField jtfOne, jtfTwo, jtfThree;
	JButton jbOne, jbTwo, jbThree;
	JPanel jpOne, jpTwo, jpThree;
	JTable jtOne;

	String num, total = null;

	public MainUI() {
		init();
	}

	/**
	 * 初始化方法
	 */
	private void init() {
		// 定义一个窗体对象f，窗体名称为"一个简单窗口"

		JFrame f = new JFrame("一个简单窗口");

		/*
		 * 设置窗体左上角与显示屏左上角的坐标，
		 * 
		 * 离显示屏上边缘300像素，离显示屏左边缘300像素
		 */

		f.setLocation(300, 300); // f.setLocationRelativeTo(null);本语句实现窗口居屏幕中央

		f.setSize(300, 200); // 设置窗体的大小为300*200像素大小

		f.setResizable(false); // 设置窗体是否可以调整大小，参数为布尔值

		// 设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了

		f.setVisible(true);

//用户单击窗口的关闭按钮时程序执行的操作
//
//        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
//		jpOne = new JPanel();
//		jpTwo = new JPanel();
//		jpThree = new JPanel();
//		// 创建组件
//		jlOne = new JLabel("选择导入的Excel文件：");
//		jlTwo = new JLabel("请输入要查询的编号：");
//		jlThree = new JLabel("请输入要导出的word文件存储地址：");
//		jtfOne = new JTextField(10);
//		jtfTwo = new JTextField(10);
//		jtfThree = new JTextField(10);
//		jbOne = new JButton("导入文件");
//		jbTwo = new JButton("选择下列单个编号");
//		jbThree = new JButton("导出文件");
//
//		// 设置监听
//		jbOne.addActionListener(this);
//
//		jpOne.add(jlOne);
//		jpOne.add(jtfOne);
//		jpOne.add(jbOne);
//		this.add(jpOne);
//		this.setLayout(new GridLayout(4, 1));
//		this.setTitle("789789");
//		this.setSize(300, 200);
//		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setVisible(true);
//		this.setResizable(false);

	}

//	// 单击事件
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if ("导入文件".equals(e.getActionCommand())) {
//			FileDialog fdopen = new FileDialog(this, "打开", FileDialog.LOAD);
//			fdopen.setVisible(true);
//			System.out.println(fdopen.getDirectory() + fdopen.getFile());
//
//		} else if (e.getActionCommand() == "选择下列单个编号") {
//
//		} else if (e.getActionCommand() == "导出文件") {
//
//		}
//	}

	public static void main(String[] args) {
		new MainUI();
	}

}
