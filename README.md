Social Media App API

Bu proje, kullanıcıların yazdığı gönderiler, yorumlar ve beğeniler üzerinde işlem yapmayı sağlayan bir RESTful API sunmaktadır. Kullanıcılar, gönderi oluşturabilir, güncelleyebilir, silebilir ve beğeniler ve yorumlar ekleyebilir. API, temel CRUD işlemleri ve kullanıcı yönetimi özelliklerine sahiptir.

Teknolojiler

Spring Boot: Java tabanlı framework, REST API'lerini geliştirmek için kullanılmıştır.
JPA: Veritabanı işlemleri için kullanılmıştır.
H2 Database: Veritabanı olarak H2 kullanılmaktadır, ancak başka veritabanlarına geçiş yapılabilir.
API Endpoints

1. User Controller
GET /users
Tüm kullanıcıları listele.
POST /users
Yeni bir kullanıcı oluştur.
GET /users/{userId}
Verilen userId'ye sahip kullanıcıyı getir.
PUT /users/{userId}
Verilen userId'ye sahip kullanıcıyı güncelle.
DELETE /users/{userId}
Verilen userId'ye sahip kullanıcıyı sil.
2. Post Controller
GET /posts
Tüm gönderileri listele. (Opsiyonel userId parametresi ile filtreleme yapılabilir)
POST /posts
Yeni bir gönderi oluştur.
GET /posts/{postId}
Verilen postId'ye sahip gönderiyi getir.
PUT /posts/{postId}
Verilen postId'ye sahip gönderiyi güncelle.
DELETE /posts/{postId}
Verilen postId'ye sahip gönderiyi sil.
3. Comment Controller
GET /comments
Tüm yorumları listele. (Opsiyonel postId ve userId parametreleri ile filtreleme yapılabilir)
GET /comments/{commentId}
Verilen commentId'ye sahip yorumu getir.
POST /comments
Yeni bir yorum oluştur.
PUT /comments/{commentId}
Verilen commentId'ye sahip yorumu güncelle.
DELETE /comments/{commentId}
Verilen commentId'ye sahip yorumu sil.
4. Like Controller
GET /likes
Tüm beğenileri listele. (Opsiyonel userId ve postId parametreleri ile filtreleme yapılabilir)
GET /likes/{likeId}
Verilen likeId'ye sahip beğeniyi getir.
POST /likes
Yeni bir beğeni oluştur.
DELETE /likes/{likeId}
Verilen likeId'ye sahip beğeniyi sil.
