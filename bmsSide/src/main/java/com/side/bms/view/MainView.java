package com.side.bms.view;

import com.side.bms.controller.InventoryController;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    Scanner sc = new Scanner(System.in);
    private InventoryController inventoryController = new InventoryController();

    /***
     * 메인 메뉴 뷰
     */
    public void mainView() {
        while (true) {
            int menuNum = 0;
            System.out.println("""
                    ========================
                    메 인 메 뉴
                    ========================
                    1. 로그인
                    2. 회원가입
                    9. 프로그램 종료
                    """);
            try {
                System.out.print("메뉴번호를 입력하세요 : ");
                menuNum = sc.nextInt();
                sc.nextLine();

                if (menuNum < 0) {
                    System.out.println("정수를 입력해주세요.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해주세요.");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("입력 오류가 발생했습니다.");
            }
            switch (menuNum) {
                case 1:
                    adminView();
                    break;
                case 2:
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴 번호를 잘못입력하셨습니다.");
                    break;
            }
        }

    }

    // 재고 관리 관리자 뷰
    private void adminView() {
        while (true) {
            int menuNum = 0;
            System.out.println("""
                    ========================
                    관 리 자 메 뉴
                    ========================
                    1. 재고 조회
                    2. 재고 입고
                    3. 재고 출고
                    4. 재고 이동
                    9. 로그아웃
                    """);
            try {
                System.out.print("메뉴번호를 입력하세요 : ");
                menuNum = sc.nextInt();
                sc.nextLine();
                if (menuNum < 0) {
                    System.out.println("정수를 입력해주세요.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해주세요.");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("입력 오류가 발생했습니다.");
            }
            switch (menuNum) {

                case 1:
                    searchInventoryView();
                    break;
                case 2:
                    inventoryController.insertInInventory(inputInInventory());
                    break;

                case 3:
                    inventoryController.updateOutInventory(inputOutInventory());
                    break;

                case 4:
                    inventoryController.moveInventory(inputMoveInventory());
                    break;

                case 9:
                    System.out.println("로그아웃 합니다.");
                    return;
                default:
                    System.out.println("메뉴 번호를 잘못입력하셨습니다.");
                    break;
            }
        }
    }


    // 재고 조회 뷰
    private void searchInventoryView() {
        while (true) {
            int menuNum = 0;

            System.out.println("""
                    ========================
                    재 고 조 회 메 뉴
                    ========================
                    1. 도서별 재고조회
                    2. 창고별 재고 조회
                    9. 이전메뉴
                    """);
            try {
                System.out.print("메뉴번호를 입력하세요 : ");
                menuNum = sc.nextInt();
                sc.nextLine();
                if (menuNum < 0) {
                    System.out.println("정수를 입력해주세요.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해주세요.");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("입력 오류가 발생했습니다.");
            }
            switch (menuNum) {
                case 1:
                    inventoryController.selectBookQuantity();
                    break;
                case 2:
                    inventoryController.selectLocationQuantity();

                    break;
                case 9:
                    System.out.println("이전메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("메뉴 번호를 잘못입력하셨습니다.");
            }
        }
    }

    // 재고 입고
    private Map<String, String> inputInInventory() {
        System.out.print("도서 ID를 입력하세요 : ");
        String bookId = sc.nextLine();

        System.out.print("수량을 입력하세요 : ");
        String bookQuantity = sc.nextLine();

        System.out.print("창고 위치를 입력하세요(창고1,창고2,창고3) : ");
        String bookLocation = sc.nextLine();

        Map<String, String> map = new HashMap<>();
        map.put("bookId", bookId);
        map.put("bookQuantity", bookQuantity);
        map.put("bookLocation", bookLocation);
        return map;
    }

    // 재고 출고
    private Map<String, String> inputOutInventory() {
        System.out.print("출고할 도서 ID를 입력하세요 : ");
        String bookId = sc.nextLine();

        System.out.print("출고 할 수량을 입력하세요 : ");
        String bookQuantity = sc.nextLine();

        Map<String, String> map = new HashMap<>();
        map.put("bookId", bookId);
        map.put("bookQuantity", bookQuantity);
        return map;
    }

    // 재고 이동
    private Map<String, String> inputMoveInventory() {
        System.out.print("이동할 도서 ID를 입력하세요 : ");
        String bookId = sc.nextLine();

        System.out.print("이동할 창고 위치를 입력하세요(창고1,창고2,창고3) : ");
        String bookLocation = sc.nextLine();

        Map<String, String> map = new HashMap<>();
        map.put("bookId", bookId);
        map.put("bookLocation", bookLocation);

        return map;

    }



}
