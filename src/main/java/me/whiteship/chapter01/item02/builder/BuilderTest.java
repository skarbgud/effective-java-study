package me.whiteship.chapter01.item02.builder;

public class BuilderTest {

    public static void main(String[] args) {
        // 단점1. 모든 매개변수 생성자가 사용되게 된다. -> @AllArgsConstructor(access = AccessLevel.PRIVATE)
//        NutritionFacts nutritionFacts = new NutritionFacts(10, 10, 10, 0, 0, 0);
        // 단점2. 필수값을 정할 수 없다.
//        new NutritionFacts.NutritionFactsBuilder()
//                .servingSize(10)
//                .servings(10)
//                .build();
        new NutritionFacts.Builder(10, 10)
                .calories(10)
                .build();
    }
}
