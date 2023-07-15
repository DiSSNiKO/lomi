package com.example.lomi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;

public class Movie {
    int price;
    int duration;
    String name;
    String category;
    public Movie(int pricen, int durationn, String namen, String categoryn){
        price = pricen;
        duration = durationn;
        name = namen;
        category = categoryn;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static ResultSet getMovies(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
        while(rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("category"));
            System.out.println(rs.getInt("price"));
            System.out.println(rs.getString("duration"));
        }
        return rs;
    }
    public static ResultSet getMoviesForChart(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
        return rs;
    }
    public static void addMovie(Connection con, String price) throws SQLException {
        if(price == "") {
            System.out.println("Input valid name");
        } else {
            Statement stmt = con.createStatement();
            String name = "joni xurcilava";
            String category = "baeviki";
            String duration = "2000";
            stmt.executeUpdate("INSERT INTO movies (name, category, price, duration) VALUES (" + "'" + name + "'"  + ", " + "'" + category + "'" + ", " + price + ", " + duration + ")");
            System.out.println("Executed operation -> " + "INSERT INTO movies (name, category, price, duration) VALUES (" + "'" + name + "'" + "'" + ", " + "'" + category + "'" + ", " + price + ", " + duration + ")");
        }
    }
    public static void getDurationChart(Connection con, PieChart PieChart) throws SQLException {
        ResultSet rs = getMoviesForChart(con);
        ArrayList<Movie> movieList = new ArrayList<>();
        while (rs.next()){
            movieList.add(new Movie(rs.getInt("price"), rs.getInt("duration"), rs.getString("name"), rs.getString("category")));
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(int i = 0; i<movieList.size(); i++){
            pieChartData.add(new PieChart.Data(movieList.get(i).getName(), 1));
        }
        PieChart.setData(pieChartData);
    }
}
