import sqlite3
banco = sqlite3.connect('Aplicativo.db')
cursor = banco.cursor()


cursor.execute("DROP TABLE Cadastra_Usuario")
cursor.execute('''CREATE TABLE IF NOT EXISTS Cadastra_Usuario (
    id_usuario integer not null primary key,
    nome varchar(60),
    senha varchar(60),
    cpf varchar(11)
   )''')

cursor.execute("DROP TABLE Cadastro_restaurante")
cursor.execute('''CREATE TABLE IF NOT EXISTS Cadastro_restaurante (
    id_restaurante integer not null primary key,
    nome_restaurante varchar(60),
    senha varchar(60),
    cnpj varchar(18)
    
 
  )''')


cursor.execute("DROP TABLE Endereco")
cursor.execute('''CREATE TABLE IF NOT EXISTS Endereco (
    id_endereco integer not null primary key,
    posicao_x integer,
    posicao_y integer,
    fk_usuario INTEGER null,
    fk_restaurante integer null,
    FOREIGN KEY(fk_restaurante) REFERENCES Endereco(id_endereco),
    FOREIGN KEY(fk_usuario) REFERENCES Endereco(id_endereco)
  )''')
# cursor.execute('INSERT INTO Cadastra_Usuario VALUES (null,"Keven","12345", "53688621808")')
cursor.execute("DROP TABLE Lanche")
cursor.execute("""CREATE TABLE IF NOT EXISTS Lanche(
    id_lanche integer not null  primary key,
    nome varchar(100),
    preço FLOAT,
    fk_restaurante integer,
    FOREIGN KEY(fk_restaurante) REFERENCES Cadastro_restaurante(id_restaurante)
    )""")

cursor.execute("DROP TABLE Pedido")
cursor.execute("""CREATE TABLE IF NOT EXISTS Pedido(
    id_pedido integer not null  primary key,
    preço_total FLOAT,
    fk_usuario integer,
    fk_restaurante integer,
    fk_lanche integer,
    FOREIGN KEY(fk_lanche) REFERENCES Lanche(id_lanche),
    FOREIGN KEY(fk_restaurante) REFERENCES Cadastro_restaurante(id_restaurante),
     FOREIGN KEY(fk_usuario) REFERENCES Cadastro_Usuario(id_usuario)
    )""")
banco.commit()
