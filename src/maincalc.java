import javax.swing.JFrame;


class maincalc
{
	public static void main(String args[])
	{
		
		laycalc calc = new laycalc(); //pass all of code from laycalc
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close correctly
		calc.setSize(510,330); //set size in pixels
		calc.setVisible(true); //set to be able to see or be visible

	}

	
}
