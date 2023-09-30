public class Pedidos {
   
        String nomeUsuario;
        String nomeRestaurante;
        String lanche;
    
        Pedidos(String usuario, String restaurante, String lanche){
            this.nomeUsuario = usuario;
            this.nomeRestaurante = restaurante;
            this.lanche = lanche;
        }

        public String getNomeUsuario() {
            return nomeUsuario;
        }

        public String getNomeRestaurante() {
            return nomeRestaurante;
        }

        public String getLanche() {
            return lanche;
        }
    
}
