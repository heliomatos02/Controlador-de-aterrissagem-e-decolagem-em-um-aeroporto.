
public class No {

	private Aviao item;
	private No proximo;
	
	public No() {
		this.item = null;
		this.proximo = null;
	}

	public Aviao getItem() {
		return item;
	}
	
	public void setItem(Aviao item) {
		this.item = item;
	}
	
	public No getProximo() {
		return proximo;
	}
	
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	
}
