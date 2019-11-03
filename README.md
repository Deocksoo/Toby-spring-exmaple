# ����� ������ �н� ����

## ���� ȯ��
����� ������ ������ gradle ���嵵���� ����ϵ��� porting �Ͽ����ϴ�.
porting �۾��� �׽�Ʈ�� ��� IntellJ IDEA 2019.2.3 Ultimate Edition�� ���� �����Ͽ����ϴ�.
�׽�Ʈ ȯ���� �Ʒ��� �����ϴ�.
```
1. jdk 1.8
2. MySQL 5.7
3. MySQL-connector-java 5.1.48
```

## MySQL server ��ġ �� ���� ���̵�
docker ���丮�� �̵��ؼ� docker-compose.yml ������ ���� mysql�� ��ġ�մϴ�.
```
cd docker
docker-compose up -d
```
���� docker-compose.yml �������� ������Ʈ ���࿡ �ʿ��� mysql user�� database�� 
��� �������ְ� �ֽ��ϴ�. ���� �� ������Ʈ���� �����ϴ� yml ������ ����ϴ� ���
`/sql/create_mysql_database.sql`�� `/sql/create_mysql_user.sql`�� ���� �������� �ʾƵ� �������ϴ�.
