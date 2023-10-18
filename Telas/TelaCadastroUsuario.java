package org.example.Telas;
import org.example.Banco.FuncaoBanco;
import org.example.Classes.Usuarios;
import org.example.Componentes.*;
import org.example.Componentes.Button;
import org.example.Componentes.Label;
import org.example.Componentes.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class TelaCadastroUsuario extends Tela{

    Senha confirmaSenha = new Senha();
    Input cpf = new Input();
    Input nomeUsuario = new Input();
    Senha senha = new Senha();
    Usuarios usuario;
    FuncaoBanco db;

    public String getNome() {
        return nomeUsuario.getText();
    }

    public String getSenha() {
        return senha.getText();
    }

    public String getCPF() {
        return cpf.getText();
    }

    Button btn = new Button();


    Label mensagem = new Label();
    Label background = new Label();

    public TelaCadastroUsuario() throws SQLException {

        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaUsuario.png";
        background.setIcon(new ImageIcon(bosch));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

        nomeUsuario.setLocation(190, 520);
        cpf.setLocation(190, 590);
        senha.setLocation(190, 665);
        confirmaSenha.setLocation(190, 736);
        mensagem.setLocation(300, 200);
        btn.setText("Próximo >");
        mensagem.setForeground(Color.WHITE);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (getSenha().equals(confirmaSenha.getText())
                        && (!getSenha().equals(null)) == (!confirmaSenha.getText().equals(null))) {
                    try {
                        inserindoUsuarios();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getNome());
                } else if (!senha.getText().equals(confirmaSenha.getText())
                        && (!getSenha().equals(null)) == (!confirmaSenha.getText().equals(null))) {
                    mensagem.setText("Coloque uma senha correta!");
                }

            }
        });
        mensagem.setSize(350, 100);
        mensagem.setLocation(178, 420);
        mensagem.setForeground(Color.WHITE);

        btn.setSize(270, 50);
        btn.setLocation(190, 809);

        add(nomeUsuario);
        add(mensagem);
        add(cpf);
        add(btn);
        add(confirmaSenha);
        add(senha);
        add(background);
        setVisible(true);
    }

    public void inserindoUsuarios() throws SQLException {
        db = new FuncaoBanco();
        if (verificaCpf() == true && verificaSenha() == true) {
            usuario = new Usuarios(getNome(), getSenha(), getCPF());
            db.adicionarUsuario(usuario);
            new TelaCadastroEndereco(getCPF(), 1);
            dispose();
        }

    }

    public boolean verificaCpf() {
        if (getCPF().length() < 11) {
            mensagem.setText("Faltam alguns digitos");
            return false;
        } else if (getCPF().length() > 11) {
            mensagem.setText("Digitos a mais, digite um CPF correto");
            return false;
        } else
            return true;
    }

    public boolean verificaSenha() {
        if (getSenha().length() < 8) {
            mensagem.setText("O minimo da senha é 8 digitos");
            return false;
        } else if (getSenha().length() > 8 && getSenha().length() < 60) {
            mensagem.setText("Deu certo");
            return true;
        } else
            return true;
    }
}
