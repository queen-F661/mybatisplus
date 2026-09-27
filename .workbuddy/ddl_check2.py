import pymysql

conn = pymysql.connect(
    host="localhost", port=3306, user="root", password="123456",
    database="mybatisplus", charset="utf8mb4", connect_timeout=5,
)
with conn.cursor() as cur:
    cur.execute("SHOW CREATE TABLE `user`")
    print(cur.fetchone()[1])
    print()
    cur.execute("SELECT id, name, create_time, update_time FROM `user` ORDER BY id")
    for row in cur.fetchall():
        print(row)
conn.close()
