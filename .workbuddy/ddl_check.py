import pymysql

conn = pymysql.connect(
    host="localhost", port=3306, user="root", password="123456",
    database="mybatisplus", charset="utf8mb4", connect_timeout=5,
)
with conn.cursor() as cur:
    cur.execute("SHOW CREATE TABLE `user`")
    print(cur.fetchone()[1])
    print()
    cur.execute(
        "SELECT COLUMN_NAME, COLUMN_TYPE, IS_NULLABLE, COLUMN_KEY, EXTRA "
        "FROM information_schema.COLUMNS "
        "WHERE TABLE_SCHEMA='mybatisplus' AND TABLE_NAME='user' ORDER BY ORDINAL_POSITION"
    )
    for row in cur.fetchall():
        print(row)
conn.close()
