package calc.MainCalcFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import calc.Chart.CalcChart;
import calc.CalcPanel;
import calc.BtnAction.CalcBtnAction;
import calc.add.Calc_Add_Date;
import commute.Action.Add_Commute_Off_Time;
import commute.Action.Check_on_Time;
import commute.List.List_Input;


public class CalcMainFrame extends JFrame {


	public JPanel topView;
	public JPanel cView;
	public JPanel Calc_Btn;
	public CalcPanel clv = null;
	public JPanel calcBtnView;
	public ChartPanel chart_p = new ChartPanel(null);
	
	
	
	public CalcMainFrame() {
		
		
		
		clv=new CalcPanel(null,null);
		
		clv.chart_p = this.chart_p ;
		clv.m1 = this;
		
	}

}