package Bean;

public class powerBean {
	public powerBean() {

	}


	String age;
	private int xuguan, 
	            mima, 
	            jieshao, 
	            shenhe, 
	            chaxun, 
	            quanxian, 
	            tubiao;

	public String getAge() {
		return age;
	}
	

	public void setAge(String age) {
		this.age = age;
	}

	public int getXuguan() {
		return xuguan;
	}

	public void setXuguan(int xuguan) {
		this.xuguan = xuguan;
	}

	public int getMima() {
		return mima;
	}

	public void setMima(int mima) {
		this.mima = mima;
	}

	public int getJieshao() {
		return jieshao;
	}

	public void setJieshao(int jieshao) {
		this.jieshao = jieshao;
	}

	public int getShenhe() {
		return shenhe;
	}

	public void setShenhe(int shenhe) {
		this.shenhe = shenhe;
	}

	public int getChaxun() {
		return chaxun;
	}

	public void setChaxun(int chaxun) {
		this.chaxun = chaxun;
	}

	public int getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(int quanxian) {
		this.quanxian = quanxian;
	}

	public int getTubiao() {
		return tubiao;
	}

	public void setTubiao(int tubiao) {
		this.tubiao = tubiao;
	}
	
	@Override
	public String toString() {
		return "powerBean [age=" + age + ", xuguan=" + xuguan + ", mima=" + mima + ", jieshao=" + jieshao + ", shenhe="
				+ shenhe + ", chaxun=" + chaxun + ", quanxian=" + quanxian + ", tubiao=" + tubiao + "]";
	}
	
	
	public powerBean(String age,int xuguan,int mima,int jieshao,int shenhe,int chaxun,
			int quanxian,int tubiao){
		super();
		this.age=age;
		this.xuguan=xuguan;
		this.mima=mima;
		this.jieshao=jieshao;
		this.shenhe=shenhe;
		this.chaxun=chaxun;
		this.quanxian=quanxian;
		this.tubiao=tubiao;
	}
	
}
