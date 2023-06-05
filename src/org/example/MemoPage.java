package org.example;

import java.util.Date;
import java.util.Scanner;

public class MemoPage {
    private MemoList memoList;
    private int memoNum; // 메모 일련 번호 (수정 삭제시 필요)

    // 생성자 메서드
    public MemoPage() {
        memoList = new MemoList();
        memoNum = 0;
    }

    // setter() , getter()
    public MemoList getMemoList() {
        return memoList;
    }
    public void setMemoList(MemoList memoList) {
        this.memoList = memoList;
    }

    // 새로운 메모 입력
    public void setNewMemo(Memo memo) {
        memo.setId(this.getMemoId()); // id값 setting.
        memoList.NewMemo(memo); // 목록에 메모 추가
    }

    // id값 반환
    private int getMemoId() {
        // 메모 목록의 1,2,3 ... n번째 -> id 값으로 지정.
        this.memoNum = memoList.getMemoList().size()+1;
        return memoList.getMemoList().size()+1;
    }

    // 메모 목록 출력
    public void printMemoList() {
        memoList.printMemoList();
    }


    // 메모 삭제하기
    public void deleteMemo(int delId) {
        memoList.deleteMemo(delId);
    }
    
    // 메모 수정하기
    public void editMemo(int editId){
        memoList.editMemo(editId);
    }


    // 비밀번호 확인
    static boolean checkPwForm(Memo memo, String password) {
        return memo.getPassword().equals(password);
    }
}