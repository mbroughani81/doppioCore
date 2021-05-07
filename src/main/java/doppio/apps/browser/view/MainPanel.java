package doppio.apps.browser.view;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class MainPanel extends JPanel {

    Stack<JPanel> centerPanels;

    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);

        centerPanels = new Stack<>();
    }

    public void setNewCenter(JPanel panel) {
        centerPanels.add(panel);

        BorderLayout layout = (BorderLayout) this.getLayout();
        this.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        this.add(panel, BorderLayout.CENTER);
        this.repaint();
        this.revalidate();
    }

    public void undo() {
        if (centerPanels.size() > 1)
            centerPanels.pop();
        JPanel panel = centerPanels.peek();
        centerPanels.pop();
        setNewCenter(panel);
    }
}
