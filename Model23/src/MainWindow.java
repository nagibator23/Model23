
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	private TutorListModel model;
	private JList<String> list;
	private JButton removeBut;
	private JButton add_btn;

	public MainWindow() {
	
			
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(640,480);
	setResizable(false);
	
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(21, 21, 303, 401);
	getContentPane().add(scrollPane);
	
	model=new TutorListModel();
	
	 list = new JList<String>(model);
	scrollPane.setViewportView(list);
	
	removeBut = new JButton("New button");
	removeBut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			model.removeElement(list.getSelectedValue());
			list.updateUI();
		}
	});
	removeBut.setBounds(343, 19, 89, 23);
	getContentPane().add(removeBut);
	
   add_btn = new JButton("add");
	add_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String s=JOptionPane.showInputDialog("enter your string here");
			model.addElement(s);
			list.updateUI();
		}
	});
	add_btn.setBounds(343, 71, 89, 23);
	getContentPane().add(add_btn);
	setVisible(true);
	list.updateUI();
	}
	public void addElement(String s){
		model.addElement(s);
	}
	public void removeElement(int index){
		model.removeElement(index);
		
	}
	public void updateUI(){
		list.updateUI();
	}
}