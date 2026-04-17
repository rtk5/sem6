// Existing external lab classes (cannot be modified)
class BloodLab {
    public String getBloodReport() {
        return "Blood Report from BloodLab";
    }
}

class PathLab {
    public String fetchLabResults() {
        return "Lab Results from PathLab";
    }
}

class DiagnosticCenter {
    public String retrieveDiagnostics() {
        return "Diagnostics from DiagnosticCenter";
    }
}

// Target interface expected by the hospital system
interface LabAdapter {
    String getPatientReport();
}

// Adapters for each lab
class BloodLabAdapter implements LabAdapter {
    private BloodLab bloodLab;
    BloodLabAdapter(BloodLab b) { this.bloodLab = b; }
    public String getPatientReport() { return bloodLab.getBloodReport(); }
}

class PathLabAdapter implements LabAdapter {
    private PathLab pathLab;
    PathLabAdapter(PathLab p) { this.pathLab = p; }
    public String getPatientReport() { return pathLab.fetchLabResults(); }
}

class DiagnosticAdapter implements LabAdapter {
    private DiagnosticCenter center;
    DiagnosticAdapter(DiagnosticCenter d) { this.center = d; }
    public String getPatientReport() { return center.retrieveDiagnostics(); }
}

// Hospital system using the unified interface
public class HospitalSystem {
    public static void main(String[] args) {
        LabAdapter[] labs = {
            new BloodLabAdapter(new BloodLab()),
            new PathLabAdapter(new PathLab()),
            new DiagnosticAdapter(new DiagnosticCenter())
        };

        for (LabAdapter lab : labs) {
            System.out.println(lab.getPatientReport());
        }
    }
}