import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TempConverter extends JFrame implements ActionListener{

	private Container c; //A container is a component which can contain other components inside itself.
	private JLabel inlabel, outlabel, instate, outstate;
	private JTextArea inta, outta;
	private JRadioButton incel, inkel, infahr, outcel, outkel, outfahr;
	private JButton btn;
	double m, n;
	String st;

	TempConverter(){
		//getContentPane() method retrieves the content pane layer so that you can add an object to it.
		c = this.getContentPane();
		c.setBackground(Color.green);
		c.setLayout(null);

		inlabel = new JLabel("Input:");
		inlabel.setBounds(120, 20, 100, 20);
		c.add(inlabel);

		outlabel = new JLabel("Output:");
		outlabel.setBounds(120, 50, 100, 20);
		c.add(outlabel);

		inta = new JTextArea();
		inta.setBounds(170, 20, 130, 20);
		inta.setBackground(Color.white);
		c.add(inta);

		outta = new JTextArea();
		outta.setBounds(170, 50, 130, 20);
		outta.setBackground(Color.white);
		c.add(outta);

		instate = new JLabel("Input State:");
		instate.setBounds(70, 90, 100, 20);
		c.add(instate);

		outstate = new JLabel("Output State:");
		outstate.setBounds(300, 90, 100, 20);
		c.add(outstate);

		incel = new JRadioButton("Celsius");
		incel.setBounds(70, 120, 100, 30);
		c.add(incel);

		inkel = new JRadioButton("Kelvin");
		inkel.setBounds(70, 160, 100, 30);
		c.add(inkel);

		infahr = new JRadioButton("Fahrenheit");
		infahr.setBounds(70, 200, 100, 30);
		c.add(infahr);

		outcel = new JRadioButton("Celsius");
		outcel.setBounds(300, 120, 100, 30);
		c.add(outcel);

		outkel = new JRadioButton("Kelvin");
		outkel.setBounds(300, 160, 100, 30);
		c.add(outkel);

		outfahr = new JRadioButton("Fahrenheit");
		outfahr.setBounds(300, 200, 100, 30);
		c.add(outfahr);

		btn = new JButton("Convert");
		btn.setBounds(185, 270, 100, 30);
		c.add(btn);

		ButtonGroup grp1 = new ButtonGroup();
		ButtonGroup grp2 = new ButtonGroup();

		grp1.add(incel);
		grp1.add(inkel);
		grp1.add(infahr);
		grp2.add(outcel);
		grp2.add(outkel);
		grp2.add(outfahr);

		btn.addActionListener(this);
        incel.addActionListener(this);
        inkel.addActionListener(this);
        infahr.addActionListener(this);
        outcel.addActionListener(this);
        outkel.addActionListener(this);
        outfahr.addActionListener(this);
	
	}

	public static void main(String[] arags){
		
		TempConverter tc = new TempConverter();
		tc.setVisible(true);
		tc.setBounds(450, 200, 500, 400);
		tc.setTitle("Temparature Converter");
        tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tc.setResizable(true);
     }

     @Override
    	public void actionPerformed(ActionEvent e){

    		try {
            	if(e.getSource() == incel) {
                	String st = inta.getText();
                	double c = Double.parseDouble(st);
                	n = c;
            	}
            	else if(e.getSource() == inkel) {
                	String st = inta.getText();
                	double k = Double.parseDouble(st);
                	n = k-273;
            	}
            	else if(e.getSource() == infahr) {
                	String st = inta.getText();
                	double f = Double.parseDouble(st);
                	n = (5*(f-32))/9;
            	}
        	}
        	catch(Exception e1){
            	outta.setText("No input");
        	}
        	
        	if(e.getSource() == outcel){
        		
        		m = n;
				                outta.setText(m + "");

        	}
        	else if(e.getSource() == outkel){
        		
        		m = n+273;
				                outta.setText(m + "");

        	}
        	else if(e.getSource() == outfahr){
        		
        		m = (9*n)/5+32;
				                outta.setText(m + "");

        	}
        	if(e.getSource() == btn){
                outta.setText(m + "");
        	}
		}
}