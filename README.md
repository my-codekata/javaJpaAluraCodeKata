# javaJpaAluraCodeKata

Repositório de prática e revisão sobre o estudo de JPA.

## Associações entre entidades
### @ManyToOne
No primeiro momento vamos demonstrar um relacionamento `ManyToOne` permitindo valor `nulo`. Veja o resultado de uma consulta no Mysql:
```sql
+----+---------------+-----------+
| id | number        | person_id |
+----+---------------+-----------+
|  1 | 11 11111-1111 |      NULL |
+----+---------------+-----------+
```
Entidade `Person`:
```java
@Entity(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // restante do código
}
```

Entidade `Phone`:
```java
@Entity(name = "phone")
public class Phone {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToOne
    private Person person;

    // restante do código
}
```
Estrutura das tabelas geradas:
- person:
```sql
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| id    | int(11)      | NO   | PRI | NULL    | auto_increment |
| name  | varchar(255) | YES  |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
```

- phone:
```sql
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| id        | int(11)      | NO   | PRI | NULL    | auto_increment |
| number    | varchar(255) | YES  |     | NULL    |                |
| person_id | int(11)      | YES  | MUL | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+
```
Agora vamos realizar um relacionamento `ManyToOne` que não aceita valores nulos. E para isso vamos utilizar a anotação` @JoinColumn` com a propriedade nullable igual a false. Ex: `@JoinColumn(nullable = false)`.

Entidade `Person`:
```java
@Entity(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // restante do código
}
```

Entidade `Phone`:
```java
@Entity(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    // restante do código
}
```

Estrutura da tabela `phone` gerada:
```java
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| id        | int(11)      | NO   | PRI | NULL    | auto_increment |
| number    | varchar(255) | YES  |     | NULL    |                |
| person_id | int(11)      | NO   | MUL | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+
```
> Obs: caso o seu **persistence.xml** esteja com a propriedade e valor `<property name="hibernate.hbm2ddl.auto" value="update"/>`, será necessário deletar a tabela manualmente no banco de dados para que a coluna `Null` atualize de `YES` para `NO`.
