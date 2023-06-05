package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(memoList, new idComparator());
        for(Memo memo : memoList){
            if(memo!=null) {
                System.out.println("\n=====================================");
                System.out.printf(" [[ %-2d번째 메모 ]] ", memo.getId());
                memo.printMemo();
                System.out.println();
            }else {// if() of the end
                System.out.println("저장된 메모가 없습니다.");
            } // if ~ else() of the end
        }// for() of the end
    }
}

class idComparator implements Comparator<Memo> {
    @Override
    public int compare(Memo o1, Memo o2) {
        if (o1.getId() < o2.getId()) {
            return 1;
        } else if (o1.getId() > o2.getId()) {
            return -1;
        }
        return 0;
    }
}