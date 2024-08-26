# Fashion management system

### 구현 범위
1) 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인하는 기능 구현
2) 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액이 얼마인지 확인하는 기능 구현
3) 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격을 확인하는 기능 구현
4) 브랜드의 상품을 추가, 변경, 삭제하는 기능 구현

* 1/2/3번은 검색 컨트롤러, 4번은 관리 컨트롤러로 분리하여 개발 수행

### 코드 빌드, 테스트, 실행 방법
- JAR Build 수행
- JAR 명령어를 통해 직접 실행 : java -jar target/fashion-1.0.0.jar
- Postman을 통해 테스트 호출 수행

### 주요 API 테스트 호출 스펙
1) 카테고리 별 최저가격인 브랜드와 가격을 조회 및 총액 확인 API
- curl 'http://localhost:8080/api/fashions/search/category/lowest-price-summary'

2) 최저가 브랜드와 총액 확인 API
- curl 'http://localhost:8080/api/fashions/search/brand/lowest-price-summary'

3) 특정 카테고리의 최저가 및 최고가 브랜드 가격 확인 API
- curl 'http://localhost:8080/api/fashions/search/price-range?category=%EC%83%81%EC%9D%98'

4) 브랜드 상품 관리API
   4-1) 브랜드 상품 추가 API
   - curl 'http://localhost:8080/api/fashions' \
        --header 'Content-Type: application/json' \
        --data '{
            "brandName":"O",
            "category":"상의",
            "price":5000
        }'

   4-2) 브랜드 상품 변경 API
    - curl --request PUT 'http://localhost:8080/api/fashions/72' \
        --header 'Content-Type: application/json' \
        --data '{
            "brandName":"I",
            "category":"액세서리",
            "price":9999
        }'
   
   4-3) 브랜드 상품 삭제 API
     - curl --request DELETE 'http://localhost:8080/api/fashions/72'

### 참고사항
- H2 Local DB 사용, 초기 데이터 INSERT 로직 작성
- JPA, Lombok 디펜던시 추가
