package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	int mode = 0;

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private Button clearButton;
    
    @FXML
    private RadioButton EraserSwitch;

    @FXML
    private RadioButton PenSwitch;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        if (event.getSource() == clearButton) {
        	drawingAreaPane.getChildren().clear();
        }
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        if (x >= 0 && x <= drawingAreaPane.getWidth() && y >= 0 && y <= drawingAreaPane.getHeight()) {
    		if (mode == 1) {
                Circle newCircle = new Circle(event.getX(),
                event.getY(), 4, Color.BLACK);
                drawingAreaPane.getChildren().add(newCircle);
    		}  else if (mode == 2) {
                Circle newCircle = new Circle(event.getX(),
                event.getY(), 4, Color.WHITE);
                drawingAreaPane.getChildren().add(newCircle);
    		}
        }
    }
    
    @FXML
    void PenSwitchHandler(ActionEvent event) {
    	if (event.getSource() == PenSwitch) {
    		mode = 1;
    	}
    }
    
    @FXML
    void EraserSwitchHandler(ActionEvent event) {
    	if (event.getSource() == EraserSwitch) {
    		mode = 2;
    	}
    }
}