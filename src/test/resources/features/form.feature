Feature: Form Gönderme

  Kullanıcı, formdaki tüm alanları doldurmalı ve başarıyla gönderebilmelidir.

  Scenario: Kullanıcı formu eksiksiz doldurur ve gönderir
    Given kullanıcı "https://www.2ntech.com.tr/hr" adresine gitsin
    When kullanıcı aşağıdaki bilgileri girer:
      | alan                | değer                |
      | Ad Soyad            | Haluk Ural            |
      | Doğum Tarihi        | 01/01/1985          |
      | T.C. Kimlik Numarası| 12345678901         |
      | Cep Telefonu        | 05013686320    |
      | Mail Adresi         | haluk1@gmail.com|
    And kullanıcı CV dosyasını yükler
    And kullanıcı "Lisans" eğitim seviyesini seçer
    And kullanıcı KVKK metnini kabul eder
    And kullanıcı formun ilk adımını tamamlar
    Then kullanıcı Test Engineer pozisyonunu seçer
    And kullanıcı formu gönderir
    Then formun 2.adımı geçtiği kontrol edilir
