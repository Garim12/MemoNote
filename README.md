# MemoNote, 메모장 프로젝트
<br/>

## 팀 소개

### 팀명 : 어렵자바 <br/>
팀장 : 임채영 (본인)  https://github.com/Chaeyounglim <br/>
팀원 : 김성수님  https://github.com/ksungsu <br/>
팀원 : 전영민님  https://github.com/youngmin13 <br/>
팀원 : 모성민님 https://github.com/Garim12 <br/>
팀원 : 이경식님  https://github.com/leegyeongsik

<br/><br/>

## 프로젝트의 목적 및 용도
해당 프로젝트는 "**메모장 프로그램**" 입니다.<br/>
사용자가 메모 내용을 저장하고 비밀번호를 통해 수정 및 삭제가 가능합니다.<br/>

<br/><br/><br/>


## 요구 기능 사항
### 1. 입력 기능<br/>

![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/9099e2cf-0f2d-4804-bd73-618155a5fea0)
<br/><br/>



### 2. 목록 기능<br/>

![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/47ea1cd9-5e7d-49cb-8186-62071580f139)
<br/><br/>



### 3. 수정 기능<br/>

![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/38fe08d2-ffc6-48e8-986a-4c7d7e07347d)
<br/><br/>



### 4. 삭제 기능<br/>

![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/802c82c0-53da-402f-b29c-4200a97b0a55)
<br/><br/>



### 5. 종료 기능<br/>

![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/f8f259f2-2ec4-4269-8b37-fbff10f2b430)
<br/><br/><br/>


## 기술적인 부분 <br/>
**Comparator interface** 를 상속받아 idComparator 클래스를 생성하였습니다.<br/>
compare() 메서드를 오버라이딩 하였다. <br/><br/>


```java
class idComparator implements Comparator<Memo> {
    @Override
    public int compare(Memo o1, Memo o2) {
        if(o1.getDate().before(o2.getDate())){
            return 1;
        } else if (o2.getDate().before(o1.getDate())) {
            return -1;
        }
        return 0;
    }
}
```
<br/><br/>
```java
        List<Memo> sortMemoList = new ArrayList<>();
        sortMemoList.addAll(memoList);

        Collections.sort(sortMemoList, new org.example.idComparator());
```
<br/><br/>


## 환경설정
JDK : openjdk version 17.0.7 <br/>
SDK : corretto-17 Amazon Corretto version 17.0.6 <br/>
<br/><br/>

