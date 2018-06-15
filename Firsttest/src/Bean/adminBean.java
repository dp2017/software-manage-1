package Bean;

public class adminBean {
	public adminBean() {
		// TODO Auto-generated constructor stub
	}
	
	private int id; //手机
	
	private String 
	    username,     //用户名
		name,	//	名字
		password,	//	密码
		
	    sex,        //性别
	    Gshi,       //国家省市
	    danwei,     //单位
	    zhuanye,    //专业方向
	    hangye,     //行业
	    jiaoyu,     //教育
	    zhicheng,   //职称
	    
	    tongxun,     //通讯地址
	    
	    youbian,     //邮编	
	    
	    guhua,     //固定电话
	    youxiang,  //邮箱
	    qq,        //QQ
	    msn;        

	public String age;//年龄
	   
	    
	public String getTongxun() {
		return tongxun;
	}
	public void setTongxun(String tongxun) {
		this.tongxun = tongxun;
	}
	public String getYoubian() {
		return youbian;
	}
	public void setYoubian(String youbian) {
		this.youbian = youbian;
	}
	public String getGshi() {
		return Gshi;
	}
	public void setGshi(String gshi) {
		Gshi = gshi;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public String getZhuanye() {
		return zhuanye;
	}
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	public String getHangye() {
		return hangye;
	}
	public void setHangye(String hangye) {
		this.hangye = hangye;
	}
	public String getJiaoyu() {
		return jiaoyu;
	}
	public void setJiaoyu(String jiaoyu) {
		this.jiaoyu = jiaoyu;
	}
	public String getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	public String getGuhua() {
		return guhua;
	}
	public void setGuhua(String guhua) {
		this.guhua = guhua;
	}
	public String getYouxiang() {
		return youxiang;
	}
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	


	public adminBean(int id, String username, String name, String password, String sex, String gshi, String danwei,
			String zhuanye, String hangye, String jiaoyu, String zhicheng, String tongxun, String youbian, String guhua,
			String youxiang, String qq, String msn) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.Gshi = gshi;
		this.danwei = danwei;
		this.zhuanye = zhuanye;
		this.hangye = hangye;
		this.jiaoyu = jiaoyu;
		this.zhicheng = zhicheng;
		this.tongxun = tongxun;
		this.youbian = youbian;
		this.guhua = guhua;
		this.youxiang = youxiang;
		this.qq = qq;
		this.msn = msn;
	}
	@Override
	public String toString() {
		return "adminBean [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", sex="
				+ sex + ", Gshi=" + Gshi + ", danwei=" + danwei + ", zhuanye=" + zhuanye + ", hangye=" + hangye
				+ ", jiaoyu=" + jiaoyu + ", zhicheng=" + zhicheng + ", tongxun=" + tongxun + ", youbian=" + youbian
				+ ", guhua=" + guhua + ", youxiang=" + youxiang + ", qq=" + qq + ", msn=" + msn + "]";
	}
	
	public adminBean(int id, String name,String username, String password,String age,String sex) {
		super();
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.id = id;
		this.username = username;
		this.password = password;
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
