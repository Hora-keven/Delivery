import sqlite3
banco = sqlite3.connect('Aplicativo.db')
cursor = banco.cursor()



cursor.execute('''CREATE TABLE IF NOT EXISTS Cadastra_Usuario (
    id_usuario integer not null primary key,
    nome varchar(60),
    senha varchar(10),
    cpf varchar(11)
   )''')

cursor.execute('''CREATE TABLE IF NOT EXISTS Cadastro_restaurante (
    id_restaurante integer not null primary key,
    nome_restaurante varchar(60),
    cnpj varchar(10)
 
  )''')



cursor.execute('''CREATE TABLE IF NOT EXISTS Endereco (
    id_endereco not null primary key,
    posicao_x integer,
    posicao_y integer,
    fk_usuario INTEGER,
    fk_restaurante,
    FOREIGN KEY(fk_restaurante) REFERENCES Endereco(id_endereco),
    FOREIGN KEY(fk_usuario) REFERENCES Endereco(id_endereco)
  )''')
cursor.execute('INSERT INTO Cadastra_Usuario VALUES (null,"Keven","12345", "53688621808")')

cursor.execute("""CREATE TABLE Lanche(
    id_lanche integer not null  primary key,
    nome varchar(100),
    preço varchar(60),
    fk_restaurante integer,
    FOREIGN KEY(fk_restaurante) REFERENCES Cadastro_restaurante(id_restaurante)
    )""")

cursor.execute("""CREATE TABLE Pedido(
    id_pedido integer not null  primary key,
    fk_usuario varchar(100),
    preço_total varchar(60),
    fk_restaurante integer,
    FOREIGN KEY(fk_restaurante) REFERENCES Cadastro_restaurante(id_restaurante),
     FOREIGN KEY(fk_usuario) REFERENCES Cadastro_Usuario(id_usuario)
    )""")
banco.commit()
