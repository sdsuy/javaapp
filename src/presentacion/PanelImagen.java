package presentacion;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PanelImagen extends javax.swing.JPanel {
	
	public PanelImagen() {
		this.setSize(400,280);
	}
	@Override
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/img/STIGMA.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
