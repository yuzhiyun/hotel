//package manager;
//
//import java.util.Date;
//import java.util.Calendar;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Point;
//import java.awt.Dimension;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.Component;
//import java.awt.Cursor;
//import java.awt.Frame;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.JSpinner;
//import javax.swing.JSpinner.NumberEditor;
//import javax.swing.SpinnerNumberModel;
//import javax.swing.SwingUtilities;
//import javax.swing.SwingConstants;
//import javax.swing.event.ChangeListener;
//import javax.swing.event.ChangeEvent;
//import javax.swing.border.LineBorder;
//
//public class DateChooserJButton extends JButton {
//
//	private DateChooser dateChooser = null;//继承自面板，为内部类
//	private String preLabel = "";
//
//	public DateChooserJButton() {
//		this(getNowDate());//调用其他的构造方法
//	}
//
//	public DateChooserJButton(SimpleDateFormat df, String dateString) {
//		this();//干嘛的？
//		setText(df, dateString);
//	}
//
//	public DateChooserJButton(Date date) {
//		this("", date);
//	}
//
//	public DateChooserJButton(String preLabel, Date date) {
//		if (preLabel != null)
//			this.preLabel = preLabel;
//		setDate(date);
//		setBorder(null);
//		setCursor(new Cursor(Cursor.HAND_CURSOR));
//		
//		//点击按钮，就会弹出那个日期选择器
//		super.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (dateChooser == null)
//					dateChooser = new DateChooser();
//				Point p = getLocationOnScreen();
//				p.y = p.y + 30;
//				dateChooser.showDateChooser(p);//把选择框显示出来
//			}
//		});
//	}
//
//	private static Date getNowDate() {
//		return Calendar.getInstance().getTime();
//	}
//
//	private static SimpleDateFormat getDefaultDateFormat() {
//		//return new SimpleDateFormat("yyyy-MM-dd HH:MM:ss"); // 按钮显示的日期格式
//		return new SimpleDateFormat("yyyy-MM-dd"); // 按钮显示的日期格式
//	}
//
//	/**
//	 * 该类的构造方法被链式调用，构造方法一出来就会导致public void setDate(Date date)被调用，按钮会显示出当前日期，然后程序静止，等待用户点击按钮
//	 * 直到按钮被点击就会显示出日期选择器
//	 * */
//	// 覆盖父类的方法
//	public void setText(String s) {
//		
//		Date date;
//		try {
//			date = getDefaultDateFormat().parse(s);
//		} catch (ParseException e) {
//			date = getNowDate();//如果获取失败，就默认为当前时间
//		}
//		//System.out.println("日期"+s);
//		setDate(date);
//	}
//
//	public void setText(SimpleDateFormat df, String s) {
//		Date date;
//		try {
//			date = df.parse(s);
//		} catch (ParseException e) {
//			date = getNowDate();								//不理解啊！！！！！！！！！！1
//		}
//		setDate(date);
//		System.out.println("日期"+s);
//	}
//
//	public void setDate(Date date) {
//		super.setText(preLabel + getDefaultDateFormat().format(date));//使按钮显示时间
//	}
//
//	public Date getDate() {
//		String dateString = getText().substring(preLabel.length());
//		try {
//			return getDefaultDateFormat().parse(dateString);
//		} catch (ParseException e) {
//			return getNowDate();
//		}
//	}
//
//	// 覆盖父类的方法使之无效
//	public void addActionListener(ActionListener listener) {
//	}
//
//	/**
//	 * 日期选择内部类
//	 * *******************************************************************************************/
//	private class DateChooser extends JPanel implements ActionListener,
//			ChangeListener {
//		int startYear = 1980; // 默认【最小】显示年份
//		int lastYear = 2050; // 默认【最大】显示年份
//		int width = 200; // 界面宽度
//		int height = 200; // 界面高度
//		Color backGroundColor = Color.gray; // 底色
//		// 月历表格配色----------------//
//		Color palletTableColor = Color.white; // 日历表底色
//		Color todayBackColor = Color.orange; // 今天背景色
//		Color weekFontColor = Color.blue; // 星期文字色
//		Color dateFontColor = Color.black; // 日期文字色
//		Color weekendFontColor = Color.red; // 周末文字色
//		// 控制条配色------------------//
//		Color controlLineColor = Color.pink; // 控制条底色
//		Color controlTextColor = Color.white; // 控制条标签文字色
//		Color rbFontColor = Color.white; // RoundBox文字色
//		Color rbBorderColor = Color.red; // RoundBox边框色
//		Color rbButtonColor = Color.pink; // RoundBox按钮色
//		Color rbBtFontColor = Color.red; // RoundBox按钮文字色
//		JDialog dialog;
//		JSpinner yearSpin;
//		JSpinner monthSpin;
//		//JSpinner hourSpin;
//		JButton[][] daysButton = new JButton[6][7];// 一个月的日期
//
//		DateChooser() {
//			setLayout(new BorderLayout());
//			setBorder(new LineBorder(backGroundColor, 2));
//			setBackground(backGroundColor);
//			JPanel topYearAndMonth = createYearAndMonthPanal();
//			add(topYearAndMonth, BorderLayout.NORTH);
//			JPanel centerWeekAndDay = createWeekAndDayPanal();
//			add(centerWeekAndDay, BorderLayout.CENTER);
//		}
//
//		private JPanel createYearAndMonthPanal() {
//			Calendar c = getCalendar();
//			int currentYear = c.get(Calendar.YEAR);
//			int currentMonth = c.get(Calendar.MONTH) + 1;
//			int currentHour = c.get(Calendar.HOUR_OF_DAY);
//			JPanel result = new JPanel();
//			result.setLayout(new FlowLayout());
//			result.setBackground(controlLineColor);
//			yearSpin = new JSpinner(new SpinnerNumberModel(currentYear,
//					startYear, lastYear, 1));
//			yearSpin.setPreferredSize(new Dimension(48, 20));
//			yearSpin.setName("Year");
//			yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
//			yearSpin.addChangeListener(this);
//			result.add(yearSpin);
//			JLabel yearLabel = new JLabel("年");
//			yearLabel.setForeground(controlTextColor);
//			result.add(yearLabel);
//			monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1,
//					12, 1));
//			monthSpin.setPreferredSize(new Dimension(35, 20));
//			monthSpin.setName("Month");
//			monthSpin.addChangeListener(this);
//			result.add(monthSpin);
//			JLabel monthLabel = new JLabel("月");
//			monthLabel.setForeground(controlTextColor);
//			result.add(monthLabel);
////			hourSpin = new JSpinner(new SpinnerNumberModel(currentHour, 0, 23,
////					1));
////			hourSpin.setPreferredSize(new Dimension(35, 20));
////			hourSpin.setName("Hour");
////			hourSpin.addChangeListener(this);
////			result.add(hourSpin);
////			//JLabel hourLabel = new JLabel("时");
////			hourLabel.setForeground(controlTextColor);
////			result.add(hourLabel);
//			return result;
//		}
//
//		private JPanel createWeekAndDayPanal() {
//			String colname[] = { "日", "一", "二", "三", "四", "五", "六" };
//			JPanel result = new JPanel();
//			// 设置固定字体，以免调用环境改变影响界面美观
//			result.setFont(new Font("宋体", Font.PLAIN, 12));
//			result.setLayout(new GridLayout(7, 7));
//			result.setBackground(Color.white);
//			JLabel cell;
//			for (int i = 0; i < 7; i++) {
//				cell = new JLabel(colname[i]);
//				cell.setHorizontalAlignment(JLabel.RIGHT);
//				if (i == 0 || i == 6)
//					cell.setForeground(weekendFontColor);
//				else
//					cell.setForeground(weekFontColor);
//				result.add(cell);
//			}
//			int actionCommandId = 0;
//			for (int i = 0; i < 6; i++)
//				for (int j = 0; j < 7; j++) {
//					JButton numberButton = new JButton();
//					numberButton.setBorder(null);
//					numberButton.setHorizontalAlignment(SwingConstants.RIGHT);
//					numberButton.setActionCommand(String
//							.valueOf(actionCommandId));
//					numberButton.addActionListener(this);
//					numberButton.setBackground(palletTableColor);
//					numberButton.setForeground(dateFontColor);
//					if (j == 0 || j == 6)
//						numberButton.setForeground(weekendFontColor);
//					else
//						numberButton.setForeground(dateFontColor);
//					daysButton[i][j] = numberButton;
//					result.add(numberButton);
//					actionCommandId++;
//				}
//			return result;
//		}
//
//		private JDialog createDialog(Frame owner) {
//			JDialog result = new JDialog(owner, "日期时间选择", true);
//			result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
//			result.getContentPane().add(this, BorderLayout.CENTER);
//			result.pack();
//			result.setSize(width, height);
//			return result;
//		}
//
//		void showDateChooser(Point position) {
//			Frame owner = (Frame) SwingUtilities
//					.getWindowAncestor(DateChooserJButton.this);
//			if (dialog == null || dialog.getOwner() != owner)
//				dialog = createDialog(owner);
//			dialog.setLocation(getAppropriateLocation(owner, position));
//			flushWeekAndDay();
//			dialog.show();
//		}
//
//		Point getAppropriateLocation(Frame owner, Point position) {
//			Point result = new Point(position);
//			Point p = owner.getLocation();
//			int offsetX = (position.x + width) - (p.x + owner.getWidth());
//			int offsetY = (position.y + height) - (p.y + owner.getHeight());
//			if (offsetX > 0) {
//				result.x -= offsetX;
//			}
//			if (offsetY > 0) {
//				result.y -= offsetY;
//			}
//			return result;
//		}
//
//		private Calendar getCalendar() {
//			Calendar result = Calendar.getInstance();
//			result.setTime(getDate());
//			return result;
//		}
//
//		private int getSelectedYear() {
//			return ((Integer) yearSpin.getValue()).intValue();
//		}
//
//		private int getSelectedMonth() {
//			return ((Integer) monthSpin.getValue()).intValue();
//		}
//
////		private int getSelectedHour() {
////			return ((Integer) hourSpin.getValue()).intValue();
////		}
//
//		private void dayColorUpdate(boolean isOldDay) {
//			Calendar c = getCalendar();
//			int day = c.get(Calendar.DAY_OF_MONTH);
//			c.set(Calendar.DAY_OF_MONTH, 1);
//			int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
//			int i = actionCommandId / 7;
//			int j = actionCommandId % 7;
//			if (isOldDay)
//				daysButton[i][j].setForeground(dateFontColor);
//			else
//				daysButton[i][j].setForeground(todayBackColor);
//		}
//
//		private void flushWeekAndDay() {
//			Calendar c = getCalendar();
//			c.set(Calendar.DAY_OF_MONTH, 1);
//			int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
//			int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);
//			for (int i = 0; i < 6; i++) {
//				for (int j = 0; j < 7; j++) {
//					String s = "";
//					if (dayNo >= 1 && dayNo <= maxDayNo)
//						s = String.valueOf(dayNo);
//					daysButton[i][j].setText(s);
//					dayNo++;
//				}
//			}
//			dayColorUpdate(false);
//		}
//
//		//这是那个JSpinner监听事件，有
//		public void stateChanged(ChangeEvent e) {
//			JSpinner source = (JSpinner) e.getSource();
//			Calendar c = getCalendar();
////			if (source.getName().equals("Hour")) {
////				c.set(Calendar.HOUR_OF_DAY, getSelectedHour());
////				setDate(c.getTime());
////				return;
////			}
//			dayColorUpdate(true);
//			if (source.getName().equals("Year"))
//				c.set(Calendar.YEAR, getSelectedYear());
//			else
//				// (source.getName().equals("Month"))
//				c.set(Calendar.MONTH, getSelectedMonth() - 1);
//			setDate(c.getTime());//我等下在这里把时间用2个textvIew显示出来，然后插入数据库
//			/**
//			 * 注意：
//			 * 只有调用setDate的时候才会把时间设置在那个按钮DateChooserJButton里面
//			 * 这个文件里只有2处setDate方法被调用， 包括在stateChanged这里选择年，月，还有在actionPerformed里面选择日的时候**/
//			flushWeekAndDay();
//		}
//
//		//日期按钮监听
//		public void actionPerformed(ActionEvent e) {
//			JButton source = (JButton) e.getSource();
//			if (source.getText().length() == 0)
//				return;
//			dayColorUpdate(true);
//			source.setForeground(todayBackColor);
//			int newDay = Integer.parseInt(source.getText());//获取日。
//			Calendar c = getCalendar();
//			c.set(Calendar.DAY_OF_MONTH, newDay);
//			setDate(c.getTime());
//			
//			System.out.println(c.getTime());
//			//输出Wed Feb 18 22:00:31 CST 2015
//			System.out.println(""+ getDefaultDateFormat().format(c.getTime()));
//			//输出2015-02-18 22:02:31
//		}
//	}// end class DateChooser
//
//}
