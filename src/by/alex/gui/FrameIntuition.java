package by.alex.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import by.alex.logic.LogicGame;

public class FrameIntuition extends JFrame {

	JButton buttonAction;

	JProgressBar barHumanLife;
	JProgressBar barCompLife;

	JList listChooseNumber;

	JLabel labelHumanLifeName;
	JLabel labelCompLifeName;
	JLabel labelChooseHero;
	JLabel labelChooseComp;
	JLabel labelHeroDamage;
	JLabel labelCompDamage;
	JLabel labelHelp;
	JLabel labelResult;

	JCheckBox chooseCheckBox;

	public void init () {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		
		buttonAction = new JButton("Ход");
		Font font = new Font("Arial", Font.BOLD, 30);
		buttonAction.setFont(font);
		buttonAction.setForeground(Color.BLACK);
		buttonAction.setBounds(416, 92, 150, 40);
		buttonAction.addMouseListener(new buttonMouseListener());
		add(buttonAction);

		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		barHumanLife = new JProgressBar ();
		barHumanLife.setStringPainted(true);
		barHumanLife.setMinimum(0);
		barHumanLife.setMaximum(10);
		barHumanLife.setValue(10);
		barHumanLife.setForeground(Color.GREEN);
		barHumanLife.setBackground(Color.WHITE);
		barHumanLife.setString(10 + "");
		barHumanLife.setPreferredSize(new Dimension(400, 50));
		barHumanLife.setFont(new Font ("Arial",Font.PLAIN, 50));
		barHumanLife.setBounds(93, 87, 230, 50);
		add(barHumanLife);


		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		barCompLife = new JProgressBar ();
		barCompLife.setStringPainted(true);
		barCompLife.setMinimum(0);
		barCompLife.setMaximum(5);
		barCompLife.setValue(5);
		barCompLife.setForeground(Color.GREEN);
		barCompLife.setBackground(Color.WHITE);
		barCompLife.setString(5 + "");
		barCompLife.setPreferredSize(new Dimension(400, 50));
		barCompLife.setFont(new Font ("Arial",Font.PLAIN, 50));
		barCompLife.setBounds(659, 87, 230, 50);
		add(barCompLife);


		String [] str = {"1","2","3","4","5","6","7","8","9"};
		listChooseNumber = new JList<String> (str);
		listChooseNumber.setBackground(UIManager.getColor("FormattedTextField.disabledBackground"));
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listChooseNumber.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		listChooseNumber.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listChooseNumber.setVisibleRowCount(9);
		listChooseNumber.setFont(new Font("Arial", Font.BOLD, 20));
		listChooseNumber.setBounds(168, 157, 86, 234);
		listChooseNumber.setSelectedIndex(0);
		add(listChooseNumber);


		labelHumanLifeName =new JLabel ();
		labelHumanLifeName.setFont(new Font("Verdana",Font.BOLD,30));
		labelHumanLifeName.setText("Жизнь героя");
		labelHumanLifeName.setForeground(Color.BLACK);
		labelHumanLifeName.setBounds(97, 40, 222, 30);
		add(labelHumanLifeName);


		labelCompLifeName =new JLabel ();
		labelCompLifeName.setFont(new Font("Verdana", Font.BOLD,30));
		labelCompLifeName.setText("Жизнь компа");
		labelCompLifeName.setForeground(Color.BLACK);
		labelCompLifeName.setBounds(658, 40, 232, 30);
		add(labelCompLifeName);


		labelChooseHero = new JLabel("Герой выбрал число "+ -1);
		labelChooseHero.setFont(new Font("Arial", Font.PLAIN, 20));
		labelChooseHero.setBounds(659, 211, 214, 20);
		add(labelChooseHero);
		labelChooseHero.setVisible(false);


		labelChooseComp = new JLabel("Комп выбрал число " + -1);
		labelChooseComp.setFont(new Font("Arial", Font.PLAIN, 20));
		labelChooseComp.setFont(new Font("Arial", Font.PLAIN, 20));
		labelChooseComp.setBounds(659, 242, 214, 20);
		add(labelChooseComp);
		labelChooseComp.setVisible(false);


		labelHeroDamage = new JLabel("Урон герою равен " + -1);
		labelHeroDamage.setFont(new Font("Arial", Font.PLAIN, 20));
		labelHeroDamage.setBounds(659, 273, 214, 20);
		add(labelHeroDamage);
		labelHeroDamage.setVisible(false);


		labelCompDamage = new JLabel("Урон компу равен " + -1);
		labelCompDamage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCompDamage.setBounds(659, 303, 214, 20);
		add(labelCompDamage);
		labelCompDamage.setVisible(false);


		labelHelp = new JLabel("Выберите цифру от 1 до 9. Отсчет по часовой стрелке или нет. Постарайтесь угадать число компа");
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(32, 402, 919, 25);
		add(labelHelp);


		labelResult = new JLabel();
		labelResult.setText("Ничья");
		labelResult.setForeground(Color.BLUE);
		labelResult.setFont(new Font("Verdana", Font.BOLD, 30));
		labelResult.setBounds(390, 40, 203, 30);
		add(labelResult);
		labelResult.setVisible(false);


		chooseCheckBox = new JCheckBox("По часовой стрелке");
		chooseCheckBox.setSelected(false);
		chooseCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
		chooseCheckBox.setBounds(292, 258, 207, 25);
		add(chooseCheckBox);

		setVisible(true);

	}
	public class buttonMouseListener implements MouseListener{
		public void mouseReleased(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {

		}
		public void mouseClicked(MouseEvent e) {
			if (buttonAction.getText().equals("Ход")) {

			boolean heroChooseCheckBox = chooseCheckBox.isSelected();
			int chooseHeroNumber = Integer.valueOf(listChooseNumber.getSelectedIndex()) + 1;
			LogicGame.setCurrentHumanLife( barHumanLife.getValue());
			LogicGame.setCurrentCompLife( barCompLife.getValue());
			labelChooseHero.setText("Герой выбрал число "+ chooseHeroNumber);
			
			LogicGame.calculate(heroChooseCheckBox, chooseHeroNumber);
			labelChooseComp.setText("Комп выбрал число " + LogicGame.getChooseCompNumber());
			labelHeroDamage.setText("Урон герою равен " + LogicGame.getHeroDamage());
			labelCompDamage.setText("Урон компу равен " + LogicGame.getCompDamage());
			
			barHumanLife.setValue(LogicGame.getCurrentHumanLife());
			barHumanLife.setString(LogicGame.getCurrentHumanLife() + "");
			barCompLife.setValue(LogicGame.getCurrentCompLife());
			barCompLife.setString(LogicGame.getCurrentCompLife() + "");
			
			labelChooseHero.setVisible(true);
			labelChooseComp.setVisible(true);
			labelHeroDamage.setVisible(true);
			labelCompDamage.setVisible(true);
			labelHelp.setVisible(false);
			
			chooseCheckBox.setEnabled(false);
			listChooseNumber.setEnabled(false);

			if (LogicGame.getCurrentHumanLife() == 0){
				labelResult.setText("Поражение");
				labelResult.setVisible(true);
			}
			
			if (LogicGame.getCurrentCompLife() == 0){
				labelResult.setText("   Победа");
				labelResult.setVisible(true);
			}
			
			buttonAction.setText("Далее");
			
			} else {
				
				chooseCheckBox.setEnabled(true);
				listChooseNumber.setEnabled(true);
				
				labelChooseHero.setVisible(false);
				labelChooseComp.setVisible(false);
				labelHeroDamage.setVisible(false);
				labelCompDamage.setVisible(false);
				labelHelp.setVisible(true);
				labelResult.setVisible(false);
				
				if ((LogicGame.getCurrentHumanLife() == 0) || (LogicGame.getCurrentCompLife() == 0)){
					LogicGame.setCurrentHumanLife(10);
					LogicGame.setCurrentCompLife(5);
					barHumanLife.setValue(10);
					barHumanLife.setString(10 + "");
					barCompLife.setValue(5);
					barCompLife.setString(5 + "");	
				}
				
				buttonAction.setText("Ход");

			}

		}
	}
}



