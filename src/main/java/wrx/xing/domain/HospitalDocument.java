package wrx.xing.domain;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-21 20:41
 */
public class HospitalDocument {
	private Long pkId;
	private String name;
	private String nameNoTokenize;
	private String nameTokenize;
	private String nameElement;
	private String namePinYin;
	private String namePinYinEle;
	private String address;
	private String phone;
	private Integer grade;

	@Override
	public String toString() {
		return "HospitalDocument{" +
				"pkId=" + pkId +
				", name='" + name + '\'' +
				", nameNoTokenize='" + nameNoTokenize + '\'' +
				", nameTokenize='" + nameTokenize + '\'' +
				", nameElement='" + nameElement + '\'' +
				", namePinYin='" + namePinYin + '\'' +
				", namePinYinEle='" + namePinYinEle + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", grade=" + grade +
				'}';
	}

	public Long getPkId() {
		return pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameNoTokenize() {
		return nameNoTokenize;
	}

	public void setNameNoTokenize(String nameNoTokenize) {
		this.nameNoTokenize = nameNoTokenize;
	}

	public String getNameTokenize() {
		return nameTokenize;
	}

	public void setNameTokenize(String nameTokenize) {
		this.nameTokenize = nameTokenize;
	}

	public String getNameElement() {
		return nameElement;
	}

	public void setNameElement(String nameElement) {
		this.nameElement = nameElement;
	}

	public String getNamePinYin() {
		return namePinYin;
	}

	public void setNamePinYin(String namePinYin) {
		this.namePinYin = namePinYin;
	}

	public String getNamePinYinEle() {
		return namePinYinEle;
	}

	public void setNamePinYinEle(String namePinYinEle) {
		this.namePinYinEle = namePinYinEle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}
