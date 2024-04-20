## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## Database Name -- librarymanagement

## Admin Table Schema

+----------------+--------------+------+-----+---------+-------+
| Field          | Type         | Null | Key | Default | Extra |
+----------------+--------------+------+-----+---------+-------+
| admin_userid   | varchar(100) | YES  |     | NULL    |       |
| admin_password | varchar(20)  | YES  |     | NULL    |       |
| admin_name     | varchar(30)  | YES  |     | NULL    |       |
| contact_info   | varchar(30)  | YES  |     | NULL    |       |
+----------------+--------------+------+-----+---------+-------+

## Book Table Schema

+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| book_id   | int         | NO   | PRI | NULL    | auto_increment |
| book_name | varchar(50) | NO   |     | NULL    |                |
| author    | varchar(30) | NO   |     | NULL    |                |
| price     | int         | NO   |     | NULL    |                |
| quantity  | int         | NO   |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+

## Book_borrowed Table Schema

+------------------+--------------+------+-----+---------+-------+
| Field            | Type         | Null | Key | Default | Extra |
+------------------+--------------+------+-----+---------+-------+
| book_id          | int          | YES  |     | NULL    |       |
| borrowed_by      | varchar(100) | YES  |     | NULL    |       |
| duration_month   | int          | YES  |     | NULL    |       |
| fine_generated   | int          | YES  |     | NULL    |       |
| date_borrowed_on | date         | YES  |     | NULL    |       |
| quantity         | int          | YES  |     | NULL    |       |
+------------------+--------------+------+-----+---------+-------+

## User Table Schema

+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| user_id      | varchar(100) | NO   | PRI | NULL    |       |
| password     | varchar(20)  | NO   |     | NULL    |       |
| contact_info | varchar(30)  | NO   |     | NULL    |       |
| user_name    | varchar(30)  | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+