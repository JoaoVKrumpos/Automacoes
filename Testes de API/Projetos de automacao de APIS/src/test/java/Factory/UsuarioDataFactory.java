package Factory;

import Pojo.Usuario;

public class UsuarioDataFactory {
    public static Usuario criarUsuarioAdministrador(){


        Usuario usuarioadministrador = new Usuario();
        usuarioadministrador.setEmail("admin@email.com");
        usuarioadministrador.setSenha("654321");

        return usuarioadministrador;
    }
    public static Usuario criarUsuarioComum(){


        Usuario usuariocomum = new Usuario();
       usuariocomum.setEmail("usuario@email.com");
       usuariocomum.setSenha("123456");

        return usuariocomum;
    }
}
