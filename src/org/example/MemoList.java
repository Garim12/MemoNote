package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoList {
    private List<Memo> memoList;

    // 생성자 메서드
    public MemoList() {
        memoList = new ArrayList<>();
    }

    // setter() , getter()
/*    public void setMomoList(List<Memo> memoList) {
        this.memoList = memoList;
    }*/
    public List<Memo> getMemoList() {
        return memoList;
    }

    // list에 memo 추가
    public void NewMemo(Memo memo){
        this.memoList.add(memo);
    }

    // 메모 정보 출력
    public void printMemoList() {
        int i = 1; // 몇번째 메모인지 출력하기 위해 변수 선언
        for(Memo memo : memoList){
            if(memo!=null) {
                System.out.println("\n=====================================");
                System.out.printf(" [[ %-2d번째 메모 ]] ",i);
                memo.printMemo();
                System.out.println();
                i++;
            }else {// if() of the end
                System.out.println("저장된 메모가 없습니다.");
            } // if ~ else() of the end
        }// for() of the end
    }

    // 번호를 넘겨받아 해당 memo 반환하는 메소드
    public Memo getMemo(int num) {
        num--; // 1번째 메모는 0번 인덱스이므로 감소시킴
        return memoList.get(num);
    }

    // 해당되는 글 1건 수정하는 메서드
    public void editMemo(int editNum) {
        Memo editMemo = getMemo(editNum); // 수정할 Memo


    }

    // 해당 글 삭제하는 메서드
    public void deleteMemo(int delNum) {
        Memo deleteMemo = getMemo(delNum); // 삭제할 Memo

        if (deleteMemo != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("비밀번호를 입력하세요: ");
            String password = scanner.nextLine();

            if (MemoPage.checkPwForm(deleteMemo, password)) {
                memoList.remove(deleteMemo);
                reindexMemo(); // 글 삭제 후 글 번호 다시 붙여주기
                System.out.println("\n글이 삭제되었습니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("존재하지 않는 글입니다.");
        }
    }

    // 삭제후 글 번호 다시 붙여주기.
    // 글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정한다.
    private void reindexMemo() {
        for (int i = 0; i < memoList.size(); i++) {
            memoList.get(i).setId(i + 1);
        }
    }

}
