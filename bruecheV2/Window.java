import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Window extends JFrame {

	JTextField z1, z2, n1, n2;
	JLabel resZ, resN;

	public Window() {
		super("Bruch GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(5, 5));
		z1 = new JTextField();
		z2 = new JTextField();
		n1 = new JTextField();
		n2 = new JTextField();
		this.add(new JLabel("Zähler 1"));
		this.add(z1);
		this.add(new JLabel(""));
		this.add(new JLabel("Zähler 2"));
		this.add(z2);

		this.add(new JLabel("Nenner 1"));
		this.add(n1);
		this.add(new JLabel(""));
		this.add(new JLabel("Nenner 2"));
		this.add(n2);

		for (int i = 0; i < 5; i++)
			this.add(new JLabel("-"));

		JButton multB = new JButton("Multiplizieren");
		JButton divB = new JButton("Dividieren");
		JButton addB = new JButton("Addieren");
		JButton subB = new JButton("Subtrahieren");
		JButton kurB = new JButton("Kürzen");

		multB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					show(getBruch1().multiplizieren(getBruch2()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		divB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					show(getBruch1().dividieren(getBruch2()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		addB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					show(getBruch1().addieren(getBruch2()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		subB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					show(getBruch1().subtrahieren(getBruch2()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		kurB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Bruch b = getBruch1().kuerze();
					n1.setText(b.getNenner() + "");
					z1.setText(b.getZaehler() + "");
					b = getBruch2().kuerze();
					n2.setText(b.getNenner() + "");
					z2.setText(b.getZaehler() + "");
					b = new Bruch(Utils.asInt(resZ.getText()), Utils.asInt(resN
							.getText()));
					show(b.kuerze());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		this.add(multB);
		this.add(divB);
		this.add(addB);
		this.add(subB);
		this.add(kurB);

		resZ = new JLabel("[Zähler]");
		resN = new JLabel("[Nenner]");

		this.add(new JLabel());
		this.add(resZ);
		this.add(new JLabel("/"));
		this.add(resN);
		this.add(new JLabel());

		this.pack();
		this.setVisible(true);

	}

	private Bruch getBruch1() {
		return new Bruch(Utils.asInt(z1.getText()), Utils.asInt(n1.getText()));
	}

	private Bruch getBruch2() {
		return new Bruch(Utils.asInt(z2.getText()), Utils.asInt(n2.getText()));
	}

	private void show(Bruch b) {
		resN.setText(b.getNenner() + "");
		resZ.setText(b.getZaehler() + "");
	}

}
