# Rent-A-Car-Java-Spring-Project

Bu projede katmanlı mimari kullanılmıştır.

Entity katmanı altındaki Brand Class içinde;
Database bağlantısı ve bu bağlantı için gereken isterler girişmiştir. 
Database bağlantısında Brands ve Models arasında OneToMany Anotasyonu kullanılmıştır. 
Modellerin listelenmesi için List yapısı kullanılmıştır.

Entity katmanı altındaki Car Class içinde;
Brand id bilgisine göre aracın plaka, fiyat, model, kiralanabilir durumda olup olmadığı bilgilerini alıyoruz.

Entity katmanı altındaki Model Class içinde;
Brand id bilgisine göre aracın model bilgisini List yapısını kullanrak listeliyoruz.
