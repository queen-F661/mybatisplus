import pymysql

print("=" * 50)
print("测试1: 用 application.yml 里的配置连接 localhost:3306/mybatisplus (root/123456)")
print("=" * 50)
try:
    conn = pymysql.connect(
        host="localhost", port=3306, user="root", password="123456",
        database="mybatisplus", charset="utf8mb4", connect_timeout=5,
    )
    print("[成功] root/123456 能连上 mybatisplus 库")
    with conn.cursor() as cur:
        cur.execute("SELECT id, name, age, email FROM user")
        rows = cur.fetchall()
        print(f"[成功] user 表能查到, 共 {len(rows)} 行:")
        for r in rows:
            print("   ", r)
    conn.close()
except Exception as e:
    print(f"[失败] 错误类型: {type(e).__name__}")
    print(f"[失败] 错误信息: {e}")

print()
print("=" * 50)
print("测试2: MySQL 服务是否在 3306 端口监听")
print("=" * 50)
import socket
try:
    s = socket.create_connection(("localhost", 3306), timeout=3)
    s.close()
    print("[成功] 3306 端口有 MySQL 在监听")
except Exception as e:
    print(f"[失败] 3306 端口连不上: {e}")
