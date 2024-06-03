package com.side.bms.view;

import com.side.bms.model.dto.BookDTO;
import com.side.bms.model.dto.QuantityByBookDTO;
import com.side.bms.model.dto.QuantityByLocationDTO;

import java.util.List;

public class ResultView {

    // 전체 book 조회
    public void printBookList(List<BookDTO> bookList) {
        for(BookDTO book : bookList) {
            System.out.println(book);
        }
    }

    public void printBookQuantity(List<QuantityByBookDTO> bookQuantityList) {
        System.out.println("==================도서별 재고조회=================");
        for(QuantityByBookDTO quantity : bookQuantityList) {
            System.out.println(quantity);
        }
        System.out.println("==============================================");
    }
    public void printLocationQuantity(List<QuantityByLocationDTO> quantityByLocationDTO) {
        System.out.println("==================창고별 재고조회=================");
        for(QuantityByLocationDTO quantity : quantityByLocationDTO) {
            System.out.println(quantity);
        }
        System.out.println("==============================================");
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch(successCode) {
            case "selectBook" : successMessage = "도서별 재고 조회에 성공하였습니다."; break;
            case "selectInventory" : successMessage = "창고별 재고 조회에 성공하였습니다."; break;
            case "insert" : successMessage = "재고 입고를 성공하였습니다."; break;
            case "update" : successMessage = "재고 출고를 성공하였습니다."; break;
            case "move" : successMessage = "재고 이동을 성공하였습니다."; break;
        }

        System.out.println(successMessage);
    }


    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch(errorCode) {
            case "selectBookList" :
                errorMessage = "도서별 재고 목록 조회를 실패하였습니다.";
                break;
            case "selectInventoryList" :
                errorMessage = "창고별 재고 목록 조회를 실패하였습니다.";
                break;
            case "insert" :
                errorMessage = "재고 입고를 실패하였습니다.";
                break;
            case "update" :
                errorMessage = "재고 출고에 실패하였습니다.";
                break;
            case "move" :
                errorMessage = "재고 이동을 실패하였습니다.";
                break;
        }
        System.out.println(errorMessage);
    }
}
