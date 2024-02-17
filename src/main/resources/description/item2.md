# **Item2. 생성자에 매개변수가 많다면 빌더를 고려하라**

---

- 정적 팩터리와 생성자로 객체생성시 매개변수가 많을때 대응이 어렵다는 제약이 있다.
- 이런 상황에는 점증척 생성자 패턴(telescoping constructor pattern)으로 매개변수에 대응되는 생성자를 늘려가는 방식으로 대응

### 점증척 생성자 패턴(telescoping constructor pattern)이란?

- 생성자를 필수 매개변수 1개만 받는 생성자, 필수 매개변수 1개와 선택 매개변수 1개를 받는 생성자, 선택 매개변수 2개를 받는 생성자 등에 형태로 매개변수 개수만큼 생성자를 늘리는 방식

```java
public class NutritionFacts {
	private final int servingSize;    // (ml, 1회 제공량)     필수
	private final int servings;       // (회, 총 n회 제공량)  필수
	private final int calories;       // (1회 제공량당)       선택
	private final int fat;            // (g/1회 제공량)       선택
	private final int sodium;         // (mg/1회 제공량)      선택  
	private final int carbohydrate;   // (g/1회 제공량)       선택

	public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);    
	}     

	public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);    
	}     

	public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);    
	} 
    
	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);    
	}

  public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {        
				this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
  }
}
```

- 점층적 생성자 패턴을 쓸 수 있지만, 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다. → 생성자의 매개변수 몇개인지, 어떤값에 매칭되는지 하나씩 확인해야함
- 매개변수가 많을 때 활용할 수 있는 두번째 방법은 자바빈즈패턴(JavaBeans pattern)이 있다.

### 자바빈즈패턴(JavaBeans pattern)이란?

매개변수가 없는 생성자로 객체를 만든 후 세터(setter) 메서드들을 호출해 원하는 매개변수의 값을 설정하는 방식이다.

```java
public class NutritionFacts {

	private int servingSize = -1; // 필수
	private int servings = -1; // 필수
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;

	public NutritionFacts() { }

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
    
}
```

호출방법

```java
NutritionFacts cocalCola = new NutritionFacts();
cocalCola.setServingSize(240);
cocalCola.setServings(8);
cocalCola.setCalories(100);
cocalCola.setSodium(35);
cocalCola.setCarbohydrate(27);
```

- 자바빈즈 패턴에서는 객체 하나를 만드려면 메서드를 여러 개 호출해야 하고, 객체가 완전히 생성되기 전까지는 일관성(consistency)이 무너진 상태에 놓이게 된다. → set메소드로 객체를 생성하고 값을 세팅해줘야함.
- **자바빈즈 패턴에서는 클래스를 불변으로 만들 수 없으며**, 스레드 안정성을 얻으려면 개발자가 추가 작업을 해줘야만 한다.
- 빌더 패턴(Builder Pattern)은 점층적 생성자 패턴의 안정성과 자바빈즈 패턴의 가독성을 겸비한 패턴이다.

### 빌더 패턴(Builder pattern)이란?

빌더 패턴은 소프트 웨어 디자인 패턴 중에 하나로 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴

```java
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 필수 매개변수        
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
```

- NutritionFacts 클래스는 불변, 세터 메서드들은 빌더 자신을 반환하기 때문에 연쇄적으로 호출 할 수 있다. → 메서드 체이닝(method chaining)

사용 예시

```java
public static void main(String[]args) {
    NutritionFacts cocaCola=new NutritionFacts.Builder(240,8).calories(100).sodium(35).carbohydrate(27).build();
}
```

- 빌더 객체가 제공하는 setter 메서드를 이용하여 선택 매개변수를 설정한다.
- 최종적으로 build 메서드를 호출하여 필요한 객체를 얻는다 → build 메서드가 호출하는 생성자에서 여러 매개 변수에 걸친 불변식(invariant)을 검사하자 (매개변수가 잘못되었다면 해당 메세지를 담아 IllegalArgumentException을 던지기)
- 빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기에 좋다.
- 각 계층에 클래스에 관련 빌더를 멤버로 정의하자. 추상 클래스는 추상 빌더를, 구체 클래스는 구체 빌더를 갖게 한다.

피자 추상 클래스의 구현 예시

```java
public abstract class Pizza {
    public enum Topping { HAM, ONION, GALIC, SAUSAGE, BULGOGI }
    Set<Topping> toppingList;

    abstract static class Builder<T extends Builder<T>>{

        EnumSet<Topping> toppingList = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping){
            toppingList.add(Objects.requireNonNull(topping));
            return self();

        }

        abstract Pizza build();

				// 하위 클래스는 이 메서드를 재정의(overriding) 하여
				// "this"를 반환하도록 해야 한다.
        protected abstract T self();

    }

    Pizza(Builder<?> builder){
        toppingList = builder.toppingList.clone(); // 아이템 50 참조
    }
}
```

- 추상 메소드인 self 를 통해 하위 클래스에서 형변환을 하지 않고 메서드 체이닝을 사용할 수 있다 → 셀프 타입(simulated self-type) 관용구

```java
public class NyPizza extends Pizza {
	public enum Size { SMALL, MEDIUM, LARGE }
	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;		
		}

		public NyPizza(Builder builder) {
			super(builder);
			size = builder.size;
		}
	}
}
```

```java
public class Calzone extends Pizza {
	private final boolean sauceInside;

	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sauceInsice = false;

		public Builder sauceInside() {
			sauceInsdie = true;
			return this;
		}
		
		@Override
		public Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}

		private Calzone(Builder builder) {
			super(builder);
			sauceInside = builder.sauceInside;
		}
	}
}
```

```java
NyPizza pizza = new NyPizza.Builder(SMALL)
	.addTopping(SAUSAGE)
	.addTopping(ONION)
	.build();

Calzone pizza = new Calzone.Builder()
	.addTopping(HAM)
	.sauceInside()
	.build();
```

- 하위 클래스의 build 메서드는 구체 하위 클래스를 반환하도록 선언(공변 반환 타이핑 - covariant return typing)
- 생성자와 달리 가변 인수 매개변수를 여러 개 사용하는 것이 가능하다 → addTopping 메서드
- 빌더의 매개변수에 따라 다른 객체를 생성할 수 있다.
- 생성자나 정적팩터리 방식으로 시작했다가 나중에 매개변수가 많아지면 빌더 패턴으로 전환할 수 있지만 기존 코드가 도드라지니 매개변수가 많아진다면 애초부터 빌더를 고려하자