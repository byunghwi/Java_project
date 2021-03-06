package sale.saleAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import common.CheckValid;
import main.MainFrame;
import stock.Stock;

public class SaleAction implements ActionListener{
	
	public MainFrame mainFrame;
	CheckValid chkValid = new CheckValid();

	public SaleAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();
		
		if (ob == mainFrame.salePanel.addBucketBtn) { // 판매화면에서 장바구니 추가 버튼 클릭시
			int row  = mainFrame.salePanel.stockTable.getSelectedRow();

			if(row == -1) {
				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 추가할 상품의 행을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}else {
				
				//장바구니에 추가할 수량
				String prodQt = String.valueOf(mainFrame.salePanel.prodQt.getText());
				
				//원래 재고의 수량
				String stockQt = String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 2));
				
				if(!chkValid.isQtChk(prodQt)) {
					// 확인 팝업창
					JOptionPane.showMessageDialog(null, "\t[SYSTEM] 정확한 수량을 입력해주세요", "확인", JOptionPane.CLOSED_OPTION);
				}else if(Integer.parseInt(prodQt) > Integer.parseInt(stockQt)) {
					// 확인 팝업창
					JOptionPane.showMessageDialog(null, "\t[SYSTEM] 현 재고 수량보다 많은 양을 구매하실 수 없습니다.", "확인", JOptionPane.CLOSED_OPTION);
				}else {
					String [] arrData = new String[4];
					
					//이벤트 타입 가져오기
					String eventType = mainFrame.sdao.searchEvent(String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 0)));
								
					int originInput = Integer.parseInt(prodQt); // 원래 입력한 수량
					int originStock = Integer.parseInt(stockQt); //원래 재고의 수량
					String totalCost = null;
					
					//이벤트 상품일 경우 처리프로세스
					if(eventType != null) {
						switch (eventType) {
						case "1+1": 
							JOptionPane.showMessageDialog(null, "\t[SYSTEM] "+eventType+" 이벤트 적용되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
							//짝수 갯수 구매시
							if(originInput%2==0) {
								totalCost = Integer.toString((originInput/2) * Integer.parseInt(String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 3))));
								arrData[2] = prodQt; //수량
								arrData[3] = totalCost; //가격
							}else { //짝수 갯수 구매시
								if(originInput == originStock){ 
									arrData[2] = Integer.toString(originInput);	//수량
									totalCost = Integer.toString(((originInput+1)/2) * Integer.parseInt(String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 3))));
									arrData[3] = totalCost; 
									JOptionPane.showMessageDialog(null, "\t[SYSTEM] 수량이 부족하여 "+ eventType + " 적용 불가입니다.", "확인", JOptionPane.CLOSED_OPTION);
								}else {
									//홀수 갯수 추가할 때 1개 더 추가하고 금액은 절반 가격
									totalCost = Integer.toString(((originInput+1)/2) * Integer.parseInt(String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 3))));
									arrData[2] = Integer.toString(originInput+1);	//수량
									arrData[3] = totalCost; 					//가격
								}
							}
							
							break;
						case "10% 할인" :
						case "20% 할인" :
							double disCount =  (double) ((100 - Integer.parseInt(eventType.substring(0, 2))) * 0.01);
							
							JOptionPane.showMessageDialog(null, "\t[SYSTEM] "+eventType+" 이벤트 적용되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
							totalCost = Integer.toString((int) ((originInput) * (Integer.parseInt(String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 3))) * disCount)));
							arrData[2] = Integer.toString(originInput);		//수량
							arrData[3] = totalCost; 						//가격
							
							break;
						
						}
					}else {
						totalCost = Integer.toString(((originInput) * Integer.parseInt(String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 3)))));
						arrData[2] = Integer.toString(originInput);	//수량
						arrData[3] = totalCost; 
					}
					
					arrData[0] = String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 0)); // 상품코드
					arrData[1] = mainFrame.salePanel.prodnameTf.getText();							 // 상품명
					
					mainFrame.salePanel.bucketTblModel.addRow(arrData);
					
					//재고화면테이블에서 선택한 수량만큼 차감하고 장바구니에 넣기.
					int rs = Integer.parseInt(String.valueOf(mainFrame.salePanel.stockTblModel.getValueAt(row, 2)))  - Integer.parseInt(arrData[2]);
					
					mainFrame.salePanel.stockTblModel.setValueAt(rs, row, 2);

				}
				
			}
			
			
		}else if (ob == mainFrame.salePanel.delBucketBtn) {
			int bucketRow  = mainFrame.salePanel.bucketTable.getSelectedRow();
			
			//행이 선택되었을 때
			if(bucketRow != -1) {
				for(int i =0; i<mainFrame.salePanel.stockTable.getRowCount(); i++) {
					if(String.valueOf(mainFrame.salePanel.stockTable.getValueAt(i, 0)).equals(String.valueOf(mainFrame.salePanel.bucketTable.getValueAt(bucketRow, 0)))){	
						int addQT = Integer.parseInt(String.valueOf(mainFrame.salePanel.stockTable.getValueAt(i, 2))) + Integer.parseInt(String.valueOf(mainFrame.salePanel.bucketTable.getValueAt(bucketRow, 2)));
						mainFrame.salePanel.stockTable.setValueAt(addQT, i, 2);
						break;
					}
				}				
				mainFrame.salePanel.bucketTblModel.removeRow(bucketRow);
	
			}else {
				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제할 행을 선택해주세요", "확인", JOptionPane.CLOSED_OPTION);
			}

		}else if (ob == mainFrame.salePanel.completeBtn) { // 결제이미지버튼 눌렀을때 결제 처리
			int count = mainFrame.salePanel.bucketTblModel.getRowCount();
			
			//장바구니에 1개이상의 로우가 있을 때만 결제 가능
			if(count > 0) {
				ArrayList<Stock> stocks = new ArrayList<Stock>();
				for(int i=0; i<count; i++) {
					Stock stock = new Stock();
					stock.setProduct_id(String.valueOf(mainFrame.salePanel.bucketTable.getValueAt(i, 0)));
					stock.setQuantity(Integer.parseInt(String.valueOf(mainFrame.salePanel.bucketTable.getValueAt(i, 2))));
					stock.setPrice(Integer.parseInt(String.valueOf(mainFrame.salePanel.bucketTable.getValueAt(i, 3))));
					
					stocks.add(stock);
				}
				
				if(mainFrame.sdao.pay(stocks, mainFrame.mem_id)) {
					// 확인 팝업창
					JOptionPane.showMessageDialog(null, "\t[SYSTEM] 결제가 완료 되었습니다!", "확인", JOptionPane.CLOSED_OPTION);
					// 장바구니 화면테이블 초기화
					mainFrame.salePanel.bucketTblModel.setNumRows(0);
					
					// 재고목록 화면테이블 초기화 해주기.
					mainFrame.salePanel.stockTblModel.setNumRows(0);

					// 재고목록 화면테이블 새로 채우기
					mainFrame.salePanel.addStockLine(mainFrame.stockdao.stockAll());
				}
			}else {
				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 결제할 상품이 없습니다.", "확인", JOptionPane.CLOSED_OPTION);
			}
			
			
		}
		
	}
	
}
