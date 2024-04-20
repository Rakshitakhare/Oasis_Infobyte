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

## SQL Table Schemas
Databse :- railwayreservationsystem

User Table
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| user_id  | int         | YES  |     | NULL    |       |
| username | varchar(20) | YES  |     | NULL    |       |
| password | varchar(20) | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+

Reservations Table
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| train_name   | varchar(30) | YES  |     | NULL    |       |
| train_number | int         | YES  |     | NULL    |       |
| date         | date        | YES  |     | NULL    |       |
| time         | varchar(10) | YES  |     | NULL    |       |
| source       | varchar(15) | YES  |     | NULL    |       |
| destination  | varchar(15) | YES  |     | NULL    |       |
| pnr_number   | int         | NO   | PRI | NULL    |       |

