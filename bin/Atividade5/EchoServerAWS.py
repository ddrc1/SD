import socket

HOST = '127.0.0.1'  # Standard loopback interface address (localhost)
PORT = 65432        # Port to listen on (non-privileged ports are > 1023)
buffer = 1024

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.bind((HOST, PORT))
s.listen()

while True:
    conn, addr = s.accept()
    data = conn.recv(buffer)

    conn.sendall(data.encode())