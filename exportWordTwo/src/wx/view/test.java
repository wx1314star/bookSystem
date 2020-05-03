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

public class test {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 6, 435, 50);
		frame.getContentPane().add(panel);

		JLabel label = new JLabel("是为产主笔的：");
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);

		textField = new JTextField();
		panel.add(textField);
		textField.setText("123");
		textField.setColumns(20);

		JButton button = new JButton("123");
		panel.add(button);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-27, 49, 435, 39);
		frame.getContentPane().add(panel_1);

		JLabel label_1 = new JLabel("是为产主笔的：");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);

		panel_1.add(label_1);

		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(15);

		JButton button_2 = new JButton("345");
		panel_1.add(button_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 100, 289, 156);
		frame.getContentPane().add(panel_2);
		// panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JList list = new JList();
		list.setToolTipText("");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "mk-oin-001", "mk-oin-002", "mk-oin-003" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		list.setVisibleRowCount(5);
		panel_2.add(list);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 255, 435, 62);
		frame.getContentPane().add(panel_3);

		JLabel label_2 = new JLabel("是为产主笔的：");
		panel_3.add(label_2);

		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(20);

		JButton button_4 = new JButton("56");
		panel_3.add(button_4);
	}

}
