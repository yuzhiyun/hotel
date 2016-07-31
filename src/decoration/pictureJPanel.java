//package decoration;
//
//import java.awt.Graphics;
//import javax.swing.*;
//import javax.swing.ImageIcon;
//import java.awt.*;
//
//public class pictureJPanel extends JPanel{
//
//	public pictureJPanel() {
//
//	}
//
//	public void paintComponent(Graphics g) {
//		int x = 0, y = 0;
//		java.net.URL imgURL = getClass().getResource("jpanel.jpg");
//
//		// test.jpg�ǲ���ͼƬ����Demo.java����ͬһĿ¼��
//		ImageIcon icon = new ImageIcon(imgURL);
//		g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height,
//				this);
//		while (true) {
//			g.drawImage(icon.getImage(), x, y, this);
//			if (x > getSize().width && y > getSize().height)
//				break;
//			// ��δ�����Ϊ�˱�֤�ڴ��ڴ���ͼƬʱ��ͼƬ���ܸ�����������
//			if (x > getSize().width) {
//				x = 0;
//				y += icon.getIconHeight();
//			} else
//				x += icon.getIconWidth();
//		}
//	}
//}
