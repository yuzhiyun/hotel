//package manager;
//
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.Shape;
//import java.awt.event.MouseEvent;
//import java.awt.geom.Ellipse2D;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//public class CircleButton extends JButton {
//	private Shape shape = null;// ���ڱ��水ť����״,����������������ť�¼�
//
//	public CircleButton(String label) {
//		super(label);
//		this.addMouseListener(new java.awt.event.MouseAdapter() {
//			/** */
//			/**
//			 * {@inheritDoc}
//			 */
//			public void mouseEntered(MouseEvent e) {
//				((JButton) e.getSource()).setCursor(new Cursor(
//						Cursor.HAND_CURSOR));
//			}
//
//			/** */
//			/**
//			 * {@inheritDoc}
//			 */
//			public void mouseExited(MouseEvent e) {
//				((JButton) e.getSource()).setCursor(new Cursor(
//						Cursor.MOVE_CURSOR));
//			}
//		});
//		Dimension size = getPreferredSize();// ��ȡ��ť����Ѵ�С
//		// ������ť�Ĵ�С,ʹ֮���һ������
//		size.width = size.height = Math.max(size.width, size.height);
//		setPreferredSize(size);
//		// ʹjbutton��������,������ʾ���α���,���������ǻ�һ��Բ�ı���
//		setContentAreaFilled(false);
//	}
//
//	// ��ͼ�İ�ť�ı����ͱ�ǩ
//	protected void paintComponent(Graphics g) {
//		if (getModel().isArmed()) {
//			// getModel������������ģ��ButtonModel
//			// �����갴�°�ť����buttonModel��armed����Ϊ��
//			g.setColor(Color.LIGHT_GRAY);
//		} else {
//			// �����¼���Ĭ�ϵı���ɫ��ʾ��ť
//			g.setColor(getBackground());
//		}
//		// fillOval������һ�����ε�������Բ,������������Բ
//		// ������Ϊ������ʱ,��������Բ����Բ
//		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
//		// ���ø����paintComponent����ť�ı�ǩ�ͽ������ڵ�С����
//		super.paintComponents(g);
//	}
//
//	// �ü򵥵Ļ��䵱��ť�ı߽�
//	protected void paintBorder(Graphics g) {
//		g.setColor(getForeground());
//		// drawOval���������ε�������Բ,�������,ֻ����һ���߽�
//		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
//	}
//
//	// �ж�����Ƿ���ڰ�ť��
//	public boolean contains(int x, int y) {
//		// �����ť�߿�,λ�÷����ı�,�����һ���µ���״����
//		if ((shape == null) || (!shape.getBounds().equals(getBounds()))) {
//			// ������Բ�Ͷ���
//			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
//		} // �ж�����x,y�����Ƿ����ڰ�ť��״��
//		return shape.contains(x, y);
//	}
//}