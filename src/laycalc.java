import java.awt.*; //imports all utils to make GUI and stuff
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class laycalc extends JFrame implements ActionListener, ItemListener
{
	JTextField t1, t2;
	JTextField a1, a2, a3, a4, a5, a6, a7, a8;
	JLabel la1, la2, l1, l2;
	JCheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8;
	JButton b1;
	String s1s, s2s;
	double d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;//d9 and d10 are textfields
	JList colorlist;
	static String colors[] = {"Black", "Blue", "Green", "Pink", "Yellow", "Orange", "Red", "White"};
	static Color pcolors[] = {Color.BLACK, Color.BLUE, Color.GREEN, Color.PINK, Color.YELLOW, Color.ORANGE, Color.RED, Color.WHITE};
	public laycalc()
	{
		super("Epic Calculator by ©Johnny Ceja Officially done: 01/14/2013"); //title
		setLayout(new FlowLayout());
		
		l1 = new JLabel("PRESS 'ENTER' ON YOUR KEYBOARD AFTER ENTERING EACH NUMBER");
		add(l1);
		la1 = new JLabel("Enter first number here:"); //creates label that instructs user to enter number in the next JTextField
		add(la1);
		t1 = new JTextField(8); //creates JTextField to input first number
		add(t1);
		la2 = new JLabel("Enter second number here:"); // self explanatory, enter 2nd number
		add(la2);
		t2 = new JTextField(8); //creates JTextField to input second number
		add(t2);
		l1 = new JLabel("Addition answer: ");
		add(l1);
		a1 = new JTextField(8); //addition text
		add(a1);
		l1 = new JLabel("Subtraction answer: ");
		add(l1);
		a2 = new JTextField(8); //subtraction text
		add(a2);
		l1 = new JLabel("Multiplication answer: ");
		add(l1);
		a4 = new JTextField(8); //division text
		add(a4);
		l1 = new JLabel("Division answer: ");
		add(l1);
		a3 = new JTextField(9); //multiplication text
		add(a3);
		l1 = new JLabel("Squareroot answer: ");
		add(l1);
		a5 = new JTextField(8); //Squareroot text
		add(a5);
		l1 = new JLabel("Square answer: ");
		add(l1);
		a6 = new JTextField(8); //Square text
		add(a6);
		l1 = new JLabel("Area answer: ");
		add(l1);
		a7 = new JTextField(8);//Area of circle text
		add(a7);
		l1 = new JLabel("Circumference answer: ");
		add(l1);
		a8 = new JTextField(8);//Circumference of circle text
		add(a8);
		
		ch1 = new JCheckBox("Addition"); //adds check box for all operations
		add(ch1);
		ch2 = new JCheckBox("Subtraction");
		add(ch2);
		ch4 = new JCheckBox("Multiplication");
		add(ch4);
		ch3 = new JCheckBox("Division");
		add(ch3);
		ch5 = new JCheckBox("Squareroot");
		add(ch5);
		ch6 = new JCheckBox("Square");
		add(ch6);
		ch7 = new JCheckBox("Area of Circle");
		add(ch7);
		ch8 = new JCheckBox("Circumference of circle");
		add(ch8);
		
		t1.addActionListener(this);// adds all to action and item listener
		t2.addActionListener(this);
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);	
		ch4.addItemListener(this);
		ch5.addItemListener(this);
		ch6.addItemListener(this);
		ch7.addItemListener(this);
		ch8.addItemListener(this);
		
		Icon c = new ImageIcon(getClass().getResource("C.png"));
		b1 = new JButton(c);
		add(b1);
		Icon ch = new ImageIcon (getClass(). getResource("Ch.png"));
		b1.setRolloverIcon(ch);
		l2 = new JLabel("Calculator programmed by Johnny Ceja with Java.");//disclaimer?
		add(l2);
		Icon logo = new ImageIcon(getClass().getResource("jc logo.png"));
		
		l1 = new JLabel(logo);
		add(l1);
		
		colorlist = new JList(colors); // adds list of colors
		colorlist.setVisibleRowCount(4); //set visible row count of 2
		colorlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // can select only 1 at a time
		add(new JScrollPane(colorlist)); //adds scroll bar
		
		colorlist.addListSelectionListener(
				new ListSelectionListener() // bypasses having to create new class
				{
					public void valueChanged(ListSelectionEvent event)
					{
						getContentPane().setBackground(pcolors[colorlist.getSelectedIndex()]);//set background to what click
					}
				}
					
					
			);
	}
		
		public void actionPerformed(ActionEvent event)
		{
			b1.addActionListener(this);
			if(event.getSource() == b1)
			{
				String empt = "";
				t1.setText(empt);
				t2.setText(empt);
			}
			if(event.getSource() == t1)
			{
				s1s = event.getActionCommand();//string = text box
				d9 = Double.valueOf(s1s.trim()).doubleValue();	//double = text  box
			}
			if(event.getSource() == t2)
			{
				s2s = event.getActionCommand();//string = text box
				d10 = Double.valueOf(s2s.trim()).doubleValue();	//double = text  box
			}
			System.out.println(d9 + d10); //for de-bugging purposes
		}
		public void itemStateChanged(ItemEvent event1)
		{
			if(event1.getSource() == b1)
			{
				String empt = "";
				d9 = 0; //the text goes away but the double d9 and d10 remains, this resets it to 0
				d10 = 0;//^^^ however it is not working
				t1.setText(empt);//makes the text in the t1 and t2 empty
				t2.setText(empt);//^^^
				a7.setText(empt);//text does not go away by it self, have to do it manually which is this
				a8.setText(empt);//^^^
			}
		
			if(event1.getSource() == ch1)
			{
				
				String tot1 = ch1.isSelected() ? " " + (d9 + d10):"";//addition
				a1.setText(tot1);
			}
			else if(event1.getSource() == ch2)
			{
				
				String tot2 = ch2.isSelected() ? " " + (d9 - d10):""; //subtraction
				a2.setText("\n" + tot2);
			}
			else if(event1.getSource() == ch3)
			{
				String tot3 = ch3.isSelected() ? " " + (d9/d10):"";//division
				a3.setText("\n" + tot3);
				if(d10 == 0)
				{
					a3.setText("*World Explodes*"); //if divide by 0...
				}
			}
			else if(event1.getSource() == ch4)
			{
				String tot4 = ch4.isSelected() ? " " + (d9*d10):"";//multiplication
				a4.setText("\n" + tot4);
			}
			else if(event1.getSource() == ch5)
			{
				String tot5 = ch5.isSelected() ? " " + (Math.sqrt(d9) + " and " + Math.sqrt(d10)):"";//Squareroot
				a5.setText(tot5);
			}
			else if(event1.getSource() == ch6)
			{
				String tot6 = ch6.isSelected() ? " " + (Math.pow(d9, 2) + " and " + Math.pow(d10, 2)):"";//square
				a6.setText(tot6);
			}
			else if(event1.getSource() == ch7) // area of circle
			{
				String tot7 = ch7.isSelected() ? " " + (d5 = (d3 = d9 * d9) * (3.14159)) + " and " + (d6 = (d4 = d10 * d10) * (3.14159)): " ";
				a7.setText(d5 + " and " + d6);
			}
			else if(event1.getSource() == ch8) //circumference of circle
			{
				String tot8 = ch8.isSelected() ? " " + (d7 = (d3 = d9 * 2) * (3.14159)) + (d8 = (d3 = d10 * 2) * (3.14159)): " ";
				a8.setText(d7 + " and " + d8);
			}
		}
}