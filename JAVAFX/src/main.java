import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
// TODO Auto-generated method stub
		Button btOK = new Button("OK");
		Scene scene = new Scene(btOK, 200, 250);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String args[]) {
		Application.launch(args);
	}
}
