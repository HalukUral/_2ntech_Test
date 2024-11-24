Feature: Navbar Kontrolü
  Kullanıcı, 2NHABER web sitesindeki navbar öğelerine tıklayabilmelidir.

  Scenario: Navbar öğelerine tıklama
    Given kullanıcı "https://2nhaber.com/" adresine gider
    When navbar öğelerine tıklar
    Then her sayfanın başlığı doğru olmalıdır
