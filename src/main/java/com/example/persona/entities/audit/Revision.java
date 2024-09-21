package com.example.persona.entities.audit;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import com.example.persona.config.CustomRevisionListener;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class)
@Data
public class Revision implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(
          name = "revision_seq",
            sequenceName = "rbac.seq.revision_id")
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;

}
