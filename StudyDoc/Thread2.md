# 12장. 멀티 쓰레드
멘토링 날짜 : 16/8/15, 11:00

## 쓰레드풀
한번 만들어지고 죽은 쓰레드는 다시 생성될 수 없다
새로운 쓰레드가 만들어질 뿐
그래서 매번 만들면 느려지니까 미리 만들어놓고 빠르게 실행하자
우리 컴퓨터의 코어 수를 고려했을 때 쓰레드는 16개만 만들어져야 함
이럴 때 쓰레드풀을 통해 안정적인 서비스 가능

## 데몬쓰레드
고아 쓰레드를 만들고 싶지 않을 때 사용

## CountDownLatch
쓰레드를 동시에 시작시키고 다 끝날때까지 기다려주는 클래스
별도의 관리 객체를 만들어주는 객체지향 클래스

```java
CountDownLatch latch = new CountDownLatch(4);
latch.await();

// In Thread
latch.countDown();
```
CountDownLatch를 실행하는 이유는?
만약에 한번 씩 Request를 보내는 것이 아니라
한번에 엄청 큰 Request를 보낸다고 가정한다면 미리 준비해두는 것이 좋음
join()과 CountDownLatch를 비교해보면 CountDownLatch는 한번에 실행됨
성능측정할때 동시에 시작해야하기 때문에 CountDownLatch을 사용
연산을 하는 도중에 쓰레드를 만드는 것 자체가 무거운 작업이기 때문에
CountDownLatch이 엄청난 성능향상 (Stress Test : 1000)

# 질문
## 반복문에서의 메모리 해제 테크닉
```java
do {
  void func(int i) {
    ...
    break;
  }
} while(false)
// Memory terminated
```

## 반복문 성능 테스트
```java
for(Integer i : list) {
  System.out.print(i);
}

for(int i=0; i<list.size(); i++) {
  System.out.print(i);
}
```
list.size() 메서드 호출 자체가 성능에 영향을 미침
개선방법으로 final int size = list.size() 미리 선언, 할당

```java
for(long i = 1000000; i>0; --i) {
  sum += i;
}
```
어셈블리언어 내부적으로 0은 이미 있는 숫자이기 때문에
0과 비교하는 것에 성능이 더 빨라짐
