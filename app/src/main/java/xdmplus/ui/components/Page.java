package xdmplus.ui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import xdmplus.ui.res.ColorResource;
import xdmplus.ui.res.FontResource;
import xdmplus.ui.res.ImageResource;


import static xdmplus.util.XDMUtils.getScaledInt;
public class Page extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1452620326785609526L;
	private XDMFrame parent;
	private int diffx, diffy;
	private Color bgColor;
	protected JScrollPane jsp;
	private int y = 0, h = 0;
	private JLabel titleLbl, btnNav;
	private int width;
	private String title;

	public Page(String title, int width, XDMFrame parent) {
		setOpaque(false);
		setLayout(null);
		this.title = title;
		this.width = width;
		this.parent = parent;
		bgColor = ColorResource.getDarkestBgColor();
		MouseInputAdapter ma = new MouseInputAdapter() {
		};

		addMouseListener(ma);
		addMouseMotionListener(ma);

		jsp = new JScrollPane();
		jsp.setOpaque(false);
		jsp.setBorder(null);
		jsp.getViewport().setOpaque(false);

		DarkScrollBar scrollBar = new DarkScrollBar(JScrollBar.VERTICAL);
		jsp.setVerticalScrollBar(scrollBar);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.getVerticalScrollBar().setUnitIncrement(getScaledInt(10));
		jsp.getVerticalScrollBar().setBlockIncrement(getScaledInt(25));

		add(jsp);

		registerMouseListener();

		init();

	}

	private void init() {
		y = getScaledInt(25);
		h = getScaledInt(40);

		btnNav = new JLabel(ImageResource.getIcon("back.png",32,32));
		btnNav.setFont(FontResource.getBiggerFont());
		btnNav.setForeground(ColorResource.getSelectionColor());
		btnNav.setBounds(getScaledInt(10), y, getScaledInt(35), h);
		add(btnNav);

		btnNav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				close();
			}
		});

		titleLbl = new JLabel(title);
		titleLbl.setFont(FontResource.getBiggerFont());
		titleLbl.setForeground(ColorResource.getSelectionColor());
		titleLbl.setBounds(getScaledInt(50), y, getScaledInt(200), h);
		add(titleLbl);

		y += h;
		y += getScaledInt(10);
		h = getScaledInt(2);

		JLabel lineLbl = new JLabel();
		lineLbl.setBackground(ColorResource.getSelectionColor());
		lineLbl.setBounds(0, y, width, h);
		lineLbl.setOpaque(true);
		add(lineLbl);

		y += h;

	}

	protected void setBgColor(Color color) {
		this.bgColor = color;
	}

	public void registerMouseListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				diffx = me.getXOnScreen() - parent.getLocationOnScreen().x;
				diffy = me.getYOnScreen() - parent.getLocationOnScreen().y;
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent me) {
				parent.setLocation(me.getXOnScreen() - diffx, me.getYOnScreen() - diffy);
			}
		});
	}

	public void close() {
		parent.hideDialog(this);
	}

	public void showPanel() {
		int x = parent.getWidth() - width;
		jsp.setBounds(0, y, width, parent.getHeight() - y);
		setBounds(x, 0, width, parent.getHeight());
		parent.showDialog(this);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jsp.getVerticalScrollBar().setValue(0);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(bgColor);
		int arc = getScaledInt(20);
		// M3 side-sheet shape: round only the leading (left) edge, since the
		// panel is flush with the window's right edge.
		g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() + arc, getHeight(), arc, arc));
		g2.dispose();
	}

	public void addToPage(Component c) {
		this.add(c);
	}

	protected XDMFrame getParentFrame() {
		return parent;
	}
}
