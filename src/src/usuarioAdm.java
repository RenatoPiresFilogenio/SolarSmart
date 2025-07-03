package src;

public class usuarioAdm extends Usuarios {
	private final boolean isAdm = true;
	
		public usuarioAdm(String email , String senha){
			super (email,senha);
		
		}
	
		
		public void getEmail() {
			super.GetEmail();
		}
		
		public void getSenha() {
			super.GetSenha();
		}
		
		public boolean getAdm() {
			return isAdm;
		}
		
}
