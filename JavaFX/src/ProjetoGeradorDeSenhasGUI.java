import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;

public class ProjetoGeradorDeSenhasGUI extends Application {

    @Override
    public void start(Stage palco) {

        palco.setTitle("Gerador de Senhas");

        Label labelTamanhoSenha = new Label("Tamanho da senha:");
        labelTamanhoSenha.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        TextField campoTamanhoSenha = new TextField();
        campoTamanhoSenha.setText("8");  // Sugestão de tamanho de senha
        campoTamanhoSenha.setStyle(
                "-fx-background-radius: 8;" +
                        "-fx-padding: 5;" +
                        "-fx-font-size: 14px;"
        );

        Label labelSenhaGerada = new Label("Senha gerada:");
        labelSenhaGerada.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        TextField campoSenhaGerada = new TextField();
        campoSenhaGerada.setEditable(false);
        campoSenhaGerada.setStyle(
                "-fx-text-fill: #00ffcc;" +
                        "-fx-background-color: #2b2b2b;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 8;"
        );

        CheckBox checkNumeros = new CheckBox("Incluir números");
        checkNumeros.setSelected(true);
        checkNumeros.setStyle("-fx-text-fill: white;");

        CheckBox checkEspeciais = new CheckBox("Incluir caracteres especiais");
        checkEspeciais.setSelected(true);
        checkEspeciais.setStyle("-fx-text-fill: white;");

        Button botaoGerar = new Button("Gerar Senha");
        botaoGerar.setStyle(
                "-fx-background-color: #4CAF50;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 8 15;"
        );
        botaoGerar.setOnAction(e -> {
            int tamanhoSenha = Integer.parseInt(campoTamanhoSenha.getText()); // Pegar o tamanho de senha desejado
            boolean usarNumeros = checkNumeros.isSelected();
            boolean usarEspeciais = checkEspeciais.isSelected();
            String senha = ProjetoGeradorDeSenhas.gerarSenha(tamanhoSenha, usarNumeros, usarEspeciais); // Gerar a senha
            campoSenhaGerada.setText(senha); // Mostrar a senha gerada para o usuario
        });

        //designda gui
        VBox vBox = new VBox(
                labelTamanhoSenha,
                campoTamanhoSenha,
                checkNumeros,
                checkEspeciais,
                botaoGerar,
                labelSenhaGerada,
                campoSenhaGerada
        );
        vBox.setSpacing(15); // Configura espaçamento entre os componentes
        vBox.setPadding(new Insets(20)); // Adiciona um espaçamento de 10 pixels em todas as bordas
        vBox.setStyle("-fx-background-color: #1e1e1e;");
        vBox.setAlignment(javafx.geometry.Pos.CENTER);

        //tamanho do gui inicial
        Scene cena = new Scene(vBox, 400, 300);
        palco.setScene(cena);
        palco.show();
    }

    //launch
    public static void main(String[] args) {
        launch(args);
    }
}