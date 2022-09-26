package g53203.atl.fx.bmr.view;

import g53203.atl.fx.bmr.model.BMRfacade;
import g53203.atl.fx.bmr.util.Observer;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;

/**
 * Class ChartBMRWeight, Graph for Wieght
 *
 * @author Anas Benallal 53203
 */
public class ChartBMRWeight extends HBox implements Observer {

    private final BMRfacade facade;
    BMRroot root = new BMRroot();
    private final NumberAxis xAxis = new NumberAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private XYChart.Series series = new XYChart.Series();
    private XYChart.Series series2 = new XYChart.Series();
    final LineChart<Number, Number> lineChart
            = new LineChart<Number, Number>(xAxis, yAxis);

    /**
     * Constructor for Weight
     *
     * @param facade my facade
     */
    public ChartBMRWeight(BMRfacade facade) {
        this.facade = facade;
        facade.register(this);
        xAxis.setLabel("Weight (kg)");
        yAxis.setLabel("BMR");
        lineChart.setTitle("Weight(kg) Vs BMR index");
        series.setName("MenData");
        series2.setName("WomenData");
        lineChart.getData().add(series);
        lineChart.getData().add(series2);
        this.getChildren().add(lineChart);

    }

    @Override
    public void upDate() {
        if (facade.getPerson().isGenre()) {
            series2.getData().add(new XYChart.Data(facade.getPerson().getPoids(), facade.getBMRFemme()));
        } else {
            series.getData().add(new XYChart.Data(facade.getPerson().getPoids(), facade.getBMRHomme()));
        }
    }

}
