package org.example;

import java.util.Date;
import java.util.Scanner;

public class MemoApplication {
    private static MemoPage memoPage;

    public static void main(String[] args) {
        memoPage = new MemoPage();
        displayMainPage();
    }

    // 메인 페이지 출력
    private static void displayMainPage() {
        System.out.println("\n=====================================");
        System.out.println(" [[ Memo NOTE ]] ");
        System.out.println("원하는 항목 번호를 입력해주세요\n");
        System.out.println("1. 입력 2. 목록 보기 3. 수정 4. 삭제 5. 종료 메뉴");

        handleMainMemoInput();
    }

    //
    private static void handleMainMemoInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input) {
            case 1: // 입력 기능
                displayNewMemo(input);
                break;
            case 2: // 목록 보기
                displayMemoList(input);
                break;
            case 3: // 수정 기능
                displayEditMemo(input);
                break;
            case 4: // 삭제 기능
                displayDeleteMemo(input);
                break;
            case 5: // 종료 기능
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                //handleMainMemoInput(); // 재귀호출
                break;
        }
    }

    // 메모 입력 메서드
    private static void displayNewMemo(int input) {
        Scanner scanner = new Scanner(System.in);

        if (input >= 1) {
            System.out.println("이름을 입력해주세요: ");
            String name = scanner.nextLine();

            System.out.println("비밀번호를 입력해주세요: ");
            String passwd = scanner.nextLine();

            System.out.println("메모를 입력해주세요: ");
            String content = scanner.nextLine();
            Date now = new Date(); // 현재 날짜 지정.

            //id랑 date는 MemoPage에서 할 예정
            Memo memo = new Memo(name,passwd,content,now);
            memoPage.setNewMemo(memo);

            System.out.println("메모가 추가되었습니다.");
            displayMainPage();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleMainMemoInput();
        }
    }

    // 메모 목록 페이지
    private static void displayMemoList(int input) {
        memoPage.printMemoList();
        displayMainPage();
    }

    // 수정 페이지
    private static void displayEditMemo(int input) {
        Scanner scanner = new Scanner(System.in);

        memoPage.printMemoList();
        System.out.println("\n=====================================");
        System.out.println("수정할 글 번호 입력: ");
        int editNum = scanner.nextInt();

        memoPage.editMemo(editNum);
        displayMainPage();
    }

    // 삭제 페이지
    private static void displayDeleteMemo(int input) {
        Scanner scanner = new Scanner(System.in);

        memoPage.printMemoList();
        System.out.println("\n=====================================");
        System.out.println("삭제할 글 번호 입력: ");
        int delNum = scanner.nextInt();

        memoPage.deleteMemo(delNum);
        displayMainPage();
    }


}