import sqlite3
banco = sqlite3.connect('Usuarios.db')
cursor = banco.cursor()



# cursor.execute('''CREATE TABLE IF NOT EXISTS Cadastra_Usuario (
#     id_usuario integer not null primary key,
#     nome varchar(60),
#     senha varchar(10),
#     cpf varchar(11)
#    )''')

# cursor.execute('''CREATE TABLE IF NOT EXISTS Cadastro_restaurante (
#     id_restaurante integer not null primary key,
#     nome_restaurante varchar(60),
#     cnpj varchar(10)
 
#   )''')

# cursor.execute('''CREATE TABLE IF NOT EXISTS Endereco (
#     id_endereco not null primary key,
#     rua varchar(60),
#     cep varchar(8),
#     bairro varchar(60),
#     cidade varchar(60),
#     fk_usuario INTEGER,
#     fk_restaurante,
#     FOREIGN KEY(fk_restaurante) REFERENCES Endereco(id_endereco),
#     FOREIGN KEY(fk_usuario) REFERENCES Endereco(id_endereco)
#   )''')
cursor.execute('INSERT INTO Cadastra_Usuario VALUES (null,"Keven","12345", "53688621808")')


banco.commit()
