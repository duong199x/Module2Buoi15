package model;

import java.util.Date;

public class Certificate {
    private int CertificatedID;
    private String CertificateName;
    private int CertificateRank;
    private String CertificatedDate;

    public Certificate(int certificatedID, String certificateName, int certificateRank, String certificatedDate) {
        CertificatedID = certificatedID;
        CertificateName = certificateName;
        CertificateRank = certificateRank;
        CertificatedDate = certificatedDate;
    }

    public int getCertificatedID() {
        return CertificatedID;
    }

    public void setCertificatedID(int certificatedID) {
        CertificatedID = certificatedID;
    }

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public int getCertificateRank() {
        return CertificateRank;
    }

    public void setCertificateRank(int certificateRank) {
        CertificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return CertificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        CertificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "CertificatedID=" + CertificatedID +
                ", CertificateName='" + CertificateName + '\'' +
                ", CertificateRank=" + CertificateRank +
                ", CertificatedDate=" + CertificatedDate +
                '}';
    }
}
