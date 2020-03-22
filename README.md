# Standard Calculator
## Kelompok 12
* Nathaniel Evan Gunawan / 13516055
* Thoriq Akbar Mahmudi / 13518106
* Hanif Muhamad Gana / 13518127
* Ryan Daniel / 13518130
* Dwiani Yulia Ariyanti / 13518142

Asisten: Teresa / 13516133

## Struktur kode
Relatif dari folder repository, semua source code terdapat dalam folder `StandardCalculator/src`. Di dalam folder `src`, terdapat 4 folder: `data`, `gui`, `test`, dan `token`.

* Folder `data` terdiri dari 2 sub-folder: `expression` dan `exception`.
  * Folder `expression` menyimpan kelas-kelas yang bertugas mem-*parse* ekspresi matematika yang dapat dimengerti, kemudian dikalkulasi oleh kelas-kelas di folder `binaryExpressions` atau `unaryExpressions`, tergantung jenis operasi matematika.
  * Folder `exception` berisi kelas-kelas yang meng-handle kasus *exception* yang mungkin terjadi, misalnya kehabisan memori, *operand* yang tidak sah, dan lain-lain.
* Folder `gui` mengandung kelas `CalcForm` dan `Main`.
  * Kelas `CalcForm` mendefinisikan tampilan GUI kalkulator dan aksi yang dilakukan setiap tombol pada kalkulator.
  * Kelas `Main` menjalankan program kalkulator.
* Folder `token` menyimpan `Token.java`, sebuah kelas untuk menyimpan maksimal 100 ekspresi matematika dalam bentuk `String` untuk kemudian dikalkulasi. String dalam *token* juga akan ditampilkan ke layar kalkulator dalam program GUI.
* Folder `test` mengandung kelas-kelas testing program untuk menguji fungsi *token*, *parsing* ekspresi matematika dan fungsi kalkukasi ekspresi matematika.

## Cara compile dan run
### Linux
1. cd ke path folder src. Dari folder git repository:
   ```sh
   cd StandardCalculator/src
   ```
2. Compile seluruh file .java dalam project:
   ```sh
   find . -name "*.java" -print | xargs javac
   ```
3. Jalankan program:
   ```sh
   java gui.Main
   ```

## Screenshot
![Standard Calculator](./screenshot_calculator.png?raw=true "Standard Calculator")
