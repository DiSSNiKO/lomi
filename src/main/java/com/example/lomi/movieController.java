package com.example.lomi;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;

public class movieController {
    SQLConnector sqlcon = new SQLConnector();
    Connection con = sqlcon.createConnection();
    @FXML
    private Button fetchbtn;
    @FXML
    private Button addbtn;
    @FXML
    private TextField nameinp;
    @FXML
    private PieChart paichart;
    public movieController() throws SQLException {
    }

    @FXML
    protected void onGetButtonClick() throws SQLException {
        Movie.getMovies(con);
    }
    @FXML
    protected void onAddButtonClick() throws SQLException {
        Movie.addMovie(con, nameinp.getText());
    }
    @FXML
    protected void addpiechart() throws SQLException {
        Movie.getDurationChart(con, paichart);
    }
}