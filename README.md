# Инструкция!
1. Нужно создать базу и таблицу.
Тут либо самому разбираться, либо брать моё готовое:
   1. Создаём базу с любым названием
   2. Создаём таблицу, код ниже
```sql
create table if not exists main_menu
(
    id        int auto_increment
        primary key,
    dish_name varchar(150)         not null,
    price     double               not null,
    visible   tinyint(1) default 0 not null
);
```
2. Изменяем [app.properties](src/main/resources/app.properties) на (Если что, фигурные скобки тоже убрать):
```properties
DBLogin={Имя пользователя}
DBPassword={Пароль от пользователя}
DBName={Название базы данных}
menuTable={Название таблицы}
```
3. Сервер запускается через [Main](src/main/java/com/kurs/server/Main.java)
4. Клиент запускается через: `mvn javaxf:run`