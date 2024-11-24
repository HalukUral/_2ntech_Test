Feature: Arama Fonksiyonu
  Kullanıcı, belirli bir kelimeyi arayarak sonuçlara ulaşabilmelidir.

  Scenario: Arama yapma ve belirli bir haber detayına gitme
    Given kullanıcı "https://2nhaber.com/" adresine git
    When arama kutusuna "İstanbul" yazıp arama yapar
    Then arama sonuçlarından 8. habere gider
    And haberin başlığı doğru olmalıdır
