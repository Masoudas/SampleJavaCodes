package SwingLibrary.components_5.ChoiceComponents_6;

import java.awt.Container;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 * The choices are given altogether in 1_ChoicesInAView.png.
 * 
 * The ToggleButton has depressed, pressed situation, and allows you to select
 * and keep (as opposed to a normal button). I don't think it's very useful.
 * 
 * Following is some of the ways to create the choises.
 * 
 * To select/unselect a JToggleButton, JCheckBox, and JRadioButton, you need to
 * call their setSelected() methods.
 * 
 * To check if they are selected, use their isSelected() methods. The following
 * snippet of code shows how to use these methods:
 * 
 * tb3.setSelected(true); // Select tb3 boolean b1 = tb3.isSelected(); // will
 * store true in b1
 * 
 * tb3.setSelected(false); // Unselect tb3 boolean b2 = tb3.isSelected(); //
 * will store false in b2
 * 
 */

class CreatingChoices {
    public static void main(String[] args) {
        // NOTE : Note that each of these items are just ONE CHOICE, and not
        // a group of choices. Down below we explain how to create a group of them.

        // Create them with no label and no image
        JToggleButton tb1 = new JToggleButton();
        JCheckBox cb1 = new JCheckBox();
        JRadioButton rb1 = new JRadioButton();

        // Create them with text as "Multi-Lingual"
        JToggleButton tb2 = new JToggleButton("Multi-Lingual");
        JCheckBox cb2 = new JCheckBox("Multi-Lingual");
        JRadioButton rb2 = new JRadioButton("Multi-Lingual");

        // Create them with text as "Multi-Lingual" and selected by default
        JToggleButton tb3 = new JToggleButton("Multi-Lingual", true);
        JCheckBox cb3 = new JCheckBox("Multi-Lingual", true);
        JRadioButton rb3 = new JRadioButton("Multi-Lingual", true);

        tb3.setSelected(true);
        // Select tb3
        boolean b1 = tb3.isSelected();
        // will store true in b1

        tb3.setSelected(false); // Unselect tb3
        boolean b2 = tb3.isSelected(); // will store false in b2

    }

}

/**
 * If the selection is mutually exclusive, you must group all your choices in a
 * button group. In a mutually exclusive group of choices, if you select one
 * choice, all other choices are unselected. Typically, you create a button
 * group for a group of mutually exclusive JRadioButtons or JToggleButtons.
 * Theoretically, you can also create a button group for JCheckBoxes to have
 * mutually exclusive choices. However, it is not recommended to use a group of
 * mutually exclusive JCheckBoxes in a GUI.
 * 
 * Note that ButtonGroup is actually not a component, but just a means of
 * grouping a set of buttons. If we want to add the buttons as a component, we
 * should rather use a box for example.
 * 
 */
class ButtonGroupExample extends JFrame {
    private static final long serialVersionUID = 648891176483141267L;

    ButtonGroup group = new ButtonGroup();
    JRadioButton b1 = new JRadioButton("Male");
    JRadioButton b2 = new JRadioButton("Female");
    JRadioButton b3 = new JRadioButton("Unknown");

    protected void initFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.setSelected(false);
        group.add(b1);
        group.add(b2);
        group.add(b3);


        Container contentPane = this.getContentPane();
        Box box = Box.createVerticalBox();
        box.add(b1);
        box.add(b2);
        box.add(b3);

        contentPane.add(box);

        this.pack();
    }

    public ButtonGroupExample(){
        initFrame();
    }

    public static void main(String[] args) {
        ButtonGroupExample example = new ButtonGroupExample();

        example.setVisible(true);
    }
}