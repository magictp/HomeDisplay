package tp.homeDisplay.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import tp.homeDisplay.controller.MainFormController;

public class MainForm {

	private static final int border = 1;
	static JLabel busLabel = new JLabel();
	static JLabel weatherLabel = new JLabel();
	static JLabel memoLabel = new JLabel();
	static JLabel newsLabel = new JLabel();
	static JLabel clockLabel = new JLabel();
	static JLabel photoLabel = new JLabel();
	String newsString = "";
	boolean isNewsUpdated = false;

	public void CreateJFrame() {
		JFrame jf = new JFrame("这是一个JFrame窗体"); // 实例化一个JFrame对象
		jf.setVisible(true); // 设置窗体可视
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH); // 设置窗体大小
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置窗体关闭方式

		int fHeight = jf.getHeight();
		int fWidth = jf.getWidth();

		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout());
		jp.setLocation(0, 0);
		jp.setBorder(BorderFactory.createLineBorder(Color.BLUE, border));
		jp.setSize(fWidth, fHeight);

		busLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, border));
		busLabel.setText("this is bus information!");

		weatherLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, border));
		weatherLabel.setText("this is weather information!");

		memoLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, border));
		memoLabel.setText("this is memo information!");

		newsLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, border));
		newsLabel.setText("this is news information!");

		clockLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, border));
		clockLabel.setText("this is clock information!");

		photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, border));
		photoLabel.setText("this is photo information!");

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 0.5;

		// for bus
		c.ipadx = (int) (fWidth * 0.7);
		c.ipady = (int) (fHeight * 0.15);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridx = 0;
		c.gridwidth = 2;
		jp.add(busLabel, c);

		// for weather
		c.ipadx = (int) (fWidth * 0.3);
		c.ipady = (int) (fHeight * 0.15);
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.gridx = 2;
		c.gridwidth = 1;
		jp.add(weatherLabel, c);

		// for photo
		c.ipadx = (int) (fWidth * 0.4);
		c.ipady = (int) (fHeight * 0.5);
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridwidth = 1;
		jp.add(photoLabel, c);

		// for memo
		c.ipadx = (int) (fWidth * 0.2);
		c.ipady = (int) (fHeight * 0.5);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridwidth = 1;
		jp.add(memoLabel, c);

		// for clock
		c.ipadx = (int) (fWidth * 0.4);
		c.ipady = (int) (fHeight * 0.5);
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 2;
		c.gridwidth = 1;
		jp.add(clockLabel, c);

		// for news
		c.ipadx = (int) (fWidth);
		c.ipady = (int) (fHeight * 0.2);
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridx = 0;
		c.gridwidth = 3;
		jp.add(newsLabel, c);

		jf.add(jp);
	}

	public void init() {
		new MainForm().CreateJFrame(); // 调用CreateJFrame()方法
		updateInfo();
		new Timer(10000, taskPerformer).start();
		Thread newsScroll = new Thread() {
			public void run() {
				int i = 0;
				try {
					while (true) {
						if (i >= newsString.length()) {
							i = 0;
						}
						if (isNewsUpdated) {
							i = 0;
							isNewsUpdated = false;
						}
						newsLabel.setText(newsString.substring(i, newsString.length()));
						newsLabel.paintImmediately(newsLabel.getVisibleRect());
						if (i == 0) {
							i++;
							Thread.sleep(1000);
						} else if (i < newsString.length()) {
							i++;
							Thread.sleep(300);
						}
					}
				} catch (Exception e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
		};
		newsScroll.start();
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new MainForm().init();
	}

	ActionListener taskPerformer = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			updateInfo();
		}
	};

	private void updateInfo() {
		busLabel.setText(new MainFormController().getOncomingMetro());
		busLabel.paintImmediately(busLabel.getVisibleRect());
		try {
			newsString = new MainFormController().getLatestNews();
			isNewsUpdated = true;
			weatherLabel.setText(new MainFormController().getWeatherForecast());
			weatherLabel.paintImmediately(weatherLabel.getVisibleRect());
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}
}
