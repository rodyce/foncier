package org.rodyce.foncier.datamodel.ladm.external;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ExtArchiveKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private ExtArchive extArchive;
    
    @OneToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", updatable = true)
    public ExtArchive getExtArchive() {
        return extArchive;
    }
    public void setExtArchive(ExtArchive extArchive) {
        this.extArchive = extArchive;
    }
}
