package com.side.bms.controller;

import com.side.bms.model.dto.InventoryDTO;
import com.side.bms.model.dto.QuantityByBookDTO;
import com.side.bms.model.dto.QuantityByLocationDTO;
import com.side.bms.model.service.InventoryService;
import com.side.bms.view.ResultView;

import java.util.List;
import java.util.Map;

public class InventoryController {
    private InventoryService inventoryService = new InventoryService();
    private ResultView resultView = new ResultView();

    /***
     * 도서별 재고 출력 메서드
     * 도서별 재고 리스트가 있으면 도서별 재고리스트를 출력한다.
     */
    public void selectBookQuantity() {

        List<QuantityByBookDTO> bookQuantityList = inventoryService.selectBookQuantity();

        if(bookQuantityList != null) {
            resultView.printSuccessMessage("selectBook");
            resultView.printBookQuantity(bookQuantityList);
        } else {
            resultView.printErrorMessage("selectBookList");
        }
    }

    /***
     * 창고별 재고출력 메서드
     * 창고별 재고 리스트가 있으면 창고별 재고리스트를 출력한다.
     */
    public void selectLocationQuantity() {
        List<QuantityByLocationDTO> locationQuantityList = inventoryService.selectLocationQuantity();
        if(locationQuantityList != null) {
            resultView.printSuccessMessage("selectInventory");
            resultView.printLocationQuantity(locationQuantityList);
        } else {
            resultView.printErrorMessage("selectInventoryList");
        }
    }

    /***
     * 도서 입고처리 메서드
     * @param parameter 입고처리할 도서번호, 도서개수, 창고명을 입력받고
     *                  입고처리를 한다.
     */
    public void insertInInventory(Map<String, String> parameter) {

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setBookId(Integer.parseInt(parameter.get("bookId")));
        inventoryDTO.setQuantity(Integer.parseInt(parameter.get("bookQuantity")));
        inventoryDTO.setLocation(parameter.get("bookLocation"));

        int result = inventoryService.insertInventory(inventoryDTO);

        if(result > 0) {
            resultView.printSuccessMessage("insert");
        } else {
            resultView.printErrorMessage("insert");
        }
    }

    /***
     * 도서 출고처리 메서드
     * @param parameter 출고처리할 도서번호와, 도서개수를 입력받아서
     *                  출고처리를 한다.
     */
    public void updateOutInventory(Map<String, String> parameter) {

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setBookId(Integer.parseInt(parameter.get("bookId")));
        inventoryDTO.setQuantity(Integer.parseInt(parameter.get("bookQuantity")));

        int result = inventoryService.updateInventory(inventoryDTO);

        if(result > 0) {
            resultView.printSuccessMessage("update");
        } else {
            resultView.printErrorMessage("update");
        }
    }

    /***
     * 재고 이동 메서드
     * @param parameter 재고이동할 도서번호와, 창고명을 입력받고
     *                  재고이동처리를 한다.
     */
    public void moveInventory(Map<String, String> parameter) {

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setBookId(Integer.parseInt(parameter.get("bookId")));
        inventoryDTO.setLocation(parameter.get("bookLocation"));

        int result = inventoryService.moveInventory(inventoryDTO);
        if(result > 0) {
            resultView.printSuccessMessage("move");
        } else {
            resultView.printErrorMessage("move");
        }
    }
}
