package org.example;

import java.util.ArrayList;
import java.util.List;

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

    
}
