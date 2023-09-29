package manager;

import model.Certificate;

import java.util.ArrayList;
import java.util.List;

public class CertificateManager {
    List<Certificate> certificatesList = new ArrayList<>();
    public void addCertificates(Certificate certificate){
        certificatesList.add(certificate);
    }
}
