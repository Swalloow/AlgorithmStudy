# 12장. 멀티 쓰레드
멘토링 날짜 : 16/8/11, 21:00

## 프로세스와 쓰레드
어플리케이션을 실행하면 운영체제로부터 실행에 필요한 메모리를 할당받아 코드를 실행
자바의 모든 어플리케이션은 메인 쓰레드로부터 시작해서 마지막 코드 또는 return에서 종료
 - 프로세스 : 실행 중인 하나의 어플리케이션
 - 쓰레드 :  하나의 쓰레드는 하나의 코드 흐름

## JAVA의 Thread 클래스
먼저 기본 생성방법은 다음과 같음
```java
Thread thread = new Thread();
thread.start();
```
Runnable 인터페이스를 사용하는 경우
```java
Thread thread = new Thread(new Runnable() {
  @Override
  public void run() {
    System.out.println("Hello Thread");
  }
});
thread.start();
```
이외에도 쓰레드를 상속받는 클래스를 만들 수 있음

## 쓰레드 우선순위
자바의 쓰레드 스케줄링은 우선순위(Priority) 방식과 순환할당(Round-Robin) 방식이 있음

순환할당 방식은 JVM에 의해 정해지기 때문에 코드로 제어할 수 없음
하지만 우선순위 방식은 코드로 제어할 수 있음

자바는 `setPriority()` 메서드를 통해 10까지의 우선순위를 부여할 수 있음
Thread 클래스의 상수를 사용할 수도 있음 (MAX: 10, NORM: 5, MIN: 1)

```java
thread.setPriority(priority);
thread.setPriority(Thread.MAX_PRIORITY);
thread.setPriority(Thread.NORM_PRIORITY);
thread.setPriority(Thread.MIN_PRIORITY);
```

## 동기화 블록
동시에 공유 객체에 접근한다면 동시성(Concurrency) 문제가 발생함
동시성 문제를 해결하기 위해서는 멀티 쓰레드에서 하나의 쓰레드만 실행할 수 있는
임계 영역(Critical Section)을 지정해야하는데,
자바에서는 이를 제어하기 위해 `동기화(Synchronized) 메서드`를 제공

```java
public synchronized void method() {
  // Critical Section
}
```
메소드 내용이 아니라 일부 내용만 만들고 싶다면 `동기화 블록`을 사용
```java
public void method() {
  ...
  synchronized(Object obj) {
    // Critical Section
  }
  ...
}
```

## 쓰레드 상태
쓰레드 객체를 생성하고, `start()` 메서드를 호출하면
쓰레드가 바로 실행이 되는 것이 아니라, 실행 대기 상태가 됨
(스케줄링이 되지 않아서 실행을 기다리고 있는 상태)
이후 스케줄링이 된 쓰레드는 `run()` 메서드를 실행하여 `RUNNING` 상태가 됨

자바에서는 쓰레드의 상태를 코드에서 확인할 수 있는 getState() 메서드가 있음
쓰레드 생명주기에 따른 상수는 다음과 같음
```
NEW → RUNNABLE → TIMED_WAITING(WAITING) → BLOCKED → TERMINATED
```

쓰레드의 상태를 통해 다음과 같이 활용할 수 있음
```java
public void run() {

  while(true) {
    Thread.State state = targetThread.getState();
    if(state == Thread.State.NEW) {
      targetThread.start();
    }

    if(state == Thread.State.TERMINATED) {
      break;
    }
  }
}
```

## 쓰레드 상태제어
실행 중인 쓰레드의 상태를 변경하고 싶을 때 쓰레드 상태제어를 사용
자바에서는 이를 위해 다양한 메서드를 제공함
`resume(), suspend(), stop()` 이 메서드는 안정성을 위해 Deprecated 되었음
 - sleep() : 주어진 시간 동안 일시정지
 - yield() : 다른 쓰레드에게 실행 양보
 - join() : 다른 쓰레드의 종료를 기다림
 - wait() : 동기화 블럭에서 쓰레드를 일시정지 상태로 만듬
 - notify() : 일시정지해있는 쓰레드를 실행대기 상태로 만듬
 - interrupt() : 쓰레드의 안전한 종료

동기화 메서드에서 제어하는 예제는 다음과 같음
```java
public synchronized void method {
  notify();
  try {
    wait();
  } catch(InterruptedException e) {}
}
```

데이터를 저장하고 소비하는 Producer, Consumer 예제는 다음과 같음
GitHub JavaStudy에 저장

## 쓰레드 그룹
쓰레드 그룹(ThreadGroup)은 관련 쓰레드를 묶어서 관리할 목적으로 이용
보통 JVM이 실행되면 system 쓰레드 그룹을 만들고, JVM 운영에 필요한 쓰레드를 생성해서
system 쓰레드 그룹에 포함시킴
그리고 그 하위 쓰레드 그룹으로 main을 만들고 대부분 우리가 만드는 작업 쓰레드가 여기에 속함
쓰레드 그룹의 가장 큰 장점은 그룹의 interrupt() 메서드를 통해
한번에 그룹에 속한 모든 쓰레드를 종료시킬 수 있다는 것

```java
// 쓰레드 그룹 생성
ThreadGroup tg = new ThreadGroup(String name);
ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name);

// 그룹 이름 가져오기
ThreadGroup group = Thread.currentThread.getThreadGroup();
String groupName = group.getName();
```

## 쓰레드풀
병렬 작업 처리로 인해 쓰레드의 개수가 계속 증가하게 되면
쓰레드 생성과 스케줄링으로 인해 메모리 사용량이 늘어나고 성능 저하 발생
따라서 이를 막기 위해 쓰레드풀을 지정해서 쓰레드 개수에 제한을 두는 것

## 작업 생성과 처리 요청
#### 작업 생성
하나의 작업은 Runnable 또는 Callable 클래스로 표현
둘의 차이점은 리턴 값이 있는지 유무
쓰레드풀의 쓰레드는 작업 큐에서 Runnable 또는 Callable 객체를 가져와서
run()과 call() 메서드를 실행

```java
Callable<T> task = new Callable<T> {
  @Override
  public T call() throws Exception {
    // Thread working
    return T;
  }
}
```

#### 작업 처리 요청
처리 요청은 ExecutorService의 작업 큐에 Runnable 또는 Callable 객체를 넣는 것을 말함
이를 위해 `execute()` 와 `submit()` 메서드를 사용함
execute() 는 작업처리 결과를 받지 못하고, submit()은 Future를 통해 결과를 받을 수 있음
execute() 는 작업처리 도중 예외가 발생하면 쓰레드 종료되고,
submit() 은 예외가 발생하더라도 다음 작업을 위해 재사용
결론, 쓰레드의 생성 오버헤드를 줄이기 위해 submit()을 사용하는 것이 좋음

#### 작업 처리 결과를 외부 객체에 저장
그림참고
