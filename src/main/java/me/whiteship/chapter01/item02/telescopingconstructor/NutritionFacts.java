package me.whiteship.chapter01.item02.telescopingconstructor;

// 코드 2-1 점층적 생성자 패턴 - 확장하기 어렵다! (14~15쪽)
public class NutritionFacts {

    private  int servingSize;  // (mL, 1회 제공량)     필수
    private  int servings;     // (회, 총 n회 제공량)  필수
    private  int calories;     // (1회 제공량당)       선택
    private  int fat;          // (g/1회 제공량)       선택
    private  int sodium;       // (mg/1회 제공량)      선택
    private  int carbohydrate; // (g/1회 제공량)       선택

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

    public NutritionFacts() {
    }

    public static void main(String[] args) {
        // 점층적 생성자 패턴 또는 생성자 체이닝
//        NutritionFacts cocaCola = new NutritionFacts(10, 10); //어떤 파라미터에 들어가는지 확인하기 어렵다.

        // 자바빈즈 패턴
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);

        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}