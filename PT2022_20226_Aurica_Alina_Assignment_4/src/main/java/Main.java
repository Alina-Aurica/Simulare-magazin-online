import presentationLayer.Controller;
import presentationLayer.MainGUI;

public class Main {
    public static void main(String[] argv){
        MainGUI gui = new MainGUI();

        Controller controller = new Controller(gui);
        gui.setVisible(true);
    }
}
