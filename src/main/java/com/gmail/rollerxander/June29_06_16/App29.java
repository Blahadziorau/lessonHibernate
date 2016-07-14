package com.gmail.rollerxander.June29_06_16;

import com.gmail.rollerxander.Entity.Employee;
import com.gmail.rollerxander.dao.impl.EmployeeDAOImpl;
import com.gmail.rollerxander.service.UserService;
import com.gmail.rollerxander.service.impl.UserServiceImpl;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.List;

public class App29 extends Application {

    private UserService service = new UserServiceImpl(new EmployeeDAOImpl());
    private final ObservableList<Employee> data = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new VBox();
        Scene scene = new Scene(pane);
        TableView table = new TableView();

        MenuBar bar = new MenuBar();
        Menu database = new Menu("Data");

        MenuItem item = new MenuItem("Load");
        item.setOnAction(event -> data.setAll(service.getUsers()));

        bar.getMenus().add(database);
        pane.getChildren().add(bar);

        TableColumn<Employee, Long> idCol = new TableColumn<>("Id");
        TableColumn name = new TableColumn("First name");
        TableColumn lastName = new TableColumn("Last name");

        Button button = new Button();
        button.setText("Load");
        button.setOnAction(event -> data.setAll(service.getUsers()));

        RadioMenuItem radio1 = new RadioMenuItem("1");
        RadioMenuItem radio2 = new RadioMenuItem("2");

        ToggleGroup group = new ToggleGroup();
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        database.getItems().addAll(item, radio1, radio2);
        Button del = new Button("Delete");
        del.setOnAction(event -> service.deleteLast(data));

        TextField field = new TextField();

        Button filter = new Button("Filter");
        field.setOnAction(event -> {
            List<Employee> list = service.filterByName(data, field.getText());
            data.setAll(list);
        });
        HBox hBox = new HBox();
        hBox.getChildren().addAll(field, filter);


        name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());

        idCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employee, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<Employee, Long> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getId());
            }
        });

        lastName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());

        table.getColumns().addAll(name, lastName);

        table.setItems(data);

        pane.getChildren().add(table);
        pane.getChildren().addAll(button, del, hBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
