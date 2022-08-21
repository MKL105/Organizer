package ui;

import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {

    public Panel(String name) {
        super();
        this.setName(name);
    }

    public Panel(LayoutManager layout, String name) {
        super(layout);
        this.setName(name);
    }

    public Component getComponentByName(String name) {
        for (int index = 0; index < this.getComponentCount(); ++index) {
            if (this.getComponent(index).getName().equals(name))
                return this.getComponent(index);
        }
        return null;
    }
}
