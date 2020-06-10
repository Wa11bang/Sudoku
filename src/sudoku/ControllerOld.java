package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Waldo
 */
public class ControllerOld implements ActionListener {
    ModelOld model;
    View view;

    ControllerOld() {
        System.out.println("AppController()");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("AppController(): Acting on AppModel()");
    }

    public void addModel(ModelOld m) {
        System.out.println("AppController: Adding AppModel");
        this.model = m;
    }

    public void addView(View v) {
        System.out.println("AppController: Adding AppView");
        this.view = v;
    }
}