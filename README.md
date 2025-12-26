# Mini Wallet API 🏦

**Mini Wallet API** adalah simulasi sistem E-Wallet backend yang dibangun menggunakan teknologi **Java & Spring Boot** terbaru (Bleeding Edge). Proyek ini dirancang dengan fokus pada *Clean Architecture*, *Data Consistency*, dan *High Scalability*.

Proyek ini dibuat sebagai bagian dari Final Project **Dibimbing.id Bootcamp (DSF 46 Faculty of IT: Back End)**.

## 🚀 Tech Stack (Bleeding Edge)
- **Java:** JDK 25 ☕
- **Framework:** Spring Boot 4.0.0 (Snapshot)
- **Database:** MySQL / MariaDB
- **ORM:** Hibernate 7 (Spring Data JPA)
- **API Documentation:** OpenAPI 3 (Swagger UI)
- **Build Tool:** Maven

## ✨ Key Features

### 1. Robust Architecture
- **Layered Architecture:** Controller ↔ Service ↔ Repository (Clean Separation of Concerns).
- **DTO Pattern:** Menggunakan Data Transfer Object untuk keamanan dan kebersihan data API response.

### 2. Advanced Database Handling
- **Atomic Transactions:** Menjamin integritas data saldo saat *Deposit* dan *Withdraw* (ACID Compliant).
- **Custom ID Generator:** Implementasi Hibernate Generator kustom untuk membuat ID yang deskriptif:
  - `bnk-xxxxx` (Bank)
  - `cust-xxxxx` (Customer)
  - `sav-xxxxx` (Saving/Rekening)
  - `trx-xxxxx` (Transaction)
- **Master-Detail View:** Fitur agregasi data untuk melihat profil nasabah beserta seluruh rekeningnya dalam satu request.

### 3. Developer Experience
- **Auto-generated Documentation:** Terintegrasi penuh dengan Swagger UI.
- **Strict Validation:** Validasi input request menggunakan Jakarta Validation.

## 🛠️ How to Run

### Pre-Requirement
- Java JDK 25 terinstall.
- Maven terinstall.
- MySQL/MariaDB berjalan di port 3306.

### Langkah-langkah
1. **Clone Repository**
   ```bash
   git clone [https://github.com/USERNAME_GITHUB_KAMU/mini-wallet-api.git](https://github.com/USERNAME_GITHUB_KAMU/mini-wallet-api.git)
   cd mini-wallet-api
2. **Setup Database**
   Buat database kosong bernama `marcel_mini_wallet`.
    ```sql
    CREATE DATABASE marcel_mini_wallet;
    ```
    *(Tabel akan otomatis dibuat oleh Hibernate saat aplikasi berjalan)*
3. **Konfigurasi**
   Sesuaikan username & password database di `src/main/resources/application.properties`.
4. **Jalankan Aplikasi**
    ```bash
    mvn spring-boot:run
    ```
5. **Akses API**
   Buka Swagger UI di browser:
   👉 `http://localhost:8080/swagger-ui/index.html`

## 📚 API Endpoints Overview

| Method | Endpoint | Deskripsi |
| --- | --- | --- |
| **POST** | `/api/banks` | Tambah Bank Baru |
| **GET** | `/api/banks` | Lihat Semua Bank |
| **POST** | `/api/customers` | Registrasi Nasabah |
| **GET** | `/api/customers/nik/{nik}` | **(Highlight)** Lihat Detail Nasabah + List Rekening |
| **POST** | `/api/savings` | Buka Rekening Baru |
| **POST** | `/api/transactions` | Setor Tunai (Deposit) / Tarik Tunai (Withdraw) |
| **GET** | `/api/transactions/{savingId}` | Lihat Mutasi Rekening |

## 👨‍💻 Author

**Marshalinas Yustiawan**

* [LinkedIn](linkedin.com/in/cyrochrome-dev21/)
* [GitHub](github.com/Cyrochrome/)

---
*Built with ❤️ and a lot of coffee for Dibimbing.id Final Task.*