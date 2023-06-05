package org.example;

import java.util.Date;

public class MemoPage {
    private MemoList memoList;

    // setter() , getter()
    public MemoList getMemoList() {
        return memoList;
    }
    public void setMemoList(MemoList memoList) {
        this.memoList = memoList;
    }

    // 새로운 메모 입력
    public void setMemo(Memo memo) {
        memoList = new MemoList();
        // id값 세팅 필요!
        memo.setId(this.getMemoId()); // id값 반환.
        memoList.NewMemo(memo); // 목록에 메모 추가
    }

    // id값 반환
    private int getMemoId() {
        // 메모 목록의 1,2,3 ... n번째 -> id 값으로 지정.
        return memoList.getMemoList().size()+1;
    }

    // 메모 목록 출력
    public void printMemoList() {
        memoList.printMemoList();
    }



}
