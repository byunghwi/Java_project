package calc.Chart;

import java.awt.BasicStroke;  
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
import calc.Calc;

public class CalcChart{
    
    public JFreeChart chart = null;
    public ChartPanel chart_p = null;
    public ArrayList<Calc> cl = new ArrayList<Calc>();
    
    
    public CalcChart() {
    	chart = this.getChart();
		chart_p = new ChartPanel(chart);
	}
    
    

    public JFreeChart getChart() {

        // 데이터 생성
        DefaultCategoryDataset CalcChart = new DefaultCategoryDataset();                // line chart 1
        

        // CalcChart에 데이터 저장   
        for (int i = 0; i < cl.size(); i++) {
        	CalcChart.addValue(cl.get(i).gettotal_sale_price(), "매출합계", cl.get(i).getsale_date());
	      }
 
        // 렌더링 생성 및 세팅

        // 렌더링 생성
        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();

        // 공통 옵션 정의

        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

        final ItemLabelPosition p_center = new ItemLabelPosition(

                ItemLabelAnchor.CENTER, TextAnchor.CENTER

            );

        final ItemLabelPosition p_below = new ItemLabelPosition(

                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

                     );

        Font f = new Font("나눔고딕", Font.PLAIN, 17);//값 표시 텍스트 

        Font axisF = new Font("나눔고딕", Font.PLAIN, 20);//X,Y축 폰트
        
        

       

        // 렌더링 세팅

        // 그래프 3       

        renderer2.setBaseItemLabelGenerator(generator);
        renderer2.setBaseItemLabelsVisible(true);
        renderer2.setBaseShapesVisible(true);
        renderer2.setDrawOutlines(true);
        renderer2.setUseFillPaint(true);
        renderer2.setBaseFillPaint(Color.WHITE);
        renderer2.setBaseItemLabelFont(f);
        renderer2.setBaseItemLabelPaint(Color.WHITE);
        renderer2.setBasePositiveItemLabelPosition(p_below);
        renderer2.setSeriesPaint(0,new Color(219,121,22));
        renderer2.setSeriesStroke(0,new BasicStroke(

                                               2.0f,

                                               BasicStroke.CAP_ROUND,

                                               BasicStroke.JOIN_ROUND,

                                               3.0f)

        );

       

        // plot 생성

        final CategoryPlot plot = new CategoryPlot();


        // plot 에 데이터 적재

        plot.setDataset(CalcChart);
        plot.setRenderer(renderer2);

 

        // plot 기본 설정

        plot.setOrientation(PlotOrientation.VERTICAL);             // 그래프 표시 방향
        plot.setRangeGridlinesVisible(true);                       // X축 가이드 라인 표시여부
        plot.setDomainGridlinesVisible(true);                      // Y축 가이드 라인 표시여부
        plot.setBackgroundPaint(Color.DARK_GRAY);								   // 그래프 배경색상 
        
        
 

        // 렌더링 순서 정의 : CalcChart 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        // X축 세팅

        plot.setDomainAxis(new CategoryAxis());              // X축 종류 설정
        plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);; // X축 눈금라벨 폰트 색상 조정
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);// 카테고리 라벨 위치 조정
        



        // Y축 세팅

        plot.setRangeAxis(new NumberAxis());                 // Y축 종류 설정
        plot.getRangeAxis().setTickLabelFont(axisF);  // Y축 눈금라벨 폰트 조정
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE); // Y축 눈금라벨 폰트 색상 조정

        // 세팅된 plot을 바탕으로 chart 생성

        final JFreeChart chart = new JFreeChart(plot);
        
        
        chart.setBackgroundPaint(Color.DARK_GRAY);
        
       
        
        return chart;

    }
}
