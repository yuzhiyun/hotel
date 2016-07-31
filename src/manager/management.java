package manager;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dataBaseOperation.Operation;

//import java.sql.Date;

public class management extends JFrame {

	JPanel p2 = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();

	public int Countdays = 0;// 居住天数
	JButton btnBook = new JButton("预定");
	JButton btnRegister = new JButton("登记");
	JButton btnAboutRoom = new JButton("房间信息");
	JButton btnChangeRoom = new JButton("换房间");
	JButton btnOtherService = new JButton("其他服务");
	JButton btnShowConsumption = new JButton("具体消费");
	JButton btnCheckOut = new JButton("结账");

	static String sStartDate = null;// 记录String型日期
	static String sEndDate = null;// 记录String型日期
	static String sTempDate = null;// 注意这是临时记录字符串型日期

	static Date dStartDate = null;
	static Date dEndDate = null;
	static Date dTempDate = null;// 注意这是临时记录Date型日期

	public management() {
		setLayout(new GridLayout(3, 3));
		// add(btnBook);
		// add(btnRegister);
		// add(btnAboutRoom);
		// add(btnChangeRoom);
		// add(btnOtherService);
		// add(btnFind);
		setLayout(new GridLayout(1, 2));
		label.setIcon(new ImageIcon("src/image/new1.jpg"));
		label2.setIcon(new ImageIcon("src/image/user1.jpg"));
		// label.setIcon(new ImageIcon("src/image/new.jpg"));
		add(label);
		add(p2);
		p2.setLayout(new GridLayout(4, 2));
		p2.add(btnBook);
		p2.add(btnRegister);
		p2.add(btnAboutRoom);
		p2.add(btnChangeRoom);
		p2.add(btnOtherService);
		p2.add(btnShowConsumption);
		p2.add(btnCheckOut);
		p2.add(label2);
		// 预定 按钮
		btnBook.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame("Motel 酒店管理————预定");
				// f.setUndecorated(true);
				f.setLayout(new GridLayout(7, 1));

				final JTextField txtSingleOrDouble = new JTextField("");
				final JTextField txtName = new JTextField("姓名");
				final JTextField txtPhone = new JTextField("电话");
				final JTextField txtIDNumber = new JTextField("身份证号码");
				final JRadioButton singleRoom;
				final JRadioButton doubleRoom;
				singleRoom = new JRadioButton("singleRoom");
				doubleRoom = new JRadioButton("doubleRoom");
				ButtonGroup group = new ButtonGroup();
				group.add(singleRoom);
				group.add(doubleRoom);
				// final JTextField txtPhoneNUmber = new JTextField(" 电话号码");
				final JTextField txtStartDate = new JTextField("入住开始日期");// 这只是显示出来，是不方便传递给数据库的，我得定义另外2个Date变量记录时间
				final JTextField txtEndDate = new JTextField("入住结束日期");
				final JButton btnChooseDate = new JButton("选择开始日期");
				final JButton btnChooseDate2 = new JButton("选择结束日期");
				JButton btnOK = new JButton();

				btnOK.setText("确定");
				btnOK.setFont(new Font("篆体", Font.CENTER_BASELINE, 11));
				// btnOK.setBackground(Color.lightGray);
				// btnChooseDate.setBackground(Color.lightGray);
				// btnChooseDate2.setBackground(Color.lightGray);

				// 给RadioGroup设置事件监听

				// group.setOnCheckedChangeListener(new
				// ButtonGroup.OnCheckedChangeListener() {
				// @Override
				// public void onCheckedChanged(ButtonGroup group, int
				// checkedId) {
				// // TODO Auto-generated method stub
				// if(checkedId==singleRoom.getId()){
				// //editText1.setText("单人房");
				// }else if(checkedId==doubleRoom.getId()){
				// //editText1.setText("双人房");
				// }
				// }
				// });
				singleRoom.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getSource() == singleRoom) {
							txtSingleOrDouble.setText("singleRoom");
						}
					}
				});
				doubleRoom.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getSource() == doubleRoom) {
							txtSingleOrDouble.setText("doubleRoom");
						}
					}
				});

				// txtName.setBackground(Color.lightGray);
				// txtPhone.setBackground(Color.lightGray);
				// txtIDNumber.setBackground(Color.lightGray);
				// txtStartDate.setBackground(Color.lightGray);
				// txtEndDate.setBackground(Color.lightGray);

				JPanel p1 = new JPanel(new GridLayout(1, 2));
				JPanel p2 = new JPanel(new GridLayout(1, 2));
				add(p1);
				p1.add(btnChooseDate);
				p1.add(txtStartDate);

				add(p2);
				p2.add(btnChooseDate2);
				p2.add(txtEndDate);

				f.add(txtName);
				f.add(txtPhone);
				f.add(txtIDNumber);

				JPanel p3 = new JPanel(new GridLayout(1, 2));

				p3.add(singleRoom);
				p3.add(doubleRoom);
				f.add(p3);
				f.add(p1);
				f.add(p2);

				JPanel p4 = new JPanel();
				p4.add(btnOK);
				f.add(p4);

				f.setSize(250, 230);
				f.setVisible(true);

				// 选择开始日期
				btnChooseDate.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						JFrame frame = new JFrame("选择开始日期");
						JPanel cp = new JPanel();
						DateChooserJButton button = new DateChooserJButton();
						button.setSize(100, 100);
						cp.add(button);
						frame.setContentPane(cp);
						frame.setSize(200, 200);
						frame.setVisible(true);
						// btnChooseDate.setText("Nihao");

						/*
						 * 当前窗口为这个窗口就会得到焦点，弹出其他页面就会失去焦点 我在这里给时间文本框赋值
						 */
						frame.addWindowFocusListener(new WindowFocusListener() {

							public void windowLostFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								// txtStartDate.setText("入住开始日期为:"+"\n"+dStartDate+"\n"+sStartDate);
								dStartDate = dTempDate;
								sStartDate = sTempDate;// 这个数据将被记录到数据库
								txtStartDate.setText(sTempDate);
								System.out.println("开始日期" + sStartDate);
								System.out.println(sTempDate);
							}

							public void windowGainedFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								System.out.println("得到焦点");
							}
						});
					}
				});

				// 选择入住结束日期
				btnChooseDate2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						JFrame frame = new JFrame("选择结束日期");
						JPanel cp = new JPanel();
						DateChooserJButton button = new DateChooserJButton();
						button.setSize(100, 100);
						cp.add(button);
						frame.setContentPane(cp);
						frame.setSize(200, 200);
						frame.setVisible(true);
						// btnChooseDate.setText("Nihao");

						/*
						 * 当前窗口为这个窗口就会得到焦点，弹出其他页面就会失去焦点 我在这里给时间文本框赋值
						 */
						frame.addWindowFocusListener(new WindowFocusListener() {

							public void windowLostFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								dEndDate = dTempDate;
								sEndDate = sTempDate;// 这个数据将被记录到数据库
								txtEndDate.setText(sTempDate);// 显示选择好的时间
								System.out.println("结束日期" + sEndDate);
								System.out.println(sTempDate);
							}

							public void windowGainedFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								System.out.println("得到焦点");
							}
						});
					}
				});
				/**
				 * 1.预定后在数据库customer表创建新的一行，写入顾客姓名，房间号，身份证，
				 * 2.以及在roominfor表更改对应房间的状态
				 * 3.在consumption中加入一条住房消费。这里还有住宿的天数，时间。
				 * */
				btnOK.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							final String name = txtName.getText().toString();

							final String IDnumber = txtIDNumber.getText()
									.toString();
							final String phoneNumber = txtPhone.getText()
									.toString();
							final String SingleOrDouble = txtSingleOrDouble
									.getText().toString();

							// 预定后在数据库customer表创建新的一行，写入顾客姓名，房间号，身份证
							// 我不知道该怎么处理Date数据转换了，于是重新设计数据库，改为用String型存储日期
							// 计算居住天数
							Countdays = (int) ((dEndDate.getTime() - dStartDate
									.getTime()) / 1000 / 60 / 60 / 24);
							Operation.insertCustomerInfor(name, IDnumber,
									sStartDate, sEndDate, Countdays,
									phoneNumber, SingleOrDouble);

							// System.out.println("住这么多天："+(dEndDate.getTime()-dStartDate.getTime())/1000/60/60/24);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		});
		// 预定后登记
		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				f.setLayout(new GridLayout(3, 2));
				f.setSize(400, 300);
				f.setVisible(true);

				Vector vName = new Vector();
				Vector vRoomNumber = new Vector();
				try {
					vName = Operation.getName();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int i = 1; i <= 13; i++)
					for (int j = 1; j <= 20; j++) {
						vRoomNumber.add("" + (i * 100 + j));
					}

				// 控件
				final JList listName = new JList(vName);
				JScrollPane scrollPaneListName = new JScrollPane();
				scrollPaneListName.setViewportView(listName);// 把listName放在可滚动面板scrollPane里面
				final JTextField txtName = new JTextField("姓名");

				final JList listRoomNumber = new JList(vRoomNumber);
				final JTextField txtRoomNumber = new JTextField(" 房间");
				listRoomNumber.setLayoutOrientation(JList.HORIZONTAL_WRAP);// 水平排列
				listRoomNumber
						.setFont(new Font("篆体", Font.CENTER_BASELINE, 15));
				listRoomNumber.setVisibleRowCount(13);// 行数
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setViewportView(listRoomNumber);
				// scrollPane2.getViewport().setBackground(Color.magenta);//
				// 设置滚动面板颜色，注意不是直接setBackground
				JScrollBar bar = scrollPane2.getHorizontalScrollBar();
				JScrollBar bar2 = scrollPane2.getVerticalScrollBar();
				// bar.setBackground(Color.CYAN);// 设置滚动条颜色
				// bar2.setBackground(Color.CYAN);// 设置滚动条颜色

				// 把已经预定的客户的姓名显示在这个列表里面，这样在预定后登记的时候就不用输入了，直接鼠标点击选择即可

				/*
				 * http://blog.csdn.net/andycpp/article/details/1737658 JList用法
				 */

				JButton btnOK = new JButton("OK");

				txtRoomNumber.setFont(new Font("篆体", Font.CENTER_BASELINE, 90));// 设置字体
				// txtRoomNumber.setBackground(Color.CYAN);
				// txtName.setFont(new Font("篆体", Font.CENTER_BASELINE, 40));//
				// 设置字体
				// txtName.setBackground(Color.CYAN);
				// scrollPane2.setViewportView(listRoomNumber);// 绑定显示内容

				listRoomNumber
						.addListSelectionListener(new ListSelectionListener() {

							public void valueChanged(ListSelectionEvent arg0) {
								txtRoomNumber.setText(""
										+ listRoomNumber.getSelectedValue());
							}
						});
				listName.addListSelectionListener(new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent arg0) {
						// JOptionPane.showMessageDialog(this, "我喜欢的小说："
						// +listName.getSelectedValue());
						// System.out.println("" +listName.getSelectedValue());
						txtName.setText("" + listName.getSelectedValue());
					}
				});
				f.add(scrollPaneListName);
				f.add(txtName);

				f.add(scrollPane2);
				f.add(txtRoomNumber);
				f.add(btnOK);

				// 修改isHasRegister属性
				btnOK.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String name = txtName.getText().toString();
						final String roomNumber = txtRoomNumber.getText()
								.toString();
						try {
							Operation.updateWhenRegister(name);
							Operation.updateWhenRegister(name, roomNumber);
							// 在roominfor表更改对应房间的状态，还有记录房间主人
							Operation.insertChangeRoomInfor(name, roomNumber);

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});
			}
		});
		// 呈现房间状态
		btnAboutRoom.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				f.setSize(1500, 1500);
				f.setVisible(true);
				f.setLayout(new GridLayout(20, 13));// 所有房间用按钮来显示
				// ImageIcon icon = new ImageIcon("src/image/left_back.jpg");

				for (int i = 1; i <= 20; i++)
					for (int j = 1; j <= 13; j++) {
						if (i <= 10) {
							try {
								if (Operation
										.FindInforByRoomnumber((i * 100 + j)
												+ "")) {
									// 去查询每个房间的入住状态，有人住的显示高亮颜色背景
									JButton temp = new JButton();
									temp.setText("单" + (i * 100 + j));
									// temp.setIcon(icon);
									temp.setBackground(Color.BLUE);
									final int I = i;// 由于在按钮点击的actionPerformed（0)里面如果要使用i,j，必须声明为final
													// ，这样for循环就无法进行
									final int J = j;
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {
											String Master = null;
											try {
												// //获取房间主人姓名
												Master = Operation
														.getMasterofRoom(""
																+ (I * 100 + J));
											} catch (UnsupportedEncodingException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											} catch (SQLException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											} finally {
												JOptionPane
														.showMessageDialog(
																null,
																(I * 100 + J)
																		+ "号房间 "
																		+ "\n"
																		+ "主人为"
																		+ Master
																		+ "\n"
																		+ "加大尺寸的、备有空调"
																		+ "\n"
																		+ "里面配有淋浴设备、25英寸立体彩色电缆电视、 电话、 完整的厨房、 "
																		+ "\n"
																		+ "烘干机、 带时钟的收音机以及房内的安全和急救装备");

											}

										}
									});
									f.add(temp);
								} else {
									JButton temp = new JButton();
									temp.setText("单" + (i * 100 + j));
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {

											JOptionPane
													.showMessageDialog(
															null,
															"暂时无人居住 "
																	+ "\n"
																	+ "加大尺寸的、备有空调"
																	+ "\n"
																	+ "里面配有淋浴设备、25英寸立体彩色电缆电视、 电话、 完整的厨房、 "
																	+ "\n"
																	+ "烘干机、 带时钟的收音机以及房内的安全和急救装备");
										}
									});
									f.add(temp);
								}
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						// 双人房
						else {
							try {
								if (Operation
										.FindInforByRoomnumber((i * 100 + j)
												+ "")) {
									// 去查询每个房间的入住状态，有人住的显示高亮颜色背景
									JButton temp = new JButton();
									temp.setText("双" + (i * 100 + j));
									// temp.setIcon(icon);
									temp.setBackground(Color.BLUE);
									final int I = i;// 由于在按钮点击的actionPerformed（0)里面如果要使用i,j，必须声明为final
													// ，这样for循环就无法进行
									final int J = j;
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {
											String Master = null;
											try {
												// //获取房间主人姓名
												Master = Operation
														.getMasterofRoom(""
																+ (I * 100 + J));
											} catch (UnsupportedEncodingException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											} catch (SQLException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}
											JOptionPane.showMessageDialog(null,
													(I * 100 + J) + "号房间 "
															+ "\n" + "居住人为"
															+ Master);
										}
									});
									f.add(temp);
								} else {
									JButton temp = new JButton();

									temp.setText("双" + (i * 100 + j));
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {

											JOptionPane
													.showMessageDialog(
															null,
															"暂时无人居住 "
																	+ "\n"
																	+ "加大尺寸的、备有空调"
																	+ "\n"
																	+ "里面配有淋浴设备、25英寸立体彩色电缆电视、 电话、 完整的厨房、 "
																	+ "\n"
																	+ "烘干机、 带时钟的收音机以及房内的安全和急救装备");
										}
									});
									f.add(temp);
								}
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
			}
		});

		btnChangeRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				f.setLayout(new GridLayout(1, 2));
				final JTextField oldNumber = new JTextField("已登记房号");
				final JTextField newNumber = new JTextField("更改房号");
				JPanel p1 = new JPanel(new GridLayout(2, 1));
				p1.add(oldNumber);
				p1.add(newNumber);
				f.add(p1);
				JPanel p2 = new JPanel();
				JButton b = new JButton("确认更换");
				p2.add(b);
				f.add(p2);
				f.setVisible(true);
				f.setSize(200, 100);
				b.addActionListener(new ActionListener() { // 点击确认更换按钮
					public void actionPerformed(ActionEvent e) {
						final String ID1 = oldNumber.getText().toString();
						final String ID2 = newNumber.getText().toString();
						System.out.println(ID1 + ID2);
						try {
							try {
								Operation.changeRoom(ID1, ID2);
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				});
			}
		});

		btnOtherService.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();
				JPanel p4 = new JPanel();

				f.setLayout(new GridLayout(4, 1));

				f.add(p1);
				f.add(p2);
				f.add(p3);
				f.add(p4);

				f.setVisible(true);
				f.setSize(350, 200);
				p1.setLayout(new GridLayout(1, 2));
				p2.setLayout(new GridLayout(1, 2));
				final JCheckBox c1 = new JCheckBox("酒吧");
				final JCheckBox c2 = new JCheckBox("网吧");
				final JCheckBox c3 = new JCheckBox("租车");
				final JCheckBox c4 = new JCheckBox("咖啡厅");
				p1.add(c1);
				p1.add(c2);
				p2.add(c3);
				p2.add(c4);
				final JTextField t = new JTextField("请输入房号");
				JButton b = new JButton("确认预定");
				p3.add(t);
				p4.add(b);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String roomNumber = t.getText();
						boolean a = c1.isSelected();
						boolean b = c2.isSelected();
						boolean c = c3.isSelected();
						boolean d = c4.isSelected();
						try {
							Operation.service(a, b, c, d, roomNumber);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						JOptionPane.showMessageDialog(null, "预定成功");
					}
				});
			}
		});
		btnCheckOut.addActionListener(new ActionListener() { // btnFInd这个按钮用于退房结账
					public void actionPerformed(ActionEvent e) {
						JFrame f = new JFrame();
						f.setLayout(new GridLayout(1, 2));
						final JTextField txtName = new JTextField("请输入姓名");
						final JTextField txtID = new JTextField("请输入房间号");
						JPanel p1 = new JPanel(new GridLayout(2, 1));
						p1.add(txtName);
						p1.add(txtID);
						f.add(p1);
						JPanel p2 = new JPanel();
						JButton b = new JButton("确定退房结账");
						p2.add(b);
						f.add(p2);
						f.setVisible(true);
						f.setSize(300, 100);
						b.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final String roomNumber = txtID.getText();
								try {
									Operation.checkout(roomNumber);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
					}
				});

		btnShowConsumption.addActionListener(new ActionListener() { // btnFInd这个按钮用于退房结账
					public void actionPerformed(ActionEvent e) {
						JFrame f = new JFrame();
						// f.setLayout(new FlowLayout(FlowLayout.CENTER));
						f.setLayout(new GridLayout(2, 1));

						f.setVisible(true);
						f.setSize(600, 200);
						// 表格
						String[] columnNames = { "name","pub","bar","taxi","coffee" ,"fareOfHousing","sum"};
						Object[][] data = null;
						final DefaultTableModel tableModel = new DefaultTableModel(
								data, columnNames);

						JTable table = new JTable(tableModel);
						// 我原本是直接用add（table），但是列名显示不出来，就是用了JScrollPane
						JScrollPane pane = new JScrollPane(table,
								ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
								ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

						JButton testAdd = new JButton("添加一行");// 添加一行
						// testAdd.setSize(100, 300);
						JPanel add = new JPanel(new GridLayout(1, 2));
						final JTextField textName = new JTextField("请输入需要查询的姓名");

						add.add(textName);
						add.add(testAdd);
						f.add(add);
						f.add(pane);
						testAdd.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {

								String name = textName.getText().toString();
								Vector rowValues =null;
								try {
									rowValues=Operation.consumption(name);
								} catch (UnsupportedEncodingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
//
//								String[] rowValues = { "Grapes", "String",
//										"2.00" };
								tableModel.addRow(rowValues); // 添加一行
							}
						});
					}
				});
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generat ed method stub

		management f = new management();
		f.setSize(400, 200);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Operation.Connect();// 连接数据库
		// Operation.test();
	}

	/**
	 * 内部类时间选择器，为了获取时间，把这个写在这里，以免访问问题不好处理
	 * ***************************************
	 * *****************************************************
	 * */
	public static class DateChooserJButton extends JButton {

		private DateChooser dateChooser = null;// 继承自面板，为内部类
		private String preLabel = "";

		public DateChooserJButton() {
			this(getNowDate());// 调用其他的构造方法
		}

		public DateChooserJButton(SimpleDateFormat df, String dateString) {
			this();// 干嘛的？
			setText(df, dateString);
		}

		public DateChooserJButton(Date date) {
			this("", date);
		}

		public DateChooserJButton(String preLabel, Date date) {
			if (preLabel != null)
				this.preLabel = preLabel;
			setDate(date);
			setBorder(null);
			setCursor(new Cursor(Cursor.HAND_CURSOR));

			// 点击按钮，就会弹出那个日期选择器
			super.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (dateChooser == null)
						dateChooser = new DateChooser();
					Point p = getLocationOnScreen();
					p.y = p.y + 30;
					dateChooser.showDateChooser(p);// 把选择框显示出来
				}
			});
		}

		private static Date getNowDate() {
			return Calendar.getInstance().getTime();
		}

		/**
		 * 2个重要的用法 getDefaultDateFormat().format(date)日期变字符串
		 * getDefaultDateFormat().parse(s) 字符串变日期
		 * */
		private static SimpleDateFormat getDefaultDateFormat() {
			// return new SimpleDateFormat("yyyy-MM-dd HH:MM:ss"); // 按钮显示的日期格式
			return new SimpleDateFormat("yyyy-MM-dd"); // 按钮显示的日期格式
		}

		/**
		 * 该类的构造方法被链式调用，构造方法一出来就会导致public void setDate(Date
		 * date)被调用，按钮会显示出当前日期，然后程序静止，等待用户点击按钮 直到按钮被点击就会显示出日期选择器
		 * */
		// 覆盖父类的方法
		public void setText(String s) {

			Date date;
			try {
				date = getDefaultDateFormat().parse(s);
			} catch (ParseException e) {
				date = getNowDate();// 如果获取失败，就默认为当前时间
			}
			// System.out.println("日期"+s);
			setDate(date);
		}

		public void setText(SimpleDateFormat df, String s) {
			Date date;
			try {
				date = df.parse(s);
			} catch (ParseException e) {
				date = getNowDate(); // 不理解啊！！！！！！！！！！1
			}
			setDate(date);
			// System.out.println("日期" + s);
		}

		public void setDate(Date date) {
			super.setText(preLabel + getDefaultDateFormat().format(date));// 使按钮显示时间
		}

		public Date getDate() {
			String dateString = getText();// 我用这个代码代替了下面
			// String dateString =
			// getText().substring(preLabel.length());//getText()表示按钮DateChooserJButton上的文本；
			// 子字符串在指定的字符位置开始并一直到该字符串的末尾。事实上preLabel.length()就是0
			try {
				return getDefaultDateFormat().parse(dateString);
			} catch (ParseException e) {
				return getNowDate();
			}
		}

		// 覆盖父类的方法使之无效
		public void addActionListener(ActionListener listener) {

		}

		/**
		 * 日期选择内部类
		 * *******************************************************************************************/
		private class DateChooser extends JPanel implements ActionListener,
				ChangeListener {
			int startYear = 1980; // 默认【最小】显示年份
			int lastYear = 2050; // 默认【最大】显示年份
			int width = 200; // 界面宽度
			int height = 200; // 界面高度
			Color backGroundColor = Color.gray; // 底色
			// 月历表格配色----------------//
			Color palletTableColor = Color.white; // 日历表底色
			Color todayBackColor = Color.orange; // 今天背景色
			Color weekFontColor = Color.blue; // 星期文字色
			Color dateFontColor = Color.black; // 日期文字色
			// 控制条配色------------------//
			Color controlLineColor = Color.pink; // 控制条底色
			Color controlTextColor = Color.white; // 控制条标签文字色
			JDialog dialog;
			JSpinner yearSpin;
			JSpinner monthSpin;
			// JSpinner hourSpin;
			JButton[][] daysButton = new JButton[6][7];// 一个月的日期

			DateChooser() {
				setLayout(new BorderLayout());
				setBorder(new LineBorder(backGroundColor, 2));// 神马？
				setBackground(backGroundColor);
				JPanel topYearAndMonth = createYearAndMonthPanal();
				add(topYearAndMonth, BorderLayout.NORTH);
				JPanel centerWeekAndDay = createWeekAndDayPanal();
				add(centerWeekAndDay, BorderLayout.CENTER);
			}

			private JPanel createYearAndMonthPanal() {
				// 获取日历对象
				Calendar c = getCalendar();
				int currentYear = c.get(Calendar.YEAR);
				int currentMonth = c.get(Calendar.MONTH) + 1;// 为什么 +1
				// int currentHour = c.get(Calendar.HOUR_OF_DAY);
				JPanel result = new JPanel();
				result.setLayout(new FlowLayout());
				result.setBackground(controlLineColor);
				// 构造一个具有指定 value、minimum/maximum 边界和 stepSize 的
				// SpinnerNumberModel。
				yearSpin = new JSpinner(new SpinnerNumberModel(currentYear,
						startYear, lastYear, 1));
				yearSpin.setPreferredSize(new Dimension(48, 20));
				yearSpin.setName("Year");
				yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
				yearSpin.addChangeListener(this);

				result.add(yearSpin);
				JLabel yearLabel = new JLabel("年");
				yearLabel.setForeground(controlTextColor);
				result.add(yearLabel);
				monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth,
						1, 12, 1));
				monthSpin.setPreferredSize(new Dimension(35, 20));
				monthSpin.setName("Month");
				monthSpin.addChangeListener(this);
				result.add(monthSpin);
				JLabel monthLabel = new JLabel("月");
				monthLabel.setForeground(controlTextColor);
				result.add(monthLabel);
				// hourSpin = new JSpinner(new SpinnerNumberModel(currentHour,
				// 0, 23,
				// 1));
				// hourSpin.setPreferredSize(new Dimension(35, 20));
				// hourSpin.setName("Hour");
				// hourSpin.addChangeListener(this);
				// result.add(hourSpin);
				// //JLabel hourLabel = new JLabel("时");
				// hourLabel.setForeground(controlTextColor);
				// result.add(hourLabel);
				return result;
			}

			private JPanel createWeekAndDayPanal() {
				String colname[] = { "日", "一", "二", "三", "四", "五", "六" };
				JPanel result = new JPanel();
				// 设置固定字体，以免调用环境改变影响界面美观
				result.setFont(new Font("宋体", Font.PLAIN, 12));
				result.setLayout(new GridLayout(7, 7));
				result.setBackground(Color.white);
				JLabel cell;
				for (int i = 0; i < 7; i++) {
					cell = new JLabel(colname[i]);
					cell.setHorizontalAlignment(JLabel.RIGHT);
					cell.setForeground(weekFontColor);
					result.add(cell);
				}

				int actionCommandId = 0;
				for (int i = 0; i < 6; i++)
					for (int j = 0; j < 7; j++) {
						JButton numberButton = new JButton();
						numberButton.setBorder(null);
						numberButton
								.setHorizontalAlignment(SwingConstants.RIGHT);
						/**
						 * 设置此组件激发的操作事件的命令名称。 如: JButton btnShow = new
						 * JButton(); btnShow.setActionCommand("show");
						 * 当这个按钮被点击的时候,你就可以用 ActionEvent 的
						 * getActionCommand().equals("show") 来辨识是点击了哪个按钮
						 */
						numberButton.setActionCommand(String
								.valueOf(actionCommandId));// 获取对应的字符串
						numberButton.addActionListener(this);
						numberButton.setBackground(palletTableColor);
						numberButton.setForeground(dateFontColor);
						numberButton.setForeground(dateFontColor);
						daysButton[i][j] = numberButton;
						result.add(numberButton);
						actionCommandId++;// 监听时就可以通过actionCommandId来辨识是点击了哪个按钮。
					}
				return result;
			}

			private JDialog createDialog(Frame owner) {
				JDialog result = new JDialog(owner, "日期时间选择", true);
				result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				result.getContentPane().add(this, BorderLayout.CENTER);// 这个this指的是本类最大的JPanel，实际上，弹出来的框是包含JPanel的一个JDialog。
				result.pack();// 调整此窗口的大小，以适合其子组件的首选大小和布局
				result.setSize(width, height);
				return result;
			}

			void showDateChooser(Point position) {
				Frame owner = (Frame) SwingUtilities
						.getWindowAncestor(DateChooserJButton.this);// 返回
																	// Component
																	// 的第一个
																	// Window 祖先
				if (dialog == null || dialog.getOwner() != owner)
					dialog = createDialog(owner);// 竟然要有一个Dialog???
				dialog.setLocation(getAppropriateLocation(owner, position));
				flushWeekAndDay();
				dialog.show();
			}

			Point getAppropriateLocation(Frame owner, Point position) {
				Point result = new Point(position);
				Point p = owner.getLocation();
				int offsetX = (position.x + width) - (p.x + owner.getWidth());
				int offsetY = (position.y + height) - (p.y + owner.getHeight());
				if (offsetX > 0) {
					result.x -= offsetX;
				}
				if (offsetY > 0) {
					result.y -= offsetY;
				}
				return result;
			}

			private Calendar getCalendar() {
				Calendar result = Calendar.getInstance();
				result.setTime(getDate());
				return result;
			}

			private int getSelectedYear() {
				return ((Integer) yearSpin.getValue()).intValue();
			}

			private int getSelectedMonth() {
				return ((Integer) monthSpin.getValue()).intValue();
			}

			// private int getSelectedHour() {
			// return ((Integer) hourSpin.getValue()).intValue();
			// } 
  
			private void dayColorUpdate(boolean isOldDay) {
				Calendar c = getCalendar();
				int day = c.get(Calendar.DAY_OF_MONTH);
				c.set(Calendar.DAY_OF_MONTH, 1);
				int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
				int i = actionCommandId / 7;
				int j = actionCommandId % 7;
				if (isOldDay)
					daysButton[i][j].setForeground(dateFontColor);
				else
					daysButton[i][j].setForeground(todayBackColor);
			}

			// 关于如何设置这个月的星期，这段代码很需要想象力了啊
			private void flushWeekAndDay() {
				Calendar c = getCalendar();
				c.set(Calendar.DAY_OF_MONTH, 1);// 时间设置为本月的1号
				int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);// 本月天数
				int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);// c.get(Calendar.DAY_OF_WEEK)表示本月一号是星期几，如果是星期一则返回2，以此类推，这样在for循环里面就可以正确画出月份图
				// System.out.println("星期 "+c.get(Calendar.DAY_OF_WEEK));
				// System.out.println(""+dayNo);
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						String s = "";
						if (dayNo >= 1 && dayNo <= maxDayNo)// 这个很重要
							s = String.valueOf(dayNo);
						daysButton[i][j].setText(s);
						dayNo++;
					}
				}
				dayColorUpdate(false);
			}

			// 这是那个JSpinner监听事件，有
			public void stateChanged(ChangeEvent e) {
				JSpinner source = (JSpinner) e.getSource();
				Calendar c = getCalendar();
				// if (source.getName().equals("Hour")) {
				// c.set(Calendar.HOUR_OF_DAY, getSelectedHour());
				// setDate(c.getTime());
				// return;
				// }
				dayColorUpdate(true);
				if (source.getName().equals("Year"))
					c.set(Calendar.YEAR, getSelectedYear());
				else
					// (source.getName().equals("Month"))
					c.set(Calendar.MONTH, getSelectedMonth() - 1);
				setDate(c.getTime());// 我等下在这里把时间用2个textvIew显示出来，然后插入数据库
				/** 
				 * 注意： 只有调用setDate的时候才会把时间设置在那个按钮DateChooserJButton里面
				 * 这个文件里只有2处setDate方法被调用，
				 * 包括在stateChanged这里选择年，月，还有在actionPerformed里面选择日的时候
				 **/
				dTempDate = c.getTime();// 记录Date型日期
				sTempDate = "" + getDefaultDateFormat().format(c.getTime());// 记录字符串型日期
				flushWeekAndDay();
			}

			// 日期按钮监听
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();// 获取到那个button
				if (source.getText().length() == 0)
					return;
				dayColorUpdate(true);
				source.setForeground(todayBackColor);
				int newDay = Integer.parseInt(source.getText());// 获取日。
				Calendar c = getCalendar();// 获取到的Calendar 包含了选择过的月和年
				c.set(Calendar.DAY_OF_MONTH, newDay);
				setDate(c.getTime());

				System.out.println(c.getTime());
				dTempDate = c.getTime();// 记录Date型日期
				// 输出Wed Feb 18 22:00:31 CST 2015
				System.out.println(""
						+ getDefaultDateFormat().format(c.getTime()));
				// 输出2015-02-18 22:02:31
				sTempDate = "" + getDefaultDateFormat().format(c.getTime());// 记录字符串型日期
			}
		}// end class DateChooser
	}
}
