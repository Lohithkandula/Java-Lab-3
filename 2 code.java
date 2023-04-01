import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainPage
{
public static void main(String[] args)
{
final JFrame frame = new JFrame("JRadioButton Demo");
// implement ItemListener interface
class MyItemListener implements ItemListener
{
public void itemStateChanged(ItemEvent ev)
{
boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
AbstractButton button = (AbstractButton) ev.getItemSelectable();
String command = button.getActionCommand();
// build message
String state;
if (selected)
{
state = "selected";
}
else
{
state = "unselected";
}
String message;
if (command.equals("Java"))
{
message = "The Java option has been " + state;
}
else if (command.equals("ASP"))
{
message = "The ASP.Net option has been " + state;
} else
{
message = "The SQL option has been " + state;
}
// show dialog
JOptionPane.showMessageDialog(frame, message);
}
}
// creates radio button and set corresponding action
// commands
JRadioButton rdbJava = new JRadioButton("Java");
rdbJava.setActionCommand("Java");
JRadioButton rdbASP = new JRadioButton("ASP.Net");
rdbASP.setActionCommand("ASP");
JRadioButton rdbSQL = new JRadioButton("SQL");
rdbSQL.setActionCommand("SQL");
// add event handler
MyItemListener myItemListener = new MyItemListener();
rdbJava.addItemListener(myItemListener);
rdbASP.addItemListener(myItemListener);
rdbSQL.addItemListener(myItemListener);
// add radio buttons to a ButtonGroup
final ButtonGroup group = new ButtonGroup();
group.add(rdbJava);
group.add(rdbASP);
group.add(rdbSQL);
// Frame setting
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(300, 200);
Container cont = frame.getContentPane();
cont.setLayout(new GridLayout(0, 1));
cont.add(new JLabel("Please choose your favorite language: "));
cont.add(rdbJava);
cont.add(rdbASP);
cont.add(rdbSQL);
frame.setVisible(true);
}
}
