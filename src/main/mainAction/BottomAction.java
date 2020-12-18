package main.mainAction;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTable;


import main.MainFrame;
import sale.SalePanel;


public class BottomAction implements ActionListener {

	public MainFrame mainFrame;

	public BottomAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();

		if (ob == mainFrame.bottomPanel.productBtn) {
			// 메인 버튼 클릭시 색 변경해주기
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.productBtn);
			mainFrame.cardlayout.show(mainFrame.centerView, "productView");
		} else if (ob == mainFrame.bottomPanel.saleBtn) {
			// 필드 초기화 먼저.
			mainFrame.salePanel.prodnameTf.setText("");
			mainFrame.salePanel.prodQt.setText("");
//<<<<<<< HEAD
//=======
			
			//재고화면 장바구니화면 초기화
			mainFrame.salePanel.bucketTblModel.setNumRows(0);
			mainFrame.salePanel.stockTblModel.setNumRows(0);
			
			//재고화면 로우 새로 받아오기.
			mainFrame.salePanel.addStockLine(mainFrame.stockdao.stockAll());
			
//>>>>>>> branch 'develop' of https://github.com/byunghwi/Java_project.git
			// 메인 버튼 클릭시 색 변경해주기
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.saleBtn);
			mainFrame.cardlayout.show(mainFrame.centerView, "salePanel");

			// 판매 패널의 J테이블에서 로우 선택시 발생하는 이벤트
			mainFrame.salePanel.stockTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JTable jt = (JTable) e.getSource();
					int row = jt.getSelectedRow();
					if (row != -1) {
						String product_name = (String) mainFrame.salePanel.stockTable.getValueAt(row, 1);
						mainFrame.salePanel.prodnameTf.setText(product_name);
						mainFrame.salePanel.prodQt.setText("");
					}
				}
			});

		}else if (ob == mainFrame.bottomPanel.stockBtn) {
			//메인 버튼 클릭시 색 변경해주기
			System.out.println("재고버튼트느틑");
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.stockBtn);
			mainFrame.cardlayout.show(mainFrame.centerView, "stockPanel");
			mainFrame.btnlayout.show(mainFrame.pBtnView, "stockBtnPanel");
			mainFrame.stockPanel.tblModel.setNumRows(0);
	        mainFrame.stockPanel.addStockLine(mainFrame.stockdao.stockAll());
			
			
		}else if (ob == mainFrame.bottomPanel.disBtn) {
			//메인 버튼 클릭시 색 변경해주기
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.disBtn);
		}else if (ob == mainFrame.bottomPanel.accountBtn) {
			//메인 버튼 클릭시 색 변경해주기
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.accountBtn);
		}else if (ob == mainFrame.bottomPanel.commuteBtn) {
			//메인 버튼 클릭시 색 변경해주기
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.commuteBtn);
		}else if (ob == mainFrame.bottomPanel.eventBtn) {
			//메인 버튼 클릭시 색 변경해주기
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.eventBtn);
			mainFrame.cardlayout.show(mainFrame.centerView, "eventPanel");	
		}else if (ob == mainFrame.bottomPanel.calcBtn) {
			//메인 버튼 클릭시 색 변경해주기
			mainFrame.bottomPanel.selectedBtn(mainFrame.bottomPanel.calcBtn);
		}

	}

}
