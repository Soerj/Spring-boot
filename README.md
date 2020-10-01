# Spring-boot
Spring-boot currency converter app
-----------------------------------

Конвертер валют.

Чтобы запустить проект нужно:

  1. База данных PostgreSQL.
      Если Postgre SQL server не установлен, то проще всего будет использовать Docker:
      в командной строке выполнить команду "docker run -p 5432:5432 --name postgres_db -e POSTGRES_PASSWORD=50057 -d postgres"
      докер сам скачает последнюю версию образа из репозитория и запустит БД с именем postgres в контейнере.
      
      Если уже есть рабочий SQL server, то нужно открыть в проекте файл application.properties (в директории /src/main/resources/)
      изменить название базы данных с postgres на имя уже существующей БД, указать значения username и password для подключения. 
      Никакие таблицы дополнительно создавать не нужно, Hibernate сам сделает это при запуске приложения.

  2. Собрать проект, используя pom.xml.
  3. Отдельно запустить jibx компилятор, используя maven-jibx-plugin, чтобы скомпилировать xml биндинги.
  
<h3>Схема приложения</h3>
![alt text](https://i.ibb.co/PrgY7RN/image.jpg)

<h3>Пример результатов работы приложения</h3>
![alt text](https://i.ibb.co/C05wmxd/front.jpg)

