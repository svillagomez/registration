# Registration
This assumes full access to mysql running on port 3306 having a user as follows:
- username=Santiago
- password=admin

### Running: 
To create an executable jar run under root folder:
- $ mvn clean package

To start up a server with the created jar:
- $ java -jar ./target/registration-0.1.0.jar

### Technical Details

Store Association.

Requiring a store association for a User is assuming one store can accept multiple users. So one user in the DB has a ONE foreing key that belongs to one store only.

The user entity table in db looks like:

Table: user_entity
| Columns           |               |
| -------------     |:-------------:|
| Id                | bigint(20) AI PK |
|City               | varchar(255)      |
| Email             | varchar(255)      |
| Name              | varchar(255)      |
| Password          | varchar(255)      |
| Status            | bit(1)     |
| Username          | varchar(255)      |
| store_entity_id   | bigint(20)     |




The store entity table looks like:
Table: store_entity

Table: store_entity

Columns:
| Columns           |               |
| -------------     |:-------------:|
| Id                | bigint(20) AI PK |
|City               | varchar(255)      |
| Name              | varchar(255)      |
| Ruc               | varchar(255)      |
| Status            | bit(1)     |

