# 13장. 제네릭
멘토링 날짜 : 16/8/11, 21:00

## 제네릭이란?
Java 5부터 Generic 타입이 추가되었음
제네릭은 컬렉션, 람다식, 스트림 등에서 많이 사용
제네릭은 클래스와 인터페이스, 메서드를 정의할 때 타입을 파라메터로 사용할 수 있도록 함
타입 파라메터는 코드 작성 시 구체적인 타입으로 대체되어 다양한 코드를 생성할 수 있게 해줌
 - 컴파일 시 강한 타입 체크를 할 수 있음
 - 타입 변환(Casting)을 제거

## 제한된 타입 파라메터
```java
public <T> method() {}
public <T extends Number> method() {}
public <T super Number> method() {}
```

## class<T>, interface<T>

## Wildcard Type <?>
