# 이펙티브자바 스터디

# **Item1. 생성자 대신 정적 팩터리 메서드를 고려하라.**

---

- 일반적인 인스턴스 생성 방법은 public 생성자다.
- 정적 팩터리 메서드(static factory method) 로도 클래스 인스턴스를 생성 할 수 있다.
- 정적 팩터리 메서드란?
    - 객체 생성을 흔히 사용하는 생성자가 아닌 정적(static) 메서드로 객체를 생성하는 메서드
- 정적 팩터리 메서드의 장점
1. 이름을 가질 수 있다.

일반적으로 생성자의 경우 객체를 생성할 때, 반활될 객체의 특성을 설명할 수 없다. → 이름을 따로 못가지기 때문에

ex) 

```java
public class ExampleCalendar {
	private int year;
	private int month;
}

public static void main(String[] args) {
    // 생성자로 객체를 생성
		ExampleCalendar calendar = new ExampleCalendar(2024, 2);
}
```

이처럼 객체의 생성자로 생성할 경우 해당 객체가 어떤 특성을 가지고 있는지 알 수 없다.

```java
// 정적 팩터리 메서드로 객체를 생성할 경우
public class ExampleCalendar {
	private int year;
	private int month;

	// 예시1. 연도와 월을 받아 객체를 생성
	public static ExampleCalendar createCalendar(int year, int month) {
		return new ExampleCalendar(year, month);
	}
	// 예시2. 현재 날짜로 객체를 생성
	public static Calendar createCurrentCalendar() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		return new ExampleCalendar(year, month);
	}
}

public static void main(String[] args) {
    // 정적 팩터리 메서드로 생성하면 객체된 객체의 특성을 파악 가능 
		// 1. 연도와 월을 지정
		ExampleCalendar calendar1 = ExampleCalendar.createCalendar(2024, 2);
		// 2. 현재 날짜로 생성
		ExampleCalendar calendar2 = ExampleCalendar.createCurrentCalendar();
		
}
```

2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
- 불변 클래스는 인스턴스를 미리 만들어 놓거나 만들어놓은 인스턴스를 재활용해서 불필요한 객체 생성을 피할 수 있다 → 싱글턴패턴 방식
- Boolean.valueOf(boolean) 메서드는 객체를 아에 생성하지 않는다. (valueOf 메서드 static)

![Untitled1](https://github.com/skarbgud/effective-java-study/blob/main/src/main/resources/description/Untitled%201.png)
![Untitled1](https://github.com/skarbgud/effective-java-study/blob/main/src/main/resources/description/Untitled.png)

- 이처럼 반복된 정적 팩터리 방식의 클래스는 언제 어느 인스턴스를 살아 있게 할지를 통제할 수 있다 → 인스턴스 통제(instance-controlled) 클래스
- 인스턴스 통제 클래스를 통해 싱글턴으로 만들수도 있고, 인스턴스화 불가(noninstantiable)로 만들 수 있다.
- 인스턴스 통제를 통해 인스턴스가 동일 인스턴스임을 보장 가능 (a ==b가 가능, a.equals(b)안해도 됨)
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
- 객체를 반환할때 반환 타입을 하위 객체로 반환할 수 있기 때문에 객체의 유연성이 증가
- 실제 구현클래스가 무엇인지 알아보지 않아도 된다.
- 정적 팩터리 메서드를 사용해서 얻은 객체를 인터페이스만으로 다루게 된다.
- 자바8부터 인터페이스가 정적 메서드를 가질 수 없다는 제한이 풀렸다.

```java
public interface Person {
	String hello();

	// 어느 국가에서 온 사람인지에 따라 다른 하위 객체를 반환한다.
	public static Person from(String country) {
		if (country.eqauls("ko")) {
			return new Korean();
		} else if (country.eqauls("ch")) {
			return new Chinese();
		} else if (country.eqauls("jp")) {
			return new Japanese();
		}
	}
}

public class Korean implements Person {
    @Override
    public String hello() {
        return "안녕하세요";
    }
}

public class Chinese implements Person {
    @Override
    public String hello() {
        return "니하오";
    }
}

public class Chinese implements Person {
    @Override
    public String hello() {
        return "니하오";
    }
}

public class Japanese implements Person {
    @Override
    public String hello() {
        return "곤니찌와";
    }
}
```

4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
- 반환타입의 하위 타입이기만 하면 어떤 클래스의 객체를 반환하든 상관없다.
- 위의 예시에서 또 다른 국가의 클래스가 필요하다면 추가를 해도 되고 제거해도 된다.
5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
- 정적 팩터리 메서드가 반환하는 인스턴스에 대한 실제 구현체는 DI, 리플렉션등으로 주입될 수 있다.

- 정적 팩터리 메서드의 단점
1. 상속을 하려면 public 이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
- 정적 메서드를 통해서만 객체를 생성하니 public 생성자, protected 생성자가 없기 때문에 하위 클래스를 생성이 불가능하다.
2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.
- 생성자처럼 API 설명에 명확하게 드러나지 않기 때문에 어떤 방법으로 객체를 생성하는지 알기 어렵다.
- 주석으로 인스턴스 생성에 대한 부분을 명확하게 문서화해야함
