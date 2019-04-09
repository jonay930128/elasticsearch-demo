package wrx.xing.domain;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-24 10:52
 */
public class Hospital {
	private Long pkId;
	private String hospitalName;
	private String address;
	private String phone;
	private Integer grade;

	@Override
	public String toString() {
		return "Hospital{" +
				"pkId=" + pkId +
				", hospitalName='" + hospitalName + '\'' +
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
