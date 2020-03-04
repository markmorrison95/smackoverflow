package view;
import javax.swing.*;
import java.awt.*;

public class CellRenderer extends DefaultListCellRenderer  {

    public ListCellRenderer defaultRenderer;

    public CellRenderer (ListCellRenderer defaultRenderer) {
        this.defaultRenderer = defaultRenderer;

    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String item = (String) value;
            if (item.contains("\u2714")) {
                c.setBackground(Color.green);
            }

        if (item.contains("\u2715")) {
            c.setBackground(Color.red);
        }

        setEnabled(true);
        return c;
    }

    public ListCellRenderer getDefaultRenderer() {
        return defaultRenderer;

    }
}