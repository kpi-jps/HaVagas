package ifsp.ads.pdm.jp.havagas;

import java.util.ArrayList;
import java.util.List;

public enum EducationDegree {
    ELEMENTARY_SCHOOL("Ensino Fundamental"),
    HIGH_SCHOOL("Ensino Médio"),
    GRADUATE ("Graduação"),
    SPECIALIZATION ("Especialização"),
    MASTER_DEGREE("Mestrado"),
    PHD("Doutorado");

    private String description;

    private EducationDegree(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public EducationDegree getValue(int index) {
        return EducationDegree.values()[index];
    }
    public List<String> listDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for (EducationDegree educationDegree : EducationDegree.values())
            descriptions.add(educationDegree.description);
        return descriptions;
    }

}
