package test;

public class ClasseInLibreria {		// questa classe appartiene ad una libreria, quindi è possibile instanziarla solo tramite una factory

	private String msg;

	public ClasseInLibreria(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ClasseInLibreria [msg=" + msg + "]";
	}
	
}
