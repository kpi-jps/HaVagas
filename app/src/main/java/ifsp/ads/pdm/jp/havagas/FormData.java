package ifsp.ads.pdm.jp.havagas;

import java.time.LocalDate;

public class FormData {
    private String name;
    private String email;
    private boolean inEmailList;
    private String phone;
    private boolean isHomePhone;
    private String mobilePhone;
    private boolean hasMobilePhone;
    private LocalDate birthDate;
    private EducationDegree educationDegree;
    private int yearOfConclusion;
    private String Institution;
    private String advisor;
    private String monographTitle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInEmailList() {
        return inEmailList;
    }

    public void setInEmailList(boolean inEmailList) {
        this.inEmailList = inEmailList;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHomePhone() {
        return isHomePhone;
    }

    public void setHomePhone(boolean homePhone) {
        isHomePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public boolean isHasMobilePhone() {
        return hasMobilePhone;
    }

    public void setHasMobilePhone(boolean hasMobilePhone) {
        this.hasMobilePhone = hasMobilePhone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public int getYearOfConclusion() {
        return yearOfConclusion;
    }

    public void setYearOfConclusion(int yearOfConclusion) {
        this.yearOfConclusion = yearOfConclusion;
    }

    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getMonographTitle() {
        return monographTitle;
    }

    public void setMonographTitle(String monographTitle) {
        this.monographTitle = monographTitle;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Dados formulários: ");
        output.append("\n Nome: " + name);
        if(isHomePhone) output.append("\nTelefone Residêncial: " + phone);
        else output.append("\nTelefone Comenrcial: " + phone);
        if(hasMobilePhone) output.append("\nTelefone Celular" + mobilePhone);
        output.append("\nFormação escolar: " + educationDegree.getDescription());
        output.append("\nAno de conclusão: " + String.valueOf(yearOfConclusion));
        if(educationDegree != EducationDegree.ELEMENTARY_SCHOOL ||
            educationDegree != EducationDegree.HIGH_SCHOOL)
            output.append("\nInstituição: " + getInstitution());
        if(educationDegree == EducationDegree.MASTER_DEGREE ||
            educationDegree == EducationDegree.PHD) {
            output.append("\nTítulo de monografia: " + getMonographTitle());
            output.append("\nOrientador: " + getAdvisor());
        }
        return output.toString();
    }
}
