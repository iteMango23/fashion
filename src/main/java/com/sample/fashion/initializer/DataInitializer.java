package com.sample.fashion.initializer;

import com.sample.fashion.model.entity.Fashion;
import com.sample.fashion.repository.FashionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner load(FashionRepository repository) {
        return args -> {
            repository.save(new Fashion("A", "상의", 11200));
            repository.save(new Fashion("A", "아우터", 5500));
            repository.save(new Fashion("A", "바지", 4200));
            repository.save(new Fashion("A", "스니커즈", 9000));
            repository.save(new Fashion("A", "가방", 2000));
            repository.save(new Fashion("A", "모자", 1700));
            repository.save(new Fashion("A", "양말", 1800));
            repository.save(new Fashion("A", "액세서리", 2300));

            repository.save(new Fashion("B", "상의", 10500));
            repository.save(new Fashion("B", "아우터", 5900));
            repository.save(new Fashion("B", "바지", 3800));
            repository.save(new Fashion("B", "스니커즈", 9100));
            repository.save(new Fashion("B", "가방", 2100));
            repository.save(new Fashion("B", "모자", 2000));
            repository.save(new Fashion("B", "양말", 2000));
            repository.save(new Fashion("B", "액세서리", 2200));

            repository.save(new Fashion("C", "상의", 10000));
            repository.save(new Fashion("C", "아우터", 6200));
            repository.save(new Fashion("C", "바지", 3300));
            repository.save(new Fashion("C", "스니커즈", 9200));
            repository.save(new Fashion("C", "가방", 2200));
            repository.save(new Fashion("C", "모자", 1900));
            repository.save(new Fashion("C", "양말", 2200));
            repository.save(new Fashion("C", "액세서리", 2100));

            repository.save(new Fashion("D", "상의", 10100));
            repository.save(new Fashion("D", "아우터", 5100));
            repository.save(new Fashion("D", "바지", 3000));
            repository.save(new Fashion("D", "스니커즈", 9500));
            repository.save(new Fashion("D", "가방", 2500));
            repository.save(new Fashion("D", "모자", 1500));
            repository.save(new Fashion("D", "양말", 2400));
            repository.save(new Fashion("D", "액세서리", 2000));

            repository.save(new Fashion("E", "상의", 10700));
            repository.save(new Fashion("E", "아우터", 5000));
            repository.save(new Fashion("E", "바지", 3800));
            repository.save(new Fashion("E", "스니커즈", 9900));
            repository.save(new Fashion("E", "가방", 2300));
            repository.save(new Fashion("E", "모자", 1800));
            repository.save(new Fashion("E", "양말", 2100));
            repository.save(new Fashion("E", "액세서리", 2100));

            repository.save(new Fashion("F", "상의", 11200));
            repository.save(new Fashion("F", "아우터", 7200));
            repository.save(new Fashion("F", "바지", 4000));
            repository.save(new Fashion("F", "스니커즈", 9300));
            repository.save(new Fashion("F", "가방", 2100));
            repository.save(new Fashion("F", "모자", 1600));
            repository.save(new Fashion("F", "양말", 2300));
            repository.save(new Fashion("F", "액세서리", 1900));

            repository.save(new Fashion("G", "상의", 10500));
            repository.save(new Fashion("G", "아우터", 5800));
            repository.save(new Fashion("G", "바지", 3900));
            repository.save(new Fashion("G", "스니커즈", 9000));
            repository.save(new Fashion("G", "가방", 2200));
            repository.save(new Fashion("G", "모자", 1700));
            repository.save(new Fashion("G", "양말", 2100));
            repository.save(new Fashion("G", "액세서리", 2000));

            repository.save(new Fashion("H", "상의", 10800));
            repository.save(new Fashion("H", "아우터", 6300));
            repository.save(new Fashion("H", "바지", 3100));
            repository.save(new Fashion("H", "스니커즈", 9700));
            repository.save(new Fashion("H", "가방", 2100));
            repository.save(new Fashion("H", "모자", 1600));
            repository.save(new Fashion("H", "양말", 2000));
            repository.save(new Fashion("H", "액세서리", 2000));

            repository.save(new Fashion("I", "상의", 11400));
            repository.save(new Fashion("I", "아우터", 6700));
            repository.save(new Fashion("I", "바지", 3200));
            repository.save(new Fashion("I", "스니커즈", 9500));
            repository.save(new Fashion("I", "가방", 2400));
            repository.save(new Fashion("I", "모자", 1700));
            repository.save(new Fashion("I", "양말", 1700));
            repository.save(new Fashion("I", "액세서리", 2400));
        };
    }
}
