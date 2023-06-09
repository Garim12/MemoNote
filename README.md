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

<br/>

## 메인 페이지
```java
    public static void displayMainPage() {
        System.out.println("\n=====================================");
        System.out.println(" [[ Memo NOTE ]] ");
        System.out.println("원하는 항목 번호를 입력해주세요\n");
        System.out.println("1. 입력 2. 목록 보기 3. 수정 4. 삭제 5. 종료 메뉴");
        System.out.print("번호를 입력해주세요: ");

        handleMainMemoInput();
    }
    
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
```
![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/1b09d725-da0f-4e31-a160-fd8b29c7cbf3)
<br/>

* 메인 페이지에서 입력, 목록 조회, 수정, 삭제를 수행할 수 있습니다. <br/>
* handleMainMemoInput() 메서드를 실행하여 입력값에 따라 수행합니다.
* 5번을 입력할 경우, 프로그램을 종료할 수 있습니다. <br/><br/>


<br/><br/>

## 요구 기능 사항
### 1. 입력 기능<br/>


- 이름, 비밀번호, 메모를 스캐너를 통해 입력 받습니다. <br/>
- 1건의 글을 생성 및 메모 리스트에 저장합니다. <br/> <br/>
![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/9099e2cf-0f2d-4804-bd73-618155a5fea0)
<br/><br/>



### 2. 목록 기능<br/>
- 메모 전체를 조회할 수 있습니다. <br/>
- 작성 최신 순으로 메모를 출력니합니다 <br/><br/>
![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/47ea1cd9-5e7d-49cb-8186-62071580f139)
<br/><br/>



### 3. 수정 기능<br/>
- 수정할 글 번호를 입력 받습니다. <br/>
- 수정할 글이 존재하면 글을 수정하고 존재하지 않으면 존재하지 않는다고 메시지를 출력합니다. <br/>
- 수정할 글의 비밀번호를 입력 받습니다. <br/>
- 글을 수정하기 위해 입력한 비밀번호와 수정할 글의 비밀번호가 일치하면 글을 수정하고 일치하지 않으면 비밀번호가 일치하지 않는다는 메시지를 출력합니다.<br/>
    - 비밀번호가 일치할 시 : 수정 내용 업데이트<br/>
    - 비밀번호 불일치 시 : 비밀번호가 일치하지 않는다는 메시지 출력<br/>
- 글의 수정 시, 수정 시간으로 시간이 변니됩니다. <br/><br/>
![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/38fe08d2-ffc6-48e8-986a-4c7d7e07347d)
<br/><br/>



### 4. 삭제 기능<br/>
- 삭제할 글 번호를 입력 받습니다.<br/>
- 글 삭제 후 글 번호를 다시 붙여줍니다. <br/>
- 삭제할 글이 존재하면 글을 삭제하고 존재하지 않으면 존재하지 않는다는 메시지를 출력합니다.<br/>
- 삭제할 글의 비밀번호를 입력 받고 비밀번호 일치 여부를 판단합니다.<br/>
- 글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정니합니다. <br/><br/>
![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/802c82c0-53da-402f-b29c-4200a97b0a55)
<br/><br/>



### 5. 종료 기능<br/>
- ![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/f8f259f2-2ec4-4269-8b37-fbff10f2b430)
<br/><br/><br/>


## 기술적인 부분
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
```java
        List<Memo> sortMemoList = new ArrayList<>();
        sortMemoList.addAll(memoList);

        Collections.sort(sortMemoList, new org.example.idComparator());
```
**Comparator interface** 를 상속받아 idComparator 클래스를 생성하였습니다.<br/>
compare() 메서드를 오버라이딩 하였습니다. <br/><br/><br/>

<br/>

## 요구사항 기능 테스트
* 기능을 모두 구현한 후에 콘솔창에서 직접 테스트를 해보았습니다.<br/>
* 기능 요구사항에 맞게 정상적으로 실행이 되는지에 여부를 판단하기 위함 입니다.<br/>
* 첫번째 테스트 때, 글이 존재하지 않을 경우 오류가 나며 프로그램이 종료되었습니다.<br/><br/>
![image](https://github.com/Chaeyounglim/MemoNote/assets/55676554/bf92a841-4ac4-40e5-a46c-45f1e7bfc6ea)
<br/><br/>

* 메모 수정시 해당 조건에 만족하는 메모가 없을 경우<br/>
```java
    public void editMemo(int editNum) {
        if (memoList.size() > 0) {
            Memo editMemo = getMemo(editNum); // 수정할 Memo
            if (editMemo != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("비밀번호를 입력하세요: ");

                String password = scanner.nextLine();

                if (password.equals(editMemo.getPassword())) {
                    System.out.print("수정할 이름을 입력해주세요: ");
                    String modifyName = scanner.nextLine();

                    System.out.print("수정할 메모를 입력해주세요: ");
                    String modifyContent = scanner.nextLine();
                    Date modifyDate = new Date(); // 현재 날짜 지정.

                    //id랑 date는 MemoPage에서 할 예정
                    Memo memo = new Memo();

                    memo.setId(editNum);
                    memo.setName(modifyName);
                    memo.setContent(modifyContent);
                    memo.setDate(modifyDate);
                    memo.setPassword(editMemo.getPassword());

                    int key = editNum - 1;

                    memoList.set(key, memo);
                    System.out.println("메모가 수정되었습니다.");
                    displayMainPage();
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            } else {
                System.out.println("존재하지 않는 글입니다.");
            }
        }
        else {
            System.out.println("수정할 글이 없습니다");
        }
    }
```
<br/>

* 메모 삭제시 해당 조건에 만족하는 메모가 없을 경우<br/>
```java
    public void deleteMemo(int delNum) {
        if (memoList.size() > 0) {
            Memo deleteMemo = getMemo(delNum); // 삭제할 Memo

            if (deleteMemo != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("비밀번호를 입력하세요: ");
                String password = scanner.nextLine();

                if (password.equals(deleteMemo.getPassword())) {
                    memoList.remove(deleteMemo);
                    reindexMemo(); // 글 삭제 후 글 번호 다시 붙여주기
                    System.out.println("글이 삭제되었습니다.");
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            } else {
                System.out.println("존재하지 않는 글입니다.");
            }
        } else {
            System.out.println("삭제할 글이 없습니다");
        }
    }
```
 -> ***해당 예외를 추가적으로 처리하고, 다시 테스트하여 모든 요구사항을 충족시켰습니다.***
<br/><br/>


<br/>

## 환경설정
Language : Java IDLE : IntelliJ community <br/>
JDK : openjdk version 17.0.7 <br/>
SDK : corretto-17 Amazon Corretto version 17.0.6 <br/>
<br/><br/>

