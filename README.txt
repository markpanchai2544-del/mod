Dead Walkers - Forge 1.20.1 (47.x)

BUILD
1. ติดตั้ง JDK 17
2. ดาวน์โหลด Forge MDK 1.20.1-47.2.0 จาก files.minecraftforge.net แล้วแตกไฟล์
3. คัดลอก src/, build.gradle, gradle.properties, settings.gradle จากโปรเจกต์นี้ไปทับใน MDK
4. รัน  gradlew build   -> ได้ไฟล์ build/libs/deadwalkers-1.0.0.jar
5. ใส่ jar ใน .minecraft/mods (Forge 1.20.1 เท่านั้น)

TEST
/summon deadwalkers:walker   (runner, spitter, bloater, crawler)
หรือหาไข่เกิดใน Creative tab "Spawn Eggs"

BUILD ด้วย GitHub (ไม่ต้องติดตั้งอะไรบนเครื่อง)
1. สร้าง repository ใหม่บน github.com (ว่างเปล่า)
2. ในโฟลเดอร์โปรเจกต์รัน:
     git remote add origin https://github.com/<ชื่อคุณ>/dead-walkers.git
     git push -u origin main
3. เปิดแท็บ Actions -> workflow "Build mod" (หรือกด Run workflow เอง)
4. รอจนเสร็จ แล้วโหลด "deadwalkers-jar" ที่ท้ายหน้ารันนั้น แตก zip จะได้ไฟล์ .jar

v1.1.0: scarier sounds, glowing eyes, gore textures, new animations, more spawns
